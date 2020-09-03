package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class Hi extends Command {

    public Hi(){
        this.name = "hi";
        this.aliases = new String[]{"hello","greet"};
        this.help = "Greets the user.";
    }

    @Override
    protected void execute(CommandEvent event) {
        String username = event.getMember().getUser().getName();
        event.getChannel().sendMessage("Wassup my Niggy Piggy "+username+"!!!").queue();
    }
}