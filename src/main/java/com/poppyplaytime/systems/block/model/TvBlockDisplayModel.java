package com.poppyplaytime.systems.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.poppyplaytime.systems.block.display.TvBlockDisplayItem;

public class TvBlockDisplayModel extends GeoModel<TvBlockDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(TvBlockDisplayItem animatable) {
		return new ResourceLocation("nova", "animations/kissy_missy_poppy.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TvBlockDisplayItem animatable) {
		return new ResourceLocation("nova", "geo/kissy_missy_poppy.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TvBlockDisplayItem entity) {
		return new ResourceLocation("nova", "textures/block/kissy_missy_poppy.png");
	}
}
