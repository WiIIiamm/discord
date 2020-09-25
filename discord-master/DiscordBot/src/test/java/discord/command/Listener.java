package discord.command;


import discord.Bot;
import discord.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.audit.*;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageDeleteEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.pagination.AuditLogPaginationAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Listener extends ListenerAdapter {

    private final CommandHandler manager;
    private final Logger logger = LoggerFactory.getLogger(Listener.class);
    public Bot bot;

    public Listener(CommandHandler manager) {
        this.manager = manager;
    }

    @Override
    public void onReady(ReadyEvent event) {
        logger.info(String.format("Logged in as %#s", event.getJDA().getSelfUser()));
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(!event.getAuthor().isBot()) {
            Bot.messagelogs.put(event.getMessageId(), event.getMessage().getContentRaw());
            Bot.usermessages.put(event.getMessageId(), event.getAuthor());
        }


        User author = event.getAuthor();
        Message message = event.getMessage();
        String content = message.getContentDisplay();


        if (event.isFromType(ChannelType.TEXT)) {

            Guild guild = event.getGuild();
            TextChannel textChannel = event.getTextChannel();

            logger.info(String.format("(%s)[%s]<%#s>: %s", guild.getName(), textChannel.getName(), author, content));
        } else if (event.isFromType(ChannelType.PRIVATE)) {
            logger.info(String.format("[PRIV]<%#s>: %s", author, content));
        }
    }

    public void onGuildMessageDelete(GuildMessageDeleteEvent event) {

            if(Bot.messagelogs.containsKey(event.getMessageId())) {
                MessageEmbed embed = new EmbedBuilder()
                        .setTitle("Message Deleted.")
                        .setDescription("Message deleted in #" + event.getChannel().getName() + "\n Message: " + Bot.messagelogs.get(event.getMessageId()) + "\n Author: " + Bot.usermessages.get(event.getMessageId()).getAsMention())
                        .setColor(event.getGuild().getMember(Bot.usermessages.get(event.getMessageId())).getColor())
                        .setThumbnail(Bot.usermessages.get(event.getMessageId()).getAvatarUrl())
                        .build();

                event.getGuild().getTextChannelsByName("bot-logs", true).get(0).sendMessage(embed).queue();
                System.out.println(Bot.messagelogs.get(event.getMessageId()));
                System.out.println(Bot.usermessages.get(event.getMessageId()));
                Bot.messagelogs.remove(event.getMessageId());
                Bot.usermessages.remove(event.getMessageId());


            }
            
        }




    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String rw = event.getMessage().getContentRaw();

        if (rw.equalsIgnoreCase(Constants.PREFIX + "ss") &&
                event.getAuthor().getIdLong() == Constants.OWNERR) {
            shutdown(event.getJDA());
            return;
        }

        String prefix = Constants.PREFIXES.computeIfAbsent(event.getGuild().getIdLong(), (l) -> Constants.PREFIX);

        if (!event.getAuthor().isBot() && !event.getMessage().isWebhookMessage() && rw.startsWith(prefix)) {
            manager.handleCommand(event);
        }
    }

    private void shutdown(JDA jda) {
        jda.shutdown();
        System.exit(0);
    }
}
