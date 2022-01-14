package me.opd02.gad.gui;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GuiCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		 
		if(cmd.getName().equalsIgnoreCase("menu")){
			
		}
		return false;
	}

}
