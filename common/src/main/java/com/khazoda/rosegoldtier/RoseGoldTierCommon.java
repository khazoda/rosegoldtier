package com.khazoda.rosegoldtier;

import com.khazoda.rosegoldtier.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Items;

public class RoseGoldTierCommon {

    public static void init() {

        if (Services.PLATFORM.isModLoaded("rosegoldtier")) {
            Constants.LOG.info("- Rose Gold Tier Loaded -");
        }
    }
}