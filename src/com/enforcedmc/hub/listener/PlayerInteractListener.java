package com.enforcedmc.hub.listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.enforcedmc.hub.guis.LobbySelector;
import com.enforcedmc.hub.guis.ServerSelector;

public class PlayerInteractListener implements Listener
{
    public static ArrayList<String> usingClock;
    public static String clockname;
	
    @EventHandler
    public void onPlayerInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        final ItemStack ss = new ItemStack(Material.COMPASS, 1, (short)0);
        final ItemMeta ss_meta = ss.getItemMeta();
        ss_meta.setDisplayName("§a§lServer Selector §8(§7Click to open§8)");
        ss_meta.setLore((List)Arrays.asList("§eChoose from our unique servers."));
        ss.setItemMeta(ss_meta);
        final ItemStack ls = new ItemStack(Material.BEACON, 1, (short)0);
        final ItemMeta ls_meta = ls.getItemMeta();
        ls_meta.setDisplayName("§3§lLobby Selector §8(§7Click to open§8)");
        ls_meta.setLore((List)Arrays.asList("§eHaving issues in a lobby? Choose a new one."));
        ls.setItemMeta(ls_meta);
        if (p.getItemInHand().equals((Object)ls)) {
            e.setCancelled(true);
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 0.5f, 1.0f);
            LobbySelector.openInv(p);
        }
        else if (p.getItemInHand().equals((Object)ss)) {
            e.setCancelled(true);
            ServerSelector.openInv(p);
        }
    }
}
