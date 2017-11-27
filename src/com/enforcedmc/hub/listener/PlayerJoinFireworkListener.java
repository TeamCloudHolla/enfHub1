package com.enforcedmc.hub.listener;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.enforcedmc.hub.Hub;

public class PlayerJoinFireworkListener implements Listener
{
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent e) {
        new BukkitRunnable() {
            public void run() {
                final Firework f = (Firework)e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), (Class)Firework.class);
                final FireworkMeta fm = f.getFireworkMeta();
                fm.addEffect(FireworkEffect.builder().flicker(false).trail(true).with(FireworkEffect.Type.BALL).withColor(Color.PURPLE).withColor(Color.ORANGE).withFade(Color.RED).build());
                fm.setPower(1);
                f.setFireworkMeta(fm);
            }
        }.runTaskLater((Plugin)Hub.getInstance(), 20L);
    }
}
