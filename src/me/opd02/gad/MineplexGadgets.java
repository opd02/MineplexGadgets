package me.opd02.gad;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MineplexGadgets extends JavaPlugin {

	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(new me.opd02.gad.EtherealPearl.PearlThrowListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new me.opd02.gad.EtherealPearl.PearlLandListener(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new me.opd02.gad.EtherealPearl.PlayerDamageListener(), this);
		
		Bukkit.getServer().getPluginManager().registerEvents(new me.opd02.gad.TNT.PlayerInteractListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new me.opd02.gad.TNT.ExplosionBlocksListener(), this);
		
		Bukkit.getServer().getPluginManager().registerEvents(new me.opd02.gad.Firework.PlayerInteractListener(), this);
		
		Bukkit.getServer().getPluginManager().registerEvents(new me.opd02.gad.PaintballGun.PlayerInteractListener(), this);
	}
	
	public void onDisable(){
		
	}
	
}
