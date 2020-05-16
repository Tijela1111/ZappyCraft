package xyz.project.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import xyz.project.permissions.PermissionsEntry;

public class GroupsetCMD implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		if (args.length == 0) {
			sender.sendMessage(
					"§c§lERRO §fComando incorreto, utilize /groupset (nick) (grupo) ou /setgroup (grupo) (nick)");
			return true;
		}
		if (!(sender instanceof Player)) {
			sender.sendMessage("§a§lPLUGIN §fGrupo alterado com sucesso!");
			sender.sendMessage("§a§lPLUGIN §fInformações: Jogador: §a" + args[1] + " §fGrupo: §a" + args[0]);
			return true;
		}
		Player target = sender.getServer().getPlayer(args[0]);
		Player p = (Player) sender;
		if (!PermissionsEntry.ExtraPermissions.containsKey(p)) {
			sender.sendMessage("§c§lERRO §fVocê não possui permissão para executar esse comando.");
			return true;
		}
		String permChangerGroup = PermissionsEntry.getPermissions(p);
		if (args[1].equalsIgnoreCase("Membro")) {
			if (!permChangerGroup.contains("Membro")) {
				sender.sendMessage("§c§lERRO §fVocê não possui permissão para executar esse comando.");
				return true;
			}
			if (!(target == null)) {
				target.kickPlayer("§a§lGROUP\n§fSeu grupo foi alterado para " + args[1].toUpperCase()
						+ "\n§fGrupo alterado por: §a" + sender.getName());
			}
			sender.sendMessage("§a§lGROUP §fGrupo alterado com sucesso.");
			return true;
		}
		if (args[1].equalsIgnoreCase("Youtuber")) {
			if (!permChangerGroup.contains("Youtuber")) {
				sender.sendMessage("§c§lERRO §fVocê não possui permissão para executar esse comando.");
				return true;
			}
			if (!(target == null)) {
				target.kickPlayer("§a§lGROUP\n§fSeu grupo foi alterado para " + args[1].toUpperCase()
						+ "\n§fGrupo alterado por: §a" + sender.getName());
			}
			sender.sendMessage("§a§lGROUP §fGrupo alterado com sucesso.");
			return true;

		}
		if (args[1].equalsIgnoreCase("Youtuber+")) {
			if (!permChangerGroup.contains("Youtuber+")) {
				sender.sendMessage("§c§lERRO §fVocê não possui permissão para executar esse comando.");
				return true;
			}
			if (!(target == null)) {
				target.kickPlayer("§a§lGROUP\n§fSeu grupo foi alterado para " + args[1].toUpperCase()
						+ "\n§fGrupo alterado por: §a" + sender.getName());
			}
			sender.sendMessage("§a§lGROUP §fGrupo alterado com sucesso.");
			return true;
         
		}
		if (args[1].equalsIgnoreCase("Admin")) {
			if (!permChangerGroup.contains("Admin")) {
				sender.sendMessage("§c§lERRO §fVocê não possui permissão para executar esse comando.");
				return true;
			}
			if (!(target == null)) {
				target.kickPlayer("§a§lGROUP\n§fSeu grupo foi alterado para " + args[1].toUpperCase()
						+ "\n§fGrupo alterado por: §a" + sender.getName());
			}
			sender.sendMessage("§a§lGROUP §fGrupo alterado com sucesso.");
			return true;

		}
		if (args[1].equalsIgnoreCase("Gerente")) {
			if (!permChangerGroup.contains("Gerente")) {
				sender.sendMessage("§c§lERRO §fVocê não possui permissão para executar esse comando.");
				return true;
			}
			if (!(target == null)) {
				target.kickPlayer("§a§lGROUP\n§fSeu grupo foi alterado para " + args[1].toUpperCase()
						+ "\n§fGrupo alterado por: §a" + sender.getName());
			}
			sender.sendMessage("§a§lGROUP §fGrupo alterado com sucesso.");
			return true;

		}
		if (args[1].equalsIgnoreCase("Coordenador")) {
			if (!permChangerGroup.contains("Coordenador")) {
				sender.sendMessage("§c§lERRO §fVocê não possui permissão para executar esse comando.");
				return true;
			}
			if (!(target == null)) {
				target.kickPlayer("§a§lGROUP\n§fSeu grupo foi alterado para " + args[1].toUpperCase()
						+ "\n§fGrupo alterado por: §a" + sender.getName());
			}
			sender.sendMessage("§a§lGROUP §fGrupo alterado com sucesso.");
			return true;

		}
		if (args[1].equalsIgnoreCase("Diretor")) {
			if (!permChangerGroup.contains("Diretor")) {
				sender.sendMessage("§c§lERRO §fVocê não possui permissão para executar esse comando.");
				return true;
			}
			if (!(target == null)) {
				target.kickPlayer("§a§lGROUP\n§fSeu grupo foi alterado para " + args[1].toUpperCase()
						+ "\n§fGrupo alterado por: §a" + sender.getName());
			}
			sender.sendMessage("§a§lGROUP §fGrupo alterado com sucesso.");
			return true;

		}
		if (args[1].equalsIgnoreCase("dono")) {
			if (!sender.getName().equalsIgnoreCase("Tijela_Quebrada")) {
				sender.sendMessage("§c§lERRO §fVocê não possui permissão para executar esse comando.");
				return true;
			}
			if (!(target == null)) {
				target.kickPlayer("§a§lGROUP\n§fSeu grupo foi alterado para " + args[1].toUpperCase()
						+ "\n§fGrupo alterado por: §a" + sender.getName());
			}
			sender.sendMessage("§a§lGROUP §fGrupo alterado com sucesso.");
			return true;
		}
		if (args[1].equalsIgnoreCase("ceo")) {
			if (!sender.getName().equalsIgnoreCase("Tijela_Quebrada")) {
				sender.sendMessage("§c§lERRO §fVocê não possui permissão para executar esse comando.");
				return true;
			}
			if (!(target == null)) {
				target.kickPlayer("§a§lGROUP\n§fSeu grupo foi alterado para " + args[1].toUpperCase()
						+ "\n§fGrupo alterado por: §a" + sender.getName());
			}
			sender.sendMessage("§a§lGROUP §fGrupo alterado com sucesso.");
			return true;
		}
		sender.sendMessage("§c§lERRO §fO grupo §c" + args[1] + "§f não foi encontrado.");
		return true;
	}

}
