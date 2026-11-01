package io.github.mjaroslav.o9f.lib;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Reference {
    public final String MOD_ID = "o9f";
    public final String NAME = "o9f";
    public final String VERSION = "@VERSION@";
    public final String MC_VERSION = "1.7.10";

    public final Gson GSON = new GsonBuilder().create();
}
