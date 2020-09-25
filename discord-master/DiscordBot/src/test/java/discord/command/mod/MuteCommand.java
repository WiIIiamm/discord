package discord.command.mod;

import com.sun.org.apache.xpath.internal.operations.Mod;
import discord.Constants;
import discord.command.ICommand;
import discord.modules.ModModule;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MuteCommand implements ICommand {
    @Override
    public void handle(List<String> args, GuildMessageReceivedEvent event) {
        event.getMessage().delete();
        if(event.getMember().getRoles().contains(event.getGuild().getRoleById(Constants.staffid))) {
            if(args.size() > 1 && event.getMessage().getMentionedMembers().isEmpty()) {
                ModModule modModule = new ModModule();
                String reason = String.join("", args.subList(1, args.size()));
                modModule.mute(args.get(0), reason, event.getMember(), event.getGuild());
            } else if (!event.getMessage().getMentionedMembers().isEmpty() && args.size() > 1) {
                ModModule modModule = new ModModule();
                String reason = String.join("", args.subList(1, args.size()));
                modModule.mute(event.getMessage().getMentionedMembers().get(0), reason, event.getMember() );
            }
            
            event.getChannel().sendMessage(":thumbsup:").queue(noob -> noob.delete().queueAfter(3, TimeUnit.SECONDS));
        }
    }

    @Override
    public String getHelp() {
        return null;
    }

    @Override
    public String getInvoke() {
        return "mute";
    }
}
