package net.ktf.ae.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

public class AmulettofwaterbreathingWennGegenstandImInventarTickProcedure {
	public static void execute(ItemStack itemstack) {
		if ((itemstack.getOrCreateTag().getString("name")).equals("")) {
			itemstack.getOrCreateTag().putString("name", (((itemstack.getDisplayName().getString()).replace("[", "")).replace("]", "")));
		}
		if (0 == itemstack.getOrCreateTag().getDouble("lvl")) {
			itemstack.getOrCreateTag().putDouble("lvl", 1);
		} else {
			itemstack.setHoverName(Component.literal((itemstack.getOrCreateTag().getString("name") + " " + ("(" + ("lvl" + " " + new java.text.DecimalFormat("#").format(itemstack.getOrCreateTag().getDouble("lvl"))) + ")"))));
		}
	}
}
