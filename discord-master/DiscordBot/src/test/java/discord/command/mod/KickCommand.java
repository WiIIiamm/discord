package discord.command.mod;

import discord.Constants;
import discord.command.ICommand;
import discord.modules.ModModule;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;


import java.util.List;

public class KickCommand implements ICommand {


    @Override
    public void handle(List<String> args, GuildMessageReceivedEvent event) {

        if(event.getMember().getRoles().contains(event.getGuild().getRoleById(Constants.staffid))) {
            if(args.size() > 1 && event.getMessage().getMentionedMembers().isEmpty()) {
                Member member = event.getGuild().getMemberById(args.get(0));
                if(event.getMember().canInteract(member)) {
                    ModModule modModule = new ModModule();
                    String reason = String.join(" ", args.subList(1, args.size()));
                    modModule.kick(args.get(0), reason, event.getMember());
                }
            }

            if(args.size() > 1 && !event.getMessage().getMentionedMembers().isEmpty()) {
                Member member = event.getMessage().getMentionedMembers().get(0);
                if(event.getMember().canInteract(member)) {
                    ModModule modModule = new ModModule();
                    String reason = String.join(" ", args.subList(1, args.size()));
                    modModule.kick(member, reason, event.getMember());
                }
            }

        }
    }

    @Override
    public String getHelp() {
        return null;
    }

    @Override
    public String getInvoke() {
        return "kick";
    }
}
