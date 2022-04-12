package com.github.rokkuu.bitofeverything;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class TestListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

        if (event.getPlayer().getName().equals("roookkuu")){
            event.getPlayer().sendMessage("Hello trash!");
        }
        event.setJoinMessage("Welcome, " + event.getPlayer().getName() + "!");

    }
}
