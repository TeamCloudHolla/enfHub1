package com.enforcedmc.hub.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherChangeListener implements Listener
{
    @EventHandler
    public void onWeatherChange(final WeatherChangeEvent e) {
        e.setCancelled(true);
    }
}
