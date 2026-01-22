package com.khazoda.rosegoldtier.item;

import com.khazoda.rosegoldtier.material.RoseGoldToolMaterial;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

public class RoseGoldShovel extends ShovelItem {
  public RoseGoldShovel(Tier tier) {
    super(tier, getItemSettings());
  }

  private static Properties getItemSettings() {
    return (new Properties()).attributes(ShovelItem.createAttributes(RoseGoldToolMaterial.INSTANCE, 1.5F, -3.0F));
  }
}
