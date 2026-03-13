package com.khazoda.rosegoldtier.datagen;

import com.khazoda.rosegoldtier.registry.MainRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.world.item.ArmorItem;

public class RGTModelProvider extends FabricModelProvider {

  public RGTModelProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
  }

  @Override
  public void generateItemModels(ItemModelGenerators itemModelGenerators) {
    itemModelGenerators.generateArmorTrims((ArmorItem) MainRegistry.ROSE_GOLD_HELMET.get());
    itemModelGenerators.generateArmorTrims((ArmorItem) MainRegistry.ROSE_GOLD_CHESTPLATE.get());
    itemModelGenerators.generateArmorTrims((ArmorItem) MainRegistry.ROSE_GOLD_LEGGINGS.get());
    itemModelGenerators.generateArmorTrims((ArmorItem) MainRegistry.ROSE_GOLD_BOOTS.get());
  }
  
}
