package discord.modules;

import discord.Bot;
import discord.Constants;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

public class LoggerModule {




    public void logToChannel(String channelid, MessageEmbed embed) {
        TextChannel channel = Bot.getAPI().getGuildById(Constants.guild).getTextChannelById(channelid);
        channel.sendMessage(embed).queue();

    }
}
