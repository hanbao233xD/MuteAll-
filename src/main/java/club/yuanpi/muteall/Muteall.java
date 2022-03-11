package club.yuanpi.muteall;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;



public final class Muteall extends JavaPlugin implements Listener {
    public static boolean enable;
    public String authcode;


    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this,this);
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&l[&b&l全员禁言+&a&l]加载成功 使用/muteall"));
        Bukkit.getPluginManager().registerEvents(new AuthCode(),this);
        Bukkit.getPluginManager().registerEvents(new AntiDuke(),this );
        Bukkit.getPluginCommand("muteall").setExecutor(this);
    }


    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
        if (cmd.getName().equals("muteall")) {
            if (sender.isOp()) {
                if (enable) {
                    enable = false;
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&a&l管理员关闭了全员禁言"));
                } else {
                    enable = true;
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&a&l管理员开启了全员禁言，无特定权限无法说话"));
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "权限不足"));
            }
        }
        return true;
    }

    @EventHandler
    public void OnChat(PlayerChatEvent e) {
        Player p = e.getPlayer();
        if (enable) {
            if (!(p.hasPermission("muteall.bypass") || p.isOp())) {
                e.setCancelled(true);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l对不起，管理员开启了全员禁言，你无法说话"));
            }
        }
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
