package club.yuanpi.muteall;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.*;
import java.util.Random;

import static org.bukkit.Bukkit.getServer;

public class utils {

    public static void log(String log){
    getServer().getLogger().info(log);

    }
    public static void banplayer(String bancmd){getServer().dispatchCommand(getServer().getConsoleSender(), bancmd);}
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
    public  static  String readLastLine(File file, String charset)  throws  IOException {
        if  (!file.exists() || file.isDirectory() || !file.canRead()) {
            return  null ;
        }
        RandomAccessFile raf =  null ;
        try  {
            raf =  new  RandomAccessFile(file,  "r" );
            long  len = raf.length();
            if  (len == 0L) {
                return  "" ;
            }  else  {
                long  pos = len -  50 ;
                while  (pos >  0 ) {
                    pos--;
                    raf.seek(pos);
                    if  (raf.readByte() ==  '\n' ) {
                        break ;
                    }
                }
                if  (pos ==  0 ) {
                    raf.seek( 0 );
                }
                byte [] bytes =  new  byte [( int ) (len - pos)];
                raf.read(bytes);
                if  (charset ==  null ) {
                    return  new  String(bytes);
                }  else  {
                    return  new  String(bytes, charset);
                }
            }
        }  catch  (FileNotFoundException e) {
        }  finally  {
            if  (raf !=  null ) {
                try  {
                    raf.close();
                }  catch  (Exception e2) {
                }
            }
        }
        return  null ;
    }
    public static String getRandomString(int minLength, int maxLength) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        int length = random.nextInt(maxLength) % (maxLength - minLength + 1) + minLength;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }


}

