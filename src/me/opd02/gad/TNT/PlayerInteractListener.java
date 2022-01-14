package me.opd02.gad.TNT;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class PlayerInteractListener implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		
		Player p = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)){
			
			try{
				if(e.getItem().getType().equals(Material.TNT)){
					
					TNTPrimed pt = (TNTPrimed) p.getWorld().spawnEntity(p.getLocation(), EntityType.PRIMED_TNT);
					pt.setFuseTicks(60);
					
					pt.setVelocity(p.getEyeLocation().getDirection().add(new Vector(0, 0.3, 0)));
				}	
			}catch(NullPointerException ex){
				//Go with it
			}
			
		}
	}
}
