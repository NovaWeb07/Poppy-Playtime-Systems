package com.poppyplaytime.systems.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.poppyplaytime.systems.entity.CatnapEntity;

public class CatnapModel extends GeoModel<CatnapEntity> {
	@Override
	public ResourceLocation getAnimationResource(CatnapEntity entity) {
		return new ResourceLocation("nova", "animations/catnap.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CatnapEntity entity) {
		return new ResourceLocation("nova", "geo/catnap.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CatnapEntity entity) {
		return new ResourceLocation("nova", "textures/entities/" + entity.getTexture() + ".png");
	}

}
