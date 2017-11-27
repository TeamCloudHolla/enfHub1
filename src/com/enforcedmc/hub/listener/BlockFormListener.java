package com.enforcedmc.hub.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.EntityBlockFormEvent;

public class BlockFormListener implements Listener
{
    @EventHandler
    public void onForm(final BlockFormEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler
    public void onEntityForm(final EntityBlockFormEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (p.getGameMode() != GameMode.CREATIVE || !p.hasPermission("hub.build")) {
                e.setCancelled(true);
            }
        }
        else {
            e.setCancelled(true);
        }
    }
}
