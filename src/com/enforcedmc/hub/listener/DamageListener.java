package com.enforcedmc.hub.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import com.enforcedmc.hub.Hub;

public class DamageListener implements Listener
{
	private Hub plugin = (Hub) Bukkit.getPluginManager().getPlugin("enfHub");
	
    @EventHandler
    public void onDamage(final EntityDamageEvent e) {
        e.setCancelled(true);
    }

@EventHandler(priority = EventPriority.HIGHEST)
public void onEntityDamage(EntityDamageEvent e) {
	if (e.getEntityType().equals(EntityType.PLAYER)) {
		if (!e.getCause().equals(DamageCause.VOID)) {
			e.setCancelled(true);
			return;
		}
		if (e.getCause().equals(DamageCause.VOID)) {
			Player player = (Player) e.getEntity();
	                final Location loc = new Location(Bukkit.getWorld(Hub.getInstance().getConfig().getString("spawnpoint.world")), Hub.getInstance().getConfig().getDouble("spawnpoint.x"), Hub.getInstance().getConfig().getDouble("spawnpoint.y"), Hub.getInstance().getConfig().getDouble("spawnpoint.z"));
	                loc.setPitch((float)Hub.getInstance().getConfig().getDouble("spawnpoint.pitch"));
	                loc.setYaw((float)Hub.getInstance().getConfig().getDouble("spawnpoint.yaw"));
	                player.teleport(loc);
	            }
	        }
		}
	}
