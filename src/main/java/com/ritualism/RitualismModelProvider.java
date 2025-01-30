package com.ritualism;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;

public class RitualismModelProvider extends FabricModelProvider {
    public RitualismModelProvider(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(RitualismBlocks.RITUALCHALK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // ...
    }
}


