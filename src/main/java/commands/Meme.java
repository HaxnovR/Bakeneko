package commands;

import com.jagrosh.jdautilities.command.Command;
import com.fasterxml.jackson.databind.JsonNode;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.duncte123.botcommons.messaging.EmbedUtils;
import me.duncte123.botcommons.web.WebUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import org.slf4j.spi.MDCAdapter;

import java.awt.*;

public class Meme extends Command {

    public Meme(){
        this.name = "meme";
        this.aliases = new String[]{};
        this.help = "Shows a Random meme";
    }

    @Override
    protected void execute(CommandEvent event) {
        final TextChannel channel = (TextChannel) event.getChannel();
        WebUtils.ins.getJSONObject("https://apis.duncte123.me/meme").async((json)->{
            if(!json.get("success").asBoolean()) {
                channel.sendMessage("Something went Wrong").queue();
                System.out.println(json);
                return;
            }

            final JsonNode data = json.get("data");
            final String title = data.get("title").asText();
            final String url = data.get("url").asText();
            final String image = data.get("image").asText();
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.YELLOW);
            eb.setTitle(title);
            eb.setImage(url);
            eb.setImage(image);
            event.getChannel().sendMessage(eb.build()).queue();

        });
    }
}