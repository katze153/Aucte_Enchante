package net.ktf.ae.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.ktf.ae.entity.SnailEntity;

public class SnailModel extends GeoModel<SnailEntity> {
	@Override
	public ResourceLocation getAnimationResource(SnailEntity entity) {
		return new ResourceLocation("ae", "animations/schnecke.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SnailEntity entity) {
		return new ResourceLocation("ae", "geo/schnecke.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SnailEntity entity) {
		return new ResourceLocation("ae", "textures/entities/" + entity.getTexture() + ".png");
	}

}
