package com.jcrm1.TogglePluginsPlugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class CommandTogglePlugin implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender.hasPermission("togglepluginsplugin.toggleplugin") && !sender.isOp()) return false;
		if (args.length <= 0) {
			sender.sendMessage("Requires a plugin name to disable");
			return false;
		} else if (args.length >= 1) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < args.length; i++) {
				if (i > 0) sb.append(" " + args[i]);
				else sb.append(args[i]);
			}
			String pluginName = sb.toString();
			Plugin foundPlugin = null;
			Plugin[] plugins = Bukkit.getServer().getPluginManager().getPlugins();
			for (Plugin plugin : plugins) {
				if (plugin.getName().equals(pluginName)) {
					foundPlugin = plugin;
				}
			}
			if (foundPlugin == null) {
				sender.sendMessage("Could not find a plugin with that name");
				return false;
			} else {
				if (foundPlugin.isEnabled() == true) {
					sender.sendMessage("Disabled plugin \"" + foundPlugin.getName() + "\"");
					Bukkit.getServer().getPluginManager().disablePlugin(foundPlugin);
					return true;
				} else if (foundPlugin.isEnabled() == false){
					sender.sendMessage("Enabled plugin \"" + foundPlugin.getName() + "\"");
					Bukkit.getServer().getPluginManager().enablePlugin(foundPlugin);
					return true;
				} else {
					sender.sendMessage("An unknown error occured");
					return false;
				}
				
			}
		} else {
			sender.sendMessage("An unknown error occured");
			return false;
		}
	}

}
