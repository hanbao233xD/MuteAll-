package club.yuanpi.muteall;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Locale;

public class AntiDuke implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        String name=event.getPlayer().getName();
        boolean isduke=name.contains("Duke");
    if (isduke){
        utils.banplayer("banip "+name+" 你可能是压测者");
    }
    }
}
