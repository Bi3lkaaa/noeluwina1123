package xyz.siema.live.tiktoklive.helpers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

public class HologramHelpers {
    private final Location location;
    private final List<String> lines;
    private final List<ArmorStand> entities;
    private boolean spawned;

    public HologramHelpers(Location location, List<String> lines) {
        this.lines = lines;
        this.entities = new LinkedList();
        this.spawned = false;
        this.location = location;
    }

    public void spawn() {
        Chunk cnk = this.location.getChunk();
        if (!cnk.isLoaded()) {
            cnk.load();
        }

        for(int i = 0; i < this.lines.size(); ++i) {
            Location spawn = this.location.clone().subtract(0.0, (double)i * 0.25, 0.0);
            ArmorStand entity = (ArmorStand)((World)Objects.requireNonNull(this.location.getWorld())).spawnEntity(spawn, EntityType.ARMOR_STAND);
            entity.setGravity(false);
            entity.setBasePlate(false);
            entity.setVisible(false);
            entity.setAI(false);
            entity.setArms(false);
            entity.setInvisible(true);
            entity.setCustomNameVisible(true);
            entity.setCustomName(ColorHelpers.color((String)this.lines.get(i)));
            this.entities.add(entity);
        }

        this.spawned = true;
    }

    public void update() {
        this.remove();
        this.spawn();
    }

    public void destroy() {
        this.remove();
        this.lines.clear();
    }

    public ArmorStand get(int index) {
        return (ArmorStand)this.entities.get(index);
    }

    public HologramHelpers add(String line) {
        this.lines.add(line);
        if (this.spawned) {
            this.update();
        }

        return this;
    }

    public HologramHelpers set(int index, String line) {
        this.lines.set(index, line);
        if (this.spawned) {
            this.update();
        }

        return this;
    }

    private boolean removeEntity(ArmorStand entity) {
        this.lines.remove(entity.getCustomName());
        entity.remove();
        boolean removed = this.entities.remove(entity);
        if (removed && this.spawned) {
            this.update();
        }

        return removed;
    }

    public void remove() {
        Iterator var1 = this.entities.iterator();

        while(var1.hasNext()) {
            ArmorStand stand = (ArmorStand)var1.next();
            stand.remove();
        }

    }

    public boolean remove(String line) {
        Iterator var2 = this.entities.iterator();

        ArmorStand entity;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            entity = (ArmorStand)var2.next();
        } while(!Objects.equals(entity.getCustomName(), ColorHelpers.color(line)));

        return this.removeEntity(entity);
    }
}
