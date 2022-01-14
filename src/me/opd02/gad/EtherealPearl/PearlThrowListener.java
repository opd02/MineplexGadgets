package me.opd02.gad.EtherealPearl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class PearlThrowListener implements Listener {

	@EventHandler
	public void onPlayerPearlThrow(ProjectileLaunchEvent e){
		
		if(!e.getEntity().getType().equals(EntityType.ENDER_PEARL)) return;
		if(!(e.getEntity().getShooter() instanceof Player)) return;
		
		Player p = (Player) e.getEntity().getShooter();
		EnderPearl pearl = (EnderPearl) e.getEntity();
		
		if(RideManager.map.containsKey(p)){
			p.sendMessage("&9Gadget> &7You must wait to thrown another &aEthereal Pearl&7.".replace('&', ChatColor.COLOR_CHAR));
			e.setCancelled(true);
			p.updateInventory();
			return;
		}
		
		ArmorStand flyer = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
		flyer.setGravity(false);
		flyer.setVisible(false);
		flyer.setMarker(true);
		flyer.setSmall(true);
		
		RideManager rm = new RideManager(p, flyer, pearl);
		rm.startFly();
		
		p.sendMessage("&9Gadget> &7You threw &aEthereal Pearl&7.".replace('&', ChatColor.COLOR_CHAR));
	}
	
	public void shout(String message){
		Bukkit.getServer().broadcastMessage(message);
	}
}
