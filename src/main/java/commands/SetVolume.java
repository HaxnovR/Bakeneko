package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import lavaplayer.PlayerManager;
import lavaplayer.TrackScheduler;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.managers.AudioManager;

public class SetVolume extends Command {


    public SetVolume(){
        this.name = "volume";
        this.aliases = new String[]{};
        this.help = "Changes the volume";
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

        audioManager.openAudioConnection(memberChannel);
        audioManager.isSelfDeafened();

//===================================================================================================================//


        String[] message = event.getMessage().getContentRaw().split(" ");

        if(message.length<2){
            channel.sendMessage("Set the volume in integer").queue();
        }
        else if(message.length == 2){
            int volume = Integer.parseInt(message[1]);



            if(!memberVoiceState.inVoiceChannel()){
                channel.sendMessage("You need to be in a voice channel for this to work!").queue();
                return;
            }

            if(!memberVoiceState.getChannel().equals(selfVoiceState.getChannel())) {
                channel.sendMessage("You need to be in the same voice channel as me!").queue();
                return;
            }

            PlayerManager.getInstance()
                    .SetVolume((TextChannel) channel, volume);

            System.out.println("Setting the volume to:"+volume);
        }
    }
}