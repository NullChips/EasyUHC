package me.nullchips.easyuhc.utilities;

/**
 * ********************************
 * Created by NullChips. Plugins
 * are used at own risk. I take no
 * responsibility if your world
 * saves or server settings
 * corrupt.
 * ********************************
 */
public enum UHCState {

    LOBBY(true),IN_GAME(false),MEETUP(false),AFTER_GAME(false);

    public boolean canJoin;

    private static UHCState state;


    UHCState(boolean canJoin) {
        this.canJoin = canJoin;
    }

    public boolean canJoin() {
        return canJoin;
    }

    public static void setUHCState(UHCState state) {
        UHCState.state = state;
    }

    public static boolean isState(UHCState state) {
        return UHCState.state == state;
    }

    public static UHCState getUHCState() {
        return state;
    }

    public static boolean playersCanJoin() {
        if(getUHCState().isState(UHCState.LOBBY)) {
            return true;
        }
        else {
            return false;
        }
    }

}
