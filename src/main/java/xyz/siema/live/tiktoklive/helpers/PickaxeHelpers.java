package xyz.siema.live.tiktoklive.helpers;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xyz.siema.live.tiktoklive.basic.Main;

public class PickaxeHelpers {
    public static ItemStack pickaxeItem;

    public PickaxeHelpers() {
    }

    public static ItemStack getPickaxe() {
        return pickaxeItem;
    }

    public static ItemStack pickaxeAmount(int amount) {
        ItemStack copy = getPickaxe().clone();
        copy.setAmount(amount);
        return copy;
    }

    public static void create(Player player) {
        pickaxeItem = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        pickaxeItem.addUnsafeEnchantment(Enchantment.DIG_SPEED, (Integer) Main.pickaxe.get(player.getName()));
    }
}
