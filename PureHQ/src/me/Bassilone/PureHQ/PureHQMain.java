package me.Bassilone.PureHQ;



import java.io.File;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.Bassilone.PureHQ.Crates.PureHQCrate;
import me.Bassilone.PureHQ.Crates.PureHQCrateBreakListener;
import me.Bassilone.PureHQ.Crates.PureHQInventoryListener;
import me.Bassilone.PureHQ.Crates.PureHQKey;
import me.Bassilone.PureHQ.Donor.PureHQClaim;
import me.Bassilone.PureHQ.Donor.PureHQRanks;
import me.Bassilone.PureHQ.Economy.PureHQEconomyCommands;
import me.Bassilone.PureHQ.Economy.PureHQSignListener;
import me.Bassilone.PureHQ.Lives.PureHQLives;
import me.Bassilone.PureHQ.Staff.PureHQChatListener;
import me.Bassilone.PureHQ.Staff.PureHQGamemodes;
import me.Bassilone.PureHQ.Staff.PureHQStaff;
import me.Bassilone.PureHQ.Staff.PureHQTeleport;
import me.Bassilone.PureHQ.UsefulListeners.PureHQInteractListener;
import me.Bassilone.PureHQ.UsefulListeners.PureHQJoinLeaveListener;
import me.Bassilone.PureHQ.UsefulMethods.PureHQFileManage;



public class PureHQMain extends JavaPlugin{
	public static File cratesFile;
	public static FileConfiguration crates;
	public static File playerDataFile;
	public static FileConfiguration playerData;
	public static File ranksFile;
	public static FileConfiguration ranks;
	public void onEnable(){
		PureHQFileManage fm = new PureHQFileManage(this);
		playerDataFile = new File(getDataFolder(), "/data/playerdata.yml");
		playerData = new YamlConfiguration();
		ranksFile = new File(getDataFolder(), "/data/ranks.yml");
		ranks = new YamlConfiguration();
		cratesFile = new File(getDataFolder(), "/data/crates.yml");
		crates = new YamlConfiguration();
		try {
            fm.firstRun();
        } catch (Exception e) {
            e.printStackTrace();
        }
		playerData.set("Note", "To edit this file, stop the server and edit!");
		ranks.set("Note", "To edit this file, stop the server and edit!");
		crates.set("Note", "Don't edit this file, or it will get corrupted!");
		PureHQFileManage.loadYamls();
		
		getConfig().addDefault("Name.server",false);
		getConfig().options().copyDefaults(true);
		saveConfig();
		reloadConfig();
		getServer().getPluginManager().registerEvents(new PureHQChatListener(this), this);
		getServer().getPluginManager().registerEvents(new PureHQCrateBreakListener(), this);
		getServer().getPluginManager().registerEvents(new PureHQJoinLeaveListener(this), this);
		getServer().getPluginManager().registerEvents(new PureHQSignListener(this), this);
		getServer().getPluginManager().registerEvents(new PureHQInteractListener(this), this);
		getServer().getPluginManager().registerEvents(new PureHQInventoryListener(), this);
	}
	
	public void onDisable(){
		saveConfig();
		PureHQFileManage.saveYamls();
	}
	
	@Override
	public boolean onCommand (CommandSender sender, Command command, String commandLabel, String[] args){
		if (sender instanceof Player){
			if (command.getName().equalsIgnoreCase("gmc"))return PureHQGamemodes.gmc(sender);
			if (command.getName().equalsIgnoreCase("gms"))return PureHQGamemodes.gms(sender);
			if (command.getName().equalsIgnoreCase("gma"))return PureHQGamemodes.gma(sender);
			if (command.getName().equalsIgnoreCase("gm"))return PureHQGamemodes.gm(sender, args);
			if (command.getName().equalsIgnoreCase("staffchat"))return PureHQStaff.staffchat(sender, args,this);
			if (command.getName().equalsIgnoreCase("clearinventory"))return PureHQStaff.clearinventory((Player)sender,args);
			if (command.getName().equalsIgnoreCase("teleporthere"))return PureHQTeleport.tphere((Player)sender, args);
			if (command.getName().equalsIgnoreCase("teleport"))return PureHQTeleport.tp((Player) sender, args);
			if (command.getName().equalsIgnoreCase("teleportall"))return PureHQTeleport.tpall((Player) sender, args);
			if (command.getName().equalsIgnoreCase("withdraw"))return PureHQEconomyCommands.withdraw(sender, args);
			if (command.getName().equalsIgnoreCase("pay"))return PureHQEconomyCommands.pay(sender, args);
			if (command.getName().equalsIgnoreCase("balance"))return new PureHQEconomyCommands(this).bal(sender, args);
			if (command.getName().equalsIgnoreCase("key"))return new PureHQKey(this).keymain((Player)sender, args);
			if (command.getName().equalsIgnoreCase("crate"))return new PureHQCrate(this).cratemain((Player) sender, args);
			if (command.getName().equalsIgnoreCase("heal"))return PureHQStaff.heal((Player)sender, args);
			if (command.getName().equalsIgnoreCase("feed"))return PureHQStaff.feed((Player)sender, args);
			if (command.getName().equalsIgnoreCase("rank"))return PureHQRanks.ranks((Player)sender, args);
			if (command.getName().equalsIgnoreCase("claim"))return PureHQClaim.claimMain((Player)sender, args);
			if (command.getName().equalsIgnoreCase("lives"))return PureHQLives.livesMain((Player)sender, args);
		}else{
			if (command.getName().equalsIgnoreCase("key"))return new PureHQKey(this).keymain(sender, args);
			if (command.getName().equalsIgnoreCase("lives"))return PureHQLives.livesMain(sender, args);
		}
		return false;
	}

}
