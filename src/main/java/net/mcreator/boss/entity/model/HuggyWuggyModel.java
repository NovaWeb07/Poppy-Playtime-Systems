package net.mcreator.boss.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.boss.entity.HuggyWuggyEntity;

public class HuggyWuggyModel extends GeoModel<HuggyWuggyEntity> {
	@Override
	public ResourceLocation getAnimationResource(HuggyWuggyEntity entity) {
		return new ResourceLocation("boss", "animations/huggy_wuggy.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HuggyWuggyEntity entity) {
		return new ResourceLocation("boss", "geo/huggy_wuggy.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HuggyWuggyEntity entity) {
		return new ResourceLocation("boss", "textures/entities/" + entity.getTexture() + ".png");
	}

}
