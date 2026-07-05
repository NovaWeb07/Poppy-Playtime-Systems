
package com.poppyplaytime.systems.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import com.poppyplaytime.systems.block.TvBlock;
import com.poppyplaytime.systems.PoppyPlaytimeSystems;

public class ModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, PoppyPlaytimeSystems.MODID);
	public static final RegistryObject<Block> TV_BLOCK = REGISTRY.register("tv_block", () -> new TvBlock());
		}
