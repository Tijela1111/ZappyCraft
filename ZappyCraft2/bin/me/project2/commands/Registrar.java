 package me.project2.commands;
 
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 import org.bukkit.entity.Player;

 import me.project2.main.Main;
 
 
 
 public class Registrar
   implements CommandExecutor
 {
   public Registrar(Main main) {}
   
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
   if (!(sender instanceof Player)) {
   return true;
     }
   Player jogador = (Player)sender;
   if (Main.logado.contains(jogador.getName())) {
       
   if (Main.plugin.getConfig().get("auth." + jogador.getName().toLowerCase() + ".senha") == null) {
         
   if (args.length == 0) {
           
 jogador.sendMessage("§c§lREGISTER §fUtilize: /register (senha)");
         }
   else if (args.length == 1) {
           
  Main.plugin.getConfig().set("auth." + jogador.getName().toLowerCase() + ".senha", args[0]);
  Main.plugin.saveConfig();
  Main.logado.remove(jogador.getName());
  jogador.sendMessage("§a§lREGISTER §fVocê se registrou com sucesso!");
         }
 else if (args.length > 1) {
           
 jogador.sendMessage("§c§lREGISTER §fColoque a senha 1 vez");
         } 
       } else {
         
 jogador.sendMessage("§c§lREGISTER §fVocê já está registrado!");
       } 
     } else {
       
 jogador.sendMessage("§c§lREGISTER §fVocê já está logado!");
     } 
 return false;
   }
 }