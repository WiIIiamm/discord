package discord;

import discord.command.CommandHandler;
import discord.command.Listener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;
import java.util.List;

public class Bot {

    public static JDA api;
    public static List<String> bannedwords;


    public static void main(String[] args) throws LoginException{
        CommandHandler handler = new CommandHandler();
        api = new JDABuilder().setToken("")
                .addEventListeners(new Listener(handler)).build();

    }


    public static JDA getAPI() {
        return api;
    }
}
