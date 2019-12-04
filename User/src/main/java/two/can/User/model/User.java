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
    ArrayList<Friends> friendslist = new ArrayList<Friends>();//friends list

    @ApiModelProperty(required = false, hidden = true)
    ArrayList<Group> grouplist = new ArrayList<Group>();//group list

    
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


    public ArrayList<Friends> getFriends(){
        return this.friendslist;
    }
    
    public void setFriends(ArrayList<Friends> list){
        list = this.friendslist;
    }
    
    public void addFriend(Friends friend){

        friendslist.add(friend);
    }

    public ArrayList<Group> getGroup(){
        return this.grouplist;
    }

    
    public void setGroup(ArrayList<Group> list){
        list = this.grouplist;
    }
    
    public void addGroup(Group group){
        grouplist.add(group);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
}