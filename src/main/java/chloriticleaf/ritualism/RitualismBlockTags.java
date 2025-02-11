package chloriticleaf.ritualism;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class RitualismBlockTags {
    public static final TagKey<Block> RITUAL_DRAWER = TagKey.of(RegistryKeys.BLOCK, Identifier.of("ritualism", "ritual_drawer"));
}
