package com.poppyplaytime.systems.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.poppyplaytime.systems.item.PrototypeItem;

public class PrototypeItemModel extends GeoModel<PrototypeItem> {
	@Override
	public ResourceLocation getAnimationResource(PrototypeItem animatable) {
		return new ResourceLocation("nova", "animations/prototype.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PrototypeItem animatable) {
		return new ResourceLocation("nova", "geo/prototype.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PrototypeItem animatable) {
		return new ResourceLocation("nova", "textures/item/prototype.png");
	}
}
