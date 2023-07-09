package xyz.siema.live.tiktoklive;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class WizardCodeTikTok extends JavaPlugin {

    @Override
    public void onEnable() {
        // Rejestrujemy komendę "/tiktok"
        getCommand("tiktok").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("tiktok")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Ta komenda może być wykonana tylko przez graczy!");
                return true;
            }

            Player player = (Player) sender;

            if (args.length < 2) {
                player.sendMessage("Użycie: /tiktok (nick) add/remove/reset/pickaxe (ilość)");
                return true;
            }

            String targetPlayerName = args[0];
            String action = args[1];

            // Sprawdzamy dostępne akcje i wykonujemy odpowiednie działania
            switch (action.toLowerCase()) {
                case "add":
                    if (args.length < 3) {
                        player.sendMessage("Użycie: /tiktok (nick) add (ilość)");
                        return true;
                    }

                    int amountToAdd = Integer.parseInt(args[2]);
                    // Wykonaj operację dodawania dla gracza targetPlayerName
                    // np. player.sendMessage("Dodano " + amountToAdd + " do gracza " + targetPlayerName);
                    break;
                case "remove":
                    if (args.length < 3) {
                        player.sendMessage("Użycie: /tiktok (nick) remove (ilość)");
                        return true;
                    }

                    int amountToRemove = Integer.parseInt(args[2]);
                    // Wykonaj operację usuwania dla gracza targetPlayerName
                    // np. player.sendMessage("Usunięto " + amountToRemove + " od gracza " + targetPlayerName);
                    break;
                case "reset":
                    // Wykonaj operację resetowania dla gracza targetPlayerName
                    // np. player.sendMessage("Zresetowano gracza " + targetPlayerName);
                    break;
                case "pickaxe":
                    if (args.length < 3) {
                        player.sendMessage("Użycie: /tiktok (nick) pickaxe (ilość)");
                        return true;
                    }

                    int amountToSet = Integer.parseInt(args[2]);
                    // Wykonaj operację ustawienia dla gracza targetPlayerName
                    // np. player.sendMessage("Ustawiono wartość dla gracza " + targetPlayerName + ": " + amountToSet);
                    break;
                default:
                    player.sendMessage("Nieznana akcja. Dostępne akcje: add, remove, reset, pickaxe");
                    break;
            }

            return true;
        }

        return false;
    }
}
