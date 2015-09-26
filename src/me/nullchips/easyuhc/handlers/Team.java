package me.nullchips.easyuhc.handlers;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Random;

/**
 * ********************************
 * Created by NullChips. Plugins
 * are used at own risk. I take no
 * responsibility if your world
 * saves or server settings
 * corrupt.
 * ********************************
 */
public class Team {

    private ChatColor colour;
    private String id;

    public Team(String id) {
        this.colour = generateRandomColour();
        teams.add(this);
    }

    public ArrayList<Team> teams = new ArrayList<Team>();

    public ChatColor getColour() {
        return colour;
    }

    public String getId() {
        return id;
    }

    public ChatColor generateRandomColour() {
        ChatColor colour = ChatColor.getByChar(Integer.toHexString(new Random().nextInt(16)));
        for(Team t : teams) {
            if(t.getColour().equals(colour)) {
                generateRandomColour();
            }
        }
        return colour;
    }

}
