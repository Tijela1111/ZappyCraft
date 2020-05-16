package xyz.project.system;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.OfflinePlayer;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardTeam;
import net.minecraft.server.v1_8_R3.ScoreboardTeamBase;

public class TagPacket {

    private PacketPlayOutScoreboardTeam packet;
    private ReflectionManager reflectionManager = new ReflectionManager();

    public TagPacket(String name, Set<?> set, int updateType) {
        this.packet = new PacketPlayOutScoreboardTeam();
        if (set == null || set.isEmpty()) {
            set = new HashSet<>();
        }
        reflectionManager.begin(packet);
        reflectionManager.setString("a", name);
        reflectionManager.setInteger("h", updateType);
        reflectionManager.getCollection("g").addAll(set);
    }

    public TagPacket(String name, String prefix, String suffix, Set<OfflinePlayer> set, int updateType) {
        this.packet = new PacketPlayOutScoreboardTeam();
        reflectionManager.begin(packet);
        reflectionManager.setString("a", name);
        reflectionManager.setInteger("h", updateType);
        if (updateType == 0 || updateType == 2) {
            reflectionManager.setString("b", name);
            reflectionManager.setString("c", prefix);
            reflectionManager.setString("d", suffix);
            reflectionManager.setInteger("i", 1);
            if (!TagAPI.visible) {
                reflectionManager.setString("e", ScoreboardTeamBase.EnumNameTagVisibility.NEVER.e);
            }
        }
        if (updateType == 0) {
            reflectionManager.getCollection("g").addAll(set);
        }
    }

    public void sendPacket(Player player) {
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }

}
