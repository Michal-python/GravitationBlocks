package cat.michal.commands;

import cat.michal.GravitationBlocks;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class StartCommand implements CommandExecutor {
    public StartCommand(JavaPlugin j) {
        j.getCommand("gravitystart").setExecutor(this::onCommand);
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) { System.out.println("You must be player"); return false;}
        GravitationBlocks.isOn = true;
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&a&lOd teraz każdy blok ma grawitacje!"));
        return false;
    }
}
