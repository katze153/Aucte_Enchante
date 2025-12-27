
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.ktf.ae.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.ktf.ae.item.StrongDiamontItem;
import net.ktf.ae.item.HometeleportItem;
import net.ktf.ae.item.AmulettofwaterbreathingItem;
import net.ktf.ae.item.AmulettofprotectionItem;
import net.ktf.ae.item.AmulettofhealingItem;
import net.ktf.ae.item.AmuletoflavaItem;
import net.ktf.ae.item.AmuletofknockbackresistanceItem;
import net.ktf.ae.item.AmuletoffireresistanceItem;
import net.ktf.ae.item.AmuletofRevivalItem;
import net.ktf.ae.item.AmuletItem;
import net.ktf.ae.AeMod;

public class AeModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, AeMod.MODID);
	public static final RegistryObject<Item> AMULET_PART = REGISTRY.register("amulet_part", () -> new StrongDiamontItem());
	public static final RegistryObject<Item> UPDATETABLE = block(AeModBlocks.UPDATETABLE);
	public static final RegistryObject<Item> AMULET = REGISTRY.register("amulet", () -> new AmuletItem());
	public static final RegistryObject<Item> AMULETOFHEALING = REGISTRY.register("amuletofhealing", () -> new AmulettofhealingItem());
	public static final RegistryObject<Item> AMULETOFPROTECTION = REGISTRY.register("amuletofprotection", () -> new AmulettofprotectionItem());
	public static final RegistryObject<Item> AMULETOFWATERBREATHING = REGISTRY.register("amuletofwaterbreathing", () -> new AmulettofwaterbreathingItem());
	public static final RegistryObject<Item> AMULET_OF_REVIVAL = REGISTRY.register("amulet_of_revival", () -> new AmuletofRevivalItem());
	public static final RegistryObject<Item> AMULETOFKNOCKBACKRESISTANCE = REGISTRY.register("amuletofknockbackresistance", () -> new AmuletofknockbackresistanceItem());
	public static final RegistryObject<Item> AMULETOFFIRERESISTANCE = REGISTRY.register("amuletoffireresistance", () -> new AmuletoffireresistanceItem());
	public static final RegistryObject<Item> SNAIL_SPAWN_EGG = REGISTRY.register("snail_spawn_egg", () -> new ForgeSpawnEggItem(AeModEntities.SNAIL, -6077429, -15712496, new Item.Properties()));
	public static final RegistryObject<Item> HOMETELEPORT = REGISTRY.register("hometeleport", () -> new HometeleportItem());
	public static final RegistryObject<Item> AMULETOFSTEP = REGISTRY.register("amuletofstep", () -> new AmuletoflavaItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
