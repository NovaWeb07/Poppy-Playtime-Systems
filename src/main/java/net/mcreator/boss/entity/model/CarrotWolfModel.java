package net.mcreator.boss.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.boss.entity.CarrotWolfEntity;

public class CarrotWolfModel extends GeoModel<CarrotWolfEntity> {
	@Override
	public ResourceLocation getAnimationResource(CarrotWolfEntity entity) {
		return new ResourceLocation("boss", "animations/doey.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CarrotWolfEntity entity) {
		return new ResourceLocation("boss", "geo/doey.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CarrotWolfEntity entity) {
		return new ResourceLocation("boss", "textures/entities/" + entity.getTexture() + ".png");
	}

}
