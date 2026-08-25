import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Conversation {
    private String Id;
    private List<String> participantIds = new ArrayList<>();
    private List<Message> messagelist= new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

   
    public Conversation( List<Message> messagelist) {
        this.Id = UUID.randomUUID().toString();
        this.messagelist = messagelist;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = createdAt;
    }

    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public List<String> getParticipantIds() {
        return participantIds;
    }
    public void setParticipantIds(List<String> participantIds) {
        this.participantIds = participantIds;
    }
    public List<Message> getMessagelist() {
        return messagelist;
    }
    public void setMessagelist(List<Message> messagelist) {
        this.messagelist = messagelist;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
