package me.nullchips.easyuhc;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

/**
 * ********************************
 * Created by NullChips. Plugins
 * are used at own risk. I take no
 * responsibility if your world
 * saves or server settings
 * corrupt.
 * ********************************
 */
public class EasyUHC extends JavaPlugin {

    private static Plugin pl;

    public void onEnable() {
        pl = this;
    }

    public void onDisable() {
        pl = null;
    }

    public static void registerEvents(Plugin plugin, Listener... listeners) {
        for(Listener listner : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listner, plugin);
        }
    }

    public static Plugin getPlugin() {
        return pl;
    }

}
