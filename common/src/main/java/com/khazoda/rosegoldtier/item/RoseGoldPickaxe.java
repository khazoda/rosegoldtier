package com.khazoda.rosegoldtier.item;

import com.khazoda.rosegoldtier.material.RoseGoldToolMaterial;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class RoseGoldPickaxe extends PickaxeItem {
  public RoseGoldPickaxe(Tier tier) {
    super(tier, getItemSettings());
  }

  private static Properties getItemSettings() {
    return (new Properties()).attributes(PickaxeItem.createAttributes(RoseGoldToolMaterial.INSTANCE, 1.0F, -2.8F));
  }
}
