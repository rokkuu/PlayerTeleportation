/*
* @author: github.com/rokkuu
* @version: 1.1.0
* */

package com.github.rokkuu.Teleportation;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.UUID;

public class Teleportation extends JavaPlugin {

    @Override
    public void onEnable() {

        // register minecraft commands:
       this.getCommand("tpr").setExecutor(new PlayerTeleport());
       this.getCommand("tpac").setExecutor(new AcceptTeleportation());
       this.getCommand("tpd").setExecutor(new DeclineTeleportation());

    }

    @Override
    public void onDisable() {
    }
}
