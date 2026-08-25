
import java.util.HashMap;
import java.util.Map;

public class MessageRepository {

    private  Map<String , Message> messages = new HashMap<>();


    public void save( Message message)
    {    
      if( id == null)
        {
           throw new Exception("Null pointer exception: id is null , nothing cant be fetched aginst it");
        }
      if( !messages.containsKey(message.getId()))
        {
           messages.put( message.getId(), message);
        }
    }

    public Message get(String id) throws Exception
    { 
       if( id == null)
        {
           throw new Exception("Null pointer exception: id is null , nothing cant be fetched aginst it");
        }   
       if( messages.get(id).getId()==null){
         throw new Exception("Null pointer exception: No such messageId are present in DB");
       }
       Message message1 = messages.get(id);
       return message1;
    }


    public void update(Message message , String id )throws Exception
    {
      // Update time , we pass two things -> 1. User body which already has the updated thing and get by the Id passed alongwith it.  
      if( id == null)
        {
           throw new Exception("Null pointer exception: id is null , nothing cant be fetched aginst it");
        } 
      
      if (!messages.containsKey(id)) {
      throw new Exception("Message does not exist");
      }

     if (!message.getId().equals(id)) {
      throw new Exception("Message id and update key do not match");
     }

      messages.put(id, message);
    }


    public void delete(String id) throws Exception{

      if( id == null)
        {
           throw new Exception("Null pointer exception: id is null , nothing cant be fetched aginst it");
        } 
      
        if(messages.get(id)==null)
        {
            throw new Exception("Null pointer exception: No such messageId are present in DB");
        }
        messages.remove(id);
    }


    
}
