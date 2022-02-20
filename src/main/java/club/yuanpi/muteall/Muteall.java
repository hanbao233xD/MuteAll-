package club.yuanpi.muteall;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import static org.bukkit.Bukkit.getServer;

public final class Muteall extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new muteallma1n(),this);
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&l[&b&l全员禁言&a&l]插件加载完成"));
        Bukkit.getPluginManager().registerEvents(new Muteallloader(),this);
    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
