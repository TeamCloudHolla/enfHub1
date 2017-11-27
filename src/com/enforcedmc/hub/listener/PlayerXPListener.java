package com.enforcedmc.hub.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

public class PlayerXPListener implements Listener
{
    @EventHandler
    public void onChangeXP(final PlayerExpChangeEvent e) {
        e.setAmount(0);
    }
}
