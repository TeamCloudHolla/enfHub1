package com.enforcedmc.hub.gadgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.enforcedmc.hub.Hub;
import com.enforcedmc.hub.utils.Lists;

public class PaintballGun implements Listener
{
    ArrayList<Player> shoot;
    HashMap<String, Long> cooldown;
    HashMap<Player, ArrayList<Block>> array;
    int time;
    int scheduler;
    
    public PaintballGun() {
        this.shoot = new ArrayList<Player>();
        this.cooldown = new HashMap<String, Long>();
        this.array = new HashMap<Player, ArrayList<Block>>();
        this.time = 9;
        this.scheduler = 0;
    }
    
    @EventHandler
    public void onPaintballThrow(final PlayerInteractEvent e) {
        final Action a = e.getAction();
        final Player p = e.getPlayer();
        if ((a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.DIAMOND_BARDING) {
            if (!this.shoot.contains(p)) {
                e.setCancelled(true);
                final String uuid = p.getUniqueId().toString();
                if (this.cooldown.containsKey(uuid)) {
                    if (Long.valueOf(this.cooldown.get(uuid)) + 5L > System.currentTimeMillis() / 1000L) {
                        final int timeleft = (int)(Long.valueOf(this.cooldown.get(uuid)) + 5L - System.currentTimeMillis() / 1000L);
                        p.sendMessage("§e§l*§6§l* §f§lYou can not use the Paintball Gun for §a" + timeleft + " §f§lSeconds. §e§l*§6§l*");
                        return;
                    }
                    this.cooldown.remove(uuid);
                    this.cooldown.put(uuid, System.currentTimeMillis() / 1000L);
                }
                else {
                    this.cooldown.put(uuid, System.currentTimeMillis() / 1000L);
                }
                this.shoot.add(p);
                p.throwSnowball();
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 10.0f, 1.0f);
            }
            else {
                e.setCancelled(true);
                final String uuid = p.getUniqueId().toString();
                if (this.cooldown.containsKey(p.getUniqueId().toString())) {
                    final int timeleft2 = (int)(Long.valueOf(this.cooldown.get(p.getUniqueId().toString())) + 5L - System.currentTimeMillis() / 1000L);
                    p.sendMessage("§e§l*§6§l* §f§lYou can not use the Paintball Gun for §a" + timeleft2 + " §f§lSeconds. §e§l*§6§l*");
                }
                else {
                    this.cooldown.remove(uuid);
                    this.cooldown.put(uuid, System.currentTimeMillis() / 1000L);	
                }
            else {
                e.setCancelled(true);
                final String uuid = p.getUniqueId().toString();
                if (this.cooldown.containsKey(p.getUniqueId().toString())) {
                    final int timeleft2 = (int)(Long.valueOf(this.cooldown.get(p.getUniqueId().toString())) + 5L - System.currentTimeMillis() / 1000L);
                    p.sendMessage("§e§l*§6§l* §f§lYou can not use the Paintball Gun for §a" + timeleft2 + " §f§lSeconds. §e§l*§6§l*");
                }
                else {
                    this.cooldown.remove(uuid);
                    this.cooldown.put(uuid, System.currentTimeMillis() / 1000L);	
                }
            }
        }
    }
    
    @EventHandler
    public void onProjectileHit(final ProjectileHitEvent e) {
        if (e.getEntity() instanceof Snowball) {
            final Player p = (Player)e.getEntity().getShooter();
            final Location loc = e.getEntity().getLocation();
            final Random rnd = new Random();
            if (this.shoot.contains(p)) {
                final World w = loc.getWorld();
                final int x = loc.getBlockX();
                final int y = loc.getBlockY();
                final int z = loc.getBlockZ();
                final Block b1 = w.getBlockAt(x - 1, y - 1, z - 1);
                final Block b2 = w.getBlockAt(x - 1, y - 1, z);
                final Block b3 = w.getBlockAt(x - 1, y - 1, z + 1);
                final Block b4 = w.getBlockAt(x, y - 1, z - 1);
                final Block b5 = w.getBlockAt(x, y - 1, z);
                final Block b6 = w.getBlockAt(x, y - 1, z + 1);
                final Block b7 = w.getBlockAt(x + 1, y - 1, z - 1);
                final Block b8 = w.getBlockAt(x + 1, y - 1, z);
                final Block b9 = w.getBlockAt(x + 1, y - 1, z + 1);
                final Block b10 = w.getBlockAt(x - 1, y, z - 1);
                final Block b11 = w.getBlockAt(x - 1, y, z);
                final Block b12 = w.getBlockAt(x - 1, y, z + 1);
                final Block b13 = w.getBlockAt(x, y, z - 1);
                final Block b14 = w.getBlockAt(x, y, z);
                final Block b15 = w.getBlockAt(x, y, z + 1);
                final Block b16 = w.getBlockAt(x + 1, y, z - 1);
                final Block b17 = w.getBlockAt(x + 1, y, z);
                final Block b18 = w.getBlockAt(x + 1, y, z + 1);
                final Block b19 = w.getBlockAt(x - 1, y + 1, z - 1);
                final Block b20 = w.getBlockAt(x - 1, y + 1, z);
                final Block b21 = w.getBlockAt(x - 1, y + 1, z + 1);
                final Block b22 = w.getBlockAt(x, y + 1, z - 1);
                final Block b23 = w.getBlockAt(x, y + 1, z);
                final Block b24 = w.getBlockAt(x, y + 1, z + 1);
                final Block b25 = w.getBlockAt(x + 1, y + 1, z - 1);
                final Block b26 = w.getBlockAt(x + 1, y + 1, z);
                final Block b27 = w.getBlockAt(x + 1, y + 1, z + 1);
                final ArrayList<Block> blocks = new ArrayList<Block>();
                blocks.clear();
                blocks.add(b1);
                blocks.add(b2);
                blocks.add(b3);
                blocks.add(b4);
                blocks.add(b5);
                blocks.add(b6);
                blocks.add(b7);
                blocks.add(b8);
                blocks.add(b9);
                blocks.add(b10);
                blocks.add(b11);
                blocks.add(b12);
                blocks.add(b13);
                blocks.add(b14);
                blocks.add(b15);
                blocks.add(b16);
                blocks.add(b17);
                blocks.add(b18);
                blocks.add(b19);
                blocks.add(b20);
                blocks.add(b21);
                blocks.add(b22);
                blocks.add(b23);
                blocks.add(b24);
                blocks.add(b25);
                blocks.add(b26);
                blocks.add(b27);
                for (final Block b28 : blocks) {
                    if (!Lists.mats.contains(b28.getType())) {
                        if (!this.array.containsKey(p)) {
                            this.array.put(p, new ArrayList<Block>());
                        }
                        this.array.get(p).add(b28);
                        final int a = rnd.nextInt(8);
                        if (a == 1) {
                            continue;
                        }
                        for (final Player pl : Bukkit.getOnlinePlayers()) {
                            pl.sendBlockChange(b28.getLocation(), Material.STAINED_CLAY, (byte)rnd.nextInt(15));
                        }
                    }
                }
                new BukkitRunnable() {
                    public void run() {
                        long l = 0L;
                        for (final Block b : PaintballGun.this.array.get(p)) {
                            l += 10L;
                            new BukkitRunnable() {
                                public void run() {
                                    for (final Player pl : Bukkit.getOnlinePlayers()) {
                                        pl.sendBlockChange(b.getLocation(), b.getType(), b.getData());
                                    }
                                }
                            }.runTaskLater((Plugin)Hub.getInstance(), l);
                        }
                        if (PaintballGun.this.shoot.contains(p)) {
                            PaintballGun.this.shoot.remove(p);
                        }
                        PaintballGun.this.array.get(p).clear();
                    }
                }.runTaskLater((Plugin)Hub.getInstance(), 100L);
            }
        }
    }
}
