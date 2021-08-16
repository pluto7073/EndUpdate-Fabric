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

    //Other
    public static final Item CHORUS_GEM = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

    //Tools
    public static final SwordItem CHORUS_GEM_SWORD = new SwordItem(ChorusGemToolMaterial.INSTANCE, 3, -2.4f, new Item.Settings().group(ItemGroup.COMBAT));
    public static final AxeItem CHORUS_GEM_AXE = new ChorusGemAxe(ChorusGemToolMaterial.INSTANCE, 5f, -3.0f, new Item.Settings().group(ItemGroup.TOOLS));
    public static final PickaxeItem CHORUS_GEM_PICKAXE = new ChorusGemPickaxe(ChorusGemToolMaterial.INSTANCE, 1, -2.8f, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ShovelItem CHORUS_GEM_SHOVEL = new ShovelItem(ChorusGemToolMaterial.INSTANCE, 1.5f, -3.0f, new Item.Settings().group(ItemGroup.TOOLS));
    public static final HoeItem CHORUS_GEM_HOE = new ChorusGemHoe(ChorusGemToolMaterial.INSTANCE, -4, 0, new Item.Settings().group(ItemGroup.TOOLS));

    //Armour
    public static final Item CHORUS_GEM_HELMET = new ArmorItem(ChorusGemArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item CHORUS_GEM_CHESTPLATE = new ArmorItem(ChorusGemArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item CHORUS_GEM_LEGGINGS = new ArmorItem(ChorusGemArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item CHORUS_GEM_BOOTS = new ArmorItem(ChorusGemArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));

    //BlockItems
    public static final Item PURPLESTONE;
    public static final Item CHORUS_BUSH;
    public static final Item PURPUR_GRASS;
    public static final Item CHORUS_WOOD;
    //public static final Item ELYTRIAN_GRASS;

    static {
        /*ELYTRIAN_GRASS = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "elytrian_grass"),
                new BlockItem(ModBlocks.ELYTRIAN_GRASS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));*/
        PURPLESTONE = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purplestone"),
                new BlockItem(ModBlocks.PURPLESTONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        CHORUS_BUSH = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_bush"),
                new BlockItem(ModBlocks.CHORUS_BUSH, new Item.Settings().group(ItemGroup.DECORATIONS)));
        PURPUR_GRASS = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purpur_grass"),
                new BlockItem(ModBlocks.PURPUR_GRASS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        CHORUS_WOOD = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "chorus_wood"),
                new BlockItem(ModBlocks.CHORUS_WOOD, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
    }

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
    }

}
