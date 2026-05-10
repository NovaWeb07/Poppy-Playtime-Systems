package net.mcreator.boss.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.boss.entity.CatnapEntity;

public class CatnapModel extends GeoModel<CatnapEntity> {
	@Override
	public ResourceLocation getAnimationResource(CatnapEntity entity) {
		return new ResourceLocation("boss", "animations/catnap.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CatnapEntity entity) {
		return new ResourceLocation("boss", "geo/catnap.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CatnapEntity entity) {
		return new ResourceLocation("boss", "textures/entities/" + entity.getTexture() + ".png");
	}

}
