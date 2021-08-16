package io.pluto.endupdate.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.Random;

public class EndGemOre extends OreBlock {

    public EndGemOre() {
        super(FabricBlockSettings.of(Material.STONE).requiresTool()
                .breakByTool(FabricToolTags.PICKAXES, 3).strength(20.0F, 1200.0F), UniformIntProvider.create(4, 10));
    }

}
