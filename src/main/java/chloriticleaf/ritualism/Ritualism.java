package chloriticleaf.ritualism;
import chloriticleaf.ritualism.block.RitualismBlocks;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.math.Direction;
import org.json.*;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static chloriticleaf.ritualism.RitualismConstants.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            if (!playerEntity.isSpectator() && (world.getBlockState(blockHitResult.getBlockPos()).isOf(RitualismBlocks.RITUALCAULDRON) && world instanceof ServerWorld)) {

                LOGGER.info("Ritual Activated at:");
                LOGGER.info(blockHitResult.getBlockPos().toShortString());

				findRitual(blockHitResult.getBlockPos(), world);
            }

            return ActionResult.PASS;
        });
    }

	private void findRitual(BlockPos centerPos, World world) {
		File[] files = new File(JSON_DIR).listFiles();

        assert files != null;
        for (File file : files) {
			if (checkFile(file.getName(), centerPos, world)) {
				LOGGER.info("found " + file.getName());
				break;
			}
		}
	}

    private boolean checkFile(String filepath, BlockPos centerPos, World world) {
		try {
			File file = new File(JSON_DIR + filepath);

			Scanner Reader = new Scanner(file);

			StringBuilder out = new StringBuilder("\n");

			while (Reader.hasNextLine()) {
				String i = Reader.nextLine();

				out.append(i);
				out.append("\n");
			}
			Reader.close();

			LOGGER.info(out.toString());

			JSONObject obj = new JSONObject(out.toString());
			String Center = obj.getString("center");

			// for now ignore until i stop being lazy
			LOGGER.info(Center);

			JSONArray arr = obj.getJSONArray("points"); // notice that `"points": [...]`

			int x;
			int y;
			int z;
			int correct = 0;

			for (int i = 0; i < arr.length(); i++) {
				String dust = arr.getJSONObject(i).getString("dust");

				// Regular expression to match (x, y, z)
				String regex = "\\((-?\\d+),\\s*(-?\\d+),\\s*(-?\\d+)\\)";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(dust);

				if (matcher.matches()) {
					x = Integer.parseInt(matcher.group(1));
					y = Integer.parseInt(matcher.group(2));
					z = Integer.parseInt(matcher.group(3));
				} else {
					LOGGER.warn("Could not parse cord!");
					return false;
				}

				// Possibly want to make this look for specific passed block idk
				if (world.getBlockState(centerPos.offset(Direction.fromVector(x, y, z, Direction.UP))).isOf(RitualismBlocks.RITUALDRAWERS)) {
					LOGGER.info(dust, "at: ", x, y, z);
					correct++;
				} else {
					LOGGER.warn("Failed to find a dust!");
					return false;
				}

				if (correct == arr.length()) {
					// need to find a nice way to specify ritual effects
					LOGGER.info(JSON_DIR + filepath + " ran!");
					return true;
				}
			}

		} catch (FileNotFoundException e) {
			LOGGER.warn("Read error! Could not get ritual json");
			LOGGER.info(e.toString());
			return false;
		}
        return false;
    }
}