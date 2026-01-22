package com.khazoda.rosegoldtier.item;

import com.khazoda.rosegoldtier.material.RoseGoldToolMaterial;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;

public class RoseGoldHoe extends HoeItem {
  public RoseGoldHoe(Tier tier) {
    super(tier, getItemSettings());
  }

  private static Properties getItemSettings() {
    return (new Properties()).attributes(HoeItem.createAttributes(RoseGoldToolMaterial.INSTANCE, -2.0F, 0.0F));
  }
}
