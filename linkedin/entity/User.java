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
    private Integer followersN;
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

    
    public Integer getFollowersN() {
        return followersN;
    }

    public void setFollowersN(Integer followersN) {
        this.followersN = followersN;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
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
