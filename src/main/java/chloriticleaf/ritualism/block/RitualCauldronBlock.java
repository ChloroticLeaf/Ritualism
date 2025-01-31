package chloriticleaf.ritualism.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractCauldronBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;

public class RitualCauldronBlock extends AbstractCauldronBlock {
    public static final MapCodec<CauldronBlock> CODEC = createCodec(CauldronBlock::new);

    public boolean isFull(BlockState state) {
        return false;
    }

    public MapCodec<CauldronBlock> getCodec() {
        return CODEC;
    }

    public RitualCauldronBlock(AbstractBlock.Settings settings) {
        super(settings, CauldronBehavior.WATER_CAULDRON_BEHAVIOR);
    }

}
