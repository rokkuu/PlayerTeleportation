package com.github.rokkuu.playerTeleportation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.UUID;


public class AcceptPlayerTeleport implements CommandExecutor {
    private static HashSet<UUID> pendingPlayerUuid = new HashSet<>();

    public static void addPendingPlayerUuid(UUID uuid){
        pendingPlayerUuid.add(uuid);
    }

    public static void removePendingPlayerUuid(UUID uuid){
            pendingPlayerUuid.remove(uuid);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            if (!pendingPlayerUuid.isEmpty()){
                Player pendingPlayer = Bukkit.getServer().getPlayer(args[0]);
                if (pendingPlayer != null && pendingPlayerUuid.contains(pendingPlayer.getUniqueId())){
                    pendingPlayer.teleport(((Player) sender).getLocation());
                    pendingPlayer.sendMessage(ChatColor.GREEN + "You have been teleported to " + ChatColor.DARK_GREEN + " " + sender.getName() + ".");
                    removePendingPlayerUuid(pendingPlayer.getUniqueId());
                }
            }
        }
        return false;
    }
}
