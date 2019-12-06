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


    public Boolean addUser(User u) {
        
        return userRepository.insertIfDoesntExist(u);
    }

    // the user                               the friend
    public void addFriend(String userID, String friendID) {

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

        for(int i = 0; i < a.size(); i++) {

            if(!userRepository.findById(a.get(i)).isPresent()) {

                return false;
            }
        }

        return true;
    }


    public Boolean addGroup(String userID, ArrayList<String> a) {

        Group g = new Group(a);
        Optional<User> temp = userRepository.findById(userID);

        if(isListValid(g) && temp.isPresent() ) {

            User user = temp.get();
            user.addGroup(g);
            
            userRepository.save(user);
            return true;
        }

        return false;
    }


    public Boolean removeFriend(String userID, String friendID) {

        Optional<User> temp = userRepository.findById(userID);

        if(temp.isPresent()){
            User user = temp.get();
            user.removeFriend(friendID);
            userRepository.save(user);
            return true;

        } else {

            return false;
        }
    }

    public Boolean removeUser(String userID) {

        Optional<User> temp = userRepository.findById(userID);

        if(temp.isPresent()){
            User user = temp.get();
            userRepository.delete(user);
            return true;

        } else {

            return false;
        }
    }
    
    public Boolean login(String userID, String password){

        Optional<User> temp = userRepository.findById(userID);

        if(temp.isPresent()){
            User user = temp.get();
            if(user.getPassword().equals(password)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    //get friends list
    //get groups list
    //remove group

    public ArrayList<Friends> getFriendList(String userID) {

        Optional<User> temp = userRepository.findById(userID);

        if(temp.isPresent()) {
            User user = temp.get();
            return user.getFriends();

        } else {

            return new ArrayList<Friends>();
        }
    }


    public ArrayList<Group> getGroupList(String userID) {

        Optional<User> temp = userRepository.findById(userID);

        if(temp.isPresent()){
            User user = temp.get();
            return user.getGroup();

        } else {

            return new ArrayList<Group>();
        }
    }
}