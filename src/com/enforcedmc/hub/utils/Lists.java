package com.enforcedmc.hub.utils;

import java.util.ArrayList;

import org.bukkit.Color;
import org.bukkit.Material;

public class Lists
{
    public static ArrayList<String> vanished;
    public static ArrayList<String> chat_disabled;
    public static ArrayList<String> stacker;
    public static final ArrayList<Color> colors;
    public static final ArrayList<Material> mats;
    
    static {
        Lists.vanished = new ArrayList<String>();
        Lists.chat_disabled = new ArrayList<String>();
        Lists.stacker = new ArrayList<String>();
        colors = new ArrayList<Color>();
        mats = new ArrayList<Material>();
    }
}
