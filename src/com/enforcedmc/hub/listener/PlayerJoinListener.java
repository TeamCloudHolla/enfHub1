package com.enforcedmc.hub.listener;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.enforcedmc.hub.Hub;
import com.enforcedmc.hub.guis.LobbySelector;
import com.enforcedmc.hub.guis.ServerSelector;

public class PlayerJoinListener implements Listener
{
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();       
        e.setJoinMessage((String)null);
        p.setFoodLevel(20);
        p.setFireTicks(0);
        p.setExp(0.0f);
        p.setLevel(0);
        p.setMaxHealth(2.0);
        p.setHealth(2.0);
        p.setHealthScale(2.0);
        p.setGameMode(GameMode.ADVENTURE);
        p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 1));
        p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999999, 1));
        p.getInventory().clear();
        p.getInventory().setArmorContents((ItemStack[])null);
        
        if (Hub.getInstance().getConfig().contains("spawnpoint") && !Hub.getInstance().getConfig().getString("spawnpoint.world").isEmpty()) {
            try {
                final Location loc = new Location(Bukkit.getWorld(Hub.getInstance().getConfig().getString("spawnpoint.world")), Hub.getInstance().getConfig().getDouble("spawnpoint.x"), Hub.getInstance().getConfig().getDouble("spawnpoint.y"), Hub.getInstance().getConfig().getDouble("spawnpoint.z"));
                loc.setPitch((float)Hub.getInstance().getConfig().getDouble("spawnpoint.pitch"));
                loc.setYaw((float)Hub.getInstance().getConfig().getDouble("spawnpoint.yaw"));
                p.teleport(loc);
            }
            catch (Exception ex) {
                p.sendMessage("§7Hub spawnpoint couldn't be found! Please contact a Staff Member!");
            }
        }
        else {
            p.sendMessage("§7Hub spawnpoint couldn't be found! Please contact a Staff Member!");
        }
        final ItemStack ss = new ItemStack(Material.COMPASS, 1, (short)0);
        final ItemMeta ss_meta = ss.getItemMeta();
        ss_meta.setDisplayName("§a§lServer Selector §8(§7Click to open§8)");
        ss_meta.setLore((List)Arrays.asList("§eChoose from our unique servers."));
        ss.setItemMeta(ss_meta);
        p.getInventory().setItem(3, ss);
        final ItemStack ls = new ItemStack(Material.BEACON, 1, (short)0);
        final ItemMeta ls_meta = ls.getItemMeta();
        ls_meta.setDisplayName("§3§lLobby Selector §8(§7Click to open§8)");
        ls_meta.setLore((List)Arrays.asList("§eHaving issues in a lobby? Choose a new one."));
        ls.setItemMeta(ls_meta);
        p.getInventory().setItem(5, ls);
        final ItemStack pg = new ItemStack(Material.DIAMOND_BARDING, 1, (short)0);
        final ItemMeta pg_meta = pg.getItemMeta();
        pg_meta.setDisplayName("§b§lPaintball Gun §8(§7Click to use§8)");
        pg_meta.setLore((List)Arrays.asList("§eUse me and design the hub in many colors ;)!"));
        pg.setItemMeta(pg_meta);
        p.getInventory().setItem(1, pg);
        final ItemStack pg7 = new ItemStack(Material.FEATHER, 1, (short)0);
        final ItemMeta pg_meta7 = pg7.getItemMeta();
        pg_meta7.setDisplayName("§e§lFly §8(§7Hold to use§8)");
        pg_meta7.setLore((List)Arrays.asList("§eUse me to Fly round the hub!"));
        pg7.setItemMeta(pg_meta7);
        p.getInventory().setItem(4, pg7);
        
        final ItemStack pg88 = new ItemStack(Material.GOLD_BARDING, 1, (short)0);
        final ItemMeta pg_meta88 = pg88.getItemMeta();
        pg_meta88.setDisplayName("§d§lParticle Gun §8(§7Click to use§8)");
        pg_meta88.setLore((List)Arrays.asList("§eShoot multiple particles at a player!"));
        pg88.setItemMeta(pg_meta88);
        p.getInventory().setItem(7, pg88);
        
        final ItemStack ph = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)8);
        final ItemMeta ph_meta = ph.getItemMeta();
        ph_meta.setDisplayName(" ");
        ph.setItemMeta(ph_meta);
        for (int i = 0; i < p.getInventory().getSize(); ++i) {
            if (p.getInventory().getItem(i) == null) {
                p.getInventory().setItem(i, ph);
            }
        }
    }
         
    
    @EventHandler
    public void onItem(PlayerMoveEvent e){
    	Player p = e.getPlayer();
    	GameMode gm = p.getGameMode();
    	if(!p.isOp() && !gm.toString().toLowerCase().equals("creative") && !p.hasPermission("enf.hub")){
    	        if(p.getItemInHand().getType() == Material.FEATHER){
    		    if(p.getAllowFlight() == false){
    		        p.setAllowFlight(true);
    			p.setFlying(true);
    		    }
    		}
    		else{
    		    if(p.getAllowFlight() == true){
    		        p.setAllowFlight(false);
    			p.setFlying(false);
    		    }
    		}
    	}
    }
    
    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        e.setQuitMessage((String)null);
        quit(p);
    }
    
    @EventHandler
    public void onPlayerKick(final PlayerKickEvent e) {
        final Player p = e.getPlayer();
        e.setLeaveMessage((String)null);
        quit(p);
    }
    
    public static void quit(final Player p) {
        if (ServerSelector.opens.contains(p.getUniqueId().toString())) {
            ServerSelector.opens.remove(p.getUniqueId().toString());
        }
        if (LobbySelector.timer.containsKey(p.getUniqueId().toString())) {
            LobbySelector.timer.remove(p.getUniqueId().toString());
        }
    }
}
