package net.kaupenjoe.onedaymod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kaupenjoe.onedaymod.OneDayMod;
import net.kaupenjoe.onedaymod.entity.ModEntities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FAKE_LOVE_CREEPER_SPAWN_EGG = registerItem("fake_love_creeper_spawn_egg",
            new SpawnEggItem(ModEntities.FAKE_LOVE_CREEPER, 0x7d013f, 0xad9aab, new FabricItemSettings()));
    public static final Item FIRE_CREEPER_SPAWN_EGG = registerItem("fire_creeper_spawn_egg",
            new SpawnEggItem(ModEntities.FIRE_CREEPER, 0xfc3903, 0xad9aab, new FabricItemSettings()));
    public static final Item FLATTEN_CREEPER_SPAWN_EGG = registerItem("flatten_creeper_spawn_egg",
            new SpawnEggItem(ModEntities.FLATTEN_CREEPER, 0x168730, 0xad9aab, new FabricItemSettings()));
    public static final Item KNOCKBACK_CREEPER_SPAWN_EGG = registerItem("knockback_creeper_spawn_egg",
            new SpawnEggItem(ModEntities.KNOCKBACK_CREEPER, 0x2d3d31, 0xad9aab, new FabricItemSettings()));
    public static final Item LAVA_CREEPER_SPAWN_EGG = registerItem("lava_creeper_spawn_egg",
            new SpawnEggItem(ModEntities.LAVA_CREEPER, 0xdb3f30, 0xad9aab, new FabricItemSettings()));
    public static final Item LOVE_CREEPER_SPAWN_EGG = registerItem("love_creeper_spawn_egg",
            new SpawnEggItem(ModEntities.LOVE_CREEPER, 0xdb1fbf, 0xad9aab, new FabricItemSettings()));
    public static final Item SNOW_CREEPER_SPAWN_EGG = registerItem("snow_creeper_spawn_egg",
            new SpawnEggItem(ModEntities.SNOW_CREEPER, 0x87bec4, 0xad9aab, new FabricItemSettings()));
    public static final Item WATER_CREEPER_SPAWN_EGG = registerItem("water_creeper_spawn_egg",
            new SpawnEggItem(ModEntities.WATER_CREEPER, 0x263bbf, 0xad9aab, new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(OneDayMod.MOD_ID, name), item);
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
        entries.add(FAKE_LOVE_CREEPER_SPAWN_EGG);
        entries.add(FIRE_CREEPER_SPAWN_EGG);
        entries.add(FLATTEN_CREEPER_SPAWN_EGG);
        entries.add(KNOCKBACK_CREEPER_SPAWN_EGG);
        entries.add(LAVA_CREEPER_SPAWN_EGG);
        entries.add(LOVE_CREEPER_SPAWN_EGG);
        entries.add(SNOW_CREEPER_SPAWN_EGG);
        entries.add(WATER_CREEPER_SPAWN_EGG);
    }

    public static void registerModItems() {
        OneDayMod.LOGGER.info("Registering Mod Items for " + OneDayMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ModItems::itemGroupIngredients);
    }
}
