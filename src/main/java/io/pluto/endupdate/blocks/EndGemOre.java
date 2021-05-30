package io.pluto.endupdate.blocks;

import net.minecraft.block.*;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class EndGemOre extends OreBlock {

    public EndGemOre() {
        super(AbstractBlock.Settings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F));
    }

    @Override
    protected int getExperienceWhenMined(Random random) {
        return MathHelper.nextInt(random, 5, 7);
    }

}
