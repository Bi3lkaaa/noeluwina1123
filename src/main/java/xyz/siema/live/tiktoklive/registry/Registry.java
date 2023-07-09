package xyz.siema.live.tiktoklive.registry;

import java.lang.reflect.Field;
import org.bukkit.command.Command;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class Registry {
        private final Plugin plugin;

        public Registry(Plugin plugin) {
                this.plugin = plugin;
        }

        public void registerListener(Listener... listeners) {
                PluginManager pluginManager = this.plugin.getServer().getPluginManager();
                for (Listener listener : listeners) {
                        pluginManager.registerEvents(listener, this.plugin);
                }
        }

        public Registry registerCommands(String fallbackPrefix, Command... commands) {
                try {
                        Field field = this.plugin.getServer().getClass().getDeclaredField("commandMap");
                        field.setAccessible(true);
                        SimpleCommandMap commandMap = (SimpleCommandMap) field.get(this.plugin.getServer());
                        if (commandMap != null) {
                                for (Command command : commands) {
                                        commandMap.register(fallbackPrefix, command);
                                }
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return this;
        }

        public Plugin getPlugin() {
                return this.plugin;
        }
}
