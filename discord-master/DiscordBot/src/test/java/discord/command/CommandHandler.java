package discord.command;

import discord.Constants;
import discord.command.mod.MuteCommand;
import discord.command.mod.WarnCommand;
import discord.command.util.PingCommand;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.regex.Pattern;

public class CommandHandler {

    public final Map<String, ICommand> commands = new HashMap<>();

    public CommandHandler() {
        addCommand(new PingCommand());
        addCommand(new WarnCommand());
        addCommand(new MuteCommand());


    }

    private void addCommand(ICommand command) {
        if (!commands.containsKey(command.getInvoke())) {
            commands.put(command.getInvoke(), command);
        }
    }

    public Collection<ICommand> getCommands() {
        return commands.values();
    }

    public ICommand getCommand(@NotNull String name) {
        return commands.get(name);
    }

    void handleCommand(GuildMessageReceivedEvent event) {
        final String prefix = Constants.PREFIXES.get(event.getGuild().getIdLong());


        final String[] split = event.getMessage().getContentRaw().replaceFirst(
                "(?i)" + Pattern.quote(prefix), "").split("\\s+");
        final String invoke = split[0].toLowerCase();

        if (commands.containsKey(invoke)) {
            final List<String> args = Arrays.asList(split).subList(1, split.length);

            commands.get(invoke).handle(args, event);
        }
    }


}