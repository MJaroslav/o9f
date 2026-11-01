package io.github.mjaroslav.o9f.asm.mixin;


import io.github.mjaroslav.o9f.O9f;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

// Just overrides ItemStack font by modded
@Mixin(RenderItem.class)
public abstract class RenderItemMixin extends Render {
    @Redirect(method = "renderItemOverlayIntoGUI(Lnet/minecraft/client/gui/FontRenderer;Lnet/minecraft/client/renderer/texture/TextureManager;Lnet/minecraft/item/ItemStack;IILjava/lang/String;)V",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/FontRenderer;getStringWidth(Ljava/lang/String;)I"))
    private int o9f$getStringWidth(FontRenderer instance, String text) {
        return O9f.font.getStringWidth(text) + 2; // Added +2 to make the numbers start from the slot corner (vanilla adds -2 for offset)
    }

    @Redirect(method = "renderItemOverlayIntoGUI(Lnet/minecraft/client/gui/FontRenderer;Lnet/minecraft/client/renderer/texture/TextureManager;Lnet/minecraft/item/ItemStack;IILjava/lang/String;)V",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/FontRenderer;drawStringWithShadow(Ljava/lang/String;III)I"))
    private int o9f$renderItemOverlayInfoGUI(FontRenderer instance, String text, int x, int y, int color) {
        return O9f.font.drawStringWithShadow(text, x, y, color);
    }
}
