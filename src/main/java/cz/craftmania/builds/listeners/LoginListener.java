package cz.craftmania.builds.listeners;

import cz.craftmania.builds.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class LoginListener implements Listener {

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onLogin(PlayerLoginEvent e){
        Player p = e.getPlayer();
        if(Main.getInstance().getMySQL().isInWhitelist(p) == 0){
            e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§c§lNemas pristup na Build servery.\n\n§ePozadej si u Waka o povoleni.");
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent e) {

        final Player p = e.getPlayer();

        // Join zprava
        e.setJoinMessage("§dServer §8» §a" + p.getName() + " §ese pripojil na server!");

        //AT
        if (Main.getInstance().getMySQL().isAT(p)) {
            Main.getInstance().at_list.add(p);
        }

        if (!p.isOp()) {
            p.setOp(true);
        }
    }


    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        final Player p = e.getPlayer();

        // Left zprava
        e.setQuitMessage("§dServer §8» §c" + p.getName() + " §ese odpojil.");

        //AT
        if (Main.getInstance().at_list.contains(p)) {
            Main.getInstance().at_list.remove(p);
        }

    }

    @EventHandler
    public void onKick(PlayerKickEvent e) {
        final Player p = e.getPlayer();

        //AT
        if (Main.getInstance().at_list.contains(p)) {
            Main.getInstance().at_list.remove(p);
        }
    }



}
