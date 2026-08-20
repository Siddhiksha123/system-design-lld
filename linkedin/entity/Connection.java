package linkedin.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import linkedin.constants.Status;

public class Connection {

    private String id;
    private User from;
    private User to;
    private Status connectionStatus; 
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Connection(String id, User from, User to, linkedin.entity.Status connectionStatus, LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = UUID.randomUUID().toString();
        this.from = from;
        this.to = to;
        this.connectionStatus = Status.PENDING;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = createdAt;
    }

    
    public String getId() {
        return id;
    }
    public User getFrom() {
        return from;
    }
    public User getTo() {
        return to;
    }
    public void setFrom(User from) {
        this.from = from;
    }
    public void setTo(User to) {
        this.to = to;
    }
    public void setConnectionStatus(Status connectionStatus) {
        this.connectionStatus = connectionStatus;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Status getConnectionStatus() {
        return connectionStatus;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
