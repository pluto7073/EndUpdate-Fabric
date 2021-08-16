package io.pluto.endupdate.registry;

import io.pluto.endupdate.EndUpdate;
import io.pluto.endupdate.blocks.EndGemOre;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final String MOD_ID = EndUpdate.MOD_ID;

    //Blocks
    public static final Block CHORUS_GEM_ORE;
    public static final Block CHORUS_LOG;
    public static final Block CHORUS_PLANKS;
    public static final Block PURPLESTONE;
    public static final Block CHORUS_BUSH;
    public static final Block PURPUR_GRASS;
    public static final Block CHORUS_WOOD;
    //public static final Block ELYTRIAN_GRASS;

    //Block Items

    static {
        CHORUS_GEM_ORE = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "chorus_gem_ore"), new EndGemOre());
        CHORUS_LOG = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "chorus_log"),
                new PillarBlock(AbstractBlock.Settings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD)));
        CHORUS_PLANKS = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "chorus_planks"),
                new Block(FabricBlockSettings.of(Material.WOOD).breakByHand(true).breakByTool(FabricToolTags.AXES).strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD)));
        PURPLESTONE = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "purplestone"),
                new Block(AbstractBlock.Settings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F)));
        CHORUS_BUSH = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "chorus_bush"),
                new Block(AbstractBlock.Settings.of(Material.LEAVES).strength(0.5F, 0.5F).sounds(BlockSoundGroup.GRASS).nonOpaque()));
        PURPUR_GRASS = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "purpur_grass"),
                new Block(AbstractBlock.Settings.of(Material.SOLID_ORGANIC).strength(0.6F).sounds(BlockSoundGroup.GRASS)));
        CHORUS_WOOD = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "chorus_wood"),
                new PillarBlock(AbstractBlock.Settings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD)));
        /*ELYTRIAN_GRASS = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "elytrian_grass"),
                new Block(FabricBlockSettings.of(Material.SOIL).breakByHand(true).breakByTool(FabricToolTags.SHOVELS)
                    .strength(0.5f).sounds(BlockSoundGroup.STONE)));*/
    }

    public static void register() {
        //Block Items
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_gem_ore"), new BlockItem(CHORUS_GEM_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_log"), new BlockItem(CHORUS_LOG, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_planks"), new BlockItem(CHORUS_PLANKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
    }

}