package com.enforcedmc.hub.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils
{
    public static ItemStack create(final Material material, final Integer amount, final Short subid, final String displayname, final List<String> lore) {
        final ItemStack output = new ItemStack(material, (int)amount, (short)subid);
        final ItemMeta meta = output.getItemMeta();
        if (displayname != null) {
            meta.setDisplayName(displayname);
        }
        if (lore != null && !lore.isEmpty()) {
            meta.setLore((List)lore);
        }
        return output;
    }
    
    public static ItemStack create(final Material material, final Short subid, final String displayname, final List<String> lore, final String ip, final Integer port) {
        final ItemStack output = new ItemStack(material, 1, (short)subid);
        final ItemMeta meta = output.getItemMeta();
        final boolean online = Ping.online(ip, port, 120);
        final int on = Ping.onpl(ip, port, 120);
        final int max = Ping.maxpl(ip, port, 120);
        if (displayname != null) {
            meta.setDisplayName(displayname);
        }
        if (online) {
            output.setAmount(max);
        }
        if (lore != null && !lore.isEmpty()) {
            final List<String> lore_out = new ArrayList<String>();
            for (final String s : lore) {
                if (s.contains("%on_pl%")) {
                    if (online) {
                        s.replaceAll("%on_pl%", "§a" + String.valueOf(on));
                    }
                    else {
                        s.replaceAll("%on_pl%", "§c--");
                    }
                }
                if (s.contains("%max_pl%")) {
                    if (online) {
                        s.replaceAll("%max_pl%", "§a" + String.valueOf(max));
                    }
                    else {
                        s.replaceAll("%max_pl%", "§c--");
                    }
                }
                if (s.contains("%online%")) {
                    if (online) {
                        s.replaceAll("%online%", "§a§lOnline");
                    }
                    else {
                        s.replaceAll("%online%", "§c§lOffline");
                    }
                }
                lore_out.add(s);
            }
            meta.setLore((List)lore_out);
        }
        output.setItemMeta(meta);
        return output;
    }
}
