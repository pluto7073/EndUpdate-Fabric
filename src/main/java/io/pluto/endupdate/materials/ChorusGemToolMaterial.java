package io.pluto.endupdate.materials;

import io.pluto.endupdate.registry.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ChorusGemToolMaterial implements ToolMaterial {

    public static final ChorusGemToolMaterial INSTANCE = new ChorusGemToolMaterial();

    public int getDurability() {
        return 3201;
    }


    public float getMiningSpeedMultiplier() {
        return 12.0f;
    }


    public float getAttackDamage() {
        return 5.0f;
    }


    public int getMiningLevel() {
        return 5;
    }


    public int getEnchantability() {
        return 19;
    }


    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.CHORUS_GEM);
    }
}
