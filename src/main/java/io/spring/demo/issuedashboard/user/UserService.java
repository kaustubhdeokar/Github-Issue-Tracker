package io.spring.demo.issuedashboard.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(long id){
        return userRepository.findById(id).orElseThrow(()->
          new RuntimeException("user not found"));
    }

    public void addUser(String name, String org){
        User user = new User(name,org);
        userRepository.save(user);
    }

}
