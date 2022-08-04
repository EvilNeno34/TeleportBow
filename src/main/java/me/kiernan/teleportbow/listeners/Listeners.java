package me.kiernan.teleportbow.listeners;

import me.kiernan.teleportbow.TeleportBow;
import me.kiernan.teleportbow.bowProperties.BowProperties;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class Listeners implements Listener {

    private final TeleportBow plugin;
    private final BowProperties bowProps;

    public Listeners(TeleportBow plugin) {
        this.plugin = plugin;
        this.bowProps = new BowProperties(plugin);
    }

    @EventHandler
    public void onArrowHit(ProjectileHitEvent e){
        if (e.getEntity().getShooter() instanceof Player player) {
            ItemStack itemInHand = player.getInventory().getItemInMainHand();
            if(itemInHand.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bow-name")))){
                Location loc = e.getEntity().getLocation();
                player.teleport(loc);
                e.getEntity().remove();
                player.playSound(loc, Sound.ENTITY_VILLAGER_CELEBRATE, 4.0f, 1.0f);
            }
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        if(plugin.getConfig().getBoolean("give-on-join")){
            Player player = e.getPlayer();
            player.getInventory().addItem(bowProps.createBow());
            player.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        }
    }

}
