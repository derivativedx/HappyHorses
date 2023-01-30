package com.perschmapples.horsepaths;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("HappyHorses starting!");
        Bukkit.getPluginManager().registerEvents(new HorseMoveEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
