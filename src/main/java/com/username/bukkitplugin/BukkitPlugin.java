/**
 * @license GPL-3.0
 */

package com.username.bukkitplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitPlugin extends JavaPlugin implements Listener {
  @Override
  public void onEnable() {
    Bukkit.getServer().broadcastMessage("Enabled!");
  }

  @Override
  public void onDisable() {
    Bukkit.getServer().broadcastMessage("Disabled.");
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!(sender instanceof Player)) {
      return false;
    }

    if (command.getName().equalsIgnoreCase("basic")) {
      Bukkit.getServer().broadcastMessage("Hello, World");
    }

    return true;
  }

  @EventHandler(priority = EventPriority.HIGH)
  public void onLogin(PlayerLoginEvent event) {
    Bukkit.getServer().broadcastMessage("User joined! (" + event.getPlayer().getName() + ")");
  }

  @EventHandler(priority = EventPriority.HIGH)
  public void onBreak(BlockBreakEvent event) {
    Bukkit.getServer().broadcastMessage("Block broke at: (XYZ) " + String.valueOf(event.getBlock().getX())
        + String.valueOf(event.getBlock().getY()) + String.valueOf(event.getBlock().getZ()));
  }
}
