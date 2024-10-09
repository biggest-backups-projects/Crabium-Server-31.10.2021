package ru.naulbimix.crabiumgamemodule.mysql.requests;

import java.sql.*;
import ru.naulbimix.crabiumgamemodule.*;
import ru.naulbimix.crabiumgamemodule.mysql.*;
import ru.naulbimix.crabiumgamemodule.utils.*;

public class Player {

    private static Main plugin = Main.getInstance();

    public static int getInt(String p, String string) {
        try {
            PreparedStatement st = MySQL.con.prepareStatement(
                    "SELECT " + string + " FROM users WHERE username = ?"
            );
            st.setString(1, p);
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

    public static long getLong(String p, String string) {
        try {
            PreparedStatement st = MySQL.con.prepareStatement(
                    "SELECT " + string + " FROM users WHERE username = ?"
            );
            st.setString(1, p);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getLong(string);
            }
        } catch (SQLException e) {
            ServerUtils.Logger("error", plugin.getConfig().getString("messages.mysql.typeError.statement")
                    .replace("$type_query", "получении запроса из")
                    .replace("$error", e.getMessage()));
            return -1;
        }
        return -1;
    }

    public static String getString(String p, String string) {
        try {
            PreparedStatement st = MySQL.con.prepareStatement(
                    "SELECT " + string + " FROM users WHERE username = ?"
            );
            st.setString(1, p);
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

    public static boolean getBoolean(String p, String string) {
        try {
            PreparedStatement st = MySQL.con.prepareStatement(
                    "SELECT " + string + " FROM users WHERE username = ?"
            );
            st.setString(1, p);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(string) == 1 ? true : false;
            }
        } catch (SQLException e) {
            ServerUtils.Logger("error", plugin.getConfig().getString("messages.mysql.typeError.statement")
                    .replace("$type_query", "получении запроса из")
                    .replace("$error", e.getMessage()));
            return false;
        }
        return false;
    }

    public static void setInt(String p, String string, int amount) {
        if(getInt(p, string) == -1) {
            try {
                PreparedStatement st = MySQL.con.prepareStatement(
                        "INSERT INTO users (username," + string + ") VALUES (?, ?)"
                );
                st.setString(1, p);
                st.setInt(2, amount);
                st.executeUpdate();
                st.close();
            } catch (SQLException e) {
                ServerUtils.Logger("error", plugin.getConfig().getString("messages.mysql.typeError.statement")
                        .replace("$type_query", "установке запроса из")
                        .replace("$error", e.getMessage()));
            }
        }else{
            try {
                PreparedStatement st = MySQL.con.prepareStatement(
                        "UPDATE users SET " + string + " = ? WHERE username = ?"
                );
                st.setInt(1, amount);
                st.setString(2, p);
                st.executeUpdate();
                st.close();
            } catch (SQLException e) {
                ServerUtils.Logger("error", plugin.getConfig().getString("messages.mysql.typeError.statement")
                        .replace("$type_query", "установке запроса из")
                        .replace("$error", e.getMessage()));
            }
        }
    }

    public static void setLong(String p, String string, long amount) {
        if(getInt(p, string) == -1) {
            try {
                PreparedStatement st = MySQL.con.prepareStatement(
                        "INSERT INTO users (username," + string + ") VALUES (?, ?)"
                );
                st.setString(1, p);
                st.setLong(2, amount);
                st.executeUpdate();
                st.close();
            } catch (SQLException e) {
                ServerUtils.Logger("error", plugin.getConfig().getString("messages.mysql.typeError.statement")
                        .replace("$type_query", "установке запроса из")
                        .replace("$error", e.getMessage()));
            }
        }else{
            try {
                PreparedStatement st = MySQL.con.prepareStatement(
                        "UPDATE users SET " + string + " = ? WHERE username = ?"
                );
                st.setLong(1, amount);
                st.setString(2, p);
                st.executeUpdate();
                st.close();
            } catch (SQLException e) {
                ServerUtils.Logger("error", plugin.getConfig().getString("messages.mysql.typeError.statement")
                        .replace("$type_query", "установке запроса из")
                        .replace("$error", e.getMessage()));
            }
        }
    }

    public static void setString(String p, String string, String value) {
        if(getString(p, string).equals(null)) {
            try {
                PreparedStatement st = MySQL.con.prepareStatement(
                        "INSERT INTO users (username," + string + ") VALUES (?, ?)"
                );
                st.setString(1, p);
                st.setString(2, value);
                st.executeUpdate();
                st.close();
            } catch (SQLException e) {
                ServerUtils.Logger("error", plugin.getConfig().getString("messages.mysql.typeError.statement")
                        .replace("$type_query", "установке запроса из")
                        .replace("$error", e.getMessage()));
            }
        }else{
            try {
                PreparedStatement st = MySQL.con.prepareStatement(
                        "UPDATE users SET " + string + " = ? WHERE username = ?"
                );
                st.setString(1, value);
                st.setString(2, p);
                st.executeUpdate();
                st.close();
            } catch (SQLException e) {
                ServerUtils.Logger("error", plugin.getConfig().getString("messages.mysql.typeError.statement")
                        .replace("$type_query", "установке запроса из")
                        .replace("$error", e.getMessage()));
            }
        }
    }

    public static void setBoolean(String p, String string, boolean value) {
        if(getInt(p, string) == -1) {
            try {
                PreparedStatement st = MySQL.con.prepareStatement(
                        "INSERT INTO users (username," + string + ") VALUES (?, ?)"
                );
                st.setString(1, p);
                st.setInt(2, value ? 1 : 0);
                st.executeUpdate();
                st.close();
            } catch (SQLException e) {
                ServerUtils.Logger("error", plugin.getConfig().getString("messages.mysql.typeError.statement")
                        .replace("$type_query", "установке запроса из")
                        .replace("$error", e.getMessage()));
            }
        }else{
            try {
                PreparedStatement st = MySQL.con.prepareStatement(
                        "UPDATE users SET " + string + " = ? WHERE username = ?"
                );
                st.setInt(1, value ? 1 : 0);
                st.setString(2, p);
                st.executeUpdate();
                st.close();
            } catch (SQLException e) {
                ServerUtils.Logger("error", plugin.getConfig().getString("messages.mysql.typeError.statement")
                        .replace("$type_query", "установке запроса из")
                        .replace("$error", e.getMessage()));
            }
        }
    }

}