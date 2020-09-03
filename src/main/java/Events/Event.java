/*
package Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {

        //-----------Invite
        if(message[0].equalsIgnoreCase("nekoinvite")){
            event.getChannel().sendMessage("Wanna Invite someone to this server?").queue();
            event.getChannel().sendMessage("Here's the Link: "+event.getChannel().createInvite().setMaxAge(1200).complete().getUrl()).queue();
            event.getChannel().sendMessage("This invite will expire in 20 mins").queue();
        }
        //-----------Status of user
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        if (message.length == 1 && message[0].equalsIgnoreCase("nekostatus")){
            event.getChannel().sendMessage("To use this command type <nekostatus [name]>").queue(); //how to use command
        }else if(message.length == 2 && message[0].equalsIgnoreCase("nekostatus")){
            String userName = message[1];
            User user = event.getGuild().getMembersByName(userName, true).get(0).getUser(); //Gets user as object so we can grab info from it for embed
            String avatar = event.getGuild().getMembersByName(userName, false).get(0).getUser().getAvatarUrl(); //gets url of user avatar so we can put in embed
            EmbedBuilder avatarEmbed = new EmbedBuilder(); //Creates the embed.
            //Sets the contents of the embed
            avatarEmbed.setTitle(userName + "'s Info:", event.getGuild().getIconUrl());
            avatarEmbed.setColor(Color.CYAN);
            avatarEmbed.addField("Name", user.getName(), true);
            avatarEmbed.addField("Online Status", event.getGuild().getMembersByName(userName, true).get(0).getOnlineStatus().toString(), true);
            avatarEmbed.addField("Avatar: ", "The Avatar is below, " + event.getMember().getAsMention(), true);
            avatarEmbed.setImage(avatar);
            avatarEmbed.setFooter("Request made @ " + formatter.format(date), event.getGuild().getIconUrl());
            //
            event.getChannel().sendMessage(avatarEmbed.build()).queue(); //Send the embed as a message
        }
        //-----------Help Embed
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Bakeneko Commands:");
        eb.setColor(Color.CYAN);
        eb.addField("General:","-hi\n-info\n-help",true);
        eb.setImage("https://github.com/HaxnovR/Bakeneko/blob/master/Mask_Seller.png?raw=true");
        eb.addField("Users:","-invite\n-status",true);
        eb.addField("Music:","Coming Soon",true);
        eb.setAuthor("Help and info on Bakeneko", "https://github.com/HaxnovR/Bakeneko");
        if(message[0].equalsIgnoreCase("help")){
            event.getChannel().sendMessage(eb.build()).queue();
        }

    }
}
*/