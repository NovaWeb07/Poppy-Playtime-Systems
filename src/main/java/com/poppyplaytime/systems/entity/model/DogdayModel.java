package com.poppyplaytime.systems.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.poppyplaytime.systems.entity.DogdayEntity;

public class DogdayModel extends GeoModel<DogdayEntity> {
	@Override
	public ResourceLocation getAnimationResource(DogdayEntity entity) {
		return new ResourceLocation("nova", "animations/dogday.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DogdayEntity entity) {
		return new ResourceLocation("nova", "geo/dogday.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DogdayEntity entity) {
		return new ResourceLocation("nova", "textures/entities/" + entity.getTexture() + ".png");
	}

}
