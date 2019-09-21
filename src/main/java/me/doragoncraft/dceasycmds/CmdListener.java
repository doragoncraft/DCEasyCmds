package me.doragoncraft.dceasycmds;

import org.bukkit.ChatColor;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.doragoncraft.dceasycmds.main;
import me.doragoncraft.dceasycmds.CmdListener;

public class CmdListener implements Listener {


    @EventHandler
    public void onPreCommand(PlayerCommandPreprocessEvent event) {
        Player p = event.getPlayer();
        String message = event.getMessage();
        if (message.contains("/?")) {

            event.setCancelled(true);
            p.sendMessage("Unknown command. Type \"/help\" for help.");
            return;
        }
    }
}
