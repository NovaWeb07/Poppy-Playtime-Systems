package com.poppyplaytime.systems.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.poppyplaytime.systems.item.MommyItem;

public class MommyItemModel extends GeoModel<MommyItem> {
	@Override
	public ResourceLocation getAnimationResource(MommyItem animatable) {
		return new ResourceLocation("nova", "animations/itemmommy.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MommyItem animatable) {
		return new ResourceLocation("nova", "geo/itemmommy.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MommyItem animatable) {
		return new ResourceLocation("nova", "textures/item/mommyangry.png");
	}
}
