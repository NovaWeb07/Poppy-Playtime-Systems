package com.poppyplaytime.systems.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.poppyplaytime.systems.entity.CarrotWolfEntity;

public class CarrotWolfModel extends GeoModel<CarrotWolfEntity> {
	@Override
	public ResourceLocation getAnimationResource(CarrotWolfEntity entity) {
		return new ResourceLocation("nova", "animations/doey.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CarrotWolfEntity entity) {
		return new ResourceLocation("nova", "geo/doey.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CarrotWolfEntity entity) {
		return new ResourceLocation("nova", "textures/entities/" + entity.getTexture() + ".png");
	}

}
