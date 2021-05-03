package cat.michal.commands;

import cat.michal.GravityBlocks;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class StopCommand implements CommandExecutor {
    public StopCommand(JavaPlugin j) {
        j.getCommand("gravitystop").setExecutor(this::onCommand);
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) { System.out.println("You must be player"); return false;}
        GravityBlocks.isOn = false;
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&a&lOd teraz działa tylko minecraftowa grawitacja!"));
        return false;
    }
}
