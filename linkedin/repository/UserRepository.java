package linkedin.repository;

import java.util.HashMap;
import java.util.Map;

import linkedin.entity.User;

public class UserRepository {

    private Map<String, User>users=new HashMap<>();


    public void save(User user) throws Exception {
        if(users.containsKey(user.getEmail())){
            throw new Exception("Already Exist");
        }
        users.put(user.getEmail(), user);
    }

    public User get(String email) throws Exception {
        if(!users.containsKey(email)){
            throw new Exception("User doesn't exist");
        }
        return users.get(email);
    }

    public void delete(String email) throws Exception {
        if(!users.containsKey(email)){
            throw new Exception("Doesn't exist");
        }
        users.remove(email);
    }

    public void update(User user) throws Exception{
        if(!users.containsKey(user.getEmail())){
            throw new Exception("Doesn't exist");
        }
        users.put(user.getEmail(), user);
    }
}
