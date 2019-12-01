package two.can.User.controller;
//import java.util.Arrays;

//import java.util.List;

//import java.util.Optional;

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

    

}