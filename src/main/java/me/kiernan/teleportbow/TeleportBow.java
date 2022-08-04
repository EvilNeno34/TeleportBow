package me.kiernan.teleportbow;

import me.kiernan.teleportbow.commands.Commands;
import me.kiernan.teleportbow.listeners.Listeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class TeleportBow extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getCommand("givebow").setExecutor(new Commands(this));
        getServer().getPluginManager().registerEvents(new Listeners(this), this);
    }

    @Override
    public void onDisable(){

    }
}
