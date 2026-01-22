package com.khazoda.rosegoldtier.registry;

import com.khazoda.rosegoldtier.RoseGoldTierCommon;
import com.khazoda.rosegoldtier.block.RoseGoldBlendBlock;
import com.khazoda.rosegoldtier.block.RoseGoldBlock;
import com.khazoda.rosegoldtier.block.RoseGoldDoor;
import com.khazoda.rosegoldtier.block.RoseGoldTrapdoor;
import com.khazoda.rosegoldtier.item.*;
import com.khazoda.rosegoldtier.material.RoseGoldArmorMaterial;
import com.khazoda.rosegoldtier.material.RoseGoldToolMaterial;
import com.khazoda.rosegoldtier.registry.helper.Reggie;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

import static com.khazoda.rosegoldtier.RoseGoldTierCommon.mod_loaded_farmersdelight;
import static net.minecraft.world.item.ArmorItem.Type.CHESTPLATE;


public class MainRegistry {
  private static final Reggie<Block> BLOCK_REGISTRAR = RoseGoldTierCommon.REGISTRARS.get(Registries.BLOCK);
  private static final Reggie<Item> ITEM_REGISTRAR = RoseGoldTierCommon.REGISTRARS.get(Registries.ITEM);
  private static final Reggie<ArmorMaterial> ARMOR_MATERIAL_REGISTRAR = RoseGoldTierCommon.REGISTRARS.get(Registries.ARMOR_MATERIAL);

  /* This c tag includes this mod's rose gold ingot as well as warden tools' one */
  public static final TagKey<Item> ROSE_GOLD_INGOT_TAGKEY = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "ingots/rose_gold"));

  /* ==========[ Item Registration ]========== */
  public static final Supplier<Item> ROSE_GOLD_BLEND = ITEM_REGISTRAR.register("rose_gold_blend", RoseGoldBlend::new);
  public static final Supplier<Item> ROSE_GOLD_NUGGET = ITEM_REGISTRAR.register("rose_gold_nugget", RoseGoldNugget::new);
  public static final Supplier<Item> ROSE_GOLD_INGOT = ITEM_REGISTRAR.register("rose_gold_ingot", RoseGoldIngot::new);
  public static final Supplier<Item> ROSE_GOLD_HORSE_ARMOR = ITEM_REGISTRAR.register("rose_gold_horse_armor", () -> new AnimalArmorItem(RoseGoldArmorMaterial.HOLDER, AnimalArmorItem.BodyType.EQUESTRIAN, false, new Item.Properties().stacksTo(1)));

  public static final Supplier<TieredItem> ROSE_GOLD_SWORD = ITEM_REGISTRAR.register("rose_gold_sword", () -> new RoseGoldSword(RoseGoldToolMaterial.INSTANCE));
  public static final Supplier<TieredItem> ROSE_GOLD_AXE = ITEM_REGISTRAR.register("rose_gold_axe", () -> new RoseGoldAxe(RoseGoldToolMaterial.INSTANCE));
  public static final Supplier<TieredItem> ROSE_GOLD_PICKAXE = ITEM_REGISTRAR.register("rose_gold_pickaxe", () -> new RoseGoldPickaxe(RoseGoldToolMaterial.INSTANCE));
  public static final Supplier<TieredItem> ROSE_GOLD_SHOVEL = ITEM_REGISTRAR.register("rose_gold_shovel", () -> new RoseGoldShovel(RoseGoldToolMaterial.INSTANCE));
  public static final Supplier<TieredItem> ROSE_GOLD_HOE = ITEM_REGISTRAR.register("rose_gold_hoe", () -> new RoseGoldHoe(RoseGoldToolMaterial.INSTANCE));

  public static final Supplier<Item> ROSE_GOLD_HELMET = ITEM_REGISTRAR.register("rose_gold_helmet", () -> new ArmorItem(RoseGoldArmorMaterial.HOLDER, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(18))));
  public static final Supplier<Item> ROSE_GOLD_CHESTPLATE = ITEM_REGISTRAR.register("rose_gold_chestplate", () -> new ArmorItem(RoseGoldArmorMaterial.HOLDER, CHESTPLATE, new Item.Properties().durability(CHESTPLATE.getDurability(18))));
  public static final Supplier<Item> ROSE_GOLD_LEGGINGS = ITEM_REGISTRAR.register("rose_gold_leggings", () -> new ArmorItem(RoseGoldArmorMaterial.HOLDER, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(18))));
  public static final Supplier<Item> ROSE_GOLD_BOOTS = ITEM_REGISTRAR.register("rose_gold_boots", () -> new ArmorItem(RoseGoldArmorMaterial.HOLDER, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(18))));

  /* Farmers Delight Knife Compatibility */
  public static Supplier<Item> ROSE_GOLD_KNIFE;

  /* ==========[ Block Registration ]========== */
  public static final Supplier<Block> ROSE_GOLD_BLOCK = BLOCK_REGISTRAR.register("rose_gold_block", RoseGoldBlock::new);
  public static final Supplier<Block> ROSE_GOLD_TRAPDOOR = BLOCK_REGISTRAR.register("rose_gold_trapdoor", RoseGoldTrapdoor::new);
  public static final Supplier<Block> ROSE_GOLD_DOOR = BLOCK_REGISTRAR.register("rose_gold_door", RoseGoldDoor::new);
  public static final Supplier<Block> ROSE_GOLD_BLEND_BLOCK = BLOCK_REGISTRAR.register("rose_gold_blend_block", RoseGoldBlendBlock::new);

  /* ==========[ BlockItem Registration ]========== */
  public static final Supplier<BlockItem> ROSE_GOLD_BLOCK_ITEM = register("rose_gold_block", ROSE_GOLD_BLOCK);
  public static final Supplier<BlockItem> ROSE_GOLD_TRAPDOOR_ITEM = register("rose_gold_trapdoor", ROSE_GOLD_TRAPDOOR);
  public static final Supplier<BlockItem> ROSE_GOLD_DOOR_ITEM = register("rose_gold_door", ROSE_GOLD_DOOR);
  public static final Supplier<BlockItem> ROSE_GOLD_BLEND_BLOCK_ITEM = register("rose_gold_blend_block", ROSE_GOLD_BLEND_BLOCK);

  public static void init() {
    if (mod_loaded_farmersdelight)
      ROSE_GOLD_KNIFE = ITEM_REGISTRAR.register("rose_gold_knife", () -> new RoseGoldKnifeFarmersDelight(RoseGoldToolMaterial.INSTANCE));

  }

  private static Supplier<BlockItem> register(String name, Supplier<Block> block) {
    Supplier<BlockItem> blockItemSupplier = ITEM_REGISTRAR.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    return blockItemSupplier;
  }
}