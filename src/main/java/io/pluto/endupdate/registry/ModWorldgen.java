package io.pluto.endupdate.registry;

import io.pluto.endupdate.EndUpdate;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class ModWorldgen {

    public static ConfiguredFeature<?, ?> ORE_CHORUS_GEM_END = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.END_STONE),
                    ModBlocks.CHORUS_GEM_ORE.getDefaultState(),
                    3
            )).range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(64))
            )).spreadHorizontally()
            .repeat(1);

    private static void addChorusGemOre() {
        RegistryKey<ConfiguredFeature<?, ?>> oreChorusGemEnd = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(EndUpdate.MOD_ID, "ore_chorus_gem_end"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreChorusGemEnd.getValue(), ORE_CHORUS_GEM_END);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, oreChorusGemEnd);
    }

    public static void register() {
        addChorusGemOre();
    }

}
