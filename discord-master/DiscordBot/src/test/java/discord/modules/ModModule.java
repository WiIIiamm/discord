package discord.modules;

import discord.Bot;
import discord.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;

import java.awt.*;


public class ModModule {



    public void ban(String id, String reason, Member author) {
        Member member = Bot.getAPI().getGuildById(Constants.guild).getMemberById(id);
        PrivateChannel channel = member.getUser().openPrivateChannel().complete();
        MessageEmbed embed = new EmbedBuilder()
                .setTitle(author.getUser().getName())
                .setDescription("────────────────────────── \n You have been Banned! \n Reason: " + reason + "\n Appeal this ban please send a message to: " + author)
                .setThumbnail(author.getUser().getAvatarUrl())
                .build();
        channel.sendMessage(embed).queue();
        MessageEmbed embed1 = new EmbedBuilder()
                .setTitle("Punishment logged")
                .setDescription("────────────────────────── \n " + member.getAsMention() + " Has been Banned. \n Banned by: " + author.getAsMention() + "\n Reason: " + reason + "\n ──────────────────────────")
                .setColor(Color.GREEN)
                .build();
        Bot.getAPI().getGuildById(Constants.guild).getTextChannelById("754700679465009212").sendMessage(embed1).queue();
        member.ban(7).queue();
    }

    public void ban(Member member, String reason, Member author) {
        PrivateChannel channel = member.getUser().openPrivateChannel().complete();
        MessageEmbed embed = new EmbedBuilder()
                .setTitle(author.getUser().getName())
                .setDescription("────────────────────────── \n You have been Banned! \n Reason: " + reason + "\n Appeal this ban please send a message to: " + author)
                .setThumbnail(author.getUser().getAvatarUrl())
                .build();
        channel.sendMessage(embed).queue();
        MessageEmbed embed1 = new EmbedBuilder()
                .setTitle("Punishment logged")
                .setDescription("────────────────────────── \n " + member.getAsMention() + " Has been Banned. \n Banned by: " + author.getAsMention() + "\n Reason: " + reason + "\n ──────────────────────────")
                .setColor(Color.GREEN)
                .build();
        Bot.getAPI().getGuildById(Constants.guild).getTextChannelById("754700679465009212").sendMessage(embed1).queue();
        member.ban(7).queue();
    }

    public void kick(String id, String reason, Member author) {
        Member member = Bot.getAPI().getGuildById(Constants.guild).getMemberById(id);
        PrivateChannel channel = member.getUser().openPrivateChannel().complete();
        MessageEmbed embed = new EmbedBuilder()
                .setTitle(author.getUser().getName())
                .setDescription("────────────────────────── \n You have been Kicked! \n Reason: " + reason)
                .setThumbnail(author.getUser().getAvatarUrl())
                .build();
        channel.sendMessage(embed).queue();
        MessageEmbed embed1 = new EmbedBuilder()
                .setTitle("Punishment logged")
                .setDescription("────────────────────────── \n " + member.getAsMention() + " Has been Kicked. \n Kicked by: " + author.getAsMention() + "\n Reason: " + reason + "\n ──────────────────────────")
                .setColor(Color.GREEN)
                .build();
        Bot.getAPI().getGuildById(Constants.guild).getTextChannelById("754700679465009212").sendMessage(embed1).queue();
        member.kick(reason).queue();
    }

    public void kick(Member member, String reason, Member author) {
        PrivateChannel channel = member.getUser().openPrivateChannel().complete();
        MessageEmbed embed = new EmbedBuilder()
                .setTitle(author.getUser().getName())
                .setDescription("────────────────────────── \n You have been Kicked! \n Reason: ")
                .setThumbnail(author.getUser().getAvatarUrl())
                .build();
        channel.sendMessage(embed).queue();
        MessageEmbed embed1 = new EmbedBuilder()
                .setTitle("Punishment logged")
                .setDescription("────────────────────────── \n " + member.getAsMention() + " Has been Kicked. \n Kicked by: " + author.getAsMention() + "\n Reason: " + reason + "\n ──────────────────────────")
                .setColor(Color.GREEN)
                .build();
        Bot.getAPI().getGuildById(Constants.guild).getTextChannelById("754700679465009212").sendMessage(embed1).queue();
        member.kick(reason).queue();
    }

    public void warn(String id, String reason, Member author) {

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
        Bot.getAPI().getGuildById(Constants.guild).getTextChannelById("754700679465009212").sendMessage(embed1).queue();

    }

    public void warn(Member member, String reason, Member author) {
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
        Bot.getAPI().getGuildById(Constants.guild).getTextChannelById("754700679465009212").sendMessage(embed1).queue();

    }

    public void mute(String id, String reason, Member author, Guild guild) {
        Role role = Bot.getAPI().getRoleById(Constants.muterole);
        Member member = Bot.getAPI().getGuildById(Constants.guild).getMemberById(id);
        PrivateChannel channel = member.getUser().openPrivateChannel().complete();
        MessageEmbed embed = new EmbedBuilder()
                .setTitle(author.getUser().getName())
                .setDescription("────────────────────────── \n You have been Muted! \n Reason: " + reason)
                .setThumbnail(author.getUser().getAvatarUrl())
                .build();
        channel.sendMessage(embed).queue();
        MessageEmbed embed1 = new EmbedBuilder()
                .setTitle("Punishment logged")
                .setDescription("────────────────────────── \n " + member.getAsMention() + " Has been Muted. \n Muted by: " + author.getAsMention() + "\n Reason: " + reason + "\n ──────────────────────────")
                .setColor(Color.GREEN)
                .build();
        member.mute(true).queue();
        Bot.getAPI().getGuildById(Constants.guild).addRoleToMember(member, role).queue();
        Bot.getAPI().getGuildById(Constants.guild).getTextChannelById("754700679465009212").sendMessage(embed1).queue();

    }

    public void mute(Member member, String reason, Member author) {
        Role role = Bot.getAPI().getRoleById(Constants.muterole);
        PrivateChannel channel = member.getUser().openPrivateChannel().complete();
        MessageEmbed embed = new EmbedBuilder()
                .setTitle(author.getUser().getName())
                .setDescription("────────────────────────── \n You have been Muted! \n Reason: " + reason)
                .setThumbnail(author.getUser().getAvatarUrl())
                .build();
        channel.sendMessage(embed).queue();
        MessageEmbed embed1 = new EmbedBuilder()
                .setTitle("Punishment logged")
                .setDescription("────────────────────────── \n " + member.getAsMention() + " Has been Muted. \n Muted by: " + author.getAsMention() + "\n Reason: " + reason + "\n ──────────────────────────")
                .setColor(Color.GREEN)
                .build();
        member.mute(true).queue();
        Bot.getAPI().getGuildById(Constants.guild).addRoleToMember(member, role).queue();
        Bot.getAPI().getGuildById(Constants.guild).getTextChannelById("754700679465009212").sendMessage(embed1).queue();
    }


}
