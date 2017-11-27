package com.enforcedmc.hub.listener;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import com.enforcedmc.hub.guis.LobbySelector;
import com.enforcedmc.hub.guis.ServerSelector;

public class InventoryCloseListener implements Listener
{
    @EventHandler
    public void onInventoryClose(final InventoryCloseEvent e) {
        final Player p = (Player)e.getPlayer();
        if (e.getInventory().getName().equals("§8Lobby Selector")) {
            p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 0.5f, 1.0f);
            if (LobbySelector.timer.containsKey(p.getUniqueId().toString())) {
                LobbySelector.timer.remove(p.getUniqueId().toString());
            }
        }
        else if (e.getInventory().getName().equals("§8Server Selector")) {
            p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 0.5f, 1.0f);
            if (ServerSelector.opens.contains(p.getUniqueId().toString())) {
                ServerSelector.opens.remove(p.getUniqueId().toString());
            }
        }
    }
}
