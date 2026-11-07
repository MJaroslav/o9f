![](assets/logo.png)

[![GitHub Release](https://img.shields.io/github/v/release/MJaroslav/o9f?logo=GitHub&logoColor=black&label=%20&color=white)](https://github.com/mjaroslav/o9f "GitHub")
[![CurseForge Downloads](https://img.shields.io/curseforge/dt/1776999?logo=curseforge&logoColor=black&label=%20&color=orange)](https://www.curseforge.com/minecraft/mc-mods/o9f "CurseForge")
[![Modrinth Downloads](https://img.shields.io/modrinth/dt/o9f?logo=modrinth&label=%20&color=black)](https://modrinth.com/project/o9f "Modrinth")
[![GitHub issues](https://img.shields.io/github/issues/mjaroslav/o9f)](https://github.com/mjaroslav/o9f/issues "GitHub issues")
[![GitHub forks](https://img.shields.io/github/forks/mjaroslav/o9f)](https://github.com/mjaroslav/o9f/network "GitHub forks")
[![GitHub stars](https://img.shields.io/github/stars/mjaroslav/o9f)](https://github.com/mjaroslav/o9f/stargazers "GitHub stars")
[![GitHub license](https://img.shields.io/badge/license-LGPL--3.0--only-green)](https://github.com/MJaroslav/o9f/blob/master/LICENSE "Open license")
[![JitPack](https://jitpack.io/v/MJaroslav/o9f.svg)](https://jitpack.io/#MJaroslav/o9f "JitPack")
[![](https://jitci.com/gh/MJaroslav/o9f/svg)](https://jitci.com/gh/MJaroslav/o9f)

# o9f

Backport of mod ["o123456789f" by Gvoper](https://modrinth.com/mod/o123456789f) (and originally ["o123456789" by catboybinary](https://modrinth.com/mod/o123456789)) for Minecraft 1.7.10.

Mod adds fancy font for your items counts and fully client-side.

![Example](assets/example.png)

## Custom font

Just create resource pack by next guide:

![Resoruce pack guide](assets/guide.png)

Yes, you can use bigger image for more space for glyphs!

## Planned things

- NEI (GTNH) support (disable dynamic font for now)
- Applied Energetics GUIs
- Extra Cells monitors and with implementation counts in GUIs.
- Thaumcraft aspect/essentia/vis counts.
- JABBA barrels counts.

You can ask for some mod support (if its now working out of the box) by GitHub issues

## Build

Build requirements:
- JDK 8 as default Java (for Gradle run).
- JDK 16 in Gradle JDKs list for use in tasks (can be specified by `gradle.properties` with `org.gradle.java.installations.paths` key.

Clone repository and run `gradlew build`.
