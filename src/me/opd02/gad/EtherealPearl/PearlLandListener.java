package me.opd02.gad.EtherealPearl;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import me.opd02.gad.MineplexGadgets;

public class PearlLandListener implements Listener {
	
	MineplexGadgets plugin;
	
	public PearlLandListener(MineplexGadgets plugin){
		this.plugin = plugin;
	}

	@EventHandler
	public void onPearlLand(ProjectileHitEvent e){
		if(!e.getEntityType().equals(EntityType.ENDER_PEARL)) return;
	
		Player p = (Player) e.getEntity().getShooter();	
		
		if(p.getWorld().getBlockAt(p.getLocation()).getType() != Material.AIR){
			p.teleport(p.getLocation().add(0, 0.7, 0));
		}
		if(RideManager.map.containsKey(p)){
			ArmorStand stand = RideManager.map.get(p);
			stand.remove();
			RideManager.map.remove(p, RideManager.map.get(p));
			spawnFirework(p.getLocation());
		}
	}
	
	public void spawnFirework(Location location){
		
		Firework fw = (Firework) location.getWorld().spawnEntity(location, EntityType.FIREWORK);
		FireworkMeta fwm = fw.getFireworkMeta();
		
		fwm.setPower(0);
		fwm.addEffect(FireworkEffect.builder().flicker(true).trail(false).withColor(Color.PURPLE).withFade(Color.WHITE).withColor(Color.BLACK).build());
		fw.setFireworkMeta(fwm);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
		    @Override
		    public void run() {
		        fw.detonate();
		    }
		}, 2L);
	}
}
