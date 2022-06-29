package com.jcrm1.TogglePluginsPlugin;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TogglePluginsPlugin extends JavaPlugin {
	@Override
	public void onEnable() {
		this.getCommand("toggleplugin").setExecutor(new CommandTogglePlugin());
	}
	public void onDisable() {
		Bukkit.getLogger().log(Level.INFO, "Feels kind of ironic, doesn't it?");
	}
}
