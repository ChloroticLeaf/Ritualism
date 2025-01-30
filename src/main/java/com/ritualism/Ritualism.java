package com.ritualism;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ritualism implements ModInitializer {
	public static final String MOD_ID = "ritualism";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		// To make some parts of the block transparent (like glass, saplings and doors):
		BlockRenderLayerMap.INSTANCE.putBlock(RitualismBlocks.RITUALCHALK, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RitualismBlocks.RITUALGOLD, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RitualismBlocks.RITUALCOPPER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RitualismBlocks.RITUALAMETHYST, RenderLayer.getCutout());

		RitualismBlocks.initialize();

		LOGGER.info("Starting Ritualism!");
	}
}