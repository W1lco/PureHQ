package me.Bassilone.PureHQ.Crates;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Bassilone.PureHQ.PureHQMain;


public class PureHQKey {
	public PureHQMain plugin;
	public PureHQKey(PureHQMain main){
		this.plugin = main;
	}
	
	public boolean keymain(CommandSender sender, String[] args){
		if (sender instanceof Player){
			Player player = (Player) sender;
			if (args.length == 4){
				if (args[0].equalsIgnoreCase("give")|| args[0].equalsIgnoreCase("add")){
					return keyadd(player, args);
				}else{
					player.sendMessage(ChatColor.RED + "Usage: crate add|remove player type amount");
				}
			}
		}else{
			if (args[0].equalsIgnoreCase("give") || args[0].equalsIgnoreCase("add")){
				Player player = Bukkit.getPlayer(args[1]);
				if (player != null){
					return keyadd(player,args);
				}else{
					return true;
				}
			}
		}
		return true;
	}

	@SuppressWarnings({ "deprecation" })
	public boolean keyadd(Player player, String[] args){
		if (!player.isOp()){
			player.sendMessage(ChatColor.RED + "You do not have permission to perform this command");
			return true;
		}
		List<String> o = (List<String>) PureHQMain.crates.getStringList("Crates");
		if (o != null){
			if (o.contains(args[2])){
				if (args[3].matches("[0-9]+")){
					for (Player all : Bukkit.getServer().getOnlinePlayers()) {
						if (all.getName().equals(args[1])) {
							if (all.getInventory().firstEmpty() != -1) return PureHQCrateManager.addKey(player, all, args[2], Integer.parseInt(args[3]));
							else{
								player.sendMessage(ChatColor.RED + "This player has no space in his inventory!");
								return true;
							}
						}      
					}
					player.sendMessage(ChatColor.RED + "Enter valid playername!");
				}else{
					player.sendMessage(ChatColor.RED + "Amount has to be a number!");
				}
			}else{
				player.sendMessage(ChatColor.RED + "Add valid cratename!");
			}
		}
		return true;
	}
}
