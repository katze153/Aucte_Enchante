package net.ktf.ae.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.ktf.ae.network.AeModVariables;

public class AmuletofRevivalWhileBaubleIsEquippedTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		{
			double _setval = itemstack.getOrCreateTag().getDouble("lvl");
			entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.rv_amulet_lvl = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
