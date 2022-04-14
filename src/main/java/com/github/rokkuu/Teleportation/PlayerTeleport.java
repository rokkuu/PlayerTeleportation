package com.github.rokkuu.Teleportation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerTeleport implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length > 0){
                Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
                if (targetPlayer != null) {
                    UUID playerUuid = player.getUniqueId();
                    PlayerTeleportation.addPendingPlayerUuid(playerUuid);
                    targetPlayer.sendMessage(ChatColor.GREEN + "Player " + ChatColor.DARK_GREEN + player.getName() + "" + ChatColor.GREEN + " has requested a teleport to you. Type /tpac <nickname> to accept!");
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
