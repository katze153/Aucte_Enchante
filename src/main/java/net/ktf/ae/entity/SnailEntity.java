
package net.ktf.ae.entity;

import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.GeoEntity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.RemoveBlockGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FollowMobGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Difficulty;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.ktf.ae.procedures.SnailWennSpielerMitDieserEinheitZusammenstosstProcedure;
import net.ktf.ae.procedures.SnailWennRechtsAufEinheitGeklicktWirdProcedure;
import net.ktf.ae.procedures.SnailWennEntitatVerletztIstProcedure;
import net.ktf.ae.procedures.SnailBeiErstellungDesErstenObjectsProcedure;
import net.ktf.ae.procedures.SnailBeiEntityTickUpdateProcedure;
import net.ktf.ae.procedures.IstamennProcedure;
import net.ktf.ae.procedures.IstamenProcedure;
import net.ktf.ae.procedures.IsSittingNotProcedure;
import net.ktf.ae.init.AeModEntities;

import javax.annotation.Nullable;

import java.util.List;

public class SnailEntity extends TamableAnimal implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(SnailEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(SnailEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(SnailEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Boolean> DATA_in = SynchedEntityData.defineId(SnailEntity.class, EntityDataSerializers.BOOLEAN);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public SnailEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(AeModEntities.SNAIL.get(), world);
	}

	public SnailEntity(EntityType<SnailEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setMaxUpStep(0.8f);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "schnecke");
		this.entityData.define(DATA_in, false);
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.2));
		this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(3, new FloatGoal(this));
		this.goalSelector.addGoal(4, new RemoveBlockGoal(Blocks.CARROTS, this, 0.2, (int) 20) {
			@Override
			public boolean canUse() {
				double x = SnailEntity.this.getX();
				double y = SnailEntity.this.getY();
				double z = SnailEntity.this.getZ();
				Entity entity = SnailEntity.this;
				Level world = SnailEntity.this.level();
				return super.canUse() && IstamennProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SnailEntity.this.getX();
				double y = SnailEntity.this.getY();
				double z = SnailEntity.this.getZ();
				Entity entity = SnailEntity.this;
				Level world = SnailEntity.this.level();
				return super.canContinueToUse() && IstamennProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(5, new RemoveBlockGoal(Blocks.POTATOES, this, 0.2, (int) 20) {
			@Override
			public boolean canUse() {
				double x = SnailEntity.this.getX();
				double y = SnailEntity.this.getY();
				double z = SnailEntity.this.getZ();
				Entity entity = SnailEntity.this;
				Level world = SnailEntity.this.level();
				return super.canUse() && IstamennProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SnailEntity.this.getX();
				double y = SnailEntity.this.getY();
				double z = SnailEntity.this.getZ();
				Entity entity = SnailEntity.this;
				Level world = SnailEntity.this.level();
				return super.canContinueToUse() && IstamennProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(6, new RemoveBlockGoal(Blocks.BEETROOTS, this, 0.2, (int) 20) {
			@Override
			public boolean canUse() {
				double x = SnailEntity.this.getX();
				double y = SnailEntity.this.getY();
				double z = SnailEntity.this.getZ();
				Entity entity = SnailEntity.this;
				Level world = SnailEntity.this.level();
				return super.canUse() && IstamennProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SnailEntity.this.getX();
				double y = SnailEntity.this.getY();
				double z = SnailEntity.this.getZ();
				Entity entity = SnailEntity.this;
				Level world = SnailEntity.this.level();
				return super.canContinueToUse() && IstamennProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(7, new RemoveBlockGoal(Blocks.WHEAT, this, 0.2, (int) 20) {
			@Override
			public boolean canUse() {
				double x = SnailEntity.this.getX();
				double y = SnailEntity.this.getY();
				double z = SnailEntity.this.getZ();
				Entity entity = SnailEntity.this;
				Level world = SnailEntity.this.level();
				return super.canUse() && IstamennProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SnailEntity.this.getX();
				double y = SnailEntity.this.getY();
				double z = SnailEntity.this.getZ();
				Entity entity = SnailEntity.this;
				Level world = SnailEntity.this.level();
				return super.canContinueToUse() && IstamennProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(8, new FollowMobGoal(this, 0.2, (float) 10, (float) 5) {
			@Override
			public boolean canUse() {
				double x = SnailEntity.this.getX();
				double y = SnailEntity.this.getY();
				double z = SnailEntity.this.getZ();
				Entity entity = SnailEntity.this;
				Level world = SnailEntity.this.level();
				return super.canUse() && IstamennProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SnailEntity.this.getX();
				double y = SnailEntity.this.getY();
				double z = SnailEntity.this.getZ();
				Entity entity = SnailEntity.this;
				Level world = SnailEntity.this.level();
				return super.canContinueToUse() && IstamennProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, SnailEntity.class, (float) 6, 0.2, 1.2) {
			@Override
			public boolean canUse() {
				double x = SnailEntity.this.getX();
				double y = SnailEntity.this.getY();
				double z = SnailEntity.this.getZ();
				Entity entity = SnailEntity.this;
				Level world = SnailEntity.this.level();
				return super.canUse() && IstamenProcedure.execute(world, x, y, z);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SnailEntity.this.getX();
				double y = SnailEntity.this.getY();
				double z = SnailEntity.this.getZ();
				Entity entity = SnailEntity.this;
				Level world = SnailEntity.this.level();
				return super.canContinueToUse() && IstamenProcedure.execute(world, x, y, z);
			}
		});
		this.goalSelector.addGoal(10, new FollowOwnerGoal(this, 0.2, (float) 10, (float) 2, false) {
			@Override
			public boolean canUse() {
				double x = SnailEntity.this.getX();
				double y = SnailEntity.this.getY();
				double z = SnailEntity.this.getZ();
				Entity entity = SnailEntity.this;
				Level world = SnailEntity.this.level();
				return super.canUse() && IsSittingNotProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SnailEntity.this.getX();
				double y = SnailEntity.this.getY();
				double z = SnailEntity.this.getZ();
				Entity entity = SnailEntity.this;
				Level world = SnailEntity.this.level();
				return super.canContinueToUse() && IsSittingNotProcedure.execute(entity);
			}
		});
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(Items.SLIME_BALL));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		SnailWennEntitatVerletztIstProcedure.execute(this.level(), this);
		return super.hurt(source, amount);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		SnailBeiErstellungDesErstenObjectsProcedure.execute(this);
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
		compound.putBoolean("Datain", this.entityData.get(DATA_in));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
		if (compound.contains("Datain"))
			this.entityData.set(DATA_in, compound.getBoolean("Datain"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		Item item = itemstack.getItem();
		if (itemstack.getItem() instanceof SpawnEggItem) {
			retval = super.mobInteract(sourceentity, hand);
		} else if (this.level().isClientSide()) {
			retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack)) ? InteractionResult.sidedSuccess(this.level().isClientSide()) : InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.isOwnedBy(sourceentity)) {
					if (item.isEdible() && this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						this.heal((float) item.getFoodProperties().getNutrition());
						retval = InteractionResult.sidedSuccess(this.level().isClientSide());
					} else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						this.heal(4);
						retval = InteractionResult.sidedSuccess(this.level().isClientSide());
					} else {
						retval = super.mobInteract(sourceentity, hand);
					}
				}
			} else if (this.isFood(itemstack)) {
				this.usePlayerItem(sourceentity, hand, itemstack);
				if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, sourceentity)) {
					this.tame(sourceentity);
					this.level().broadcastEntityEvent(this, (byte) 7);
				} else {
					this.level().broadcastEntityEvent(this, (byte) 6);
				}
				this.setPersistenceRequired();
				retval = InteractionResult.sidedSuccess(this.level().isClientSide());
			} else {
				retval = super.mobInteract(sourceentity, hand);
				if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
					this.setPersistenceRequired();
			}
		}
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();

		SnailWennRechtsAufEinheitGeklicktWirdProcedure.execute(entity);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		SnailBeiEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		return super.getDimensions(p_33597_).scale((float) 1);
	}

	@Override
	public void playerTouch(Player sourceentity) {
		super.playerTouch(sourceentity);
		SnailWennSpielerMitDieserEinheitZusammenstosstProcedure.execute(this.level(), this);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		SnailEntity retval = AeModEntities.SNAIL.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of(Blocks.WHEAT.asItem(), Items.CARROT, Items.POTATO, Items.BEETROOT, Items.WHEAT).contains(stack.getItem());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.updateSwingTime();
	}

	public static void init() {
		SpawnPlacements.register(AeModEntities.SNAIL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.5);
		builder = builder.add(Attributes.MAX_HEALTH, 6);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
		}
		return PlayState.STOP;
	}

	String prevAnim = "empty";

	private PlayState procedurePredicate(AnimationState event) {
		if (!animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED || (!this.animationprocedure.equals(prevAnim) && !this.animationprocedure.equals("empty"))) {
			if (!this.animationprocedure.equals(prevAnim))
				event.getController().forceAnimationReset();
			event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
			if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
				this.animationprocedure = "empty";
				event.getController().forceAnimationReset();
			}
		} else if (animationprocedure.equals("empty")) {
			prevAnim = "empty";
			return PlayState.STOP;
		}
		prevAnim = this.animationprocedure;
		return PlayState.CONTINUE;
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 20) {
			this.remove(SnailEntity.RemovalReason.KILLED);
			this.dropExperience();
		}
	}

	public String getSyncedAnimation() {
		return this.entityData.get(ANIMATION);
	}

	public void setAnimation(String animation) {
		this.entityData.set(ANIMATION, animation);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
		data.add(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
