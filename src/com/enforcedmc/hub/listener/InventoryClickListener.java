package com.enforcedmc.hub.listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

import com.enforcedmc.hub.Hub;
import com.enforcedmc.hub.utils.Ping;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class InventoryClickListener implements Listener
{
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        try {
            if (e.getInventory().getName().equals("§8Lobby Selector")) {
                e.setCancelled(true);
                if (e.getCurrentItem().getType() == Material.INK_SACK && e.getCurrentItem().getDurability() == 10) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().startsWith("§aHub §7» §e#")) {
                        int hub = 1;
                        try {
                            final String[] hubs = e.getCurrentItem().getItemMeta().getDisplayName().split("#");
                            hub = Integer.parseInt(hubs[1]);
                        }
                        catch (Exception ex4) {}
                        final ByteArrayDataOutput out = ByteStreams.newDataOutput();
                        try {
                            out.writeUTF("Connect");
                            out.writeUTF(String.valueOf(Hub.hub_name) + String.valueOf(hub));
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 0.5f, 1.0f);
                            p.sendMessage("§7Connecting to Hub #" + hub + "...");
                            p.sendPluginMessage((Plugin)Hub.getInstance(), "BungeeCord", out.toByteArray());
                        }
                        catch (Exception ex) {
                            p.sendMessage("§cCan't connect to Hub #" + hub + ".");
                        }
                    }
                }
                else if (e.getCurrentItem().getType() == Material.INK_SACK && e.getCurrentItem().getDurability() == 14) {
                    p.sendMessage("§7Sorry, you are already on this hub, choose another one!");
                }
            }
            else if (e.getInventory().getName().equals("§8Server Selector")) {
                e.setCancelled(true);
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§b§l§nFACTIONS")) {
                    if (Ping.online("localhost", 18898, 120)) {
                        final ByteArrayDataOutput out2 = ByteStreams.newDataOutput();
                        try {
                            out2.writeUTF("Connect");
                            out2.writeUTF("Factions");
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 0.5f, 1.0f);
                            p.sendMessage("§aConnecting to Factions...");
                            p.sendPluginMessage((Plugin)Hub.getInstance(), "BungeeCord", out2.toByteArray());
                        }
                        catch (Exception ex2) {
                            p.sendMessage("§cCan't connect to Factions, contact a developer.");
                        }
                    }
                    else {
                        p.sendMessage("§cCan't connect to Factions because the Server is offline.");
                    }
                }
                else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§b§l§nOPFACTIONS")) {
                    if (Ping.online("1.1.1.1", 11111, 120)) {
                        final ByteArrayDataOutput out2 = ByteStreams.newDataOutput();
                        try {
                            out2.writeUTF("Connect");
                            out2.writeUTF("OPFactions");
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 0.5f, 1.0f);
                            p.sendMessage("§7Connecting to OPFactions...");
                            p.sendPluginMessage((Plugin)Hub.getInstance(), "BungeeCord", out2.toByteArray());
                        }
                        catch (Exception ex2) {
                            p.sendMessage("§7Can't connect to OPFactions, contact a developer.");
                        }
                    }
                    else {
                        p.sendMessage("§7Can't connect to OPFactions because the Server is offline.");
                    }
                }
            }
            else if (!p.getGameMode().equals((Object)GameMode.CREATIVE)) {
                e.setCancelled(true);
            }
        }
        catch (Exception ex3) {
            e.setCancelled(true);
        }
    }
}
