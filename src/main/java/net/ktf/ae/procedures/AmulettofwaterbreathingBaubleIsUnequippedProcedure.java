package net.ktf.ae.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

public class AmulettofwaterbreathingBaubleIsUnequippedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.WATER_BREATHING);
		if (itemstack.getOrCreateTag().getDouble("lvl") == 2) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.NIGHT_VISION);
		}
	}
}
