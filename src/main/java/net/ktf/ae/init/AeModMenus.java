
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.ktf.ae.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.ktf.ae.world.inventory.GTEMenu;
import net.ktf.ae.AeMod;

public class AeModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, AeMod.MODID);
	public static final RegistryObject<MenuType<GTEMenu>> GTE = REGISTRY.register("gte", () -> IForgeMenuType.create(GTEMenu::new));
}
