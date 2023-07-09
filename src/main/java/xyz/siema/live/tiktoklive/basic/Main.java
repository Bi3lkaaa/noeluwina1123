package xyz.siema.live.tiktoklive.basic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.siema.live.tiktoklive.commands.ControlCommands;
import xyz.siema.live.tiktoklive.helpers.config.Config;
import xyz.siema.live.tiktoklive.listeners.PlayerBreakBlockListeners;
import xyz.siema.live.tiktoklive.listeners.PlayerJoinListeners;
import xyz.siema.live.tiktoklive.registry.Registry;
import xyz.siema.live.tiktoklive.tasks.TasksPickaxe;

public class Main extends JavaPlugin {
    public static Main instance;
    private Gson gson;
    private Gson gsonWithoutStyle;
    private Config customConfig;
    public static HashMap<String, Integer> block = new HashMap();
    public static HashMap<String, Integer> pickaxe = new HashMap();
    public static HashMap<String, Boolean> restart = new HashMap();

    public Main() {
    }

    public void onEnable() {
        instance = this;
        this.gson = (new GsonBuilder()).setPrettyPrinting().create();
        this.gsonWithoutStyle = (new GsonBuilder()).create();
        this.customConfig = (new Config()).init(this.getDataFolder());
        (new Registry(this)).registerCommands("TikTok-live", new Command[]{new ControlCommands()}).registerListener(new Listener[]{new PlayerBreakBlockListeners(), new PlayerJoinListeners()});
        (new TasksPickaxe()).startTask();
    }

    public void onDisable() {
        Iterator var1 = Bukkit.getWorlds().iterator();

        while(var1.hasNext()) {
            World world = (World)var1.next();
            Iterator var3 = world.getEntitiesByClass(ArmorStand.class).iterator();

            while(var3.hasNext()) {
                ArmorStand armorStand = (ArmorStand)var3.next();
                armorStand.remove();
            }
        }

    }

    public Gson getGson() {
        return this.gson;
    }

    public Gson getGsonWithoutStyle() {
        return this.gsonWithoutStyle;
    }

    public Config getCustomConfig() {
        return this.customConfig;
    }
}
