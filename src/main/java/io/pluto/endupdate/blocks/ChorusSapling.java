package io.pluto.endupdate.blocks;

import io.pluto.endupdate.features.chorus_tree.ChorusSaplingGenerator;
import io.pluto.endupdate.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.SaplingBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class ChorusSapling extends SaplingBlock {

    public ChorusSapling() {
        super(new ChorusSaplingGenerator(), Settings.of(Material.PLANT).noCollision().nonOpaque().ticksRandomly().strength(0.0F, 0.0F).sounds(BlockSoundGroup.GRASS));
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.generate(world, pos, state, random);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.equals(ModBlocks.PURPUR_GRASS.getDefaultState()) || floor.equals(ModBlocks.PURPLESTONE.getDefaultState());
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return super.canGrow(world, random, pos, state);
    }

    
}
