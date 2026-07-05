package com.poppyplaytime.systems.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.poppyplaytime.systems.entity.YarnaByEntity;

public class YarnaByModel extends GeoModel<YarnaByEntity> {
	@Override
	public ResourceLocation getAnimationResource(YarnaByEntity entity) {
		return new ResourceLocation("nova", "animations/4besmc_yarnabylisi.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(YarnaByEntity entity) {
		return new ResourceLocation("nova", "geo/4besmc_yarnabylisi.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(YarnaByEntity entity) {
		return new ResourceLocation("nova", "textures/entities/" + entity.getTexture() + ".png");
	}

}
