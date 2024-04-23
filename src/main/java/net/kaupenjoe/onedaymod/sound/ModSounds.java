package net.kaupenjoe.onedaymod.sound;

import net.kaupenjoe.onedaymod.OneDayMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent FLAME_CREEPER = registerSoundEvent("flame_creeper");
    public static final SoundEvent FLATTEN_CREEPER = registerSoundEvent("flatten_creeper");
    public static final SoundEvent KNOCKBACK_CREEPER = registerSoundEvent("knockback_creeper");
    public static final SoundEvent LOVE_CREEPER = registerSoundEvent("love_creeper");
    public static final SoundEvent SNOW_CREEPER = registerSoundEvent("snow_creeper");
    public static final SoundEvent WATER_CREEPER = registerSoundEvent("water_creeper");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new Identifier(OneDayMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerSounds() {
        OneDayMod.LOGGER.info("Registering Mod Sounds for " + OneDayMod.MOD_ID);
    }
}
