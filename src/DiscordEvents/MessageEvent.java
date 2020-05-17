package DiscordEvents;

import Consola.Consola;
import Watson.WatsonAssistant;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageEvent extends ListenerAdapter//
{
    private Consola consola;
    private WatsonAssistant waston;

    public MessageEvent(Consola consola)
    {
        this.consola = consola;
        this.waston = new WatsonAssistant();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        String messageSent = event.getMessage().getContentRaw();
        String Author = event.getMember().getNickname();
        if(!event.getAuthor().isBot())
        {
            String[] respuestas = waston.sendMessage(messageSent, Author);
            for (String i: respuestas)
            {
                event.getChannel().sendMessage(i).queue();
            }
        }
        consola.addText
                (
                        "[" + event.getGuild().getName() + "] ["+event.getChannel().getName()
                        + "] "+event.getAuthor().getName() + ": " + event.getMessage().getContentDisplay()
                );
    }
}
