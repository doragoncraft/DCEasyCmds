package me.doragoncraft.dceasycmds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class SpigotUpdater
        implements Listener {
    private JavaPlugin plugin;
    private String version;
    private String name;
    private long nextInformationCheck;
    private int resource;

    public SpigotUpdater(JavaPlugin plugin, int resource, String name) {
        this.plugin = plugin;
        this.nextInformationCheck = 0L;
        this.resource = resource;
        this.version = "0";
        this.name = name;
        refresh(true);
        Bukkit.getPluginManager().registerEvents(this, plugin);
        (new BukkitRunnable() {

            @Override
            public void run() {
                try {
                    SpigotUpdater.this.notifyUpdate();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }).runTaskTimer(plugin, 18000L, 18000L);
    }


    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        (new BukkitRunnable() {
            public void run() {
                SpigotUpdater.this.notifyUpdate(e.getPlayer());
            }
        }).runTaskLater(this.plugin, 40L);
    }


    public String getRawLatestVersion() {
        return this.version;
    }


    public void checkForUpdates() throws Exception {
        if (canRefresh())
            refresh(false);
    }

    public boolean hasUpdate() {
        if (canRefresh()) {
            try {
                checkForUpdates();
            } catch (Exception e) {
                System.out.println("[" + this.plugin.getName() + " Failed to check for update.");
                return false;
            }
        }
        return !this.version.equalsIgnoreCase(this.plugin.getDescription().getVersion());
    }


    public String getLatestVersion() {
        return isBeta() ? this.version.replace("-BETA", "") : this.version;
    }


    public boolean isBeta() {
        return this.version.endsWith("-BETA");
    }


    public int getVersionsBehind() {
        return Integer.parseInt(this.version.replaceAll("[^0-9]", "")) -
                Integer.parseInt(this.plugin.getDescription().getVersion().replaceAll("[^0-9]", ""));
    }


    public boolean canRefresh() {
        return (this.nextInformationCheck <= System.currentTimeMillis());
    }


    public void refresh(boolean force) {
        if (!force && this.nextInformationCheck > System.currentTimeMillis())
            return;
        try {
            URLConnection con = (new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resource))
                    .openConnection();
            this.version = (new BufferedReader(new InputStreamReader(con.getInputStream()))).readLine();
        } catch (Exception exception) {
        }
    }


    public void notifyUpdate() throws Exception {
        try {
            if (!hasUpdate())
                return;
            this.plugin.getLogger()
                    .info("An update is available! v" +
                            this.plugin.getDescription().getVersion() + " -> v" + this.version + ". You are " + getVersionsBehind() +
                            " versions behind. Update at https://spigotmc.org/resources/" + this.name + " (Resource: " + this.resource + ")");
            for (Player p : Bukkit.getOnlinePlayers())
                notifyUpdate(p);
        } catch (Exception e) {
            System.out.println("[" + this.plugin.getName() + " Failed to check for update.");
        }
    }

    public void notifyUpdate(Player arg0) {
        try {
            if (!hasUpdate() || !arg0.isOp())
                return;
            arg0.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&8[&6" + this.plugin.getName() + "&8] "));
            arg0.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&cAn update is available! v" + this.version));
            arg0.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&2This is v" + this.plugin.getDescription().getVersion() + " &4You are -" + getVersionsBehind() + " versions behind"));
            arg0.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&cUpdate at https://spigotmc.org/resources/" + this.name));

        } catch (Exception e) {
            System.out.println("[" + this.plugin.getName() + " Failed to perform an update task.");
        }
    }
}
