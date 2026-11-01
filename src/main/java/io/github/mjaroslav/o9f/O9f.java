package io.github.mjaroslav.o9f;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import io.github.mjaroslav.o9f.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IReloadableResourceManager;
import org.jetbrains.annotations.NotNull;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptableRemoteVersions = "*")
public class O9f {
    public static ConfirurableFontRenderer font;

    @EventHandler
    public void init(@NotNull FMLInitializationEvent event) {
        font = new ConfirurableFontRenderer(Reference.MOD_ID, "o9f");
    }

    @EventHandler
    public void postInit(@NotNull FMLPostInitializationEvent event) {
        // When font config will add than replace by wrapper that use recreated font object inside
        ((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(font);
    }
}
