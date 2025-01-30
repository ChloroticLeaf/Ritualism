package com.ritualism;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static com.ritualism.RitualismConstants.MOD_ID;

public class RitualismBlocks {

    public static final Block RITUALCHALK = register("ritualchalk", Block::new,
            AbstractBlock.Settings.create()
                    .breakInstantly()
                    .dropsNothing()
                    .noCollision()
                    .noBlockBreakParticles()
                    .sounds(BlockSoundGroup.CANDLE),
            true);

    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings, boolean withItem) {
        Identifier id = Identifier.of(MOD_ID, path);
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);

        Block block = Blocks.register(blockKey, factory, settings);
        if (withItem)
            Items.register(block);
        return block;
    }

    public static void initialize() {}
}
