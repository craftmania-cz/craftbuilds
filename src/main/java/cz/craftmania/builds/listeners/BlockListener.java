package cz.craftmania.builds.listeners;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class BlockListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onExplosion(BlockExplodeEvent e) { // Deaktivace explozí kvůli stavbám
        if (e.getBlock().getType() == Material.TNT
                || e.getBlock().getType() == Material.END_CRYSTAL
                || e.getBlock().getType() == Material.TNT_MINECART){
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityExplosion(EntityExplodeEvent e) {
        if (e.getEntityType() == EntityType.PRIMED_TNT
            || e.getEntityType() == EntityType.ENDER_CRYSTAL
            || e.getEntityType() == EntityType.MINECART_TNT) {
            e.setCancelled(true);
        }
    }
}
