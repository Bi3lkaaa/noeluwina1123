package xyz.siema.live.tiktoklive.helpers;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.siema.live.tiktoklive.basic.Main;
import xyz.siema.live.tiktoklive.basic.Main;

public class BlockHelpers {
    public static ItemStack blockItem;

    public BlockHelpers() {
    }

    public static ItemStack getBlock() {
        return blockItem;
    }

    public static ItemStack pickaxeAmount(int amount) {
        ItemStack copy = getBlock().clone();
        copy.setAmount(amount);
        return copy;
    }

    public static void create(Player player) {
        blockItem = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        blockItem.addUnsafeEnchantment(Enchantment.DIG_SPEED, (Integer) Main.pickaxe.get(player.getName()));
        ItemMeta blockMeta = blockItem.getItemMeta();

        assert blockMeta != null;

        blockMeta.setDisplayName(ColorHelpers.color("blok"));
        blockItem.setItemMeta(blockMeta);
    }
}
