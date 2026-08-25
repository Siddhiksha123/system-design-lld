import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InboxRepository {
    
   private Map< String , List<String> >  inboxMap = new HashMap<>();

   public void saveOrUpdate(String userId, String conversationId) throws Exception {

    if (userId == null || userId.isBlank()) {
        throw new Exception("Inbox id cannot be null or blank");
    }

    if (conversationId == null || conversationId.isBlank()) {
        throw new Exception("Conversation id cannot be null or blank");
    }

    List<String> conversationIds = inboxMap.get(userId);

    if (conversationIds == null) {
        conversationIds = new ArrayList<>();
        inboxMap.put(userId, conversationId);
    }

    if (conversationIds.contains(conversationId)) {
        throw new Exception("Conversation is already mapped in this inbox");
    }

    conversationIds.add(conversationId);
}


public void delete(String userID) throws Exception {
    if (userID == null || userID.isBlank()) {
       throw new Exception("Inbox id cannot be null or blank");
    }
    if (!inboxMap.containsKey(userID)) {
       throw new Exception("Inbox does not exist");
    }
    inboxMap.remove(userID);
}



public void delete(String userID, String conversationId) throws Exception {

    if (userID == null || userID.isBlank()) {
        throw new Exception("Inbox id cannot be null or blank");
    }
    if (!inboxMap.containsKey(userID)) {
        throw new Exception("Inbox does not exist");
    }
    List<String> conversationIds = inboxMap.get(userID);
    conversationIds.remove(conversationId);
}





public List<String> get(String userID) throws Exception {
    if (userID == null || userID.isBlank()) {
       throw new Exception("Inbox id cannot be null or blank");
   }
   if (!inboxMap.containsKey(userID)) {
    throw new Exception("Inbox does not exist");
   }  
    return inboxMap.get(userID);
}



}
