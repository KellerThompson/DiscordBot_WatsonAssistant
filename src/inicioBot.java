import Consola.Consola;
import DiscordEvents.MessageEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class inicioBot
{
    public static void main(String args[]) throws Exception
    {
        Consola consola = new Consola(600, 300, "Consola");
        JDA jda = new JDABuilder("NjkxMTk0MDM1Mjg4ODAxMzEx.Xncavg.ZVeoJTBRb2NrPi-OGKWZrSjXMHo").build();
        jda.addEventListener(new MessageEvent(consola));
    }
}
