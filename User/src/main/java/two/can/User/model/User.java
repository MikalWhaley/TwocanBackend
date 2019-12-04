package two.can.User.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel
public class User {

    @Id
    private String username;
    private String password;
    private String email;

    
    @ApiModelProperty(required = false, hidden = true)
    ArrayList<Friends> friendslist;

    @ApiModelProperty(required = false, hidden = true)
    ArrayList<Group> grouplist;

    public User() {}

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Friends> getFriends() {
        return this.friendslist;
    }
    
    public void setFriends(ArrayList<Friends> list) {
        this.friendslist = list;
    }
    
    public void addFriend(Friends friend) {

        if(friendslist == null) {
            
            friendslist = new ArrayList<Friends>();
            friendslist.add(friend);
            return;
        
        } 

        friendslist.add(friend);
    }

    public ArrayList<Group> getGroup() {
        return this.grouplist;
    }

    
    public void setGroup(ArrayList<Group> list) {
        this.grouplist = list;
    }
    
    public void addGroup(Group group) {
        
        if(grouplist == null) {
            
            grouplist = new ArrayList<Group>();
            grouplist.add(group);
            return;
        } 

        grouplist.add(group);
    }
}