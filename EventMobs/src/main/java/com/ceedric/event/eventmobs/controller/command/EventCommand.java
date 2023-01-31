package com.ceedric.event.eventmobs.controller.command;

import com.ceedric.event.eventmobs.EventMobs;
import com.ceedric.event.eventmobs.Permissions;
import me.deltaorion.common.command.Command;
import me.deltaorion.common.command.CommandException;
import me.deltaorion.common.command.FunctionalCommand;
import me.deltaorion.common.command.sent.SentCommand;

import java.util.Map;

public class EventCommand extends FunctionalCommand {

    private final EventMobs plugin;

    public EventCommand(EventMobs plugin) {
        super(Permissions.COMMAND);
        this.plugin = plugin;
        registerArgument("view",new ViewCommand(plugin));
        registerArgument("participant",new ParticipantCommand(plugin));
        registerArgument("spawn",new SpawnCommand(plugin));
        registerArgument("view",new ViewCommand(plugin));
        registerArgument("distribute",new DistributeCommand(plugin));
        registerArgument("report",new ReportCommand(plugin));
    }

    @Override
    public void commandLogic(SentCommand command) throws CommandException {
        for(Map.Entry<String, Command>  commandFunction : getFunctions().entrySet()) {
            command.getSender().sendMessage("/"+command.getLabel()+" "+commandFunction.getKey()+": "+commandFunction.getValue().getDescription());
        }
    }
}
