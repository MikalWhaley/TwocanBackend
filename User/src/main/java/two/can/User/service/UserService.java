package two.can.User.service;

//import java.util.HashMap;
//import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import two.can.User.model.User;
import two.can.User.model.Friends;
import two.can.User.model.Group;

import two.can.User.repositories.UserRepository;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Boolean addUser(User u){
        
        return userRepository.insertIfDoesntExist(u);

        
    }

    public void addFriend(String userID, Friends f){
        
        User user = userRepository.findById(userID).get();
        user.addFriend(f);

        
    }

    public void addGroup(String userID, Group g){
        
        User user = userRepository.findById(userID).get();
        user.addGroup(g);

        
    }
    

}