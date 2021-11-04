package me.aleiv.core.paper.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import me.aleiv.core.paper.Core;
import me.aleiv.core.paper.events.GameTickEvent;

public class GlobalListener implements Listener{
    
    Core instance;

    public GlobalListener(Core instance){
        this.instance = instance;
    }

    @EventHandler
    public void onGameTick(GameTickEvent e) {
        Bukkit.getScheduler().runTask(instance, () -> {
            
        });
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        var block = e.getBlock();
        var player = e.getPlayer();
        var game = instance.getGame();
        if(game.getMaterials().contains(block.getType())) return;

        if(!player.hasPermission("admin.perm")){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        var player = e.getPlayer();
        var inv = player.getInventory();
        
        inv.clear();
        inv.addItem(new ItemStack(Material.NETHERITE_PICKAXE));
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e){
        var entity = e.getEntity();
        var damager = e.getDamager();
        if(entity instanceof Player player && damager instanceof Player damagerPlayer && !damagerPlayer.hasPermission("admin.perm")){
            e.setCancelled(true);
        }
    }

}
