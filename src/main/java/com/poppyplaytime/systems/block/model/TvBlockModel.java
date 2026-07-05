package com.poppyplaytime.systems.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.poppyplaytime.systems.block.entity.TvBlockEntity;

public class TvBlockModel extends GeoModel<TvBlockEntity> {
	@Override
	public ResourceLocation getAnimationResource(TvBlockEntity animatable) {
		return new ResourceLocation("nova", "animations/kissy_missy_poppy.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TvBlockEntity animatable) {
		return new ResourceLocation("nova", "geo/kissy_missy_poppy.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TvBlockEntity animatable) {
		return new ResourceLocation("nova", "textures/block/kissy_missy_poppy.png");
	}
}
