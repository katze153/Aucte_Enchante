package net.ktf.ae.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.ktf.ae.network.AeModVariables;

public class SaveiteminhandProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack item, double menge) {
		if (entity == null)
			return;
		ItemStack v_item = ItemStack.EMPTY;
		double v_menge = 0;
		{
			ItemStack _setval = item;
			entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.v_item = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		AeModVariables.MapVariables.get(world).v_menge = menge;
		AeModVariables.MapVariables.get(world).syncData(world);
	}
}
