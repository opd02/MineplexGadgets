package me.opd02.gad.EtherealPearl;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class PlayerDamageListener implements Listener {

	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e){
		if(!e.getEntityType().equals(EntityType.PLAYER)) return;
		if((!e.getCause().equals(DamageCause.FALL)) || (!e.getCause().equals(DamageCause.BLOCK_EXPLOSION))) return;
		
		e.setCancelled(true);
	}
}
