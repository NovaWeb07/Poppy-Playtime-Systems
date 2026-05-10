package net.mcreator.boss.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.boss.entity.DogdayEntity;

public class DogdayModel extends GeoModel<DogdayEntity> {
	@Override
	public ResourceLocation getAnimationResource(DogdayEntity entity) {
		return new ResourceLocation("boss", "animations/dogday.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DogdayEntity entity) {
		return new ResourceLocation("boss", "geo/dogday.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DogdayEntity entity) {
		return new ResourceLocation("boss", "textures/entities/" + entity.getTexture() + ".png");
	}

}
