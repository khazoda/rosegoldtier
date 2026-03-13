package com.khazoda.rosegoldtier.datagen;

import com.khazoda.rosegoldtier.Constants;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class RGTDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        event.getGenerator().addProvider(
                event.includeClient(),
                new RGTModelProvider(event.getGenerator().getPackOutput(), event.getExistingFileHelper())
        );
    }
}
