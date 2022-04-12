/*
* @author: github.com/rokkuu
* @version: 1.0.1
* */

package com.github.rokkuu.bitofeverything;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class

Bitofeverything extends JavaPlugin {

    @Override
    public void onEnable() {

        // register minecraft commands:
       this.getCommand("skit").setExecutor(new StarterKit());
       this.getCommand("tpr").setExecutor(new PlayerTeleport());

       // register minecraft events:
       getServer().getPluginManager().registerEvents(new TestListener(), this);

        Bukkit.broadcastMessage("Hello!");
    }

    @Override
    public void onDisable() {
        Bukkit.broadcastMessage("Hello2 !");
    }
}
