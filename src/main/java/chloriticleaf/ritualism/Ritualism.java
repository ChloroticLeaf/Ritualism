package chloriticleaf.ritualism;

import chloriticleaf.ritualism.block.RitualismBlocks;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.PositionSource;
import net.minidev.json.parser.JSONParser;
import netscape.javascript.JSObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static chloriticleaf.ritualism.RitualismConstants.*;


import java.util.Objects;

public class Ritualism implements ModInitializer {
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
		BlockRenderLayerMap.INSTANCE.putBlock(RitualismBlocks.RITUALCAULDRON, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(RitualismBlocks.RITUALDRAWERS, RenderLayer.getCutout());

		RitualismBlocks.initialize();

		LOGGER.info("Starting Ritualism!");

		//for some reason this happens twice when you click on a block?? fix later imo
		UseBlockCallback.EVENT.register((playerEntity, world, hand, blockHitResult) -> {
			if (!playerEntity.isSpectator() && (world.getBlockState(blockHitResult.getBlockPos()).isOf(RitualismBlocks.RITUALCAULDRON) && world instanceof ServerWorld serverWorld)) {

				LOGGER.info("Ritual Activated at:");
				LOGGER.info(blockHitResult.getBlockPos().toShortString());

				findRitual(world, blockHitResult.getBlockPos());
			}

			return ActionResult.PASS;
		});
	}

	private void findRitual(World world, BlockPos centerPos) {

        try {
			File file = new File(JSON_DIR + "debugRitual.json");
			Scanner Reader = new Scanner(file);
			while (Reader.hasNextLine()) {
				String data = Reader.nextLine();
				LOGGER.info(data);

			}
			Reader.close();
		} catch (FileNotFoundException e) {
			LOGGER.info("Read error! Could not get ritual json");
			LOGGER.info(e.toString());
		}
	}

	}