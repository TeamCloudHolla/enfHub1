package com.enforcedmc.hub.guis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.enforcedmc.hub.Hub;
import com.enforcedmc.hub.utils.Ping;

public class LobbySelector
{
    public static HashMap<String, Integer> timer;
    
    static {
        LobbySelector.timer = new HashMap<String, Integer>();
    }
    
    public static void openInv(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 27, "§8Lobby Selector");
        final ItemStack pl = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
        final ItemMeta pl_meta = pl.getItemMeta();
        pl_meta.setDisplayName("§8 ");
        pl.setItemMeta(pl_meta);
        final ItemStack ls = new ItemStack(Material.PISTON_BASE, 1, (short)0);
        final ItemMeta ls_meta = ls.getItemMeta();
        ls_meta.setDisplayName("§eChoose a lobby to connect to.");
        ls.setItemMeta(ls_meta);
        inv.setItem(4, ls);
        for (int i = 0; i < 9; ++i) {
            if (inv.getItem(i) == null) {
                inv.setItem(i, pl);
            }
        }
        for (int i = 18; i < 27; ++i) {
            if (inv.getItem(i) == null) {
                inv.setItem(i, pl);
            }
        }
        final ItemStack hub1 = getHubItem(1);
        final ItemStack hub2 = getHubItem(2);
        if (LobbySelector.timer.containsKey(p.getUniqueId().toString())) {
            LobbySelector.timer.remove(p.getUniqueId().toString());
        }
        LobbySelector.timer.put(p.getUniqueId().toString(), 9);
        p.playSound(p.getLocation(), Sound.CHEST_OPEN, 0.5f, 1.0f);
        p.openInventory(inv);
        new BukkitRunnable() {
            public void run() {
                if (LobbySelector.timer.containsKey(p.getUniqueId().toString())) {
                    if (LobbySelector.timer.get(p.getUniqueId().toString()) > 0) {
                        if (LobbySelector.timer.get(p.getUniqueId().toString()) == 9) {
                            for (int i = 9; i < 18; ++i) {
                                inv.setItem(i, (ItemStack)null);
                            }
                            inv.setItem(17, hub1);
                        }
                        else if (LobbySelector.timer.get(p.getUniqueId().toString()) == 8) {
                            for (int i = 9; i < 18; ++i) {
                                inv.setItem(i, (ItemStack)null);
                            }
                            inv.setItem(16, hub1);
                            inv.setItem(17, hub2);
                        }
                        else if (LobbySelector.timer.get(p.getUniqueId().toString()) == 7) {
                            for (int i = 9; i < 18; ++i) {
                                inv.setItem(i, (ItemStack)null);
                            }
                            inv.setItem(15, hub1);
                            inv.setItem(16, hub2);
                        }
                        else if (LobbySelector.timer.get(p.getUniqueId().toString()) == 6) {
                            for (int i = 9; i < 18; ++i) {
                                inv.setItem(i, (ItemStack)null);
                            }
                            inv.setItem(14, hub1);
                            inv.setItem(15, hub2);
                        }
                        else if (LobbySelector.timer.get(p.getUniqueId().toString()) == 5) {
                            for (int i = 9; i < 18; ++i) {
                                inv.setItem(i, (ItemStack)null);
                            }
                            inv.setItem(13, hub1);
                            inv.setItem(14, hub2);
                        }
                        else if (LobbySelector.timer.get(p.getUniqueId().toString()) == 4) {
                            for (int i = 9; i < 18; ++i) {
                                inv.setItem(i, (ItemStack)null);
                            }
                            inv.setItem(12, hub1);
                            inv.setItem(13, hub2);
                        }
                        else if (LobbySelector.timer.get(p.getUniqueId().toString()) == 3) {
                            for (int i = 9; i < 18; ++i) {
                                inv.setItem(i, (ItemStack)null);
                            }
                            inv.setItem(11, hub1);
                            inv.setItem(12, hub2);
                        }
                        else if (LobbySelector.timer.get(p.getUniqueId().toString()) == 2) {
                            for (int i = 9; i < 18; ++i) {
                                inv.setItem(i, (ItemStack)null);
                            }
                            inv.setItem(10, hub1);
                            inv.setItem(11, hub2);
                        }
                        else if (LobbySelector.timer.get(p.getUniqueId().toString()) == 1) {
                            for (int i = 9; i < 18; ++i) {
                                inv.setItem(i, (ItemStack)null);
                            }
                            inv.setItem(9, hub1);
                            inv.setItem(10, hub2);
                        }
                        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.5f, 0.5f);
                        LobbySelector.timer.put(p.getUniqueId().toString(), LobbySelector.timer.get(p.getUniqueId().toString()) - 1);
                    }
                    else {
                        LobbySelector.timer.remove(p.getUniqueId().toString());
                        this.cancel();
                    }
                }
                else {
                    this.cancel();
                }
            }
        }.runTaskTimer((Plugin)Hub.getInstance(), 0L, 2L);
    }
    @SuppressWarnings("unchecked")
    private static ItemStack getHubItem(Integer id)
    {
      String ip = (String)Hub.hub_ips.get(id);
      int port = ((Integer)Hub.hub_ports.get(id)).intValue();
      if (Bukkit.getPort() != port)
      {
        if (Ping.online(ip, port, 120))
        {
          if (Bukkit.getServer().getPort() == port)
          {
            ItemStack hub = new ItemStack(Material.INK_SACK, 1, (short)14);
            ItemMeta hub_meta = hub.getItemMeta();
            
            hub_meta.setDisplayName("§aHub §7» §e#" + String.valueOf(id));
            hub_meta.setLore(Arrays.asList(new String[] { " ", "§7Status: §aOnline", "", "§e§oYou are on this Hub." }));
            
            hub.setItemMeta(hub_meta);
            
            hub.setAmount(Bukkit.getOnlinePlayers().length);
            
            return hub;
          }
          ItemStack hub = new ItemStack(Material.INK_SACK, 1, (short)10);
          ItemMeta hub_meta = hub.getItemMeta();
          
          hub_meta.setDisplayName("§aHub §7» §e#" + String.valueOf(id));
          hub_meta.setLore(Arrays.asList(new String[] { " ", "§7Status: §aOnline" }));
          
          hub.setItemMeta(hub_meta);
          
          hub.setAmount(Ping.onpl(ip, port, 120));
          
          return hub;
        }
        ItemStack hub = new ItemStack(Material.INK_SACK, 1, (short)8);
        ItemMeta hub_meta = hub.getItemMeta();
        
        hub_meta.setDisplayName("§aHub §7» §e#" + String.valueOf(id));
        hub_meta.setLore(Arrays.asList(new String[] { " ", "§7Status: §cOffline" }));
        
        hub.setItemMeta(hub_meta);
        
        return hub;
      }
      ItemStack hub = new ItemStack(Material.INK_SACK, 1, (short)14);
      ItemMeta hub_meta = hub.getItemMeta();
      
      hub_meta.setDisplayName("§aHub §7» §e#" + String.valueOf(id));
      hub_meta.setLore(Arrays.asList(new String[] { " ", "§7Status: §aOnline", "", "§e§oYou are on this Hub."}));
      
      hub.setItemMeta(hub_meta);
      
      hub.setAmount(Bukkit.getOnlinePlayers().length);
      
      return hub;
    }
  }

