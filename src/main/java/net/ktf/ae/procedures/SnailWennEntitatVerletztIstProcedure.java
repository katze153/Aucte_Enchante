package net.ktf.ae.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.ktf.ae.entity.SnailEntity;
import net.ktf.ae.AeMod;

public class SnailWennEntitatVerletztIstProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) == (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) && false == entity.getPersistentData().getBoolean("hit")) {
			if (entity instanceof SnailEntity) {
				((SnailEntity) entity).setAnimation("go_in");
			}
			entity.getPersistentData().putBoolean("hit", true);
		}
		if (true == entity.getPersistentData().getBoolean("hit")) {
			if (entity instanceof SnailEntity) {
				((SnailEntity) entity).setAnimation("in");
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 255, false, false));
			AeMod.queueServerWork(100, () -> {
				if (entity instanceof SnailEntity) {
					((SnailEntity) entity).setAnimation("go_out");
				}
				entity.getPersistentData().putBoolean("in", false);
			});
		}
	}
}
