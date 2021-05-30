package io.pluto.endupdate.entities;

import io.pluto.endupdate.EndUpdate;
import io.pluto.endupdate.entities.enderbones.EnderBones;
import io.pluto.endupdate.entities.enderslime.EnderSlime;
import io.pluto.endupdate.entities.enderslime.EnderSlimeRenderer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {

    public static final String MOD_ID = EndUpdate.MOD_ID;

    public static final EntityType<EnderSlime> ENDER_SLIME = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MOD_ID, "ender_slime"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EnderSlime::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static final EntityType<EnderBones> ENDER_BONES = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MOD_ID, "ender_bones"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EnderBones::new)
                .dimensions(EntityDimensions.fixed(0.6f, 2.56f)).build()
    );

    public static void registerEntities() {
        FabricDefaultAttributeRegistry.register(ENDER_SLIME, EnderSlime.createMobAttributes());
        FabricDefaultAttributeRegistry.register(ENDER_BONES, EnderBones.createMobAttributes());
    }

    public static void clientStuff() {
        EntityRendererRegistry.INSTANCE.register(ENDER_SLIME, (dispatcher, context) -> new EnderSlimeRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(ENDER_BONES, (dispatcher, context) -> new EnderBonesRenderer(dispatcher));
    }

}
