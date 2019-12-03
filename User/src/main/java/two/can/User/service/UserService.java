package two.can.User.service;

import java.util.Optional;

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
    // the user                               the friend
    public void addFriend(String userID, String friendID){

        Optional<User> temp = userRepository.findById(userID);
        
        if(userRepository.findById(friendID).isPresent() && temp.isPresent()){

            User user = temp.get();

            Friends friend = new Friends(friendID, userID);

            user.addFriend(friend);
        }
        
    
        
    }

    public void addGroup(String userID, Group g){
        
        User user = userRepository.findById(userID).get();
        user.addGroup(g);

        
    }
    

}