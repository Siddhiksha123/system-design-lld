

import java.time.LocalDateTime;
import java.util.UUID;

public class Message{
    private String Id;
    private String content;
    private String msgFromUserId ;
    private String msgToUserId ;
    private LocaldateTime createdAt;

    
    public Message( String content, String msgFromUserId, String msgToUserId) {
        this.Id = UUID.randomUUID().toString();
        this.content = content;
        this.msgFromUserId = msgFromUserId;
        this.msgToUserId = msgToUserId;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = createdAt;
    }

    
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getMsgFromUserId() {
        return msgFromUserId;
    }
    public void setMsgFromUserId(String msgFromUserId) {
        this.msgFromUserId = msgFromUserId;
    }
    public String getMsgToUserId() {
        return msgToUserId;
    }
    public void setMsgToUserId(String msgToUserId) {
        this.msgToUserId = msgToUserId;
    }
    public LocaldateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocaldateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    private LocalDateTime updatedAt;

}