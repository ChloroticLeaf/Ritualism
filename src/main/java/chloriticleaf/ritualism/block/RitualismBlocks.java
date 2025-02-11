package chloriticleaf.ritualism.block;

import net.minecraft.block.*;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static chloriticleaf.ritualism.RitualismConstants.MOD_ID;

public class RitualismBlocks {

    // Ritual scribe blocks
    public static final Block RITUALDRAWERS = register("ritualdrawers", RitualDrawers::new,
            AbstractBlock.Settings.create()
                    .breakInstantly()
                    .dropsNothing()
                    .noCollision()
                    .sounds(BlockSoundGroup.CANDLE),
            true);

    // General blocks
    public static final Block RITUALCAULDRON  = register("ritualcauldron", RitualCauldronBlock::new,
            AbstractBlock.Settings.create()
                    .hardness(4f)
                    .resistance(4f)
                    .sounds(BlockSoundGroup.METAL),
            true);

    // Crystals
    public static final Block ATTUNEDCRYSTAL = register("attunedcrystal", Block::new,
            AbstractBlock.Settings.create()
                    .nonOpaque()
                    .emissiveLighting(AbstractBlock.AbstractBlockState::hasEmissiveLighting)
                    .hardness(4f),
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
