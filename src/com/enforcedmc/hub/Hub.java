package com.enforcedmc.hub;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.enforcedmc.hub.commands.ReloadHubCommand;
import com.enforcedmc.hub.commands.SetHubCommand;
import com.enforcedmc.hub.gadgets.PaintballGun;
import com.enforcedmc.hub.gadgets.ParticleGun;
import com.enforcedmc.hub.listener.BlockFormListener;
import com.enforcedmc.hub.listener.BuildListener;
import com.enforcedmc.hub.listener.DamageListener;
import com.enforcedmc.hub.listener.EntitySpawnListener;
import com.enforcedmc.hub.listener.FoodListener;
import com.enforcedmc.hub.listener.InventoryClickListener;
import com.enforcedmc.hub.listener.InventoryCloseListener;
import com.enforcedmc.hub.listener.PlayerDropListener;
import com.enforcedmc.hub.listener.PlayerInteractEntityListener;
import com.enforcedmc.hub.listener.PlayerInteractListener;
import com.enforcedmc.hub.listener.PlayerJoinFireworkListener;
import com.enforcedmc.hub.listener.PlayerJoinListener;
import com.enforcedmc.hub.listener.PlayerXPListener;
import com.enforcedmc.hub.listener.WeatherChangeListener;
import com.enforcedmc.hub.utils.Lists;

public class Hub extends JavaPlugin
{
    private static Hub instance;
    public static HashMap<Integer, String> hub_ips = new HashMap();
    public static HashMap<Integer, Integer> hub_ports = new HashMap();
    public static String hub_name;
    
    static {
        Hub.hub_ips = new HashMap<Integer, String>();
        Hub.hub_ports = new HashMap<Integer, Integer>();
        Hub.hub_name = "Hub";
    }
    
    public void onEnable() {
        Hub.instance = this;
        this.getServer().getMessenger().registerOutgoingPluginChannel((Plugin)this, "BungeeCord");
        hub_ips.put(Integer.valueOf(1), "localhost");
        hub_ips.put(Integer.valueOf(2), "localhost");        
        hub_ports.put(Integer.valueOf(1), Integer.valueOf(22456));
        hub_ports.put(Integer.valueOf(2), Integer.valueOf(23112));
        final PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents((Listener)new PlayerJoinListener(), (Plugin)this);
        pm.registerEvents((Listener)new PlayerDropListener(), (Plugin)this);
        pm.registerEvents((Listener)new WeatherChangeListener(), (Plugin)this);
        pm.registerEvents((Listener)new PlayerXPListener(), (Plugin)this);
        pm.registerEvents((Listener)new BuildListener(), (Plugin)this);
        pm.registerEvents((Listener)new PlayerInteractEntityListener(), (Plugin)this);
        pm.registerEvents((Listener)new EntitySpawnListener(), (Plugin)this);
        pm.registerEvents((Listener)new PlayerInteractListener(), (Plugin)this);
        pm.registerEvents((Listener)new InventoryCloseListener(), (Plugin)this);
        pm.registerEvents((Listener)new InventoryClickListener(), (Plugin)this);
        pm.registerEvents((Listener)new FoodListener(), (Plugin)this);
        pm.registerEvents((Listener)new DamageListener(), (Plugin)this);
        pm.registerEvents((Listener)new PlayerJoinFireworkListener(), (Plugin)this);
        pm.registerEvents((Listener)new BlockFormListener(), (Plugin)this);
        pm.registerEvents((Listener)new PaintballGun(), (Plugin)this);
        pm.registerEvents((Listener)new ParticleGun(), (Plugin)this);
        this.getCommand("sethub").setExecutor((CommandExecutor)new SetHubCommand());
        this.getCommand("reloadhub").setExecutor((CommandExecutor)new ReloadHubCommand());
        loadLists();
        try {
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "/stoplag");
            Bukkit.getWorld("New").setGameRuleValue("doDaylightCycle", "false");
        }
        catch (Exception ex) {}
    }
    
    public void onDisable() {
    }
    
    public static Hub getInstance() {
        return Hub.instance;
    }
    
    public static void loadLists() {
        Lists.colors.clear();
        Lists.colors.add(Color.fromRGB(255, 255, 255));
        Lists.colors.add(Color.fromRGB(216, 127, 51));
        Lists.colors.add(Color.fromRGB(178, 76, 216));
        Lists.colors.add(Color.fromRGB(102, 153, 216));
        Lists.colors.add(Color.fromRGB(229, 229, 51));
        Lists.colors.add(Color.fromRGB(127, 204, 25));
        Lists.colors.add(Color.fromRGB(242, 127, 165));
        Lists.colors.add(Color.fromRGB(76, 76, 76));
        Lists.colors.add(Color.fromRGB(153, 153, 153));
        Lists.colors.add(Color.fromRGB(76, 127, 153));
        Lists.colors.add(Color.fromRGB(127, 63, 178));
        Lists.colors.add(Color.fromRGB(51, 76, 178));
        Lists.colors.add(Color.fromRGB(102, 76, 51));
        Lists.colors.add(Color.fromRGB(102, 127, 51));
        Lists.colors.add(Color.fromRGB(153, 51, 51));
        Lists.colors.add(Color.fromRGB(25, 25, 25));
        Lists.mats.clear();
        Lists.mats.add(Material.AIR);
        Lists.mats.add(Material.SIGN);
        Lists.mats.add(Material.SIGN_POST);
        Lists.mats.add(Material.WALL_SIGN);
        Lists.mats.add(Material.PAINTING);
        Lists.mats.add(Material.ITEM_FRAME);
        Lists.mats.add(Material.VINE);
        Lists.mats.add(Material.LONG_GRASS);
        Lists.mats.add(Material.YELLOW_FLOWER);
        Lists.mats.add(Material.RED_ROSE);
    }
}
