package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import lavaplayer.PlayerManager;
import lavaplayer.TrackScheduler;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.managers.AudioManager;

public class SkipCommand extends Command {


    public SkipCommand(){
        this.name = "skip";
        this.aliases = new String[]{};
        this.help = "Skips the current track";
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


//===================================================================================================================//


        String[] message = event.getMessage().getContentRaw().split(" ");


            if(!memberVoiceState.inVoiceChannel()){
                channel.sendMessage("You need to be in a voice channel for this to work!").queue();
                return;
            }

            if(!memberVoiceState.getChannel().equals(selfVoiceState.getChannel())) {
                channel.sendMessage("You need to be in the same voice channel as me!").queue();
                return;
            }

        PlayerManager.getInstance()
                .Skip((TextChannel) channel);



            System.out.println("Skipping Track");


    }
}