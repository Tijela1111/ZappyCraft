package xyz.project.main;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.project.commands.FlyCMD;
import xyz.project.commands.GroupsetCMD;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		this.Comandos();
		Bukkit.getConsoleSender().sendMessage("§a§lPLUGIN§f Plugin ligado com sucesso.");
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§4§lPLUGIN §fPlugin desativado.");
	}
	
    public void Comandos() {
    	this.getCommand("groupset").setExecutor((CommandExecutor)new GroupsetCMD());
        this.getCommand("fly").setExecutor((CommandExecutor)new FlyCMD());
    }

          public static Main getInstance() {
         return Main.getInstance();
          }

		public static Plugin getPlugin() {
			return getPlugin();
		}
}