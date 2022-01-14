package me.opd02.gad.Firework;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

public class PlayerInteractListener implements Listener {
	
	public Random rand = new Random();

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.LEFT_CLICK_AIR) ||
				e.getAction().equals(Action.LEFT_CLICK_BLOCK)){
		Player p = e.getPlayer();
		
		if(p.getItemInHand() == null) return;
		ItemStack item = p.getItemInHand();
		
		if(!item.getType().equals(Material.FIREWORK)) return;
		
		e.setCancelled(true);
		
		p.sendMessage("&9Gadget> &7You have used &aFirework&7.".replace('&', ChatColor.COLOR_CHAR));
		spawnRandomFirework(p.getLocation());
		}	
	}
	
	public void spawnRandomFirework(Location loc){
		
		Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
		FireworkMeta fwm = fw.getFireworkMeta();
		
		fwm.addEffect(FireworkEffect.builder().flicker(randomBoolean()).trail(randomBoolean()).withFade(randomColor()).withColor(randomColor()).with(randomType()).build());;
		fw.setFireworkMeta(fwm);
		
	}
	
	public boolean randomBoolean(){
		if(rand.nextInt(2) == 0){
			return true;
		}else{
		      return false;
		      }
		}
	
	public Color randomColor(){
		return Color.fromBGR(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
		}
	public Type randomType(){
		int chosen = rand.nextInt(5);
		
		switch(chosen){
		case 0:
			return Type.BALL;
		case 1:
			return Type.BALL_LARGE;
		case 2:
			return Type.BURST;
		case 3:
			return Type.CREEPER;
		case 4: 
			return Type.STAR;
		default:
			return Type.BALL_LARGE;
		}
		}
	}
