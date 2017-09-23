package me.Bassilone.PureHQ.UsefulMethods;

import org.bukkit.ChatColor;

public class PureHQStrings {
	//GENERAL
	public static final String NO_PERMISSION = ChatColor.RED + "You do not have permission to perform this command";
	public static final String WRONG_COMMAND = ChatColor.RED + "You entered the wrong command!";
	public static final String INVENTORY_NO_SPOT = ChatColor.RED + "You don't have a free spot in your inventory!";
	public static final String PLAYER_DOESNT_EXIST = ChatColor.RED + "This player does not exist!";
	public static final String AMOUNT_NUMBER = ChatColor.RED + "Amount should be a number!";
	public static final String PLAYER_DIES = ChatColor.RED + "You died! One of your " + ChatColor.YELLOW + "{lives}" + ChatColor.RED + " lives have been removed";
	//CRATES
	public static final String CRATE_ADDED = ChatColor.GREEN + "Successfully added crate " + ChatColor.RED + "{crate}";
	public static final String CRATE_EXISTS = ChatColor.RED + "This crate already exists!";
	public static final String CRATE_DOESNT_EXIST = ChatColor.RED + "This crate doesn't exists!";
	public static final String CRATE_REMOVED = ChatColor.GREEN + "Successfully removed crate " + ChatColor.RED + "{crate}";
	public static final String CRATE_SET = ChatColor.GREEN + "{crate}" + " crate successfully set!";
	public static final String CHEST_CRATE_EXISTS = ChatColor.RED + "This chest is already of type " + "{crate}";
	public static final String REMOVE_AIR = ChatColor.RED + "Cannot remove air!";
	public static final String ITEM_NOT_IN_CRATE = ChatColor.RED + "This crate doesn't contain that item!";
	public static final String ITEM_CRATE_REMOVAL = ChatColor.GREEN + "Successfully removed " + ChatColor.RED + "{item}";
	public static final String CRATE_GET_ITEM_INT = ChatColor.RED + "Please enter the position (number) of the item you want to retrieve!";
	public static final String POSITION_EMPTY = ChatColor.RED + "That position is empty!";
	public static final String CRATE_GET_ITEM = ChatColor.GREEN + "Successfully added item!";
	public static final String USAGE_CRATE_ADD_ITEM = ChatColor.RED + "Usage: crate <cratename> additem <percentage>";
	public static final String CRATE_SET_ITEM = ChatColor.GREEN + "Successfully added item to the crate!";
	public static final String CRATE_REMOVED_FAIL = ChatColor.RED + "You cannot remove a crate!";
	//KEYS
	public static final String PLAYER_ADD_KEY = ChatColor.GREEN + "Successfully added " + ChatColor.RED + "{amount}" + " " + "{crate}" + " key(s)" + ChatColor.GREEN + " to " + ChatColor.RED + "{player}";
	public static final String KEY_NAME = "§2"+"{crate}" + " §1key";
	//CLAIM
	public static final String CLAIM_RANK_NO_CLAIMS = ChatColor.RED + "This rank does not have claims!";
	public static final String BROADCAST_CLAIM = ChatColor.GRAY + "[Claim] " + ChatColor.RED + "{player}" + ChatColor.YELLOW + " has claimed their keys and lives!";
	public static final String ALREADY_CLAIMED = ChatColor.RED + "You already claimed!";
	public static final String CLAIM_RANK_NO_COMMAND = ChatColor.RED + "This rank does not have this command attached!";
	public static final String CLAIM_REMOVED_LIVES = ChatColor.GREEN + "Removed " + ChatColor.GRAY + "{amount}" + " lives" + ChatColor.GREEN +  " from " + ChatColor.DARK_GRAY + "{rank}";
	public static final String CLAIM_KEYS_ADDED = ChatColor.GREEN + "Added " + ChatColor.GRAY + "{amount}" + " " + "{key}" + " key(s)" + ChatColor.GREEN +  " to " + ChatColor.DARK_GRAY + "{rank}";
	//RANK
	public static final String RANK = ChatColor.GREEN + "Your rank is: " + ChatColor.YELLOW + "{rank}";
	public static final String RANK_PLAYER = ChatColor.GREEN + "{player}" + "'s rank is: " + ChatColor.YELLOW + "{rank}";
	public static final String RANK_ADDED = ChatColor.GREEN + "Successfully added the rank " + ChatColor.AQUA + "{rank}";
	public static final String RANK_EXISTS = ChatColor.RED+ "This rank already exists!";
	public static final String RANK_DOESNT_EXIST = ChatColor.RED + "This rank does not exist!";
	public static final String RANK_REMOVED = ChatColor.GREEN + "Successfully removed the rank " + ChatColor.AQUA + "{rank}";
	public static final String PLAYER_HAS_RANK = ChatColor.RED + "This player already has this rank!";
	public static final String PLAYER_NOT_IN_RANK = ChatColor.RED + "This player doesn't have this rank!";
	public static final String PLAYER_RANK_ADDED = ChatColor.GREEN + "Successfully added " + ChatColor.YELLOW + "{player}" + ChatColor.GREEN + " to the rank " + ChatColor.YELLOW + "{rank}";
	public static final String PLAYER_RANK_REMOVED = ChatColor.YELLOW + "{player}" + ChatColor.GREEN + " was successfully removed from the rank " + ChatColor.YELLOW + "{rank}";
}
