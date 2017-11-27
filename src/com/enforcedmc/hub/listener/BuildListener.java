package com.enforcedmc.hub.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;

public class BuildListener implements Listener
{
    @EventHandler
    public void onBuild(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        if (!p.hasPermission("hub.build")) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onBreak(final BlockBreakEvent e) {
        final Player p = e.getPlayer();
        if (!p.hasPermission("hub.break")) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onHangingBreak(final HangingBreakByEntityEvent e) {
        if (e.getRemover().getType() == EntityType.PLAYER) {
            final Entity entity = e.getRemover();
            final Player p = (Player)entity;
            if (!p.hasPermission("hub.break")) {
                e.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void onHangingPlace(final HangingPlaceEvent e) {
        final Player p = e.getPlayer();
        if (!p.hasPermission("hub.build")) {
            e.setCancelled(true);
        }
    }
}
