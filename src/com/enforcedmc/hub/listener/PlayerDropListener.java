package com.enforcedmc.hub.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PlayerDropListener implements Listener
{
    @EventHandler
    public void onPlayerDrop(final PlayerDropItemEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler
    public void onPlayerPickup(final PlayerPickupItemEvent e) {
        e.setCancelled(true);
    }
}
