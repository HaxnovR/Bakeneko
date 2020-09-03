package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import lavaplayer.PlayerManager;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.managers.AudioManager;

public class PlayCommand extends Command {

    public PlayCommand(){
        this.name = "play";
        this.aliases = new String[]{};
        this.help = "play <YouTube Link>";
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
            channel.sendMessage("Enter a link").queue();
        }
        else if(message.length == 2){
            String song = message[1];



            if(!memberVoiceState.inVoiceChannel()){
                channel.sendMessage("You need to be in a voice channel for this to work!").queue();
                return;
            }

            if(!memberVoiceState.getChannel().equals(selfVoiceState.getChannel())) {
                channel.sendMessage("You need to be in the same voice channel as me!").queue();
                return;
            }

            PlayerManager.getInstance()
                    .loadAndPlay((TextChannel) channel, song);

            System.out.println("Playing "+song);
        }

    }
}