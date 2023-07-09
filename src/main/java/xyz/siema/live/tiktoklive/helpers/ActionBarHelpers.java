package xyz.siema.live.tiktoklive.helpers;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class ActionBarHelpers {
    public ActionBarHelpers() {
    }

    public static void sendActionBar(Player player, String text) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ColorHelpers.color(text)));
    }
}