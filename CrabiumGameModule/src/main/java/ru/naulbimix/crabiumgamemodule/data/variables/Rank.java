package ru.naulbimix.crabiumgamemodule.data.variables;

import java.util.*;

public enum Rank {

    USER("&7Игрок", false, new ArrayList<>(Arrays.asList(Permissions.WHERE))),
    CHEAT("&8Читер&7", false, new ArrayList<>(Arrays.asList(Permissions.WHERE, Permissions.WHERE_OTHER))),
    WANDERER("&6Воин&7", false, new ArrayList<>(Arrays.asList(Permissions.WHERE, Permissions.WHERE_OTHER))),
    WARRIOR("&6Странник&7", false, new ArrayList<>(Arrays.asList(Permissions.WHERE, Permissions.WHERE_OTHER))),
    LORD("&bКнязь&7", false, new ArrayList<>(Arrays.asList(Permissions.WHERE, Permissions.WHERE_OTHER))),
    EMPEROR("&aИмператор&7", false, new ArrayList<>(Arrays.asList(Permissions.WHERE, Permissions.WHERE_OTHER))),
    LEGEND("&cЛегенда&7", false, new ArrayList<>(Arrays.asList(Permissions.WHERE, Permissions.WHERE_OTHER))),
    SENOR("&c&nСеньор&7", false, new ArrayList<>(Arrays.asList(Permissions.WHERE, Permissions.WHERE_OTHER))),
    GRAPH("&d&nГраф&f", false, new ArrayList<>(Arrays.asList(Permissions.WHERE, Permissions.WHERE_OTHER))),
    YT("&cY&fT", false, new ArrayList<>(Arrays.asList(Permissions.WHERE, Permissions.WHERE_OTHER))),
    ASSISTANT("&bПомощник&f", true, new ArrayList<>(Arrays.asList(Permissions.WHERE, Permissions.WHERE_OTHER))),
    MODER("&9Модер.&f", true, new ArrayList<>(Arrays.asList(Permissions.WHERE, Permissions.WHERE_OTHER))),
    GMODER("&9Гл. Модер&f", true, new ArrayList<>(Arrays.asList(Permissions.WHERE, Permissions.WHERE_OTHER))),
    MADMIN("&сМл. Админ&f", true, new ArrayList<>(Arrays.asList(Permissions.WHERE, Permissions.WHERE_OTHER))),
    ADMIN("&cАдмин&f", true, new ArrayList<>(Arrays.asList(Permissions.WHERE, Permissions.WHERE_OTHER))),
    DEV("&cВладелец&f", true, new ArrayList<>(Arrays.asList(Permissions.FULL)));

    private String prefix;
    private boolean staff;
    private List<Permissions> perms;

    private Rank(String prefix, boolean staff, List<Permissions> perms) {
        this.prefix = prefix;
        this.staff = staff;
        this.perms = perms;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public boolean isStaff() {
        return this.staff;
    }

    public List<Permissions> getPermissions() {
        return this.perms;
    }

    public static Rank containsRank(String string) {
        for (Rank rank : values()) {
            if (rank.toString().equalsIgnoreCase(string)) {
                return rank;
            }
        }
        return null;
    }
}
