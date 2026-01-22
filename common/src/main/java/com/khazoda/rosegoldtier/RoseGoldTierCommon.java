package com.khazoda.rosegoldtier;

import com.khazoda.rosegoldtier.platform.Services;
import com.khazoda.rosegoldtier.registry.MainRegistry;
import com.khazoda.rosegoldtier.registry.TabRegistry;
import com.khazoda.rosegoldtier.registry.helper.Reginald;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Items;

public class RoseGoldTierCommon {
  public static final Reginald REGISTRARS = new Reginald();
  public static final boolean mod_loaded_farmersdelight = Services.PLATFORM.isModLoaded("farmersdelight");
  public static final boolean mod_loaded_wardentools = Services.PLATFORM.isModLoaded("wardentools");


  public static void init() {
    MainRegistry.init();
    TabRegistry.init();

    if (Services.PLATFORM.isModLoaded("rosegoldtier")) Constants.LOG.info("- Rose Gold Tier Loaded -");
  }
}