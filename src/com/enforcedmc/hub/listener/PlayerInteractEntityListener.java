package com.enforcedmc.hub.listener;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerInteractEntityListener implements Listener
{
    @EventHandler
    public void onInteractEntity(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        if (e.getRightClicked() instanceof ItemFrame && !p.hasPermission("hub.itemframe")) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onEntityInteract(final EntityInteractEvent e) {
        if (e.getBlock().getType() == Material.SOIL) {
            if (e.getEntity() instanceof Player) {
                final Player p = (Player)e.getEntity();
                if (!p.hasPermission("hub.farmland")) {
                    e.setCancelled(true);
                }
            }
            else {
                e.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void onInteractAt(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        if (e.getRightClicked() instanceof ItemFrame && !p.hasPermission("hub.itemframe")) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent e) {
        final Entity en = e.getEntity();
        final Entity damager = e.getDamager();
        if (en instanceof ItemFrame) {
            if (damager instanceof Player) {
                final Player p = (Player)e.getDamager();
                if (!p.hasPermission("hub.itemframe")) {
                    e.setCancelled(true);
                }
            }
            else {
                e.setCancelled(true);
            }
        }
    }
}
