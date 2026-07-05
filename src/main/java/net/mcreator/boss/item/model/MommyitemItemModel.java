package net.mcreator.boss.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.boss.item.MommyitemItem;

public class MommyitemItemModel extends GeoModel<MommyitemItem> {
	@Override
	public ResourceLocation getAnimationResource(MommyitemItem animatable) {
		return new ResourceLocation("boss", "animations/itemmommy.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MommyitemItem animatable) {
		return new ResourceLocation("boss", "geo/itemmommy.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MommyitemItem animatable) {
		return new ResourceLocation("boss", "textures/item/mommyangry.png");
	}
}
