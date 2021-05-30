package io.pluto.endupdate.registry;

import io.pluto.endupdate.EndUpdate;
import io.pluto.endupdate.items.ChorusGemAxe;
import io.pluto.endupdate.items.ChorusGemHoe;
import io.pluto.endupdate.items.ChorusGemPickaxe;
import io.pluto.endupdate.materials.ChorusGemArmorMaterial;
import io.pluto.endupdate.materials.ChorusGemToolMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final String MOD_ID = EndUpdate.MOD_ID;

    public static final Item CHORUS_GEM = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

    public static final SwordItem CHORUS_GEM_SWORD = new SwordItem(ChorusGemToolMaterial.INSTANCE, 2, 2.5f, new Item.Settings().group(ItemGroup.COMBAT));
    public static final AxeItem CHORUS_GEM_AXE = new ChorusGemAxe(ChorusGemToolMaterial.INSTANCE, 2.5f, 2.5f, new Item.Settings().group(ItemGroup.TOOLS));
    public static final PickaxeItem CHORUS_GEM_PICKAXE = new ChorusGemPickaxe(ChorusGemToolMaterial.INSTANCE, 1, 2.5f, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ShovelItem CHORUS_GEM_SHOVEL = new ShovelItem(ChorusGemToolMaterial.INSTANCE, 1, 2.5f, new Item.Settings().group(ItemGroup.TOOLS));
    public static final HoeItem CHORUS_GEM_HOE = new ChorusGemHoe(ChorusGemToolMaterial.INSTANCE, 1, 2.5f, new Item.Settings().group(ItemGroup.TOOLS));

    public static final Item CHORUS_GEM_HELMET = new ArmorItem(ChorusGemArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item CHORUS_GEM_CHESTPLATE = new ArmorItem(ChorusGemArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item CHORUS_GEM_LEGGINGS = new ArmorItem(ChorusGemArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item CHORUS_GEM_BOOTS = new ArmorItem(ChorusGemArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));

    public static Item PURPLESTONE;
    public static Item CHORUS_BUSH;
    public static Item CHORUS_SAPLING;
    public static Item PURPUR_GRASS;
    public static Item CHORUS_WOOD;

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_gem"), CHORUS_GEM);

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_gem_sword"), CHORUS_GEM_SWORD);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_gem_axe"), CHORUS_GEM_AXE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_gem_pickaxe"), CHORUS_GEM_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_gem_shovel"), CHORUS_GEM_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_gem_hoe"), CHORUS_GEM_HOE);

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_gem_helmet"), CHORUS_GEM_HELMET);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_gem_chestplate"), CHORUS_GEM_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_gem_leggings"), CHORUS_GEM_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_gem_boots"), CHORUS_GEM_BOOTS);

        PURPLESTONE = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purplestone"),
                new BlockItem(ModBlocks.PURPLESTONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        CHORUS_BUSH = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_bush"),
                new BlockItem(ModBlocks.CHORUS_BUSH, new Item.Settings().group(ItemGroup.DECORATIONS)));
        CHORUS_SAPLING = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_sapling"),
                new BlockItem(ModBlocks.CHORUS_SAPLING, new Item.Settings().group(ItemGroup.DECORATIONS)));
        PURPUR_GRASS = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpur_grass"),
                new BlockItem(ModBlocks.PURPUR_GRASS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        CHORUS_WOOD = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_wood"),
                new BlockItem(ModBlocks.CHORUS_WOOD, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
    }

}
