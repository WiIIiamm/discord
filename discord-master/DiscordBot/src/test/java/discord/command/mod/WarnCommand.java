package discord.command.mod;

import discord.Bot;
import discord.Constants;
import discord.command.ICommand;
import discord.modules.ModModule;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WarnCommand implements ICommand {
    @Override
    public void handle(List<String> args, GuildMessageReceivedEvent event) {
        event.getMessage().delete().queue();

        if(event.getMember().getRoles().contains(Bot.getAPI().getRoleById(Constants.staffid))) {

            ModModule modModule =  new ModModule();
            if(event.getMessage().getMentionedMembers().isEmpty() && args.size() > 1) {
                    String id = args.get(0);
                    String reason = String.join(" ", args.subList(1, args.size()));
                Member member = event.getGuild().getMemberById(id);
                modModule.warn(id, reason, event.getMember());
            }

            if(!event.getMessage().getMentionedMembers().isEmpty()) {
            Member member = event.getMessage().getMentionedMembers().get(0);
            String reason = String.join(" ", args.subList(1, args.size()));
            modModule.warn(member, reason, event.getMember());


            }
            event.getChannel().sendMessage(":thumbsup:").queue(response -> response.delete().queueAfter(5, TimeUnit.SECONDS));
        }




        }


    @Override
    public String getHelp() {
        return null;
    }

    @Override
    public String getInvoke() {
        return "warn";
    }
}
