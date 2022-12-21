package me.deltaorion.consumescrolls.reward;

import me.deltaorion.common.locale.message.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CommandReward implements ScrollReward {

    private final String command;

    public CommandReward(String command) {
        this.command = command;
    }

    @Override
    public void giveReward(Player player) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Message.valueOf(command).toString(player.getName()));
    }
}
