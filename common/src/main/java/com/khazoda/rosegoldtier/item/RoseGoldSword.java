package com.khazoda.rosegoldtier.item;

import com.khazoda.rosegoldtier.material.RoseGoldToolMaterial;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class RoseGoldSword extends SwordItem {
  public RoseGoldSword(Tier tier) {
    super(tier, getItemSettings());
  }

  private static Properties getItemSettings() {
    return (new Properties()).attributes(PickaxeItem.createAttributes(RoseGoldToolMaterial.INSTANCE, 3.0F, -2.4F));
  }
}
