package ru.naulbimix.crabiumgamemodule.utils;

import java.text.*;
import java.util.*;
import org.bukkit.*;
import java.util.logging.*;
import ru.naulbimix.crabiumgamemodule.*;


public class ServerUtils {

    private static Main plugin = Main.getInstance();
    public static Date date = new Date();
    public static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public static String s(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static String getDate() {
        return format.format(date);
    }

    public static void Logger(String type, String message) {
        type = type.toUpperCase();
        type = type.equals("ERROR") ? "SEVERE" : type;
        plugin.getLogger().log(Level.parse(type), ServerUtils.s("&7" + message));
    }
}
