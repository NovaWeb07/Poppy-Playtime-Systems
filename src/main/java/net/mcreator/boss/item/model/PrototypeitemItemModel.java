package net.mcreator.boss.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.boss.item.PrototypeitemItem;

public class PrototypeitemItemModel extends GeoModel<PrototypeitemItem> {
	@Override
	public ResourceLocation getAnimationResource(PrototypeitemItem animatable) {
		return new ResourceLocation("boss", "animations/prototype.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PrototypeitemItem animatable) {
		return new ResourceLocation("boss", "geo/prototype.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PrototypeitemItem animatable) {
		return new ResourceLocation("boss", "textures/item/prototype.png");
	}
}
