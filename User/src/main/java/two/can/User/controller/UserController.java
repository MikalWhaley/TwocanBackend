package two.can.User.controller;

import java.util.ArrayList;

import com.amazonaws.services.identitymanagement.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
//import mwhaley.csumb.edu.model.Product;
import two.can.User.model.User;
import two.can.User.model.Friends;
//import two.can.User.model.Group;

import two.can.User.service.UserService;;

@RestController
public class UserController{

    @Autowired
    UserService userService;


    @RequestMapping(method = RequestMethod.POST, value = "/users/addUser")
    @ApiOperation(value = "Add a new user to the database" )
    public Boolean addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/users/getAll")
    @ApiOperation(value = "Gets all users" )
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @RequestMapping(method = RequestMethod.POST, value = "/users/addFriend")
    @ApiOperation(value = "Add someone to the friendslist" )
    public void addFriend(String userid, String friendID) {
        userService.addFriend(userid, friendID);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/users/addGroup")
    @ApiOperation(value = "Add people to the grouplist" )
    public Boolean addGroup(String userid, @RequestBody ArrayList<String> a) {
        return userService.addGroup(userid, a);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/users/removeUser")
    @ApiOperation(value = "remove people to the database" )
    public Boolean removeUser(String userid) {
        return userService.removeUser(userid);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/removeFriend")
    @ApiOperation(value = "remove friend from user" )
    public Boolean removeFriend(String userID, String friendID) {
        return userService.removeFriend(userID, friendID);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/login")
    @ApiOperation(value = "verify user credientials" )
    public Boolean login(String userID, String password) {
        return userService.login(userID, password);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/getFriends")
    @ApiOperation(value = "return user friendslist" )
    public ArrayList<Friends> getFriendsList(String userID) {
        return userService.getFriendList(userID);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/getGroups")
    @ApiOperation(value = "return user grouplist" )
    public ArrayList<two.can.User.model.Group> getGroupList(String userID) {
        return userService.getGroupList(userID);
    }
    

}