package com.enforcedmc.hub.guis;

import java.util.ArrayList;
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

public class ServerSelector
{
    public static ArrayList<String> opens;
    public static HashMap<String, ItemStack> items;
    
    static {
        ServerSelector.opens = new ArrayList<String>();
        ServerSelector.items = new HashMap<String, ItemStack>();
    }
    
    public static void openInv(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 27, "§8Server Selector");
        inv.setItem(11, getFactionsItem());
        inv.setItem(15, getXFactionsItem());
        final ItemStack ph = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)3);
        final ItemMeta ph_meta = ph.getItemMeta();
        ph_meta.setDisplayName(" ");
        ph.setItemMeta(ph_meta);
        final ItemStack ph2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)11);
        final ItemMeta ph2_meta = ph2.getItemMeta();
        ph2_meta.setDisplayName(" ");
        ph2.setItemMeta(ph2_meta);
        final ItemStack ph3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)2);
        final ItemMeta ph3_meta = ph3.getItemMeta();
        ph3_meta.setDisplayName(" ");
        ph3.setItemMeta(ph3_meta);
        final ItemStack ph4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
        final ItemMeta ph4_meta = ph4.getItemMeta();
        ph4_meta.setDisplayName(" ");
        ph4.setItemMeta(ph4_meta);
        final ItemStack ph5 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)3);
        final ItemMeta ph5_meta = ph5.getItemMeta();
        ph5_meta.setDisplayName(" ");
        ph5.setItemMeta(ph5_meta);
        final ItemStack ph6 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)6);
        final ItemMeta ph6_meta = ph6.getItemMeta();
        ph6_meta.setDisplayName(" ");
        ph6.setItemMeta(ph6_meta);
        for (int i = 0; i < inv.getSize(); ++i) {
            if (inv.getItem(i) == null) {
                inv.setItem(i, ph);
            }
        }
        p.playSound(p.getLocation(), Sound.CHEST_OPEN, 0.5f, 1.0f);
        p.openInventory(inv);
        ServerSelector.opens.add(p.getUniqueId().toString());
        new BukkitRunnable() {
            public void run() {
                if (ServerSelector.opens.contains(p.getUniqueId().toString())) {
                    if (inv.getItem(11).equals((Object)ServerSelector.getFactionsItem())) {
                        inv.setItem(11, ServerSelector.getFactionsItem2());
                    }
                    else {
                        inv.setItem(11, ServerSelector.getFactionsItem());
                    }
                    if (inv.getItem(15).equals((Object)ServerSelector.getXFactionsItem())) {
                        inv.setItem(15, ServerSelector.getXFactionsItem2());
                    }
                    else {
                        inv.setItem(15, ServerSelector.getXFactionsItem());
                    }
                    for (int i = 0; i < inv.getSize(); ++i) {
                        if (inv.getItem(i).getType() == Material.STAINED_GLASS_PANE) {
                            if (inv.getItem(i).getDurability() == 3) {
                                inv.setItem(i, ph2);
                            }
                            else if (inv.getItem(i).getDurability() == 11){
                                inv.setItem(i, ph);
                            }
                            else if (inv.getItem(i).getDurability() == 2){
                                inv.setItem(i, ph3);
                            }
                            else if (inv.getItem(i).getDurability() == 5){
                                inv.setItem(i, ph4);
                            }
                            else if (inv.getItem(i).getDurability() == 3){
                                inv.setItem(i, ph5);
                            }
                            else {
                                inv.setItem(i, ph6);
                            }
                        }
                    }
                }
                else {
                    this.cancel();
                }
            }
        }.runTaskTimer((Plugin)Hub.getInstance(), 0L, 5L);
    }
    
    public static void loadItems() {
        ServerSelector.items.clear();
    }
    
    public static ItemStack getFactionsItem() {
        final ItemStack f = new ItemStack(Material.DIAMOND_SWORD, 1, (short)0);
        final ItemMeta f_meta = f.getItemMeta();
        f_meta.setDisplayName("§b§l§nFACTIONS");
        if (Ping.online("107.175.106.206", 18898, 120)) {
            f_meta.setLore((List)Arrays.asList("§7§oWant to conqour the enforced world of §b§lFactions?", "", "§8§l* §a§oBoss Mobs", "§8§l* §a§oCustom Enchants", "§8§l* §a§oStacked Spawners", "§8§l* §a§oGen Buckets", "§8§l* §a§oMystery Spawners", "§8§l* §a§oMoney Pouches", "§8§l* §a§oMonthly Crates and GKits", "§8§l* §a§oFTOP (Factions Top)", "§8§l* §a§oBoosters", "§8§l* §a§oHead Drops", "§8§l* §a§oStacked Mobs", "§8§l* §a§oSpawner Tiers", "§8§l* §a§oEnforced Blocks§c§l (Coming soon)", "§a", "§7Status: §a§oOnline", "§a" + Ping.onpl("107.175.106.206", 18898, 120) + "§b  Players playing §b§lFactions!", "", "", "§e§lThis server is played by the entertaining youtubers:", "§bJakerGG, JUSTINGaming, DrCandyMan, Jagnole... "));
            f.setAmount(Ping.onpl("107.175.106.206", 18898, 120));
        }
        else {
            f_meta.setLore((List)Arrays.asList("§7§oWant to conqour the enforced world of §b§lFactions?", "", "§8§l* §a§oBoss Mobs", "§8§l* §a§oCustom Enchants", "§8§l* §a§oStacked Spawners", "§8§l* §a§oGen Buckets", "§8§l* §a§oMystery Spawners", "§8§l* §a§oMoney Pouches", "§8§l* §a§oMonthly Crates and GKits", "§8§l* §a§oFTOP (Factions Top)", "§8§l* §a§oBoosters", "§8§l* §a§oHead Drops", "§8§l* §a§oStacked Mobs", "§8§l* §a§oSpawner Tiers", "§8§l* §a§oEnforced Blocks§c§l (Coming soon)", "§a", "§7Status: §c§lOFFLINE", "§a-/- §b  Players playing §b§lFactions!", "", "", "§e§lThis server is played by the entertaining youtubers:", "§bJakerGG, JUSTINGaming, DrCandyMan, Jagnole... "));
            f.setAmount(1);
        }
        f.setItemMeta(f_meta);
        return f;
    }
    
    @SuppressWarnings("unchecked")
	public static ItemStack getFactionsItem2() {
        final ItemStack f = new ItemStack(Material.DIAMOND_SWORD, 1, (short)0);
        final ItemMeta f_meta = f.getItemMeta();
        f_meta.setDisplayName("§b§l§nFACTIONS");
        if (Ping.online("107.175.106.206", 18898, 120)) {
            f_meta.setLore((List)Arrays.asList("§7§oWant to conqour the enforced world of §b§lFactions?", "", "§8§l* §a§oBoss Mobs", "§8§l* §a§oCustom Enchants", "§8§l* §a§oStacked Spawners", "§8§l* §a§oGen Buckets", "§8§l* §a§oMystery Spawners", "§8§l* §a§oMoney Pouches", "§8§l* §a§oMonthly Crates and GKits", "§8§l* §a§oFTOP (Factions Top)", "§8§l* §a§oBoosters", "§8§l* §a§oHead Drops", "§8§l* §a§oStacked Mobs", "§8§l* §a§oSpawner Tiers", "§8§l* §a§oEnforced Blocks§c§l (Coming soon)", "§a", "§7Status: §a§oOnline", "§a" + Ping.onpl("107.175.106.206", 18898, 120) + "§b Players playing §b§lFactions!", "", "", "§e§lThis server is played by the entertaining youtubers:", "§bJakerGG, JUSTINGaming, DrCandyMan, Jagnole... "));
            f.setAmount(Ping.onpl("107.175.106.206", 18898, 120));
        }
        else {
            f_meta.setLore((List)Arrays.asList("§7§oWant to conqour the enforced world of §b§lFactions?", "", "§8§l* §a§oBoss Mobs", "§8§l* §a§oCustom Enchants", "§8§l* §a§oStacked Spawners", "§8§l* §a§oGen Buckets", "§8§l* §a§oMystery Spawners", "§8§l* §a§oMoney Pouches", "§8§l* §a§oMonthly Crates and GKits", "§8§l* §a§oFTOP (Factions Top)", "§8§l* §a§oBoosters", "§8§l* §a§oHead Drops", "§8§l* §a§oStacked Mobs", "§8§l* §a§oSpawner Tiers", "§8§l* §a§oEnforced Blocks§c§l (Coming soon)", "§a", "§7Status: §c§lOFFLINE", "§a-/- §b Players playing §b§lFactions!", "", "", "§e§lThis server is played by the entertaining youtubers:", "§bJakerGG, JUSTINGaming, DrCandyMan, Jagnole... "));
            f.setAmount(1);
        }
        f.setItemMeta(f_meta);
        return f;
    }
    
    public static ItemStack getXFactionsItem() {
        final ItemStack f = new ItemStack(Material.GOLDEN_APPLE, 1, (short)1);
        final ItemMeta f_meta = f.getItemMeta();
        f_meta.setDisplayName("§b§l§nOPFACTIONS");
        if (Ping.online("107.175.106.206", 18898, 120)) {
        	f_meta.setLore((List)Arrays.asList("§eOPFactions will be releasing soon...", "§eStay updated on our twitter or forums for more.", " ", "§3Twitter: @EnforcedMC", "§bForums: www.enforcedmc.com"));
        	//f_meta.setLore((List)Arrays.asList("§7§oWant to conqour the enforced world of §b§lOPFactions?", "", "§8§l* §a§oCustom Enchants", "§8§l* §a§oStacked Spawners", "§8§l* §a§oGen Buckets", "§8§l* §a§oMystery Spawners", "§8§l* §a§oMoney Pouches", "§8§l* §a§oMonthly Crates and GKits", "§8§l* §a§oFTOP (Factions Top)", "§8§l* §a§oBoosters", "§8§l* §a§oHead Drops", "§8§l* §a§oStacked Mobs", "§8§l* §a§oSpawner Tiers", "§8§l* §a§oEnforced Blocks§c§l (Coming soon)", "§a", "§7Status: §a§oOnline", + Ping.onpl("107.175.106.206", 18898, 120) + "§b Players playing §b§lOPFactions!", "", "§7*** §f(Youtuber) Plays here §7***"));
            f.setAmount(Ping.onpl("107.175.106.206", 1898, 120));
        }
        else {
        	f_meta.setLore((List)Arrays.asList("§eOPFactions will be releasing soon...", "§eStay updated on our twitter or forums for more.", " ", "§3Twitter: @EnforcedMC", "§bForums: www.enforcedmc.com"));
           // f_meta.setLore((List)Arrays.asList("§7§oWant to conqour the enforced world of §b§lOPFactions?", "", "§8§l* §a§oCustom Enchants", "§8§l* §a§oStacked Spawners", "§8§l* §a§oGen Buckets", "§8§l* §a§oMystery Spawners", "§8§l* §a§oMoney Pouches", "§8§l* §a§oMonthly Crates and GKits", "§8§l* §a§oFTOP (Factions Top)", "§8§l* §a§oBoosters", "§8§l* §a§oHead Drops", "§8§l* §a§oStacked Mobs", "§8§l* §a§oSpawner Tiers", "§8§l* §a§oEnforced Blocks§c§l (Coming soon)", "§a", "§7Status: §c§lOFFLINE", "§a-/- §b Players playing §b§lOPFactions!", "", "§7*** §d(Youtuber) Plays here §7***"));
            f.setAmount(1);
        }
        f.setItemMeta(f_meta);
        return f;
    }
    
    public static ItemStack getXFactionsItem2() {
        final ItemStack f = new ItemStack(Material.GOLDEN_APPLE, 1, (short)1);
        final ItemMeta f_meta = f.getItemMeta();
        f_meta.setDisplayName("§b§l§nOPFACTIONS");
        if (Ping.online("107.175.106.206", 18898, 120)) {
        	f_meta.setLore((List)Arrays.asList("§eOPFactions will be releasing soon...", "§eStay updated on our twitter or forums for more.", " ", "§3Twitter: @EnforcedMC", "§bForums: www.enforcedmc.com"));
        	//f_meta.setLore((List)Arrays.asList("§7§oWant to conqour the enforced world of §b§lOPFactions?", "", "§8§l* §a§oCustom Enchants", "§8§l* §a§oStacked Spawners", "§8§l* §a§oGen Buckets", "§8§l* §a§oMystery Spawners", "§8§l* §a§oMoney Pouches", "§8§l* §a§oMonthly Crates and GKits", "§8§l* §a§oFTOP (Factions Top)", "§8§l* §a§oBoosters", "§8§l* §a§oHead Drops", "§8§l* §a§oStacked Mobs", "§8§l* §a§oSpawner Tiers", "§8§l* §a§oEnforced Blocks§c§l (Coming soon)", "§a", "§7Status: §a§oOnline", + Ping.onpl("107.175.106.206", 18898, 120) + "§b Players playing §b§lOPFactions!", "", "§7*** §f(Youtuber) Plays here §7***"));
            f.setAmount(Ping.onpl("107.175.106.206", 1898, 120));
        }
        else {
        	f_meta.setLore((List)Arrays.asList("§eOPFactions will be releasing soon...", "§eStay updated on our twitter or forums for more.", " ", "§3Twitter: @EnforcedMC", "§bForums: www.enforcedmc.com"));
            //f_meta.setLore((List)Arrays.asList("§7§oWant to conqour the enforced world of §b§lOPFactions?", "", "§8§l* §a§oCustom Enchants", "§8§l* §a§oStacked Spawners", "§8§l* §a§oGen Buckets", "§8§l* §a§oMystery Spawners", "§8§l* §a§oMoney Pouches", "§8§l* §a§oMonthly Crates and GKits", "§8§l* §a§oFTOP (Factions Top)", "§8§l* §a§oBoosters", "§8§l* §a§oHead Drops", "§8§l* §a§oStacked Mobs", "§8§l* §a§oSpawner Tiers", "§8§l* §a§oEnforced Blocks§c§l (Coming soon)", "§a", "§7Status: §c§lOFFLINE","§a-/- §bPlayers playing §b§lOPFactions!", "", "§7*** §f(Youtuber) Plays here §7***"));
            f.setAmount(1);
        }
        f.setItemMeta(f_meta);
        return f;
    }
}
