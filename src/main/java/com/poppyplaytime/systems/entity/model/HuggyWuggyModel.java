package com.poppyplaytime.systems.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.poppyplaytime.systems.entity.HuggyWuggyEntity;

public class HuggyWuggyModel extends GeoModel<HuggyWuggyEntity> {
	@Override
	public ResourceLocation getAnimationResource(HuggyWuggyEntity entity) {
		return new ResourceLocation("nova", "animations/huggy_wuggy.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HuggyWuggyEntity entity) {
		return new ResourceLocation("nova", "geo/huggy_wuggy.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HuggyWuggyEntity entity) {
		return new ResourceLocation("nova", "textures/entities/" + entity.getTexture() + ".png");
	}

}
