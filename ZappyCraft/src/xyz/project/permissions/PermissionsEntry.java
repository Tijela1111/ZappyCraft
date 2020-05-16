package xyz.project.permissions;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.scheduler.BukkitRunnable;

import xyz.project.main.Main;
import xyz.project.system.TagAPI;

public class PermissionsEntry implements Listener {

	private static PermissionsEntry api;

	public static PermissionsEntry getAPI() {
		return api;
	}

	HashMap<UUID, PermissionAttachment> perms = new HashMap<UUID, PermissionAttachment>();
	public static Map<Player, String> ExtraPermissions = new HashMap<Player, String>();
	public static Map<String, String> Group = new HashMap<String, String>();

	public void addPerm(String perm, Player p) {
		PermissionAttachment attachment = p.addAttachment(Main.getInstance());
		perms.put(p.getUniqueId(), attachment);
		PermissionAttachment pperms = perms.get(p.getUniqueId());
		pperms.setPermission(perm, true);
	}

	public static String getPermissions(Player p) {
		if (ExtraPermissions.containsKey(p)) {
			return ExtraPermissions.get(p);
		} else {
			return "Nenhuma";
		}
	}

	public static String getGroup(Player p) {
		if (Group.containsKey(p.getName())) {
			return Group.get(p.getName());
		} else {
			return "Membro";
		}
	}

	@EventHandler
	public void RemoveCache(PlayerQuitEvent e) {
		if (Group.containsKey(e.getPlayer().getName())) {
			Group.remove(e.getPlayer().getName());
		}
		if (ExtraPermissions.containsKey(e.getPlayer())) {
			PermissionsEntry.ExtraPermissions.remove(e.getPlayer());
		}
		perms.remove(e.getPlayer().getUniqueId());
	}

	@EventHandler
	public void RemoveCache(PlayerKickEvent e) {
		if (Group.containsKey(e.getPlayer().getName())) {
			Group.remove(e.getPlayer().getName());
		}
		if (ExtraPermissions.containsKey(e.getPlayer())) {
			ExtraPermissions.remove(e.getPlayer());
		}
		perms.remove(e.getPlayer().getUniqueId());
	}

	@EventHandler
	public void LoginProcess(PlayerLoginEvent e) {
		String group = getGroup(e.getPlayer());
		Player p = (Player) e.getPlayer();
		PermissionAttachment attachment = e.getPlayer().addAttachment(Main.getInstance());
		perms.put(e.getPlayer().getUniqueId(), attachment);
		PermissionAttachment pperms = perms.get(e.getPlayer().getUniqueId());
		pperms.setPermission("tag.normal", true);
		new BukkitRunnable() {
			public void run() {
				if (group.equalsIgnoreCase("Membro")) {
					pperms.setPermission("simulator.fly", true);
					p.setDisplayName("§7" + p.getName());
					TagAPI.setNameTag(p.getName(), "team", "§7", group);
					return;
				}
				if (group.equalsIgnoreCase("Youtuber") || group.toLowerCase().equalsIgnoreCase("youtuber")) {
					pperms.setPermission("simulator.fly", true);
					p.setDisplayName("§b§lYT §b" + p.getName());
					TagAPI.setNameTag(p.getName(), "team", "§b§lYT §b", group);
					return;
				}
				if (group.equalsIgnoreCase("Youtuber+") || group.toLowerCase().equalsIgnoreCase("youtuber")) {
					pperms.setPermission("simulator.fly", true);
					p.setDisplayName("§9§lYT+ §9" + p.getName());
					TagAPI.setNameTag(p.getName(), "team", "§9§lYT+ §9", group);
					return;
				}
				if (group.equalsIgnoreCase("Admin") || group.toLowerCase().equalsIgnoreCase("admin")) {
					ExtraPermissions.put(p, "Youtuber+, Youtuber, Membro.");
					pperms.setPermission("simulator.fly", true);
					p.setDisplayName("§c§lADMIN §c" + p.getName());
					TagAPI.setNameTag(p.getName(), "team", "§c§lADMIN §c", group);
					return;
				}
				if (group.equalsIgnoreCase("Gerente") || group.toLowerCase().equalsIgnoreCase("gerente")) {
					ExtraPermissions.put(p,
							"Admin, Youtuber+, Youtuber, Membro.");
					pperms.setPermission("simulator.fly", true);
					p.setDisplayName("§c§lGERENTE §c" + p.getName());
					TagAPI.setNameTag(p.getName(), "team", "§c§lGERENTE §c", group);
					return;
				}
				if (group.equalsIgnoreCase("Coordenador") || group.toLowerCase().equalsIgnoreCase("coordenador")
						|| group.toLowerCase().equalsIgnoreCase("cordenador")) {
					ExtraPermissions.put(p,
							"Gerente, Admin, Youtuber+, Youtuber, Membro.");
					if (!e.getPlayer().isOp()) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op " + e.getPlayer().getName());
					}
					p.setDisplayName("§9§lCOORD §9" + p.getName());
					TagAPI.setNameTag(p.getName(), "team", "§9§lCOORD §9", group);
				}
				if (p.getName().equalsIgnoreCase("Tijela_Quebrada")) {
					ExtraPermissions.put(p,
							"Coordenador, Admin, Youtuber+, Youtuber, Membro.");
					if (!e.getPlayer().isOp()) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op " + e.getPlayer().getName());
					}
					p.setDisplayName("§4§lDONO §4" + p.getName());
					TagAPI.setNameTag(p.getName(), "team", "§4§LDONO §4", group);
					return;
				}
				if (p.getName().equalsIgnoreCase("Splitrox")) {
					ExtraPermissions.put(p,
							"Coordenador, Admin, Youtuber+, Youtuber, Membro.");
					if (!e.getPlayer().isOp()) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op " + e.getPlayer().getName());
					}
					p.setDisplayName("§4§lDONO §4" + p.getName());
					TagAPI.setNameTag(p.getName(), "team", "§4§LDONO §4", group);
					return;
				}
				if (group.equalsIgnoreCase("Dono") || group.toLowerCase().equalsIgnoreCase("dono")) {
					ExtraPermissions.put(p,
							"Dono, Coordenador, Admin, Youtuber+, Youtuber, Membro.");
					if (!e.getPlayer().isOp()) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op " + e.getPlayer().getName());
					}
					p.setDisplayName("§1§lDIRETOR §1" + p.getName());
					TagAPI.setNameTag(p.getName(), "team", "§1§lDIRETOR §1", group);
				}
				if (group.equalsIgnoreCase("Diretor") || group.toLowerCase().equalsIgnoreCase("diretor")) {
					ExtraPermissions.put(p,
							"Dono, Coordenador, Admin, Youtuber+, Youtuber, Membro.");
					if (!e.getPlayer().isOp()) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op " + e.getPlayer().getName());
					}
					p.setDisplayName("§1§lDIRETOR §1" + p.getName());
					TagAPI.setNameTag(p.getName(), "team", "§1§LDIRETOR §1", group);
					return;
				}
				return;
			}

		}.runTaskLater(Main.getPlugin(), 10 * 2);
	}

}
