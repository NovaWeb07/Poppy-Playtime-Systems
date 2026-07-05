package com.poppyplaytime.systems.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.poppyplaytime.systems.entity.KissyMissyEntity;

public class KissyMissyModel extends GeoModel<KissyMissyEntity> {
	@Override
	public ResourceLocation getAnimationResource(KissyMissyEntity entity) {
		return new ResourceLocation("nova", "animations/kissy_missy_poppy.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(KissyMissyEntity entity) {
		return new ResourceLocation("nova", "geo/kissy_missy_poppy.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(KissyMissyEntity entity) {
		return new ResourceLocation("nova", "textures/entities/" + entity.getTexture() + ".png");
	}

}
