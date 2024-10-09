package ru.naulbimix.crabikwallhack.commands;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import ru.naulbimix.crabikwallhack.*;
import ru.naulbimix.crabikwallhack.utils.*;

public class CommandWh implements CommandExecutor {

    private static Main plugin = Main.getInstance();

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String l, String[] args) {
        if(s instanceof Player && s.hasPermission("crabikstudio.wh")) {
            Player p = ((Player) s).getPlayer();
            for(Player other : Bukkit.getOnlinePlayers()) {
                if(other.getLocation().distance(p.getLocation()) <= 64 && !other.getName().equals(p.getName())) { // Хуёвая проверка, знаю, ну нахуй сложности)
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect " + other.getName() + " glowing 15 1");
                //    other.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 15, 1)); Хули закоментировано? - Я тупой или ядро хуйня, ничего  я не пойму и разбираца не хочу, проц умирац
                }
            }
            p.sendMessage(ServerUtils.s("&c&lCrabik&f&lStudio&7: &7Вы &aуспешно &7включили &ewallhack&7 на 15 секунд!"));
        }
        return true;
    }

}
