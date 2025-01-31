package chloriticleaf.ritualism;

//import com.ritualism.worldgen.biome.ritualismBiomes;
//import com.ritualism.ritualism.worldgen.feature.ritualismFeatures;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;

@Environment(EnvType.CLIENT)
public class RitualismDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        //pack.addProvider(RitualismBlockTagProvider::new);
        //pack.addProvider(RitualismItemTagProvider::new);
        //pack.addProvider(RitualismLootTableProvider::new);
        pack.addProvider(RitualismModelProvider::new);
        // pack.addProvider(RitualismRecipeProvider::new);
        //pack.addProvider(RitualismRegistryProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        //registryBuilder
        //        .addRegistry(RegistryKeys.BIOME, RitualismBiomes::initializeBiomes)
        //        .addRegistry(RegistryKeys.CONFIGURED_FEATURE, RitualismFeatures::initializeConfiguredFeatures)
        //        .addRegistry(RegistryKeys.PLACED_FEATURE, RitualismFeatures::initializePlacedFeatures);
    }
}