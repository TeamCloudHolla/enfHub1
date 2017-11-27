package com.enforcedmc.hub.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.enforcedmc.hub.Hub;

public class ReloadHubCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender cs, final Command cmd, final String label, final String[] args) {
        if (cs.hasPermission("enf.hub.reload")) {
            Hub.getInstance().reloadConfig();
            cs.sendMessage("§7You success reloaded the Hub plugin.");
        }
        else {
            cs.sendMessage("§7You don't have enough Permissions!");
        }
        return true;
    }
}
