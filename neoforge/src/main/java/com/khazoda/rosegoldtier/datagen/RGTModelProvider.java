package com.khazoda.rosegoldtier.datagen;

import com.khazoda.rosegoldtier.Constants;
import com.khazoda.rosegoldtier.registry.MainRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class RGTModelProvider extends ItemModelProvider {

    public RGTModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
         super(packOutput, Constants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        trimmedArmorItem(MainRegistry.ROSE_GOLD_HELMET.get());
        trimmedArmorItem(MainRegistry.ROSE_GOLD_CHESTPLATE.get());
        trimmedArmorItem(MainRegistry.ROSE_GOLD_LEGGINGS.get());
        trimmedArmorItem(MainRegistry.ROSE_GOLD_BOOTS.get());
    }

    private void trimmedArmorItem(net.minecraft.world.item.Item item) {
        if (!(item instanceof net.minecraft.world.item.ArmorItem armorItem)) return;
        
        String armorType = switch (armorItem.getType()) {
            case HELMET -> "helmet";
            case CHESTPLATE -> "chestplate";
            case LEGGINGS -> "leggings";
            case BOOTS -> "boots";
            default -> "";
        };

        String itemName = "rose_gold_" + armorType;

        net.neoforged.neoforge.client.model.generators.ItemModelBuilder builder = withExistingParent(itemName,
                mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + itemName));

        java.util.LinkedHashMap<String, Float> trimMaterials = new java.util.LinkedHashMap<>();
        trimMaterials.put("quartz", 0.1f);
        trimMaterials.put("iron", 0.2f);
        trimMaterials.put("netherite", 0.3f);
        trimMaterials.put("redstone", 0.4f);
        trimMaterials.put("copper", 0.5f);
        trimMaterials.put("gold", 0.6f);
        trimMaterials.put("emerald", 0.7f);
        trimMaterials.put("diamond", 0.8f);
        trimMaterials.put("lapis", 0.9f);
        trimMaterials.put("amethyst", 1.0f);

        for (java.util.Map.Entry<String, Float> entry : trimMaterials.entrySet()) {
            String trimMaterial = entry.getKey();
            float trimValue = entry.getValue();

            String trimName = itemName + "_" + trimMaterial + "_armor_trim";

            withExistingParent(trimName, mcLoc("item/generated"))
                    .texture("layer0", modLoc("item/" + itemName))
                    .texture("layer1", mcLoc("trims/items/" + armorType + "_trim_" + trimMaterial));

            builder.override()
                    .predicate(net.minecraft.resources.ResourceLocation.withDefaultNamespace("trim_type"), trimValue)
                    .model(new net.neoforged.neoforge.client.model.generators.ModelFile.UncheckedModelFile(modLoc("item/" + trimName)))
                    .end();
        }
    }
}
