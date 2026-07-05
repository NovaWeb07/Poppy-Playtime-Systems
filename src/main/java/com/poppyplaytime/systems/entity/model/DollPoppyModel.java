package com.poppyplaytime.systems.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.poppyplaytime.systems.entity.DollPoppyEntity;

public class DollPoppyModel extends GeoModel<DollPoppyEntity> {
	@Override
	public ResourceLocation getAnimationResource(DollPoppyEntity entity) {
		return new ResourceLocation("nova", "animations/dollpoppy.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DollPoppyEntity entity) {
		return new ResourceLocation("nova", "geo/dollpoppy.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DollPoppyEntity entity) {
		return new ResourceLocation("nova", "textures/entities/" + entity.getTexture() + ".png");
	}

}
