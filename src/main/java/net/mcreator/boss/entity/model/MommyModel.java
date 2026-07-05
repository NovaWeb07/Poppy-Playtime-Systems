package net.mcreator.boss.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.boss.entity.MommyEntity;

public class MommyModel extends GeoModel<MommyEntity> {
	@Override
	public ResourceLocation getAnimationResource(MommyEntity entity) {
		return new ResourceLocation("boss", "animations/mommy.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MommyEntity entity) {
		return new ResourceLocation("boss", "geo/mommy.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MommyEntity entity) {
		return new ResourceLocation("boss", "textures/entities/" + entity.getTexture() + ".png");
	}

}
