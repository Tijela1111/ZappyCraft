 package me.project2.commands;
 
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 import org.bukkit.entity.Player;

 import me.project2.main.Main;
 
 
 
 public class Logar
   implements CommandExecutor
 {
   public Logar(Main main) {}
   
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
   if (!(sender instanceof Player)) {
   return true;
     }
   Player jogador = (Player)sender;
   if (Main.logado.contains(jogador.getName())) {
       
   if (Main.plugin.getConfig().get("auth." + jogador.getName().toLowerCase() + ".senha") != null) {
         
   if (args.length == 0) {
   jogador.sendMessage("§c§lLOGIN §fUtilize: /Login (Senha)");
   } else if (args.length == 1) {
           
  if (args[0].equals(Main.plugin.getConfig().get("auth." + jogador.getName().toLowerCase() + ".senha")))
           {
  Main.logado.remove(jogador.getName());
  jogador.sendMessage("§a§lLOGIN §fVocê foi logado com sucesso!");
           }
           else
           {
   jogador.sendMessage("§c§lLOGIN §fSenha incorreta.");
           }
         
  } else if (args.length > 1) {
  jogador.sendMessage("§c§lLOGIN §fColoque a senha 1 vez");
         } 
       } else {
         
  jogador.sendMessage("§c§lLOGIN §fVocê já está logado.");
       } 
     } else {
       
  jogador.sendMessage("§c§lLOGIN §fVocê já está registrado.");
     } 
  return false;
   }
 }