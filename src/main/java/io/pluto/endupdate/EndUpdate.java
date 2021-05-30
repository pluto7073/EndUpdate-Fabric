package io.pluto.endupdate;

import com.google.common.collect.ImmutableList;
import io.pluto.endupdate.features.end_spike.EndSpike;
import io.pluto.endupdate.features.end_spike.EndSpikeGenerator;
import io.pluto.endupdate.registry.ModBlocks;
import io.pluto.endupdate.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.TheEndBiomes;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.fabricmc.fabric.impl.biome.modification.BiomeModificationImpl;
import net.minecraft.block.Blocks;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;

public class EndUpdate implements ModInitializer {

    public static final String MOD_ID = "end";

    public static final RegistryKey<Biome> PURPLESTONE_SPIKES_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(MOD_ID, "purplestone_spikes"));
    public static final RegistryKey<Biome> PURPUR_FOREST_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(MOD_ID, "purpur_forest"));

    public static final StructurePieceType END_SPIKE_PIECE = EndSpikeGenerator.EndSpikePiece::new;
    public static final StructureFeature<DefaultFeatureConfig> END_SPIKE = new EndSpike(DefaultFeatureConfig.CODEC);
    public static final ConfiguredStructureFeature<?, ?> END_SPIKE_CONFIG = END_SPIKE.configure(DefaultFeatureConfig.DEFAULT);

    private static final ConfiguredFeature<?, ?> ORE_CHORUS_GEM = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.END_STONE),
                    ModBlocks.CHORUS_GEM_ORE.getDefaultState(),
                    9))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    64)))
            .spreadHorizontally()
            .repeat(20);
    private static final ConfiguredFeature<?, ?> ORE_PURPLESTONE_PATCH = Feature.NO_SURFACE_ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.END_STONE),
                    ModBlocks.PURPLESTONE.getDefaultState(),
                    20))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0, 0, 64)))
            .spreadHorizontally()
            .repeat(20);

    public static final ConfiguredFeature<TreeFeatureConfig, ?> CHORUS_TREE_FEATURE;

    private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> PURPLESTONE_SURFACE_BUILDER = SurfaceBuilder.DEFAULT
            .withConfig(new TernarySurfaceConfig(
                    ModBlocks.PURPLESTONE.getDefaultState(),
                    Blocks.END_STONE.getDefaultState(),
                    Blocks.END_STONE.getDefaultState()));

    private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> PURPUR_GRASS_BUILDER = SurfaceBuilder.DEFAULT
            .withConfig(new TernarySurfaceConfig(
                    ModBlocks.PURPUR_GRASS.getDefaultState(),
                    ModBlocks.PURPLESTONE.getDefaultState(),
                    Blocks.END_STONE.getDefaultState()));

    private static final Biome PURPLESTONE_SPIKES = createPurplestoneSpikes();
    private static final Biome PURPUR_FOREST;
    private static final ConfiguredFeature<?, ?> CHORUS_TREES;

    private static Biome createPurplestoneSpikes() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addEndMobs(spawnSettings);

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(PURPLESTONE_SURFACE_BUILDER);
        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.NONE)
                .category(Biome.Category.NONE)
                .depth(0.125F)
                .scale(0.05F)
                .temperature(0.5F)
                .downfall(0.4F)
                .effects((new BiomeEffects.Builder())
                    .waterColor(0x0000FF)
                    .waterFogColor(0x0009FF)
                    .fogColor(0xd442f5)
                    .skyColor(0x000000)
                    .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

    private static Biome createPurpurForest() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addEndMobs(spawnSettings);

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(PURPUR_GRASS_BUILDER);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, CHORUS_TREES);
        addPurpurForestTrees(generationSettings);
        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.NONE)
                .category(Biome.Category.NONE)
                .depth(0.125F)
                .scale(0.05F)
                .temperature(0.5F)
                .downfall(0.4F)
                .effects((new BiomeEffects.Builder())
                    .waterColor(0xFF00FF)
                    .waterFogColor(0xFF00FF)
                    .fogColor(0xd442f5)
                    .skyColor(0x000000)
                    .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

    private static void addPurpurForestTrees(GenerationSettings.Builder builder) {

    }

    private static void addChorusGemOre() {
        RegistryKey<ConfiguredFeature<?, ?>> oreChorusGem = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier(MOD_ID, "ore_chorus_gem"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreChorusGem.getValue(), ORE_CHORUS_GEM);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_MIDLANDS, BiomeKeys.END_HIGHLANDS, BiomeKeys.END_BARRENS, BiomeKeys.SMALL_END_ISLANDS, PURPUR_FOREST_KEY, PURPLESTONE_SPIKES_KEY), GenerationStep.Feature.UNDERGROUND_ORES, oreChorusGem);
    }
    private static void addPurplestoneSpots() {
        RegistryKey<ConfiguredFeature<?, ?>> orePurplestone = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier(MOD_ID, "ore_purplestone"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, orePurplestone.getValue(), ORE_PURPLESTONE_PATCH);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_MIDLANDS,
                BiomeKeys.END_HIGHLANDS,
                BiomeKeys.SMALL_END_ISLANDS,
                PURPLESTONE_SPIKES_KEY,
                PURPUR_FOREST_KEY), GenerationStep.Feature.UNDERGROUND_ORES, orePurplestone);
    }

    private static void registerSpikes() {
        Registry.register(Registry.STRUCTURE_PIECE, new Identifier(MOD_ID, "end_spike_piece"), END_SPIKE_PIECE);
        FabricStructureBuilder.create(new Identifier(MOD_ID, "end_spike"), END_SPIKE)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(1, 0, 0)
                .adjustsSurface()
                .register();
        RegistryKey<ConfiguredStructureFeature<?, ?>> spike_configured = RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_WORLDGEN,
                new Identifier(MOD_ID, "end_spike"));
        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, spike_configured.getValue(), END_SPIKE_CONFIG);
        BiomeModifications.addStructure(BiomeSelectors.includeByKey(PURPLESTONE_SPIKES_KEY), spike_configured);
    }

    private static void registerPurplestoneSpikes() {
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(MOD_ID, "purplestone"), PURPLESTONE_SURFACE_BUILDER);
        Registry.register(BuiltinRegistries.BIOME, PURPLESTONE_SPIKES_KEY.getValue(), PURPLESTONE_SPIKES);
        TheEndBiomes.addHighlandsBiome(PURPLESTONE_SPIKES_KEY, 5D);
    }

    private static void registerPurpurForest() {
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(MOD_ID, "purpur_grass"), PURPUR_GRASS_BUILDER);
        Registry.register(BuiltinRegistries.BIOME, PURPUR_FOREST_KEY.getValue(), PURPUR_FOREST);
        TheEndBiomes.addHighlandsBiome(PURPUR_FOREST_KEY, 6D);
        TheEndBiomes.addMidlandsBiome(PURPUR_FOREST_KEY, PURPUR_FOREST_KEY, 6D);
    }

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id, configuredFeature);
    }

    static {
        CHORUS_TREE_FEATURE = register("chorus", Feature.TREE
                .configure(
                        (new TreeFeatureConfig.Builder(
                                new SimpleBlockStateProvider(ModBlocks.CHORUS_LOG.getDefaultState()),
                                new SimpleBlockStateProvider(ModBlocks.CHORUS_BUSH.getDefaultState()),
                                new AcaciaFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0)),
                                new ForkingTrunkPlacer(5, 2, 2),
                                new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build()));
        CHORUS_TREES = register("chorus_vegetation", Feature.RANDOM_SELECTOR
                .configure(new RandomFeatureConfig(ImmutableList.of(CHORUS_TREE_FEATURE.withChance(1.0F)),
                        CHORUS_TREE_FEATURE)).decorate(Decorator.DARK_OAK_TREE.configure(DecoratorConfig.DEFAULT)));
        PURPUR_FOREST = createPurpurForest();
    }

    private static void addChorusTrees() {

    }

    @Override
    public void onInitialize() {
        ModBlocks.register();
        ModItems.register();
        addChorusGemOre();
        registerSpikes();
        registerPurplestoneSpikes();
        registerPurpurForest();
        addPurplestoneSpots();
        addChorusTrees();
    }

}
