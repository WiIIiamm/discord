package discord.modules;

import discord.Bot;
import discord.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.PrivateChannel;

import java.awt.*;


public class ModModule {



    public void ban(String id, String reason, Member author) {

    }

    public void ban(Member member, String reason, Member author) {

    }

    public void kick(String id, String reason, Member author) {

    }

    public void kick(Member member, String reason, Member author) {

    }

    public void warn(String id, String reason, Member author) {
        LoggerModule loggerModule = new LoggerModule();
        Member member = Bot.getAPI().getGuildById(Constants.guild).getMemberById(id);
        PrivateChannel channel = member.getUser().openPrivateChannel().complete();
        MessageEmbed embed = new EmbedBuilder()
                .setTitle(author.getUser().getName())
                .setDescription("────────────────────────── \n You have been warned! \n Reason: " + reason)
                .setThumbnail(author.getUser().getAvatarUrl())
                .build();
        channel.sendMessage(embed).queue();
        MessageEmbed embed1 = new EmbedBuilder()
                .setTitle("Punishment logged")
                .setDescription("────────────────────────── \n " + member.getAsMention() + " Has been warned. \n Warned by: " + author.getAsMention() + "\n Reason: " + reason + "\n ──────────────────────────")
                .setColor(Color.GREEN)
                .build();
        loggerModule.logToChannel("754700679465009212", embed1);
    }

    public void warn(Member member, String reason, Member author) {
        LoggerModule loggerModule = new LoggerModule();
        PrivateChannel channel = member.getUser().openPrivateChannel().complete();
        MessageEmbed embed = new EmbedBuilder()
                .setTitle(author.getUser().getName())
                .setDescription("────────────────────────── \n You have been warned! \n Reason: " + reason)
                .setThumbnail(author.getUser().getAvatarUrl())
                .build();
        channel.sendMessage(embed).queue();
        MessageEmbed embed1 = new EmbedBuilder()
                .setTitle("Punishment logged")
                .setDescription("────────────────────────── \n " + member.getAsMention() + " Has been warned. \n Warned by: " + author.getAsMention() + "\n Reason: " + reason + "\n ──────────────────────────")
                .setColor(Color.GREEN)
                .build();
        loggerModule.logToChannel("754700679465009212", embed1);
    }

    public void mute(String id, String reason, Member author) {

    }

    public void mute(Member member, String reason, Member author) {

    }


}
