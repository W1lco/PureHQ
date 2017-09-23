package me.Bassilone.PureHQ.UsefulListeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import me.Bassilone.PureHQ.PureHQMain;
import me.Bassilone.PureHQ.UsefulMethods.PureHQFileManage;
import me.Bassilone.PureHQ.UsefulMethods.PureHQStrings;

public class PureHQDeathListener implements Listener{

	@SuppressWarnings("unused")
	private PureHQMain plugin;

    public PureHQDeathListener(PureHQMain plugin) {
        this.plugin = plugin;
    }
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void playerDeathEvent(PlayerDeathEvent event) {
		event.setDeathMessage(null);
		Player player = event.getEntity();
		int lives = PureHQMain.playerData.getInt("Name." + player.getName() + ".lives");
		if (lives == 1){
			player.setBanned(true);
		}else{
			PureHQMain.playerData.set("Name." + player.getName() + ".lives", lives - 1);
			PureHQFileManage.saveYamls();
			player.sendMessage(PureHQStrings.PLAYER_DIES.replace("{lives}", lives+""));
		}
	}
}
