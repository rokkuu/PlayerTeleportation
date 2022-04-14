package com.github.rokkuu.Teleportation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeclineTeleportation extends AcceptTeleportation implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && (Bukkit.getServer().getPlayerExact(args[0]) != null)){
            if(!isPendingPlayersEmpty()){
                Player sourcePlayer = Bukkit.getServer().getPlayerExact(args[0]);
                if (isPlayerInPendingList(sourcePlayer.getUniqueId())) {
                    sourcePlayer.sendMessage(ChatColor.GREEN + "Player " + ChatColor.DARK_GREEN + sender.getName() + ChatColor.GREEN + " has declined your request!");
                    removePendingPlayerUuid(sourcePlayer.getUniqueId());
                }
            } else {
                sender.sendMessage("You have no pending requests.");
            }

        }
        return true;
    }
}