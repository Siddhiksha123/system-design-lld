import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConversationRepository {
    
    private Map<String , Conversation> conversations = new HashMap<>();




    public void save( Conversation conversation) throws Exception
    {

        if( conversations.containsKey(conversation.getId()))
        {
            throw new Exception("Conversation already exists, nothing to save into db");
        }

        conversations.put(conversation.getId() , conversation);
       
    }




    public Conversation get( String Id) throws Exception
    {   

    // This line is dangerous:


    // If Id is not present in the map, then conversations.get(Id) returns null.
    // Then calling null.getId() causes a NullPointerException.

    // Correct pattern
    // First check whether the key exists:

            //  if(
            // { conversations.get(Id).getId()==null )
            //     throw new Exception("No such conversation exists , so nothing to fetch");
            // }

    // First check whether the key exists:
     if (!conversations.containsKey(id)) {
        throw new Exception("No such conversation exists, so nothing to fetch");
     }
        return conversations.get(Id);       
    }

    
    public void update(Conversation conversation , String id)throws Exception
    {
        if (!conversations.containsKey(id)) {
        throw new Exception("No such conversation exists, so nothing to update");
    }
    conversations.put(id, conversation);
    }



    public void delete(String id)
    {
        if( conversations.get(Id)==null)
        {
            throw new Exception("No such conversation exists , so nothing to delete");
        }
        conversations.remove(id);
    }



     public List<Conversation> getConversationsByUserId(String userId )
    { 
        List<Conversation> conversationsList = new ArrayList<>();

        for ( Conversation it: conversations.values())
        {
               if( it.getParticipantIds().contains(userId))
               {
                  conversationsList.add(it);
               }
        }

        return conversationsList;
    }





}
