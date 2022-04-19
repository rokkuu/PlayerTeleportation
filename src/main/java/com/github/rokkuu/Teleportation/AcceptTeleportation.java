package com.github.rokkuu.Teleportation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.UUID;


public class AcceptTeleportation implements CommandExecutor {

    private static HashSet<UUID> pendingPlayerUuid = new HashSet<>();

    public static void addPendingPlayerUuid(UUID pendingUuid, Player senderPlayer){
        Player pendingPlayer = Bukkit.getServer().getPlayer(pendingUuid);
        assert pendingPlayer != null;
        pendingPlayer.sendMessage(ChatColor.GREEN + "Player " + ChatColor.DARK_GREEN + pendingPlayer.getName() + "" + ChatColor.GREEN + " has requested a teleport to you. Type /tpac <nickname> to accept or decline with" +
                " /tpd <nickname>!");
        pendingPlayerUuid.add(pendingUuid);
    }

    public static void removePendingPlayerUuid(UUID uuid){
            pendingPlayerUuid.remove(uuid);
    }

    public static boolean isPendingPlayersEmpty(){
        return pendingPlayerUuid.isEmpty();
    }

    public static boolean isPlayerInPendingList(UUID uuid){
        return pendingPlayerUuid.contains(uuid);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){

            if (!pendingPlayerUuid.isEmpty()){
                Player pendingPlayer = Bukkit.getServer().getPlayerExact(args[0]);
                if (pendingPlayer != null && pendingPlayerUuid.contains(pendingPlayer.getUniqueId())){
                    pendingPlayer.teleport(((Player) sender).getLocation());
                    pendingPlayer.sendMessage(ChatColor.GREEN + "You have been teleported to " + ChatColor.DARK_GREEN + " " + sender.getName() + ".");
                    removePendingPlayerUuid(pendingPlayer.getUniqueId());
                }
            } else {
                sender.sendMessage("You have no pending requests.");
            }
        }
        return true;
    }
}
