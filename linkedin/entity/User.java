package linkedin.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private List<String>skills;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    

    public User(String firstName, String lastName, String userName, String email, List<String>skills, String password) {
        this.id=UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.skills=skills;
        this.password=password;
        this.createdAt=LocalDateTime.now();
        this.updatedAt=createdAt;
    }

    public String getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getUserName() {
        return userName;
    }
    public String getEmail() {
        return email;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
