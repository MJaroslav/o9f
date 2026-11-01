package com.github.mjaroslav.o9f.asm;

import com.github.mjaroslav.o9f.lib.Reference;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.Name;
import io.github.tox1cozz.mixinbooterlegacy.IEarlyMixinLoader;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@MCVersion(Reference.MC_VERSION)
@Name(Reference.NAME)
public class O9fPlugin implements IFMLLoadingPlugin, IEarlyMixinLoader {
    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> map) {
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

    @Override
    public List<String> getMixinConfigs() {
        return Collections.singletonList("mixin.o9f.json");
    }
}
