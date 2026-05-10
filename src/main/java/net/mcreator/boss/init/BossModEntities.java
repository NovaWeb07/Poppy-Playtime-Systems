
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.boss.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.boss.entity.YarnaByEntity;
import net.mcreator.boss.entity.PrototypeEntity;
import net.mcreator.boss.entity.MommyEntity;
import net.mcreator.boss.entity.KissyMissyEntity;
import net.mcreator.boss.entity.HuggyWuggyEntity;
import net.mcreator.boss.entity.DollPoppyEntity;
import net.mcreator.boss.entity.DogdayEntity;
import net.mcreator.boss.entity.CatnapEntity;
import net.mcreator.boss.entity.CarrotWolfEntity;
import net.mcreator.boss.BossMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BossModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BossMod.MODID);
	public static final RegistryObject<EntityType<CarrotWolfEntity>> CARROT_WOLF = register("carrot_wolf",
			EntityType.Builder.<CarrotWolfEntity>of(CarrotWolfEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CarrotWolfEntity::new)

					.sized(1.2f, 2f));
	public static final RegistryObject<EntityType<DollPoppyEntity>> DOLL_POPPY = register("doll_poppy",
			EntityType.Builder.<DollPoppyEntity>of(DollPoppyEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DollPoppyEntity::new)

					.sized(0.8f, 0.6f));
	public static final RegistryObject<EntityType<CatnapEntity>> CATNAP = register("catnap",
			EntityType.Builder.<CatnapEntity>of(CatnapEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CatnapEntity::new)

					.sized(1.2f, 2.5f));
	public static final RegistryObject<EntityType<DogdayEntity>> DOGDAY = register("dogday",
			EntityType.Builder.<DogdayEntity>of(DogdayEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DogdayEntity::new)

					.sized(0.5f, 0.9f));
	public static final RegistryObject<EntityType<HuggyWuggyEntity>> HUGGY_WUGGY = register("huggy_wuggy",
			EntityType.Builder.<HuggyWuggyEntity>of(HuggyWuggyEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HuggyWuggyEntity::new)

					.sized(1f, 4f));
	public static final RegistryObject<EntityType<KissyMissyEntity>> KISSY_MISSY = register("kissy_missy",
			EntityType.Builder.<KissyMissyEntity>of(KissyMissyEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(KissyMissyEntity::new)

					.sized(1f, 4f));
	public static final RegistryObject<EntityType<MommyEntity>> MOMMY = register("mommy",
			EntityType.Builder.<MommyEntity>of(MommyEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MommyEntity::new)

					.sized(1.3f, 2.1f));
	public static final RegistryObject<EntityType<PrototypeEntity>> PROTOTYPE = register("prototype",
			EntityType.Builder.<PrototypeEntity>of(PrototypeEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PrototypeEntity::new)

					.sized(3.3f, 6f));
	public static final RegistryObject<EntityType<YarnaByEntity>> YARNA_BY = register("yarna_by",
			EntityType.Builder.<YarnaByEntity>of(YarnaByEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(YarnaByEntity::new)

					.sized(2f, 1.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			CarrotWolfEntity.init();
			DollPoppyEntity.init();
			CatnapEntity.init();
			DogdayEntity.init();
			HuggyWuggyEntity.init();
			KissyMissyEntity.init();
			MommyEntity.init();
			PrototypeEntity.init();
			YarnaByEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(CARROT_WOLF.get(), CarrotWolfEntity.createAttributes().build());
		event.put(DOLL_POPPY.get(), DollPoppyEntity.createAttributes().build());
		event.put(CATNAP.get(), CatnapEntity.createAttributes().build());
		event.put(DOGDAY.get(), DogdayEntity.createAttributes().build());
		event.put(HUGGY_WUGGY.get(), HuggyWuggyEntity.createAttributes().build());
		event.put(KISSY_MISSY.get(), KissyMissyEntity.createAttributes().build());
		event.put(MOMMY.get(), MommyEntity.createAttributes().build());
		event.put(PROTOTYPE.get(), PrototypeEntity.createAttributes().build());
		event.put(YARNA_BY.get(), YarnaByEntity.createAttributes().build());
	}
}
