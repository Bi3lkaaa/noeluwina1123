package xyz.siema.live.tiktoklive.listeners;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.util.Vector;
import xyz.siema.live.tiktoklive.basic.Main;
import xyz.siema.live.tiktoklive.helpers.ColorHelpers;
import xyz.siema.live.tiktoklive.helpers.FireworkHelpers;
import xyz.siema.live.tiktoklive.helpers.HologramHelpers;
import xyz.siema.live.tiktoklive.helpers.config.Config;
import xyz.siema.live.tiktoklive.basic.Main;

public class PlayerBreakBlockListeners implements Listener {
    public PlayerBreakBlockListeners() {
    }

    @EventHandler
    public void breakBlockEventAchievementBreakBlock(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        if (block.getType().equals(Config.instancConfig.getSystemVariables().getBlockHp())) {
            int value = (Integer) Main.block.get(player.getName()) - (Integer)Main.pickaxe.get(player.getName());
            Main.block.put(player.getName(), value);
            if (!Config.instancConfig.getSystemVariables().isStartResetBoolean()) {
                Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
                    if ((Integer)Main.block.get(player.getName()) > 1) {
                        block.setType(Config.instancConfig.getSystemVariables().getBlockHp());
                    }
                }, 2L, 2L);
            }

            if (block.getType() == Config.instancConfig.getSystemVariables().getBlockHp()) {
                if ((Integer)Main.block.get(player.getName()) <= 0) {
                    block.setType(Material.BEDROCK);
                    FireworkHelpers.spawnFireworks(block.getLocation(), 1);
                    player.sendTitle(ColorHelpers.color(Config.instancConfig.getSystemVariables().getTitleVictoryMessage()), ColorHelpers.color(Config.instancConfig.getSystemVariables().getSubtitleVictoryMessage()), Config.instancConfig.getSystemVariables().getFadeInVictoryMessage(), Config.instancConfig.getSystemVariables().getStayVictoryMessage(), Config.instancConfig.getSystemVariables().getFadeOutVictoryMessage());
                }

                if (Config.instancConfig.getSystemVariables().isStartResetBoolean() && (Integer)Main.block.get(player.getName()) <= 0) {
                    Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
                        if ((Integer)Main.block.get(player.getName()) < 0) {
                            block.setType(Config.instancConfig.getSystemVariables().getBlockHp());
                            int value1 = Objects.nonNull(Main.block.get(player.getName())) ? (Integer)Main.block.get(player.getName()) + Config.instancConfig.getSystemVariables().getStartHpBlock() : Config.instancConfig.getSystemVariables().getStartHpBlock();
                            Main.block.put(player.getName(), value1);
                        }
                    }, 20L * (long)Config.instancConfig.getSystemVariables().getStartResetTime(), 20L * (long)Config.instancConfig.getSystemVariables().getStartResetTime());
                }
            }

            event.setCancelled(true);
        }
    }

    @EventHandler
    public void placeBlockEventPlots(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Location placeLocation = block.getLocation();
        World world = block.getWorld();
        Block bedrockBlock = world.getBlockAt(block.getLocation().subtract(0.0, 1.0, 0.0));
        if (block.getType() == Config.instancConfig.getSystemVariables().getBlockHp()) {
            if (bedrockBlock.getType() == Material.AIR) {
                bedrockBlock.setType(Material.BEDROCK);
            }

            Location hologramLocation = placeLocation.clone().add(new Vector(0.5, -0.7, 0.5));
            String[] hologramMessages = new String[1];
            String hologramMessage = ColorHelpers.color(Config.instancConfig.getSystemVariables().getHologramMessage());
            HashMap<String, Integer> blockMap = Main.block;
            hologramMessages[0] = hologramMessage.replace("{amount}", "" + blockMap.get(player.getName()));
            HologramHelpers hologramHelpers = new HologramHelpers(hologramLocation, Arrays.asList(hologramMessages));
            hologramHelpers.spawn();
            if (blockMap.get(player.getName()) <= 0) {
                hologramHelpers.destroy();
            }

            Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.instance, () -> {
                if (blockMap.get(player.getName()) > -1) {
                    String updatedHologramMessage = ColorHelpers.color(Config.instancConfig.getSystemVariables().getHologramMessage());
                    hologramHelpers.set(0, updatedHologramMessage.replace("{amount}", "" + blockMap.get(player.getName())));
                    if (blockMap.get(player.getName()) < 1) {
                        hologramHelpers.set(0, Config.instancConfig.getSystemVariables().getHologramVictoryMessage());
                    }
                }
            }, 2L, 2L);
        }
    }
}
