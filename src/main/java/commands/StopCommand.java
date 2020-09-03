package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import lavaplayer.PlayerManager;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.managers.AudioManager;

public class StopCommand extends Command {

    public StopCommand(){
        this.name = "stop";
        this.aliases = new String[]{};
        this.help = "Stop Playing";
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void execute(CommandEvent event) {
        final MessageChannel channel = event.getChannel();
        final Member self = event.getSelfMember();
        final GuildVoiceState selfVoiceState = self.getVoiceState();


        final Member member = event.getMember();
        final GuildVoiceState memberVoiceState = member.getVoiceState();
        if(!memberVoiceState.inVoiceChannel()){
            channel.sendMessage("You need to be in a Voice Channel").queue();
            return;
        }

        final AudioManager audioManager = event.getGuild().getAudioManager();
        final VoiceChannel memberChannel = memberVoiceState.getChannel();

        audioManager.closeAudioConnection();




        }

    }
