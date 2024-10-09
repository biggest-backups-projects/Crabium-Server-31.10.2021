package ru.naulbimix.crabiumgamemodule.mysql.requests;

import java.sql.*;
import ru.naulbimix.crabiumgamemodule.*;
import ru.naulbimix.crabiumgamemodule.mysql.*;
import ru.naulbimix.crabiumgamemodule.utils.*;

public class Settings {

    private static Main plugin = Main.getInstance();

    public static int getInt(String string) {
        try {
            PreparedStatement st = MySQL.con.prepareStatement(
                    "SELECT " + string + " FROM settings"
            );
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(string);
            }
        } catch (SQLException e) {
            ServerUtils.Logger("error", plugin.getConfig().getString("messages.mysql.typeError.statement")
                    .replace("$type_query", "получении запроса из")
                    .replace("$error", e.getMessage()));
            return -1;
        }
        return -1;
    }

    public static String getString(String string) {
        try {
            PreparedStatement st = MySQL.con.prepareStatement(
                    "SELECT " + string + " FROM settings"
            );
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getString(string);
            }
        } catch (SQLException e) {
            ServerUtils.Logger("error", plugin.getConfig().getString("messages.mysql.typeError.statement")
                    .replace("$type_query", "получении запроса из")
                    .replace("$error", e.getMessage()));
            return null;
        }
        return null;
    }

    public static void setInt(String string, int amount) {
        try {
            PreparedStatement st = MySQL.con.prepareStatement(
                    "UPDATE settings SET " + string + " = ?"
            );
            st.setInt(1, amount);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            ServerUtils.Logger("error", plugin.getConfig().getString("messages.mysql.typeError.statement")
                    .replace("$type_query", "установке запроса из")
                    .replace("$error", e.getMessage()));
        }
    }

    public static void setString(String p, String string, String value) {
        try {
            PreparedStatement st = MySQL.con.prepareStatement(
                    "UPDATE settings SET " + string + " = ??"
            );
            st.setString(1, value);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            ServerUtils.Logger("error", plugin.getConfig().getString("messages.mysql.typeError.statement")
                    .replace("$type_query", "установке запроса из")
                    .replace("$error", e.getMessage()));
        }
    }

}
