package com.enforcedmc.hub.gadgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import com.enforcedmc.hub.Hub;
import com.enforcedmc.hub.utils.Lists;
import com.enforcedmc.hub.utils.ParticleEffect;

public class ParticleGun implements Listener
{
    ArrayList<Player> shoot;
    HashMap<String, Long> cooldown;
    Snowball sb;
    int scheduler;
    
    public ParticleGun() {
        this.shoot = new ArrayList<Player>();
        this.cooldown = new HashMap<String, Long>();
        this.scheduler = 0;
    }
    
    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        final Action a = e.getAction();
        final Player p = e.getPlayer();
        if ((a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.GOLD_BARDING) {
            e.setCancelled(true);
            final String uuid = p.getUniqueId().toString();
            if (this.cooldown.containsKey(uuid)) {
                if (Long.valueOf(this.cooldown.get(uuid)) + 5000L > System.currentTimeMillis()) {
                    final int timeleft = (int)(Long.valueOf(this.cooldown.get(uuid)) + 5000L - System.currentTimeMillis());
                    p.sendMessage("§e§l*§6§l* §f§lYou can not use the Particle Gun for §a" + timeleft + " §f§lSeconds. §e§l*§6§l*");
                    return;
                }
                this.cooldown.remove(uuid);
                this.cooldown.put(uuid, System.currentTimeMillis());
            }
            else {
                this.cooldown.put(uuid, System.currentTimeMillis());
            }
            this.shoot.add(p);
            this.sb = (Snowball)p.launchProjectile((Class)Snowball.class);
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 10.0f, 1.0f);
            this.scheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)Hub.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    if (ParticleGun.this.shoot.contains(p)) {
                        if (!ParticleGun.this.sb.isOnGround() && !ParticleGun.this.sb.isDead()) {
                            for (final Player pl : Bukkit.getOnlinePlayers()) {
                                for (int i = 0; i < 3; ++i) {
                                    final Random rnd = new Random();
                                    ParticleEffect.FLAME.display(0.0f, 0.0f, 0.0f, 0.0f, 5, ParticleGun.this.sb.getLocation(), pl);
                                    ParticleEffect.ParticleColor color;
                                    ParticleEffect.REDSTONE.display(color = new ParticleEffect.OrdinaryColor(Lists.colors.get(rnd.nextInt(Lists.colors.size() - 1))), ParticleGun.this.sb.getLocation(), pl);
                                    ParticleEffect.REDSTONE.display(color = new ParticleEffect.OrdinaryColor(Lists.colors.get(rnd.nextInt(Lists.colors.size() - 1))), ParticleGun.this.sb.getLocation(), pl);
                                    ParticleEffect.REDSTONE.display(color = new ParticleEffect.OrdinaryColor(Lists.colors.get(rnd.nextInt(Lists.colors.size() - 1))), ParticleGun.this.sb.getLocation(), pl);
                                    ParticleEffect.REDSTONE.display(color = new ParticleEffect.OrdinaryColor(Lists.colors.get(rnd.nextInt(Lists.colors.size() - 1))), ParticleGun.this.sb.getLocation(), pl);
                                    ParticleEffect.REDSTONE.display(color = new ParticleEffect.OrdinaryColor(Lists.colors.get(rnd.nextInt(Lists.colors.size() - 1))), ParticleGun.this.sb.getLocation(), pl);
                                    ParticleEffect.REDSTONE.display(color = new ParticleEffect.OrdinaryColor(Lists.colors.get(rnd.nextInt(Lists.colors.size() - 1))), ParticleGun.this.sb.getLocation(), pl);
                                    ParticleEffect.REDSTONE.display(color = new ParticleEffect.OrdinaryColor(Lists.colors.get(rnd.nextInt(Lists.colors.size() - 1))), ParticleGun.this.sb.getLocation(), pl);
                                    ParticleEffect.LAVA.display(0.0f, 0.0f, 0.0f, 0.0f, 5, ParticleGun.this.sb.getLocation(), pl);
                                    ParticleEffect.CLOUD.display(0.0f, 0.0f, 0.0f, 0.0f, 1, ParticleGun.this.sb.getLocation(), pl);
                                    ParticleEffect.SPELL_MOB.display(color = new ParticleEffect.OrdinaryColor(Lists.colors.get(rnd.nextInt(Lists.colors.size() - 1))), ParticleGun.this.sb.getLocation(), pl);
                                    ParticleEffect.NOTE.display(0.0f, 0.0f, 0.0f, 0.0f, 5, ParticleGun.this.sb.getLocation(), pl);
                                }
                            }
                        }
                        else {
                            ParticleGun.this.shoot.remove(p);
                            if (!ParticleGun.this.sb.isDead()) {
                                ParticleGun.this.sb.remove();
                            }
                            Bukkit.getScheduler().cancelTask(ParticleGun.this.scheduler);
                            
                        }
                    }
                }
            }, 0L, 1L);
        }
    }
    
    @EventHandler
    public void onProjectileHit(final ProjectileHitEvent e) {
        final Player p = (Player)e.getEntity().getShooter();
        if (e.getEntity() instanceof Snowball && e.getEntity().equals(this.sb)) {
            this.shoot.remove(p);
            if (!this.sb.isDead()) {
                this.sb.remove();
            }
            p.playSound(p.getLocation(), Sound.FIREWORK_LARGE_BLAST, 10.0f, 1.0f);
        }
    }
}
