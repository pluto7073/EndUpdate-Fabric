package io.pluto.endupdate.materials;

import io.pluto.endupdate.registry.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class ChorusGemArmorMaterial implements ArmorMaterial {

    private static final int[] BASE_DURABILITY = new int[] {1920, 2000, 2048, 1920};
    private static final int[] PROTECTION_VALUES = new int[] {3, 6, 8, 3};
    public static final ChorusGemArmorMaterial INSTANCE = new ChorusGemArmorMaterial();

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()];
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 22;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.CHORUS_GEM);
    }

    @Override
    public String getName() {
        return "chorus_gem";
    }

    @Override
    public float getToughness() {
        return 10.0f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.10f;
    }

}
