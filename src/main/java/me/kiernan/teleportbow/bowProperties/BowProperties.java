package me.kiernan.teleportbow.bowProperties;

import me.kiernan.teleportbow.TeleportBow;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BowProperties {

    private final TeleportBow plugin;

    public BowProperties(TeleportBow plugin) {
        this.plugin = plugin;
    }

    public ItemStack createBow(){
        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta meta = bow.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bow-name")));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bow-description")));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        bow.setItemMeta(meta);

        return bow;
    }

}
