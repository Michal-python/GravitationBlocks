package cat.michal;

import cat.michal.commands.StartCommand;
import cat.michal.commands.StopCommand;
import cat.michal.listeners.EntityRemoveFromWorldListener;
import com.destroystokyo.paper.event.entity.EntityRemoveFromWorldEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.bukkit.Material.*;

public final class GravitationBlocks extends JavaPlugin implements Listener {
    public static boolean isOn = false;
    static List<Material> blackList = Arrays.asList(
            AIR,
            BEDROCK,
            OBSIDIAN
    );
    @Override
    public void onEnable() {
        new StartCommand(this);
        new StopCommand(this);
        new EntityRemoveFromWorldListener(this);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (!isOn) {return;}
                for (Block b : Utils.getBlocks(p)) {
                    if(!b.isSolid()) {return;}
                    if (!b.getRelative(BlockFace.DOWN).getType().equals(AIR) || b.getRelative(BlockFace.DOWN).isSolid()) {return;}
                    if (blackList.contains(b.getType())) {return;}
                    if(b.getRelative(BlockFace.DOWN).getType().equals(WATER)) {return;}
                    Location lok = Utils.getCenter(b.getLocation());
                    b.getLocation().getWorld().spawnFallingBlock(lok, b.getType(), (byte) 0);
                    b.setType(AIR);
                }
            }
        }, 0L, 10L);
    }
}
