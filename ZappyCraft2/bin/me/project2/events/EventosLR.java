 package me.project2.events;
 
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.EventPriority;
 import org.bukkit.event.Listener;
 import org.bukkit.event.player.AsyncPlayerChatEvent;
 import org.bukkit.event.player.PlayerCommandPreprocessEvent;
 import org.bukkit.event.player.PlayerInteractEvent;
 import org.bukkit.event.player.PlayerJoinEvent;
 import org.bukkit.event.player.PlayerMoveEvent;
 import org.bukkit.event.player.PlayerQuitEvent;

 import me.project2.main.Main;
 
 
 
 public class EventosLR
   implements Listener
 {
   public EventosLR(Main main) {}
   
   @EventHandler
   private void aoMover(PlayerMoveEvent evento) {
     if (Main.logado.contains(evento.getPlayer().getName())) {
       evento.getPlayer().teleport(evento.getPlayer().getLocation());
     }
   }
 
   
   @EventHandler
   private void aoEntrar(PlayerJoinEvent evento) {
     Main.logado.add(evento.getPlayer().getName());
   }
   
   @EventHandler
   private void aoSair(PlayerQuitEvent evento) {
    Main.logado.remove(evento.getPlayer().getName());
   }
 
   
   @EventHandler
   private void aoInteragir(PlayerInteractEvent evento) {
    if (Main.logado.contains(evento.getPlayer().getName())) {
      evento.setCancelled(true);
     }
   }
 
   
   @EventHandler
   private void aoFalar(AsyncPlayerChatEvent evento) {
   if (Main.logado.contains(evento.getPlayer().getName())) {
    evento.setCancelled(true);
     }
   }
   
   @EventHandler(priority = EventPriority.LOWEST)
   public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent evento) {
   Player player = evento.getPlayer();
   player.getName().toLowerCase();
   if (Main.logado.contains(evento.getPlayer().getName()) && !evento.getMessage().startsWith("/login") && !evento.getMessage().startsWith("/register"))
     {
    evento.setCancelled(true);
     }
   }
 }