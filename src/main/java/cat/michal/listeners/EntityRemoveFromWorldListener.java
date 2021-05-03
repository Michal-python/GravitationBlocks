package cat.michal.listeners;

import cat.michal.GravityBlocks;
import com.destroystokyo.paper.event.entity.EntityRemoveFromWorldEvent;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class EntityRemoveFromWorldListener implements Listener {
    public EntityRemoveFromWorldListener(JavaPlugin j) {
        j.getServer().getPluginManager().registerEvents(this, j);
    }

    @EventHandler
    public void onRemove(EntityRemoveFromWorldEvent e) {
        if(GravityBlocks.isOn) {
            if (e.getEntity() instanceof FallingBlock) {
                FallingBlock f = (FallingBlock) e.getEntity();
                e.getEntity().getLocation().getBlock().setType(f.getMaterial());
            }
        }
    }
}
