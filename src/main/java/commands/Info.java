package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class Info extends Command {

    public Info(){
        this.name = "info";
        this.aliases = new String[]{"creator"};
        this.help = "Displays bot creator information";
    }

    @Override
    protected void execute(CommandEvent event) {
        event.getChannel().sendMessage("Bakeneko is an Experimental bot created by HaxnovR#7548 which uses the Java Discord API and is completely build in Java(Maven)").queue();
    }
}