package me.opd02.gad.PaintballGun;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.LEFT_CLICK_AIR) ||
				e.getAction().equals(Action.LEFT_CLICK_BLOCK)){
		Player p = e.getPlayer();
		
		if(p.getItemInHand() == null) return;
		ItemStack item = p.getItemInHand();
		
		if(!item.getType().equals(Material.IRON_BARDING)) return;
		
		e.setCancelled(true);
		p.sendMessage("&9Gadget> &7You have used &aPaintball Gun&7.".replace('&', ChatColor.COLOR_CHAR));
		
		shootProjectile(p);
		}
	}
	
	public void shootProjectile(Player p){
		
		Projectile ball = p.launchProjectile(Snowball.class);
		ball.setVelocity(p.getLocation().getDirection().normalize().multiply(1));
		
	}
}
