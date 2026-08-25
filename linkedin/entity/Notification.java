package linkedin.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import linkedin.constants.NotificationType;

public class Notification {

    private String id;
    private User sender;
    private User receiver;
    private String title;
    private String message;
    private NotificationType type;
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "Notification [id=" + id + ", title=" + title + ", message=" + message + ", type=" + type
                + ", createdAt=" + createdAt + "]";
    }

    public Notification(String title, String message, NotificationType type) {
        this.id=UUID.randomUUID().toString();
        this.title = title;
        this.message = message;
        this.type = type;
        this.createdAt=LocalDateTime.now();
    }

    public String getId() {
        return id;
    }
    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
    public String getTitle() {
        return title;
    }
    public String getMessage() {
        return message;
    }
    public NotificationType getType() {
        return type;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
