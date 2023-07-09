package xyz.siema.live.tiktoklive.helpers;

import java.util.Objects;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireworkHelpers {
    public FireworkHelpers() {
    }

    public static void spawnFireworks(Location location, int amount) {
        Firework fw = (Firework)((World)Objects.requireNonNull(location.getWorld())).spawnEntity(location, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();
        fwm.setPower(2);
        fwm.addEffect(FireworkEffect.builder().withColor(Color.LIME).flicker(true).build());
        fw.setFireworkMeta(fwm);
        fw.detonate();

        for(int i = 0; i < amount; ++i) {
            Firework fw2 = (Firework)location.getWorld().spawnEntity(location, EntityType.FIREWORK);
            fw2.setFireworkMeta(fwm);
        }

    }
}