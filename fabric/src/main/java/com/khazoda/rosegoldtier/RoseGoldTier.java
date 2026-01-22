package com.khazoda.rosegoldtier;

import net.fabricmc.api.ModInitializer;

public class RoseGoldTier implements ModInitializer {
    
    @Override
    public void onInitialize() {
        RoseGoldTierCommon.init();
    }
}
