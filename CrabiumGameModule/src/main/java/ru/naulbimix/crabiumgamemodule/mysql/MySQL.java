package ru.naulbimix.crabiumgamemodule.mysql;

import java.sql.*;
import ru.naulbimix.crabiumgamemodule.*;
import ru.naulbimix.crabiumgamemodule.utils.*;

public class MySQL {

    private static Main plugin = Main.getInstance();
    public static Connection con;
    public static boolean no_connection = false;

    /**
     * Подключение к БД, с получением данных БД по конфигу
     */
    public static void connection() {
        if(!isConnection()) {
            try {
                String mysql_host = plugin.getConfig().getString("mysql.host");
                int mysql_port = plugin.getConfig().getInt("mysql.port");
                String mysql_database = plugin.getConfig().getString("mysql.database");
                String mysql_user = plugin.getConfig().getString("mysql.username");
                String mysql_password = plugin.getConfig().getString("mysql.password");
                boolean mysql_autoReconnect = plugin.getConfig().getBoolean("mysql.autoReconnect");
                boolean mysql_useSSL = plugin.getConfig().getBoolean("mysql.useSSL");
                boolean mysql_useUnicode = plugin.getConfig().getBoolean("mysql.useUnicode");
                String mysql_characterEncoding = plugin.getConfig().getString("mysql.characterEncoding");

                con = DriverManager.getConnection("jdbc:mysql://" + mysql_host + ":" + mysql_port + "/" + mysql_database + "?autoReconnect=" + mysql_autoReconnect + "&useSSL=" + mysql_useSSL + "&useUnicode=" + mysql_useUnicode + "&characterEncoding=" + mysql_characterEncoding, mysql_user, mysql_password);
                ServerUtils.Logger("info", plugin.getConfig().getString("messages.mysql.typeSuccessful.connection"));
                no_connection = false;
            } catch (SQLException e) {
                ServerUtils.Logger("error", plugin.getConfig().getString("messages.mysql.typeError.connection").replace("$error", e.getMessage()));
            }
        }
    }

    public static void disconnection() {
        if(!isConnection()) {
            try {
                con.close();
                ServerUtils.Logger("info", plugin.getConfig().getString("messages.mysql.typeSuccessful.disconnection"));
            } catch (SQLException e) {
                ServerUtils.Logger("error", plugin.getConfig().getString("messages.mysql.typeError.disconnection").replace("$error", e.getMessage()));
            }
        }
    }

    public static boolean isConnection() {
        return (con != null);
    }

    public static void createTable() {
        try {
            con.prepareStatement("CREATE TABLE IF NOT EXISTS users (id INT(11) NOT NULL AUTO_INCREMENT, username VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL, perms VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'user', money INT(11) NOT NULL DEFAULT '0', coins INT(11) NOT NULL DEFAULT '0', prefix VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '&7Игрок ', suffix VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '', fly INT(11) DEFAULT '0', god INT(11) DEFAULT '0', gamemode INT(11) DEFAULT '0', vanish INT(11) DEFAULT '0', joins INT(11) DEFAULT '0', quits INT(11) DEFAULT '0', PRIMARY KEY (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci");
            ServerUtils.Logger("info", plugin.getConfig().getString("messages.mysql.typeSuccessful.createTable"));
        }catch (SQLException e) {
            ServerUtils.Logger("error", plugin.getConfig().getString("messages.mysql.typeError.createTable").replace("$error", e.getMessage()));
        }
    }
}
