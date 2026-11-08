package com.github.mjaroslav.o9f;

import com.github.mjaroslav.o9f.lib.Reference;
import lombok.val;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ConfirurableFontRenderer extends FontRenderer {
    protected final ResourceLocation locationFontData;
    protected FontData data;

    public ConfirurableFontRenderer(@NotNull String domain, @NotNull String name) {
        super(Minecraft.getMinecraft().gameSettings, new ResourceLocation(String.format("%s:textures/font/%s.png", domain, name)),
            Minecraft.getMinecraft().renderEngine, false);
        locationFontData = new ResourceLocation(String.format("%s:font/%s.json", domain, name));
        FONT_HEIGHT = 13;
        loadFontData();
    }

    @Override
    public int drawString(String text, int x, int y, int color, boolean shadow) {
        return super.drawString(text, x, y, color, false);
    }

    @Override
    protected float renderDefaultChar(int iChar, boolean italic) {
        val char_ = (char) iChar;
        if (char_ == ' ') return data.space + data.tracking;
        val glyph = data.glyphs.get(char_);
        if (glyph == null) return data.space + data.tracking;
        val size = data.size;
        val height = data.height;
        val u = (float) glyph.u;
        val v = (float) glyph.v;
        val italicOffset = italic ? 1F : 0F;
        bindTexture(locationFontTexture);
        val w = (float) glyph.w;
        val posY = this.posY + glyph.shift;
        GL11.glBegin(GL11.GL_TRIANGLE_STRIP);
        GL11.glTexCoord2f(u / size, v / size);
        GL11.glVertex3f(posX + italicOffset, posY, 0.0F);
        GL11.glTexCoord2f(u / size, (v + height) / size);
        GL11.glVertex3f(posX - italicOffset, posY + height, 0.0F);
        GL11.glTexCoord2f((u + w) / size, v / size);
        GL11.glVertex3f(posX + w + italicOffset, posY, 0.0F);
        GL11.glTexCoord2f((u + w) / size, (v + height) / size);
        GL11.glVertex3f(posX + w - italicOffset, posY + height, 0.0F);
        GL11.glEnd();
        return glyph.w + data.tracking;
    }

    @Override
    public int getCharWidth(char char_) {
        val glyph = data.glyphs.get(char_);
        return (glyph == null ? data.space : glyph.w) + data.tracking;
    }

    @Override
    public void onResourceManagerReload(IResourceManager manager) {
        // Super not required, texture reloads anyway
        // But data must be reloaded
        loadFontData();
    }

    protected void loadFontData() {
        try {
            val stream = Minecraft.getMinecraft().getResourceManager().getResource(locationFontData).getInputStream();
            val content = IOUtils.toString(stream, StandardCharsets.UTF_8);
            data = Reference.GSON.fromJson(content, FontData.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class FontData {
        public int tracking;
        public int space;
        public int size;
        public int height;
        public Map<Character, Glyph> glyphs;
    }

    public static class Glyph {
        public int u, v, w, shift;
    }
}

