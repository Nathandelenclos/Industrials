package com.nather.industrials.client;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final FoodComponent SUSPICIOUS_SUBSTANCE_FOOD = new FoodComponent.Builder()
            .nutrition(-5)
            .snack()
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 75 * 20), 1.0f)
            .build();

    public static final Item SUSPICIOUS_SUBSTANCE = register(
            new Item(new Item.Settings().food(SUSPICIOUS_SUBSTANCE_FOOD)),
            "suspicious_substance"
    );

    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        Identifier itemID = Identifier.of("industrials", id);

        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(ModItems.SUSPICIOUS_SUBSTANCE));
    }
}
