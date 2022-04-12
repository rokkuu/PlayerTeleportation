package com.github.rokkuu.bitofeverything;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


import java.util.ArrayList;


// TODO: import the list of materials from json
public class StarterKit implements CommandExecutor {

    Material[] materials = {Material.IRON_AXE, Material.IRON_SWORD, Material.SPRUCE_WOOD};

    class KitTimer {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            ArrayList<ItemStack> itemStacks = new ArrayList<>();

            for (Material material : materials) {
                itemStacks.add(new ItemStack(material, 64));
            }
            for (ItemStack itemStack : itemStacks){
                player.getInventory().addItem(itemStack);
            }

        }
        return false;
    }
}

