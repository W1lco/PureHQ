package me.Bassilone.PureHQ.Crates;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class PureHQCrateManager {
	public static boolean addKey(Player player, Player playerKey, String cratename, int amount){
		ItemStack is = new ItemStack(Material.NETHER_STAR,amount);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName("§2"+cratename + " §1key");
		is.setItemMeta(im);
		playerKey.getInventory().setItem(playerKey.getInventory().firstEmpty(), is);
		playerKey.updateInventory();
		player.sendMessage(ChatColor.GREEN + "Successfully added " + ChatColor.RED + amount + " " + cratename + " key(s)" + ChatColor.GREEN + " to " + ChatColor.RED + playerKey.getName());
		return true;
	}
}
