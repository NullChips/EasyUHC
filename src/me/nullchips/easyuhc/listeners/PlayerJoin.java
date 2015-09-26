package me.nullchips.easyuhc.listeners;

import me.nullchips.easyuhc.utilities.ChatUtils;
import me.nullchips.easyuhc.utilities.UHCState;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * ********************************
 * Created by NullChips. Plugins
 * are used at own risk. I take no
 * responsibility if your world
 * saves or server settings
 * corrupt.
 * ********************************
 */
public class PlayerJoin implements Listener{

    ChatUtils chat = ChatUtils.getInstance();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        if(UHCState.playersCanJoin()) {
            e.setJoinMessage(chat.getNormalStarter() + ChatColor.DARK_GREEN + p.getName() + ChatColor.GOLD + "has joined the server!");
            return;
        }

        if(p.hasPermission("easyuhc.join")) {
            return;
        }

        if(!UHCState.playersCanJoin()) {
            p.kickPlayer("The UHC has already started!");
        }
    }

}
