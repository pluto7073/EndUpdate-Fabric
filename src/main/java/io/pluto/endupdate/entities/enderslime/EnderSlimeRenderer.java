package io.pluto.endupdate.entities.enderslime;

import io.pluto.endupdate.entities.ModEntities;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

import java.util.Random;

public class EnderSlimeRenderer extends MobEntityRenderer<EnderSlime, EnderSlimeModel> {

    public EnderSlimeRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new EnderSlimeModel(), 0.5f);
    }

    @Override
    public Identifier getTexture(EnderSlime entity) {
        return new Identifier(ModEntities.MOD_ID, "textures/entity/ender_slime/purple.png");
    }

}
