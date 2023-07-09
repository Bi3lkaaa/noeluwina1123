package xyz.siema.live.tiktoklive.helpers.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import org.bukkit.Material;
import xyz.siema.live.tiktoklive.basic.Main;
import xyz.siema.live.tiktoklive.helpers.variables.SystemVariables;
import xyz.siema.live.tiktoklive.basic.Main;

public class Config {
    public static Config instancConfig;
    private SystemVariables systemVariables;

    public Config init(File directory) {
        instancConfig = this;

        try {
            if (!directory.exists()) {
                directory.mkdir();
            }

            File configFile = new File(directory, "config.json");
            if (!configFile.exists()) {
                String json = Main.instance.getGson().toJson(instancConfig);
                FileWriter writer = new FileWriter(configFile);
                writer.write(json);
                writer.close();
                return instancConfig;
            }

            BufferedReader reader = new BufferedReader(new FileReader(configFile));
            instancConfig = (Config)Main.instance.getGson().fromJson(reader, Config.class);
        } catch (IOException var5) {
        }

        return instancConfig;
    }

    public Config() {
        this.systemVariables = new SystemVariables("Komenda pozwala kontrolować HP bloku", "control", Arrays.asList("live", "tiktok"), "/control (nick) (add remove reset pickaxe) (amount)", "&cBłąd: użyj: ", "&a&lWYGRAŁEŚ", "&aGRATULACJE", "&aSKOŃCZONE", 10, 5, 10, "&cBłąd: Wartość nie może być minusem!", "&6&l {amount} &e&lHP", "&eMoc kilofu &f&lx{amount} &a&lBLOK", "&eMoc kilofu &6&lx10 &a&lBLOK &8&l- &6&lMAX", Material.EMERALD_ORE, 300, false, 5);
    }

    public SystemVariables getSystemVariables() {
        return this.systemVariables;
    }

    public void setSystemVariables(SystemVariables systemVariables) {
        this.systemVariables = systemVariables;
    }

    public String toString() {
        return "Config(systemVariables=" + this.getSystemVariables() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Config)) {
            return false;
        } else {
            Config other = (Config)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$systemVariables = this.getSystemVariables();
                Object other$systemVariables = other.getSystemVariables();
                if (this$systemVariables == null) {
                    if (other$systemVariables != null) {
                        return false;
                    }
                } else if (!this$systemVariables.equals(other$systemVariables)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Config;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $systemVariables = this.getSystemVariables();
        result = result * 59 + ($systemVariables == null ? 43 : $systemVariables.hashCode());
        return result;
    }
}
