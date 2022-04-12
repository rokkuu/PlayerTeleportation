package com.github.rokkuu.bitofeverything;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerTeleport implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length > 0){

                try {
                    Player destPlayer = sender.getServer().getPlayer(args[0]);
                    player.teleport(destPlayer);

                } catch (Exception e){
                    e.printStackTrace();
                }
            } else {
                player.sendMessage("Please enter the nickname!");
            }
        }
        return false;
    }
}
