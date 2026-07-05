package net.mcreator.boss.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.boss.entity.YarnaByEntity;

public class YarnaByModel extends GeoModel<YarnaByEntity> {
	@Override
	public ResourceLocation getAnimationResource(YarnaByEntity entity) {
		return new ResourceLocation("boss", "animations/4besmc_yarnabylisi.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(YarnaByEntity entity) {
		return new ResourceLocation("boss", "geo/4besmc_yarnabylisi.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(YarnaByEntity entity) {
		return new ResourceLocation("boss", "textures/entities/" + entity.getTexture() + ".png");
	}

}
