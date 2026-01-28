package com.khazoda.rosegoldtier.registry;

import com.khazoda.rosegoldtier.RoseGoldTierCommon;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Supplier;

import static com.khazoda.rosegoldtier.RoseGoldTierCommon.mod_loaded_farmersdelight;
import static com.khazoda.rosegoldtier.RoseGoldTierCommon.mod_loaded_wardentools;

@SuppressWarnings("unused")
public class TabRegistry {
  public static final Supplier<CreativeModeTab> ROSE_GOLD_TIER_TAB = RoseGoldTierCommon.REGISTRARS
      .get(Registries.CREATIVE_MODE_TAB)
      .register("main", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
          .title(Component.translatable("rosegoldtier.itemGroup"))
          .icon(() -> MainRegistry.ROSE_GOLD_SWORD.get().getDefaultInstance())
          .displayItems((parameters, output) -> {
            output.accept(MainRegistry.ROSE_GOLD_SWORD.get());
            output.accept(MainRegistry.ROSE_GOLD_AXE.get());
            output.accept(MainRegistry.ROSE_GOLD_PICKAXE.get());
            output.accept(MainRegistry.ROSE_GOLD_SHOVEL.get());
            output.accept(MainRegistry.ROSE_GOLD_HOE.get());
            output.accept(MainRegistry.ROSE_GOLD_HELMET.get());
            output.accept(MainRegistry.ROSE_GOLD_CHESTPLATE.get());
            output.accept(MainRegistry.ROSE_GOLD_LEGGINGS.get());
            output.accept(MainRegistry.ROSE_GOLD_BOOTS.get());
            if (mod_loaded_farmersdelight) output.accept(MainRegistry.ROSE_GOLD_KNIFE.get());
            output.accept(MainRegistry.ROSE_GOLD_BLEND.get());
            output.accept(MainRegistry.ROSE_GOLD_NUGGET.get());
            if (!mod_loaded_wardentools) output.accept(MainRegistry.ROSE_GOLD_INGOT.get());
            output.accept(MainRegistry.ROSE_GOLD_HORSE_ARMOR.get());
            if (!mod_loaded_wardentools) output.accept(MainRegistry.ROSE_GOLD_BLOCK_ITEM.get());
            output.accept(MainRegistry.ROSE_GOLD_BLEND_BLOCK_ITEM.get());
            output.accept(MainRegistry.ROSE_GOLD_DOOR_ITEM.get());
            output.accept(MainRegistry.ROSE_GOLD_TRAPDOOR_ITEM.get());
            output.accept(MainRegistry.ROSE_GOLD_PRESSURE_PLATE_ITEM.get());
          })
          .build());

  public static void init() {
  }
}