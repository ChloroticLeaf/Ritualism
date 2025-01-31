package chloriticleaf.ritualism;

import chloriticleaf.ritualism.block.RitualCauldronBlock;
import chloriticleaf.ritualism.block.RitualismBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.TexturedModel;

public class RitualismModelProvider extends FabricModelProvider {
    public RitualismModelProvider(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //rails?
        //blockStateModelGenerator.registerSingleton(RitualismBlocks.RITUALCHALK, TexturedModel.CARPET);
        blockStateModelGenerator.registerSingleton(RitualismBlocks.RITUALCHALK, TexturedModel.CARPET);
        blockStateModelGenerator.registerSingleton(RitualismBlocks.RITUALGOLD, TexturedModel.CARPET);
        blockStateModelGenerator.registerSingleton(RitualismBlocks.RITUALCOPPER, TexturedModel.CARPET);
        blockStateModelGenerator.registerSingleton(RitualismBlocks.RITUALAMETHYST, TexturedModel.CARPET);

        //blocks
        //not right but close enough :3
        blockStateModelGenerator.registerSingleton(RitualismBlocks.RITUALCAULDRON, TexturedModel.CUBE_BOTTOM_TOP);


        //crystals


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // ...
    }
}


