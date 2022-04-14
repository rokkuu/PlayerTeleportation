/*
* @author: github.com/rokkuu
* @version: 1.0.1
* */

package com.github.rokkuu.playerTeleportation;

import org.bukkit.plugin.java.JavaPlugin;

public final class

Teleportation extends JavaPlugin {

    @Override
    public void onEnable() {

        // register minecraft commands:
       this.getCommand("tpr").setExecutor(new PlayerTeleport());
       this.getCommand("tpac").setExecutor(new AcceptPlayerTeleport());

    }

    @Override
    public void onDisable() {
    }
}
