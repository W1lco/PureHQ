package me.Bassilone.PureHQ.Donor;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import me.Bassilone.PureHQ.PureHQMain;
import me.Bassilone.PureHQ.UsefulMethods.PureHQFileManage;
import me.Bassilone.PureHQ.UsefulMethods.PureHQStrings;

public class PureHQClaim {
	public static boolean claimMain(Player player, String[] args){
		if (args.length == 0){
			return claim(player,args);
		}else if (args.length == 4 && (args[0].equalsIgnoreCase("addkeys")|| args[0].equalsIgnoreCase("addkey"))){
			return claimAddKeys(player, args);
		}else if (args.length == 4 && (args[0].equalsIgnoreCase("removekeys")|| args[0].equalsIgnoreCase("removekey"))){
			return claimRemoveKeys(player, args);
		}else if (args.length == 3 && (args[0].equalsIgnoreCase("addlives")|| args[0].equalsIgnoreCase("addlife"))){
			return claimAddLives(player, args);
		}else if (args.length == 3 && (args[0].equalsIgnoreCase("removelives")|| args[0].equalsIgnoreCase("removelife"))){
			return claimRemoveLives(player, args);
			
		}else{
			return true;
		}
		
	}
	
	public static boolean claim(Player player, String[] args){
		String playerName = player.getName();
		String rank = PureHQMain.playerData.getString("Name." + playerName + ".rank");
		String rankAvailable = PureHQMain.ranks.getString(rank);
		if (rankAvailable == null){
			player.sendMessage(PureHQStrings.RANK_DOESNT_EXIST);
			return true;
		}
		boolean claimedAlready = PureHQMain.playerData.getBoolean("Name." + playerName + ".claimed");
		
		if (!claimedAlready){
			List<String> commands = PureHQMain.ranks.getStringList(rank + ".commands");
			if (commands == null){
				player.sendMessage(PureHQStrings.CLAIM_RANK_NO_CLAIMS);
				return true;
			}else{
				for (String s : commands){
					String s2 = s.replace("{player}", player.getName());
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), s2);
				}
				PureHQMain.playerData.set("Name." + playerName + ".claimed", true);
				PureHQFileManage.saveYamls();
				Bukkit.broadcastMessage(PureHQStrings.BROADCAST_CLAIM.replace("{player}", playerName));
			}
		}else{
			player.sendMessage(PureHQStrings.ALREADY_CLAIMED);
		}
		return true;
	}
	
	public static boolean claimAddLives(Player player, String[] args){
		String rank = args[1];
		String amount = args[2];
		if (!amount.matches("[0-9]+")){
			player.sendMessage(PureHQStrings.AMOUNT_NUMBER);
		}
		String rankAvailable = PureHQMain.ranks.getString(rank);
		List<String> commands = PureHQMain.ranks.getStringList(rank + ".commands");
		String command = "lives add {player} "+ amount;
		if (rankAvailable == null){
			player.sendMessage(PureHQStrings.RANK_DOESNT_EXIST);
			return true;
		}
		if (commands == null){
			commands = new ArrayList<String>();
			commands.add(command);
		}else{
			commands.add(command);
		}
		PureHQMain.ranks.set(rank + ".commands", commands);
		PureHQFileManage.saveYamls();
		return true;
	}
	

	public static boolean claimRemoveLives(Player player, String[] args){
		String rank = args[1];
		
		String amount = args[2];
		if (!amount.matches("[0-9]+")){
			player.sendMessage(PureHQStrings.AMOUNT_NUMBER);
		}
		String rankAvailable = PureHQMain.ranks.getString(rank);
		List<String> commands = PureHQMain.ranks.getStringList(rank + ".commands");
		String command = "lives add {player} "+ amount;
		if (rankAvailable == null){
			player.sendMessage(PureHQStrings.RANK_DOESNT_EXIST);
			return true;
		}
		if (commands != null && commands.contains(command)){
			commands.remove(command);
			player.sendMessage(PureHQStrings.CLAIM_REMOVED_LIVES.replace("{amount}", amount).replace("{rank}", rank)); 
		}else{
			player.sendMessage(PureHQStrings.CLAIM_RANK_NO_COMMAND);
		}
		PureHQMain.ranks.set(rank + ".commands", commands);
		PureHQFileManage.saveYamls();
		return true;
	}
	
	
	public static boolean claimAddKeys(Player player, String[] args){
		String rank = args[1];
		String keyType = args[2];
		String amount = args[3];
		if (!amount.matches("[0-9]+")){
			player.sendMessage(PureHQStrings.AMOUNT_NUMBER);
		}
		String rankAvailable = PureHQMain.ranks.getString(rank);
		List<String> commands = PureHQMain.ranks.getStringList(rank + ".commands");
		String command = "key give {player} " + keyType + " " + amount;
		if (rankAvailable == null){
			player.sendMessage(PureHQStrings.RANK_DOESNT_EXIST);
			return true;
		}
		if (commands == null){
			commands = new ArrayList<String>();
			commands.add(command);
			player.sendMessage(PureHQStrings.CLAIM_KEYS_ADDED.replace("{amount}", amount).replace("{key}", keyType).replace("{rank}", rank));
		}else{
			commands.add(command);
			player.sendMessage(PureHQStrings.CLAIM_KEYS_ADDED.replace("{amount}", amount).replace("{key}", keyType).replace("{rank}", rank)); 
		}
		PureHQMain.ranks.set(rank + ".commands", commands);
		PureHQFileManage.saveYamls();
		return true;
	}
	
	public static boolean claimRemoveKeys(Player player, String[] args){
		String rank = args[1];
		String keyType = args[2];
		String amount = args[3];
		if (!amount.matches("[0-9]+")){
			player.sendMessage(PureHQStrings.AMOUNT_NUMBER);
		}
		String rankAvailable = PureHQMain.ranks.getString(rank);
		List<String> commands = PureHQMain.ranks.getStringList(rank + ".commands");
		String command = "key give {player} " + keyType + " " + amount;
		if (rankAvailable == null){
			player.sendMessage(PureHQStrings.RANK_DOESNT_EXIST);
			return true;
		}
		if (commands != null && commands.contains(command)){
			commands.remove(command);
			player.sendMessage(PureHQStrings.CLAIM_REMOVED_LIVES.replace("{amount}", amount).replace("{rank}", rank)); 
		}else{
			player.sendMessage(PureHQStrings.CLAIM_RANK_NO_COMMAND);
		}
		PureHQMain.ranks.set(rank + ".commands", commands);
		PureHQFileManage.saveYamls();
		return true;
	}
}