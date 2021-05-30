package io.pluto.endupdate.registry;

import io.pluto.endupdate.EndUpdate;
import io.pluto.endupdate.blocks.ChorusSapling;
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
    public static final Block CHORUS_GEM_ORE = new EndGemOre();
    public static final Block CHORUS_LOG = new PillarBlock(AbstractBlock.Settings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block CHORUS_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD).breakByHand(true).breakByTool(FabricToolTags.AXES).strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block PURPLESTONE = new Block(AbstractBlock.Settings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F));
    public static final Block CHORUS_BUSH = new Block(AbstractBlock.Settings.of(Material.LEAVES).strength(0.5F, 0.5F).sounds(BlockSoundGroup.GRASS).nonOpaque());
    public static final Block CHORUS_SAPLING = new ChorusSapling();
    public static final Block PURPUR_GRASS = new Block(AbstractBlock.Settings.of(Material.SOLID_ORGANIC).strength(0.6F).sounds(BlockSoundGroup.GRASS));
    public static final Block CHORUS_WOOD = new PillarBlock(AbstractBlock.Settings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD));

    public static void register() {
        //Blocks
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "chorus_gem_ore"), CHORUS_GEM_ORE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "chorus_log"), CHORUS_LOG);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "chorus_planks"), CHORUS_PLANKS);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "purplestone"), PURPLESTONE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "chorus_bush"), CHORUS_BUSH);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "chorus_sapling"), CHORUS_SAPLING);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "purpur_grass"), PURPUR_GRASS);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "chorus_wood"), CHORUS_WOOD);

        //Block Items
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_gem_ore"), new BlockItem(CHORUS_GEM_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_log"), new BlockItem(CHORUS_LOG, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_planks"), new BlockItem(CHORUS_PLANKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
    }

}