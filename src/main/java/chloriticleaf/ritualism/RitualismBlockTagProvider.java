package chloriticleaf.ritualism;

import chloriticleaf.ritualism.block.RitualismBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class RitualismBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public RitualismBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(RitualismBlockTags.RITUAL_DRAWER).add(RitualismBlocks.RITUALDRAWERS);
    }
}
