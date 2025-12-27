
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.ktf.ae.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.ktf.ae.AeMod;

public class AeModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AeMod.MODID);
	public static final RegistryObject<CreativeModeTab> AMULETT = REGISTRY.register("amulett",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.ae.amulett")).icon(() -> new ItemStack(AeModItems.AMULET.get())).displayItems((parameters, tabData) -> {
				tabData.accept(AeModItems.AMULET_PART.get());
				tabData.accept(AeModBlocks.UPDATETABLE.get().asItem());
				tabData.accept(AeModItems.AMULET.get());
				tabData.accept(AeModItems.AMULETOFHEALING.get());
				tabData.accept(AeModItems.AMULETOFPROTECTION.get());
				tabData.accept(AeModItems.AMULETOFWATERBREATHING.get());
				tabData.accept(AeModItems.AMULET_OF_REVIVAL.get());
				tabData.accept(AeModItems.AMULETOFKNOCKBACKRESISTANCE.get());
				tabData.accept(AeModItems.AMULETOFFIRERESISTANCE.get());
				tabData.accept(AeModItems.SNAIL_SPAWN_EGG.get());
				tabData.accept(AeModItems.HOMETELEPORT.get());
				tabData.accept(AeModItems.AMULETOFSTEP.get());
			}).withSearchBar().build());
}
