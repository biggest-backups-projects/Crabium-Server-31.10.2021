package ru.naulbimix.crabiumgamemodule.events;

import java.util.*;
import org.bukkit.block.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.event.player.*;
import org.bukkit.event.entity.*;

public class EventListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onFixPistonExtend(BlockPistonExtendEvent e) {
        List<Block> extehdBlocks = e.getBlocks();
        if (extehdBlocks != null) {
            for (Block b : extehdBlocks) {
                e.setCancelled(false);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onFixPistonRetract(BlockPistonRetractEvent e) {
        List<Block> retractedBlocks = e.getBlocks();
        if (retractedBlocks != null) {
            for (Block b : retractedBlocks) {
                e.setCancelled(false);
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        e.setDeathMessage(null);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        e.setMessage("");
    }

}
