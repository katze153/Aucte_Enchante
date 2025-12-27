
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.ktf.ae.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.ktf.ae.block.entity.UpdatetableBlockEntity;
import net.ktf.ae.AeMod;

public class AeModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AeMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> UPDATETABLE = register("updatetable", AeModBlocks.UPDATETABLE, UpdatetableBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
