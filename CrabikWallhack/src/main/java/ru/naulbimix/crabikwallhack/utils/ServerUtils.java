package ru.naulbimix.crabikwallhack.utils;

import org.bukkit.*;
import java.util.logging.*;
import ru.naulbimix.crabikwallhack.*;

public class ServerUtils {

    private static Main plugin = Main.getInstance();

    public static String s(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static void Logger(String type, String message) {
        type = type.toUpperCase();
        type = type.equals("ERROR") ? "SEVERE" : type;
        plugin.getLogger().log(Level.parse(type), ServerUtils.s("&7" + message));
    }
}
