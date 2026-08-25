import java.util.List;
import java.util.UUID;

public class Inbox {
   private String Id;
   private String userId;
   private List<String> conversationId = new ArrayList<>();

    public Inbox( String userId) {
    this.Id = UUID.randomUUID().toString();
    this.userId = userId;
}


   public String getId() {
    return Id;
   }
   public void setId(String id) {
    Id = id;
   }
   public String getUserId() {
    return userId;
   }  
   public void setUserId(String userId) {
    this.userId = userId;
   }
   public List<String> getConversationId() {
    return conversationId;
   }
   public void setConversationId(List<String> conversationId) {
    this.conversationId = conversationId;
   }

   

}
