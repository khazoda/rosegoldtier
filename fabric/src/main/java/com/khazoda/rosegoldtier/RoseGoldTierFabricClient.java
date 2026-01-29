package com.khazoda.rosegoldtier;

import com.khazoda.rosegoldtier.registry.MainRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class RoseGoldTierFabricClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.ROSE_GOLD_DOOR.get(), RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.ROSE_GOLD_TRAPDOOR.get(), RenderType.cutout());
  }
}

