package xyz.siema.live.tiktoklive.tasks;
import java.util.HashMap;
import java.util.Objects;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import xyz.siema.live.tiktoklive.basic.Main;
import xyz.siema.live.tiktoklive.helpers.ActionBarHelpers;
import xyz.siema.live.tiktoklive.helpers.ColorHelpers;
import xyz.siema.live.tiktoklive.helpers.config.Config;
import xyz.siema.live.tiktoklive.basic.Main;
import xyz.siema.live.tiktoklive.helpers.ActionBarHelpers;
import xyz.siema.live.tiktoklive.helpers.ColorHelpers;
import xyz.siema.live.tiktoklive.helpers.config.Config;

public class TasksPickaxe {
    public TasksPickaxe() {
    }

    public void startTask() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
            Player[] onlinePlayers;
            int length = (onlinePlayers = (Player[])Bukkit.getOnlinePlayers().toArray((Object[])(new Player[0]))).length;

            for(int i = 0; i < length; ++i) {
                Player player = onlinePlayers[i];
                if ((Integer)Main.pickaxe.get(player.getName()) >= 10) {
                    ActionBarHelpers.sendActionBar(player, ColorHelpers.color(Config.instancConfig.getSystemVariables().getActionbarMessageMax()));
                    int value1 = Objects.nonNull(Main.pickaxe.get(player.getName())) ? (Integer)Main.pickaxe.get(player.getName()) + 1 : 1;
                    Main.pickaxe.put(player.getName(), value1);
                }

                if ((Integer)Main.pickaxe.get(player.getName()) <= 10) {
                    String var10001 = Config.instancConfig.getSystemVariables().getActionbarMessage();
                    HashMap var10003 = Main.pickaxe;
                    ActionBarHelpers.sendActionBar(player, ColorHelpers.color(var10001.replace("{amount}", "" + var10003.get(player.getName()))));
                }
            }

        }, 20L, 20L);
    }
}
