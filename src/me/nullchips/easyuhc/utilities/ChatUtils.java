package me.nullchips.easyuhc.utilities;

import me.nullchips.easyuhc.EasyUHC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * ********************************
 * Created by NullChips. Plugins
 * are used at own risk. I take no
 * responsibility if your world
 * saves or server settings
 * corrupt.
 * ********************************
 */
public class ChatUtils {

    private ChatUtils() {
        if(!EasyUHC.getPlugin().getConfig().contains("Prefix")) {
            this.normalStarter = null;
        }
        this.normalStarter = EasyUHC.getPlugin().getConfig().getString("Prefix");
    }

    private static ChatUtils instance = new ChatUtils();

    public static ChatUtils getInstance() {
        return instance;
    }

    public String normalStarter = ChatColor.DARK_AQUA + "[" + ChatColor.RED + this.normalStarter + ChatColor.DARK_AQUA + "] ";

    public void broadcast(String message) {
        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            p.sendMessage(normalStarter + ChatColor.GOLD + message);
        }
    }

    public void message(String message, Player p) {
        p.sendMessage(normalStarter + ChatColor.GOLD + message);
    }

    public void opMessage(String message) {
        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            if(!p.isOp()) return;
            p.sendMessage(normalStarter + ChatColor.GOLD + message);
        }
    }

    public String getNormalStarter() {
        return normalStarter;
    }

}
