package me.opd02.gad.EtherealPearl;

import java.util.HashMap;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;

public class RideManager {

	private boolean isRiding;
	private Player player;
	private ArmorStand flyer;
	private EnderPearl pearl;
	
	static HashMap<Player, ArmorStand> map = new HashMap<Player, ArmorStand>();
	
	public RideManager(Player player, ArmorStand flyer, EnderPearl pearl){
		this.player = player;
		this.pearl = pearl;
		this.isRiding = true;
		this.flyer = flyer;
	}
	
	public void startFly(){
		pearl.setPassenger(flyer);
		flyer.setPassenger(player);
		map.put(this.player, this.flyer);
		return;
	}
	
	public boolean isRiding() {
		return isRiding;
	}

	public void setRiding(boolean isRiding) {
		this.isRiding = isRiding;
	}

	public ArmorStand getFlyer() {
		return flyer;
	}

	public void setFlyer(ArmorStand flyer) {
		this.flyer = flyer;
	}

	public EnderPearl getPearl() {
		return pearl;
	}

	public void setPearl(EnderPearl pearl) {
		this.pearl = pearl;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
