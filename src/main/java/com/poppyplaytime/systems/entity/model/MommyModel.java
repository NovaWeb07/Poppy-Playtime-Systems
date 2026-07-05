package com.poppyplaytime.systems.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.poppyplaytime.systems.entity.MommyEntity;

public class MommyModel extends GeoModel<MommyEntity> {
	@Override
	public ResourceLocation getAnimationResource(MommyEntity entity) {
		return new ResourceLocation("nova", "animations/mommy.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MommyEntity entity) {
		return new ResourceLocation("nova", "geo/mommy.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MommyEntity entity) {
		return new ResourceLocation("nova", "textures/entities/" + entity.getTexture() + ".png");
	}

}
