package net.ktf.ae.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class AmuletoflavaWhileBaubleIsEquippedTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (1 == itemstack.getOrCreateTag().getDouble("lvl")) {
			entity.setMaxUpStep(1);
		}
		if (2 == itemstack.getOrCreateTag().getDouble("lvl")) {
			entity.setMaxUpStep((float) 1.6);
		}
	}
}
