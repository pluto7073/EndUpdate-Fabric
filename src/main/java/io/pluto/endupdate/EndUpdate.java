package io.pluto.endupdate;

import io.pluto.endupdate.registry.ModBlocks;
import io.pluto.endupdate.registry.ModItems;
import io.pluto.endupdate.registry.ModWorldgen;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class EndUpdate implements ModInitializer {

    public static final String MOD_ID = "end";

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id, configuredFeature);
    }

    static {

    }

    @Override
    public void onInitialize() {
        ModBlocks.register();
        ModItems.register();
        ModWorldgen.register();
    }

}
