package com.enforcedmc.hub.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.enforcedmc.hub.Hub;

public class SetHubCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender cs, final Command cmd, final String label, final String[] args) {
        if (cs.hasPermission("enf.sethub")) {
            if (cs instanceof Player) {
                final Player p = (Player)cs;
                Hub.getInstance().getConfig().set("spawnpoint.world", (Object)p.getLocation().getWorld().getName());
                Hub.getInstance().getConfig().set("spawnpoint.x", (Object)p.getLocation().getX());
                Hub.getInstance().getConfig().set("spawnpoint.y", (Object)p.getLocation().getY());
                Hub.getInstance().getConfig().set("spawnpoint.z", (Object)p.getLocation().getZ());
                Hub.getInstance().getConfig().set("spawnpoint.yaw", (Object)(double)p.getLocation().getYaw());
                Hub.getInstance().getConfig().set("spawnpoint.pitch", (Object)(double)p.getLocation().getPitch());
                Hub.getInstance().saveConfig();
                Hub.getInstance().reloadConfig();
                p.sendMessage("§7You success set the spawnpoint.");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 0.5f, 1.0f);
            }
            else {
                cs.sendMessage("§7This command is only executable by Players!");
            }
        }
        else {
            cs.sendMessage("§7You don't have enough Permissions!");
        }
        return true;
    }
}
