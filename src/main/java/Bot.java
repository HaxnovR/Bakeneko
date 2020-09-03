import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import commands.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import java.util.EnumSet;

public class Bot
{
    public static void main(String[] args) throws Exception
    {
        JDA jda = JDABuilder.createDefault("NzQzMzc0MzA3MDMxMzg0MTA0.XzTvRg.OllWwURu6vuCE3-JlpDWRG_7mI4").build();
        CommandClientBuilder builder = new CommandClientBuilder();
        builder.setOwnerId("743374307031384104");
        builder.setPrefix("neko");
        builder.setHelpWord("commands");
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setActivity(Activity.listening("nekocommands"));

        builder.addCommand(new Hi());
        builder.addCommand(new Info());
        builder.addCommand(new JoinCommand());
        builder.addCommand(new PlayCommand());
        builder.addCommand(new StopCommand());
        builder.addCommand(new SkipCommand());
        builder.addCommand(new SetVolume());
        builder.addCommand(new radio());
        builder.addCommand(new Anime());
        builder.addCommand(new Meme());

        CommandClient client = builder.build();
        jda.addEventListener(client);

        JDABuilder.createDefault(("NzQzMzc0MzA3MDMxMzg0MTA0.XzTvRg.OllWwURu6vuCE3-JlpDWRG_7mI4"),
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.GUILD_VOICE_STATES,
                GatewayIntent.GUILD_PRESENCES
        )
                .disableCache(EnumSet.of(
                        CacheFlag.CLIENT_STATUS,
                        CacheFlag.ACTIVITY,
                        CacheFlag.EMOTE
                ))
                .enableCache(CacheFlag.VOICE_STATE)
                .build();
    }
}
