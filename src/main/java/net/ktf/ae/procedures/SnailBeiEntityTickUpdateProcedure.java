package net.ktf.ae.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

import net.ktf.ae.entity.SnailEntity;

public class SnailBeiEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState block = Blocks.AIR.defaultBlockState();
		boolean block_bool = false;
		block = (world.getBlockState(BlockPos.containing(x, y + 1, z)));
		if (!(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)) {
			block_bool = Blocks.POTATOES == block.getBlock() || Blocks.WHEAT == block.getBlock() || Blocks.CARROTS == block.getBlock() || Blocks.BEETROOTS == block.getBlock() ? true : false;
			if (block_bool) {
				world.destroyBlock(BlockPos.containing(x, y + 1, z), false);
			}
		}
		if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
			if (entity.getPersistentData().getBoolean("hit") == false && entity.getPersistentData().getBoolean("sit") == true) {
				if (entity instanceof SnailEntity) {
					((SnailEntity) entity).setAnimation("go_in");
				}
				entity.getPersistentData().putBoolean("hit", true);
			} else if (entity.getPersistentData().getBoolean("hit") == true && true == entity.getPersistentData().getBoolean("sit")) {
				if (entity instanceof SnailEntity) {
					((SnailEntity) entity).setAnimation("in");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 255, false, false));
			}
			if (entity.getPersistentData().getBoolean("hit") == true && false == entity.getPersistentData().getBoolean("sit")) {
				if (entity instanceof SnailEntity) {
					((SnailEntity) entity).setAnimation("go_out");
				}
				entity.getPersistentData().putBoolean("hit", false);
			}
		}
	}
}
