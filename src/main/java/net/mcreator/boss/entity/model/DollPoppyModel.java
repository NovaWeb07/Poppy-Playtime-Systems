package net.mcreator.boss.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.boss.entity.DollPoppyEntity;

public class DollPoppyModel extends GeoModel<DollPoppyEntity> {
	@Override
	public ResourceLocation getAnimationResource(DollPoppyEntity entity) {
		return new ResourceLocation("boss", "animations/dollpoppy.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DollPoppyEntity entity) {
		return new ResourceLocation("boss", "geo/dollpoppy.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DollPoppyEntity entity) {
		return new ResourceLocation("boss", "textures/entities/" + entity.getTexture() + ".png");
	}

}
