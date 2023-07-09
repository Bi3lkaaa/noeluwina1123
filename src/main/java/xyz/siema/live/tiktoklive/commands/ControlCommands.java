package xyz.siema.live.tiktoklive.commands;

import java.util.Objects;
import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xyz.siema.live.tiktoklive.basic.Main;
import xyz.siema.live.tiktoklive.helpers.ColorHelpers;
import xyz.siema.live.tiktoklive.helpers.PickaxeHelpers;
import xyz.siema.live.tiktoklive.helpers.config.Config;

public class ControlCommands extends Command {
    public ControlCommands() {
        super(Config.instancConfig.getSystemVariables().getCommandsControlCommands(), Config.instancConfig.getSystemVariables().getCommandsControlDescription(), Config.instancConfig.getSystemVariables().getCommandsControlUsageMessage(), Config.instancConfig.getSystemVariables().getCommandsControlAllias());
    }

    public boolean execute(@NonNull CommandSender sender, @NonNull String commandLabel, @NonNull String @NonNull [] args) {
        if (sender == null) {
            throw new NullPointerException("sender is marked non-null but is null");
        } else if (commandLabel == null) {
            throw new NullPointerException("commandLabel is marked non-null but is null");
        } else if (args == null) {
            throw new NullPointerException("args is marked non-null but is null");
        } else {
            Player player = Bukkit.getServer().getPlayer(args[0]);
            if (args.length < 2) {
                assert player != null;

                String var10001 = Config.instancConfig.getSystemVariables().getCommandsErrorUsageMessage();
                player.sendMessage(ColorHelpers.color(var10001 + this.usageMessage));
                return false;
            } else {
                int value;
                if (args[1].equalsIgnoreCase("add")) {
                    assert player != null;

                    value = (Integer)Main.block.get(player.getName()) + Integer.parseInt(args[2]);
                    Main.block.put(player.getName(), value);
                    return false;
                } else if (args[1].equalsIgnoreCase("remove")) {
                    assert player != null;

                    if ((Integer)Main.block.get(player.getName()) <= -1) {
                        player.sendMessage(ColorHelpers.color(Config.instancConfig.getSystemVariables().getErrorBlock()));
                        return false;
                    } else {
                        value = (Integer)Main.block.get(player.getName()) - Integer.parseInt(args[2]);
                        Main.block.put(player.getName(), value);
                        return false;
                    }
                } else {
                    if (args[1].equalsIgnoreCase("reset")) {
                        assert player != null;

                        Main.block.put(player.getName(), Config.instancConfig.getSystemVariables().getStartHpBlock());
                        Main.pickaxe.put(player.getName(), 1);
                        player.closeInventory();
                        player.getInventory().addItem(new ItemStack[]{PickaxeHelpers.pickaxeAmount(1)});
                    }

                    if (args[1].equalsIgnoreCase("pickaxe")) {
                        assert player != null;

                        if ((Integer)Main.pickaxe.get(player.getName()) >= 10) {
                            player.sendMessage(ColorHelpers.color(Config.instancConfig.getSystemVariables().getErrorBlock()));
                            return false;
                        } else {
                            value = (Integer)Main.pickaxe.get(player.getName()) + Integer.parseInt(args[2]);
                            Main.pickaxe.put(player.getName(), value);
                            PickaxeHelpers.create(player);
                            ((Player)Objects.requireNonNull(player)).getInventory().addItem(new ItemStack[]{PickaxeHelpers.pickaxeAmount(1)});
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
    }
}
