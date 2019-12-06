package two.can.User.service;

import java.util.ArrayList;
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
            userRepository.save(user);
        }
        
    
        
    }

    public boolean isListValid(Group g){

        ArrayList<String> a = g.getList();

        for(int i = 0; i < a.size(); i++){
            if(!userRepository.findById(a.get(i)).isPresent()){
                return false;
            }
        }

        return true;

        /*
        

        Boolean valid = true;
    
        for(int i = 0; i < g.getListSize(); i++){
            if(userRepository.findById(g.getNameAtIndex(i)).isPresent()){
                valid = true;
            }else{
                valid = false;
                return valid;
            }
    
        }
        return valid;
 */
    
    }


    public Boolean addGroup(String userID, ArrayList<String> a){

        // System.out.print(userID);
        
        // System.out.print(a.get(0));
        
        Group g = new Group(a);
        Optional<User> temp = userRepository.findById(userID);

        if(isListValid(g) && temp.isPresent() ){
            User user = temp.get();
            user.addGroup(g);
            for(int i =0; i<g.getListSize(); i++){
                System.out.print(g.getNameAtIndex(i));
            }
           
            userRepository.save(user);
            return true;
        }
        return false;

    }
    

}