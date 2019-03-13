package cz.craftmania.builds.listeners;

import cz.craftmania.builds.managers.ReplacementManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        e.setCancelled(true);
        for(Player p : Bukkit.getOnlinePlayers()){
            p.sendMessage("§b" + e.getPlayer().getName() + " §8» §f" + ReplacementManager.replaceText(e.getMessage()));
        }
    }
}
