package Watson;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.MessageInput;
import com.ibm.watson.assistant.v2.model.MessageOptions;
import com.ibm.watson.assistant.v2.model.MessageResponse;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;

public class WatsonAssistant {//

  private Assistant assistant;
  private String apikey = "05poh059UKtpZv6trg4IxYOIaAFC5PZSiXTRNaRiHebC";
  private String versionDate = "2020-02-05";
  private String assistant_id = "58349c82-0edb-42d6-9f7c-29d2f7534196";
  private String session_id;

  public WatsonAssistant()
  {
    IamAuthenticator authenticator = new IamAuthenticator(apikey);
    assistant = new Assistant(versionDate, authenticator);
    assistant.setServiceUrl("https://api.us-south.assistant.watson.cloud.ibm.com");
    CreateSession();
  }

  public void CreateSession()
  {
    CreateSessionOptions options = new CreateSessionOptions.Builder(assistant_id).build();
    session_id = assistant.createSession(options).execute().getResult().getSessionId();
  }

  public String[] sendMessage(String message, String Author)
  {
    try
    {
      MessageInput input = new MessageInput.Builder()
              .messageType("text")
              .text(message)
              .build();

      MessageOptions optionsMessage = new MessageOptions.Builder(assistant_id, session_id)
              .input(input)
              .build();

      MessageResponse responseMessage = assistant.message(optionsMessage)
              .execute()
              .getResult();

      System.out.println(optionsMessage); //input
      System.out.println(responseMessage);//output

      String[] respuestas = new String[responseMessage.getOutput().getGeneric().size()];
      for (int i = 0; i < respuestas.length; i++)
      {
         respuestas[i] = responseMessage.getOutput().getGeneric().get(i).text();
      }
      return respuestas;
    }
    catch(Exception ex)
    {
      System.out.println(ex);
      CreateSession();
      return sendMessage(message, Author);
    }
  }

}
