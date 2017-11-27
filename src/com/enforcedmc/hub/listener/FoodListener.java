package com.enforcedmc.hub.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodListener implements Listener
{
    @EventHandler
    public void onFoodChange(final FoodLevelChangeEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            e.setFoodLevel(20);
            p.setSaturation(20.0f);
            p.setExhaustion(20.0f);
        }
    }
}
