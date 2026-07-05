package net.mcreator.boss.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.boss.item.PlayerHandItem;

public class PlayerHandItemModel extends GeoModel<PlayerHandItem> {
	@Override
	public ResourceLocation getAnimationResource(PlayerHandItem animatable) {
		return new ResourceLocation("boss", "animations/the_player.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PlayerHandItem animatable) {
		return new ResourceLocation("boss", "geo/the_player.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PlayerHandItem animatable) {
		return new ResourceLocation("boss", "textures/item/the_player.png");
	}
}
