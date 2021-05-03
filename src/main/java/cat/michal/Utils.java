package cat.michal;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static Location getCenter(Location loc) {
        double x = Double.valueOf((int) loc.getX());
        double y = loc.getY();
        double z = Double.valueOf((int) loc.getZ());
        Location l = new Location(loc.getWorld(), x+0.5, y, z+0.5);
        return l;
    }
    public static List<Block> getBlocks(Player p) {
        int radius = 15;
        Location loc = p.getLocation();
        World world = p.getWorld();
        List<Block> blocks = new ArrayList<Block>();
        for (int x = -radius; x < radius; x++) {
            for (int y = -radius; y < radius; y++) {
                for (int z = -radius; z < radius; z++) {
                    Block block = world.getBlockAt(loc.getBlockX()+x, loc.getBlockY()+y, loc.getBlockZ()+z);
                    blocks.add(block);
                }
            }
        }
        return blocks;
    }
}
