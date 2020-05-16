 package me.project2.main;

 import java.util.ArrayList;
 import org.bukkit.Bukkit;
 import org.bukkit.entity.Player;
 import org.bukkit.plugin.Plugin;
 import org.bukkit.plugin.PluginManager;
 import org.bukkit.plugin.java.JavaPlugin;

 import me.project2.commands.Logar;
 import me.project2.commands.Registrar;
 import me.project2.events.EventosLR;
 
 
 
 public class Main
   extends JavaPlugin
 {
   public static Plugin plugin;
   public static Main instance;
   public static Integer score = null;
   public static String p = "§cLOGIN ";
   public static String semperm = "§cLOGIN ";
   public static ArrayList<String> logado = new ArrayList<>();
   
   public static Main getInstance() {
   return instance;
   }
   
   public static Plugin getPlugin() {
   return plugin;
   }
   
   public void onEnable() {
   Bukkit.getServer().getConsoleSender().sendMessage(String.valueOf(p) + "§fPlugin ativado!");
   saveDefaultConfig();
   instance = this;
   plugin = (Plugin)this;
   getConfig().options().copyDefaults(true);
   getConfig().options().copyHeader(true);
   saveConfig();
   Eventos();
   Comandos();
   Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)this, new Runnable() {
           public void run() {
             byte b;
             int i;
             Player[] arrayOfPlayer;
             for (i = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, b = 0; b < i; ) { Player jogadores = arrayOfPlayer[b];
               if (Main.logado.contains(jogadores.getName()))
                 if (Main.this.getConfig().get("auth." + jogadores.getName().toLowerCase() + ".senha") != null) {
                  jogadores.sendMessage("§cLOGIN §fUtilize: /Login (Senha)");
                 } else {
                 jogadores.sendMessage("§c§lREGISTER §fUtilize: /register (senha)");
                 }  
               b++; }
           
           }
        }, 40L);
   }
   
   public void onDisable() {
   Bukkit.getServer().getConsoleSender().sendMessage(String.valueOf(p) + "§fPlugin desativado!");
   }
   
   public void Eventos() {
   PluginManager Eventos = Bukkit.getPluginManager();
   Eventos.registerEvents(new EventosLR(this), (Plugin)this);
   }
   
   public void Comandos() {
   getCommand("login").setExecutor(new Logar(this));
   getCommand("register").setExecutor(new Registrar(this));
   }
 }