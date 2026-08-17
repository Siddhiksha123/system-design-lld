package linkedin.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Job {
    private String id;
    private String title;
    private String description;
    private String link;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Job(String title, String description, String link, User user) {
        this.id=UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.link = link;
        this.user = user;
        this.createdAt=LocalDateTime.now();
        this.updatedAt=createdAt;
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getLink() {
        return link;
    }
    public User getUser() {
        return user;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
