package xyz.siema.live.tiktoklive.listeners;

import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import xyz.siema.live.tiktoklive.basic.Main;
import xyz.siema.live.tiktoklive.basic.Main;
import xyz.siema.live.tiktoklive.helpers.PickaxeHelpers;
import xyz.siema.live.tiktoklive.helpers.PickaxeHelpers;
import xyz.siema.live.tiktoklive.helpers.config.Config;

public class PlayerJoinListeners implements Listener {
    public PlayerJoinListeners() {
    }

    @EventHandler
    public void onJoinEventPlayer(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Main.block.put(player.getName(), Config.instancConfig.getSystemVariables().getStartHpBlock());
        Main.pickaxe.put(player.getName(), 1);
        player.getInventory().addItem(new ItemStack[]{new ItemStack(Config.instancConfig.getSystemVariables().getBlockHp())});
        PickaxeHelpers.create(player);
        player.getInventory().addItem(new ItemStack[]{PickaxeHelpers.pickaxeAmount(1)});
    }

    @EventHandler
    public void onQuitEventMessagePlayer(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Main.block.put(player.getName(), Config.instancConfig.getSystemVariables().getStartHpBlock());
        Main.pickaxe.put(player.getName(), 0);
        player.getInventory().clear();
        Iterator var3 = Bukkit.getWorlds().iterator();

        while(var3.hasNext()) {
            World world = (World)var3.next();
            Iterator var5 = world.getEntitiesByClass(ArmorStand.class).iterator();

            while(var5.hasNext()) {
                ArmorStand armorStand = (ArmorStand)var5.next();
                armorStand.remove();
            }
        }

    }
}
