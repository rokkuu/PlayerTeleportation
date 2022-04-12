package com.github.rokkuu.bitofeverything;

import jdk.tools.jlink.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;

public class PlayerTeleport implements CommandExecutor {

    private Bitofeverything plugin = Bitofeverything.getPlugin(Bitofeverything.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length > 0){

                if (Bukkit.getServer().getPlayerExact(args[0]) != null) {
                    Player destPlayer = sender.getServer().getPlayer(args[0]);
                    assert destPlayer != null;
                    player.teleport(destPlayer);

                    class DestinationPlayer {
                        private HashMap<Player, Boolean> players;


                    }

                } else {
                    player.sendMessage(ChatColor.RED + "Unknown player, try again.");
                }

            } else {
                player.sendMessage(ChatColor.RED + "Something went wrong, please try /tpa <nickname>");
            }
        }
        return false;
    }
}
