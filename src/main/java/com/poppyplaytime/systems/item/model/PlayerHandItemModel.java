package com.poppyplaytime.systems.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.poppyplaytime.systems.item.PlayerHandItem;

public class PlayerHandItemModel extends GeoModel<PlayerHandItem> {
	@Override
	public ResourceLocation getAnimationResource(PlayerHandItem animatable) {
		return new ResourceLocation("nova", "animations/the_player.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PlayerHandItem animatable) {
		return new ResourceLocation("nova", "geo/the_player.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PlayerHandItem animatable) {
		return new ResourceLocation("nova", "textures/item/the_player.png");
	}
}
