package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class Anime extends Command {

    public Anime(){
        this.name = "anime";
        this.aliases = new String[]{"9anime"};
        this.help = "Searches for the Anime";
    }

    @Override
    protected void execute(CommandEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");
        int len = message.length;
        String tempanime = "";
        for(int i = 1;i<len;i++){
            tempanime = tempanime+message[i]+"+";
        }
        String text = "";
        for(int i = 1;i<len;i++){
            text = text+message[i]+" ";
        }
        String tempmal = "";
        for(int i = 1;i<len;i++){
            tempmal = tempmal+message[i]+"%20";
        }
        String linkanime = "https://9anime.to/search?keyword="+tempanime;
        String linkmal = "https://myanimelist.net/search/all?cat=all&q="+tempmal;
        //System.out.println(linkanime);
        //System.out.println(linkmal);
        //System.out.println(text);


        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Search result for "+text);
        eb.setColor(Color.BLUE);
        eb.setImage("https://techtida.com/wp-content/uploads/2019/04/9anime-1024x576.png");
        eb.addField("My Anime List:",linkmal,true);
        eb.addField("9anime:",linkanime,true);
        event.getChannel().sendMessage(eb.build()).queue();
    }
}