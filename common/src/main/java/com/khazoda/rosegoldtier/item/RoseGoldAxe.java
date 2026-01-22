package com.khazoda.rosegoldtier.item;

import com.khazoda.rosegoldtier.material.RoseGoldToolMaterial;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class RoseGoldAxe extends AxeItem {
  public RoseGoldAxe(Tier tier) {
    super(tier, getItemSettings());
  }

  private static Properties getItemSettings() {
    return (new Properties()).attributes(PickaxeItem.createAttributes(RoseGoldToolMaterial.INSTANCE, 5.5F, -3.1F));
  }
}
