package me.opd02.gad.TNT;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class ExplosionBlocksListener implements Listener {

	@EventHandler
	public void onTNTExplode(EntityExplodeEvent e){
		e.blockList().clear();
		e.setCancelled(true);
	}
}
