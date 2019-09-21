package me.doragoncraft.dceasycmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.doragoncraft.dceasycmds.SpigotUpdater;

public class main extends JavaPlugin implements Listener {
    JavaPlugin plugin;

    public void onDisable() {
        System.out.println("[DcEasyCmds] by Doragoncraft!");
    }

    public void onEnable() {
        loadConfig();
        System.out.println("[DcEasyCmds] by DoragonCraft!");
        getServer().getPluginManager().registerEvents(new CmdListener(), this);
        Metrics metrics = new Metrics(this);

        new SpigotUpdater(this, 51426, "51426" );
        Bukkit.getPluginManager().registerEvents(this, this);

    }

    public void onJoin(PlayerJoinEvent a) {
        Player p = a.getPlayer();
        String oriprefix = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "DCCMD" + ChatColor.DARK_GRAY + "]"
                + ChatColor.GRAY + " ";
        if (p.getName().contains("DoragonCraft")) {
            p.sendMessage(
                    oriprefix + ChatColor.RED + ChatColor.BOLD + "This server uses your plugin!" + " " + oriprefix);
        }
    }

    public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("skype")) {

            String sk1 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Message.skype.1"));
            String sk2 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Message.skype.2"));
            String sk3 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Message.skype.3"));
            String sk4 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Message.skype.4"));
            String sk5 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Message.skype.5"));
            String sk6 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Message.skype.6"));
            String sk7 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Message.skype.7"));
            String sk8 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Message.skype.8"));
            p.sendMessage(sk1);
            p.sendMessage(sk2);
            p.sendMessage(sk3);
            p.sendMessage(sk4);
            p.sendMessage(sk5);
            p.sendMessage(sk6);
            p.sendMessage(sk7);
            p.sendMessage(sk8);
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("twitch") || cmd.getName().equalsIgnoreCase("stream")) {
            String tw1 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Message1.twitch.1"));
            String tw2 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Message1.twitch.2"));
            String tw3 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Message1.twitch.3"));
            String tw4 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Message1.twitch.4"));
            String tw5 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Message1.twitch.5"));
            String tw6 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Message1.twitch.6"));
            String tw7 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Message1.twitch.7"));
            String tw8 = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Message1.twitch.8"));
            p.sendMessage(tw1);
            p.sendMessage(tw2);
            p.sendMessage(tw3);
            p.sendMessage(tw4);
            p.sendMessage(tw5);
            p.sendMessage(tw6);
            p.sendMessage(tw7);
            p.sendMessage(tw8);
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("fb") || cmd.getName().equalsIgnoreCase("facebook")) {

            String msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.fb"));
            p.sendMessage(msg);
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("ts") || cmd.getName().equalsIgnoreCase("teamspeak")) {

            String msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.ts"));
            p.sendMessage(msg);
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("vote")) {

            String msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.vote"));
            p.sendMessage(msg);
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("twitter")) {

            String msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.twitter"));
            p.sendMessage(msg);
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("website")) {

            String msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.website"));
            p.sendMessage(msg);
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("youtube")) {

            String msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.youtube"));
            p.sendMessage(msg);
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("donate")) {

            String msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.donate"));
            p.sendMessage(msg);
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("member")) {

            String msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.member"));
            p.sendMessage(msg);
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("discord")) {

            String msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.discord"));
            p.sendMessage(msg);
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("forum")) {

            String msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.forum"));
            p.sendMessage(msg);
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("dec")) {

            p.sendMessage(ChatColor.AQUA + "[DCEasyCommands] " + ChatColor.GREEN + "Version "
                    + getDescription().getVersion() + " by " + ChatColor.BLUE + "DoragonCraft");
            p.sendMessage(ChatColor.AQUA + "============== " + ChatColor.DARK_RED + ChatColor.BOLD + "DC Easy Cmds Help"
                    + ChatColor.AQUA + "==============");
            p.sendMessage(ChatColor.DARK_RED + "   -   " + ChatColor.AQUA + "/dec " + ChatColor.DARK_AQUA
                    + "Display This Menu!");
            p.sendMessage(ChatColor.DARK_RED + "   -   " + ChatColor.AQUA + "/discord " + ChatColor.DARK_AQUA
                    + "Shows Staff Skype!");
            p.sendMessage(ChatColor.DARK_RED + "   -   " + ChatColor.AQUA + "/fb " + ChatColor.DARK_AQUA
                    + "Shows Our Facebook page link!");
            p.sendMessage(ChatColor.DARK_RED + "   -   " + ChatColor.AQUA + "/ts " + ChatColor.DARK_AQUA
                    + "Shows Our Teamspeak Ip!");
            p.sendMessage(ChatColor.DARK_RED + "   -   " + ChatColor.AQUA + "/vote " + ChatColor.DARK_AQUA
                    + "Shows the voting info!");
            p.sendMessage(ChatColor.DARK_RED + "   -   " + ChatColor.AQUA + "/website " + ChatColor.DARK_AQUA
                    + "Shows out website home page link!");
            p.sendMessage(ChatColor.DARK_RED + "   -   " + ChatColor.AQUA + "/youtube " + ChatColor.DARK_AQUA
                    + "Shows the Youtube channel link!");
            p.sendMessage(ChatColor.DARK_RED + "   -   " + ChatColor.AQUA + "/twitch " + ChatColor.DARK_AQUA
                    + "Shows the twitch channel links!");
            p.sendMessage(ChatColor.DARK_RED + "   -   " + ChatColor.AQUA + "/member " + ChatColor.DARK_AQUA
                    + "Shows the signup link!");
            p.sendMessage(ChatColor.DARK_RED + "   -   " + ChatColor.AQUA + "/forum " + ChatColor.DARK_AQUA
                    + "Shows the fourm page link!");
            p.sendMessage(ChatColor.DARK_RED + "   -   " + ChatColor.AQUA + "/donate " + ChatColor.DARK_AQUA
                    + "Shows the store link!");
            p.sendMessage(ChatColor.DARK_RED + "   -   " + ChatColor.AQUA + "/twitter " + ChatColor.DARK_AQUA
                    + "Shows the twitter page link!");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("decreload") && p.hasPermission("dec.reload")) {

            reloadConfig();
            p.sendMessage("Config Reloaded");
            sender.sendMessage("DCEasyCmds reloaded from Console!");
            return true;
        }

        return false;
    }
    public void loadConfig() {
        FileConfiguration cfg = getConfig();
        cfg.options().copyDefaults(true);
        saveConfig();
    }
}