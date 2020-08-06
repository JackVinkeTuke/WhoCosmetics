package com.whocraft.whocosmetics.common;


import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.whocraft.whocosmetics.WhoCosmetics.MODID;

public class WCSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, MODID);

    public static final RegistryObject<SoundEvent> UMBRELLA_OPEN = SOUNDS.register("umbrella_open", () -> setUpSound("umbrella_open"));

    private static SoundEvent setUpSound(String soundName) {
        return new SoundEvent(new ResourceLocation(MODID, soundName));
    }
}
