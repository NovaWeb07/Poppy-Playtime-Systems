package net.mcreator.boss.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.boss.entity.PrototypeEntity;

public class PrototypeModel extends GeoModel<PrototypeEntity> {
	@Override
	public ResourceLocation getAnimationResource(PrototypeEntity entity) {
		return new ResourceLocation("boss", "animations/prototype.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PrototypeEntity entity) {
		return new ResourceLocation("boss", "geo/prototype.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PrototypeEntity entity) {
		return new ResourceLocation("boss", "textures/entities/" + entity.getTexture() + ".png");
	}

}
