package io.pluto.endupdate.features.chorus_tree;

import io.pluto.endupdate.EndUpdate;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Random;

public class ChorusSaplingGenerator extends SaplingGenerator {
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
        return EndUpdate.CHORUS_TREE_FEATURE;
    }


}
