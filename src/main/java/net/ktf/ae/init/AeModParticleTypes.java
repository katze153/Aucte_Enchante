
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.ktf.ae.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.ktf.ae.AeMod;

public class AeModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, AeMod.MODID);
	public static final RegistryObject<SimpleParticleType> AORUSE = REGISTRY.register("aoruse", () -> new SimpleParticleType(false));
}
