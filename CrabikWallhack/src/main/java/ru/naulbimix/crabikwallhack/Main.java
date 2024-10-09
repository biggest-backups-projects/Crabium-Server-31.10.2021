package ru.naulbimix.crabikwallhack;

import java.io.*;
import org.bukkit.plugin.java.*;
import ru.naulbimix.crabikwallhack.utils.*;
import ru.naulbimix.crabikwallhack.commands.*;

public class Main extends JavaPlugin {

    private static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        ServerUtils.Logger("info", "&8-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= &cCrabik&eWallhack &8-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        ServerUtils.Logger("info", "&6| &fВерсия: &6" + getDescription().getVersion());
        ServerUtils.Logger("info", "&6| &fАвтор: &6NaulbiMIX");
        ServerUtils.Logger("info", "&6| &fВеб-сайт: &6" + getDescription().getWebsite());
        ServerUtils.Logger("info", "&8-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=  &cCrabik&eWallhack &8-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        File config = new File(getDataFolder() + File.separator + "config.yml");
        if(!config.exists()){
            saveDefaultConfig();
            ServerUtils.Logger("info", "&6| &fСоздание нового конфигурационного файла плагина...");
        }
        getCommand("wh").setExecutor(new CommandWh());
        ServerUtils.Logger("info", "&6| &fПлагин был &eуспешно &aвключён&7!");
    }

    @Override
    public void onDisable() {
        ServerUtils.Logger("info", "&8-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= &eSlut&cAPI &8-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        ServerUtils.Logger("info", "&6| &fВерсия: &6" + getDescription().getVersion());
        ServerUtils.Logger("info", "&6| &fАвтор: &6NaulbiMIX");
        ServerUtils.Logger("info", "&6| &fВеб-сайт: &6" + getDescription().getWebsite());
        ServerUtils.Logger("info", "&8-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= &eSlut&cAPI &8-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        ServerUtils.Logger("info", "&6| &fПлагин был &eуспешно &cвыключен&7!");
    }

    public static Main getInstance(){
        return plugin;
    }

}
