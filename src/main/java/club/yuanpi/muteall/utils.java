package club.yuanpi.muteall;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.bukkit.Bukkit.getServer;

public class utils {

    public static void log(String log){
    getServer().getLogger().info(log);

    }
    public static void sendok(Player player,String message){
        player.sendMessage(ChatColor.GREEN+message);
    }
    public  static  void senderr(Player player,String message){
        player.sendMessage(ChatColor.RED+message);
    }

    public static String readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }


}

