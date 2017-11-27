package com.enforcedmc.hub.utils;

import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PacketPlayOutChat;

import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ActionAPI
{
  public static boolean works = true;
  public static String nmsver;
  
  public static void sendActionBar(Player player, String message)
  {
    CraftPlayer p = (CraftPlayer)player;
    if (p.getHandle().playerConnection.networkManager.getVersion() != 47) {
      return;
    }
    IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + message + "\"}");
    PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, 2);
    p.getHandle().playerConnection.sendPacket(ppoc);
  }
}
