package com.khazoda.rosegoldtier;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class RoseGoldTier {

    public RoseGoldTier(IEventBus eventBus) {
        RoseGoldTierCommon.init();
    }
}