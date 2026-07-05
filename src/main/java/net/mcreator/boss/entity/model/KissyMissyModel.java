package net.mcreator.boss.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.boss.entity.KissyMissyEntity;

public class KissyMissyModel extends GeoModel<KissyMissyEntity> {
	@Override
	public ResourceLocation getAnimationResource(KissyMissyEntity entity) {
		return new ResourceLocation("boss", "animations/kissy_missy_poppy.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(KissyMissyEntity entity) {
		return new ResourceLocation("boss", "geo/kissy_missy_poppy.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(KissyMissyEntity entity) {
		return new ResourceLocation("boss", "textures/entities/" + entity.getTexture() + ".png");
	}

}
