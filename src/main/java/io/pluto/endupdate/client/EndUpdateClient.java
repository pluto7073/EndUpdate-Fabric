package io.pluto.endupdate.client;

import io.pluto.endupdate.entities.ModEntities;
import io.pluto.endupdate.registry.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class EndUpdateClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModEntities.clientStuff();
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHORUS_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PURPUR_GRASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHORUS_SAPLING, RenderLayer.getCutout());
    }
}
