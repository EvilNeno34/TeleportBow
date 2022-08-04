package me.kiernan.teleportbow.commands;

import me.kiernan.teleportbow.TeleportBow;
import me.kiernan.teleportbow.bowProperties.BowProperties;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Commands implements CommandExecutor {

    private final TeleportBow plugin;
    private final BowProperties bowProps;

    public Commands(TeleportBow plugin) {
        this.plugin = plugin;
        this.bowProps = new BowProperties(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("tpbow.givebow")){
                ItemStack bow = bowProps.createBow();
                player.getInventory().addItem(bow);
                player.getInventory().addItem(new ItemStack(Material.ARROW, 1));
            }
        }

        return true;
    }
}
