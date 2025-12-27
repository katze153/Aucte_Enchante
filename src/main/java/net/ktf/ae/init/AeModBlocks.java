
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.ktf.ae.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.ktf.ae.block.UpdatetableBlock;
import net.ktf.ae.AeMod;

public class AeModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, AeMod.MODID);
	public static final RegistryObject<Block> UPDATETABLE = REGISTRY.register("updatetable", () -> new UpdatetableBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
