package net.ktf.ae.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class AmulettofprotectionWhileBaubleIsEquippedTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (1 == itemstack.getOrCreateTag().getDouble("lvl")) {
			if (false == (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.DAMAGE_RESISTANCE))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false));
			}
		} else if (2 == itemstack.getOrCreateTag().getDouble("lvl")) {
			if (false == (entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.DAMAGE_RESISTANCE))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 1, false, false));
			}
		}
	}
}
