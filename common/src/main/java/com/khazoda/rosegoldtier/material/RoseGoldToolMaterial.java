package com.khazoda.rosegoldtier.material;

import com.khazoda.rosegoldtier.registry.MainRegistry;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

//Todo: change block tag incorrect for tool, values
//Todo: change individual item class values too!!!
public class RoseGoldToolMaterial implements Tier {

  public static final RoseGoldToolMaterial INSTANCE = new RoseGoldToolMaterial();

  @Override
  public int getUses() {
    return 350;
  }

  @Override
  public float getSpeed() {
    return 7.0F;
  }

  @Override
  public float getAttackDamageBonus() {
    return 2.5F;
  }

  @Override
  public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
    return BlockTags.INCORRECT_FOR_IRON_TOOL;
  }

  @Override
  public int getEnchantmentValue() {
    return 15;
  }

  @Override
  public @NotNull Ingredient getRepairIngredient() {
    return Ingredient.of(MainRegistry.ROSE_GOLD_INGOT_TAGKEY);
  }
}
