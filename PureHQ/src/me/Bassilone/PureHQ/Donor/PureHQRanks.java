package me.Bassilone.PureHQ.Donor;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import me.Bassilone.PureHQ.PureHQMain;
import me.Bassilone.PureHQ.UsefulMethods.PureHQFileManage;
import me.Bassilone.PureHQ.UsefulMethods.PureHQStrings;


public class PureHQRanks {
	
	public static boolean ranks(Player player, String[] args){
		if (args.length == 0 || args.length == 1){
			return tellRank(player, args);
		}else if (!player.isOp()){
			player.sendMessage(PureHQStrings.NO_PERMISSION);
			return true;
		}else if (args.length == 2 && args[0].equalsIgnoreCase("add")){
			return addRank(player, args);
		}else if (args.length == 2 && args[0].equalsIgnoreCase("delete")){
			return deleteRank(player, args);
		}else if (args.length == 3 && args[0].equalsIgnoreCase("set")){
			return set(player, args);
		}else if (args.length == 3 && args[0].equalsIgnoreCase("remove")){
			return removePlayer(player, args);
		}else{
			player.sendMessage(PureHQStrings.WRONG_COMMAND);
			return true;
		}
	}
	public static boolean tellRank(Player player, String[] args){
		if (args.length == 0){
			String playerName = player.getName();
			String rank = PureHQMain.playerData.getString("Name."+playerName + ".rank");
			player.sendMessage(PureHQStrings.RANK.replace("{rank}", rank));
		}else{
			String playerName = args[0];
			String rank = PureHQMain.playerData.getString("Name."+playerName + ".rank");
			if (rank != null){
				player.sendMessage(PureHQStrings.RANK_PLAYER.replace("{player}", playerName).replace("{rank}", rank));
			}else{
				player.sendMessage(PureHQStrings.PLAYER_DOESNT_EXIST);
			}
			
		}
		return true;
	}
	
	public static boolean addRank(Player player, String[] args){
		String rankName = args[1];
		String rankAvailable = PureHQMain.ranks.getString(rankName);
		
		if (rankAvailable == null){
			PureHQMain.ranks.set(rankName + ".name", rankName);
			PureHQFileManage.saveYamls();
			player.sendMessage(PureHQStrings.RANK_ADDED.replace("{rank}", rankName));
		}
		else{
			player.sendMessage(PureHQStrings.RANK_EXISTS);
		}
		return true;
	}
	
	public static boolean deleteRank(Player player, String[] args){
		String rankName = args[1];
		String rankAvailable = PureHQMain.ranks.getString(rankName);
		if (rankAvailable == null){
			player.sendMessage(PureHQStrings.RANK_DOESNT_EXIST);
			return true;
		}else{
			PureHQMain.ranks.set(rankName, null);
			PureHQFileManage.saveYamls();
			player.sendMessage(PureHQStrings.RANK_REMOVED.replace("{rank}", rankName));
		}
		return true;
	}
	
	@SuppressWarnings("deprecation")
	public static boolean set(Player player, String[] args){
		String rankName = args[2];
		String rankAvailable = PureHQMain.ranks.getString(rankName);
		String playerName = args[1];
		String rank = PureHQMain.playerData.getString("Name."+playerName + ".rank");
		if (rank.equals(rankName)){
			player.sendMessage(PureHQStrings.PLAYER_HAS_RANK);
			return true;
		}
		boolean existance = false;
		for (Player all : Bukkit.getServer().getOnlinePlayers()) {
		      if (all.getName().equals(playerName)) {
		    	  existance = true;
		    	  break;
		      }
		}
		if (!existance){
			player.sendMessage(PureHQStrings.PLAYER_DOESNT_EXIST);
		}else if (rankAvailable == null){
			player.sendMessage(PureHQStrings.RANK_DOESNT_EXIST);
		}else {
			PureHQMain.playerData.set("Name."+playerName+".rank", rankName);
			PureHQFileManage.saveYamls();
			player.sendMessage(PureHQStrings.PLAYER_RANK_ADDED.replace("{player}", playerName).replace("{rank}", rankName));
		}
		
		return true;
	}
	public static boolean removePlayer(Player player, String[] args){
		String rankName = args[2];
		String playerName = args[1];
		String rank = PureHQMain.playerData.getString("Name."+playerName + ".rank");
		if (rank.equals(rankName)){
			PureHQMain.playerData.set("Name."+playerName + ".rank", "default");
			PureHQFileManage.saveYamls();
			player.sendMessage(PureHQStrings.PLAYER_RANK_REMOVED.replace("{rank}", rankName).replace("{player}", playerName));
			return true;
		}else{
			player.sendMessage(PureHQStrings.PLAYER_NOT_IN_RANK);
			return true;
		}
		
	}
}
