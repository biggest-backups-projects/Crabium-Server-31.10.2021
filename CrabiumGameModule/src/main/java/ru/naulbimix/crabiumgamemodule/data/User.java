package ru.naulbimix.crabiumgamemodule.data;

import net.md_5.bungee.api.chat.*;
import org.bukkit.Bukkit;
import ru.naulbimix.crabiumgamemodule.data.variables.*;
import ru.naulbimix.crabiumgamemodule.mysql.requests.*;
import ru.naulbimix.crabiumgamemodule.utils.ServerUtils;

public class User {

    private String username, lastIP, regIP, permission, prefix, suffix;

    public User(String username, String ip) {
        loadData();
        this.username = username;
    }

    public void loadData() {
        setPermission(Player.getString(getUsername(), "permission"));
        setPrefix(Player.getString(getUsername(), "prefix"));
        setSuffix(Player.getString(getUsername(), "suffix"));
        setRegIP(Player.getString(getUsername(), "regIp"));
        setLastIP(Player.getString(getUsername(), "lastIp"));
    }

    public void saveData() {
        Player.setString(getUsername(), "permission", getPermission());
        Player.setString(getUsername(), "prefix", getPrefix());
        Player.setString(getUsername(), "suffix", getSuffix());
        Player.setString(getUsername(), "regIp", getRegIP());
        Player.setString(getUsername(), "lastIp", getLastIP());
    }

    public void sendMessage(String message) {
        Bukkit.getServer().getPlayer(getUsername()).sendMessage(new TextComponent(ServerUtils.s(message)));
    }

    public void disconnect(String string) {
        org.bukkit.entity.Player p = Bukkit.getServer().getPlayer(getUsername());
        p.kickPlayer(String.valueOf(new TextComponent(ServerUtils.s(string))));
    }

    /* Values */

    public String getUsername() {
        return this.username;
    }

    public String getPermission() {
        loadData();
        return this.permission;
    }

    public String getPrefix() {
        loadData();
        return this.prefix;
    }

    public String getSuffix() {
        loadData();
        return this.suffix;
    }

    public String getRegIP() {
        loadData();
        return this.regIP;
    }

    public String getLastIP() {
        loadData();
        return this.lastIP;
    }

    public boolean isStaff() {
        return Rank.valueOf(getPermission().toUpperCase()).isStaff();
    }

    public boolean hasPermission(Permissions permission) {
        return Rank.valueOf(getPermission().toUpperCase()).getPermissions().contains(permission);
    }
    public void setPermission(String permission) {
        this.permission = permission;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setRegIP(String regIP) {
        this.regIP = regIP;
    }

    public void setLastIP(String lastIp) {
        this.lastIP = lastIp;
    }
}
