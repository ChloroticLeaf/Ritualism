package com.ritualism;

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
        blockStateModelGenerator.registerSingleton(RitualismBlocks.RITUALCHALK, TexturedModel.CARPET);
        //blockStateModelGenerator.registerTurnableRail(RitualismBlocks.RITUALCHALK);
        blockStateModelGenerator.registerSingleton(RitualismBlocks.RITUALGOLD, TexturedModel.CARPET);
        blockStateModelGenerator.registerSingleton(RitualismBlocks.RITUALCOPPER, TexturedModel.CARPET);
        blockStateModelGenerator.registerSingleton(RitualismBlocks.RITUALAMETHYST, TexturedModel.CARPET);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // ...
    }
}


