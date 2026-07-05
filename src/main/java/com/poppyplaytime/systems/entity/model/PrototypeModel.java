package com.poppyplaytime.systems.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.poppyplaytime.systems.entity.PrototypeEntity;

public class PrototypeModel extends GeoModel<PrototypeEntity> {
	@Override
	public ResourceLocation getAnimationResource(PrototypeEntity entity) {
		return new ResourceLocation("nova", "animations/prototype.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PrototypeEntity entity) {
		return new ResourceLocation("nova", "geo/prototype.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PrototypeEntity entity) {
		return new ResourceLocation("nova", "textures/entities/" + entity.getTexture() + ".png");
	}

}
