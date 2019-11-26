package Twocan.TwocanBackend.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

//import io.swagger.annotations.ApiModelProperty;


public class User{


@Id
String username;
String password;
//@ApiModelProperty(required = false, hidden = true)
ArrayList<String> friendslist = new ArrayList<String>();

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

public ArrayList<String> getFriends(){
    return this.friendslist;
}

public void setFriends(ArrayList<String> list){
    list = this.friendslist;
}

public void addFriend(String friend){
    friendslist.add(friend);
}




}