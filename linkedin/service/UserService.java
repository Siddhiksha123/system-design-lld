package linkedin.service;

import linkedin.entity.User;
import linkedin.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(String email) throws Exception{
        userRepository.delete(email);
    }

    public User getUser(String email){
        return userRepository.get(email);
    }

    public void updateUser(){

    }
}
