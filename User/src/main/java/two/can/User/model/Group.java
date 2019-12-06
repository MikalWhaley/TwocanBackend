package two.can.User.model;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.data.annotation.Id;


public class Group{


@Id
private String uid;
private ArrayList<String> usernames;

public Group() {}

public Group(ArrayList<String> a){
    
    uid = "";
    Collections.sort(a);
    usernames = a;
    
    for(int i = 0; i < usernames.size(); i++){
        uid += usernames.get(i);
    }

}
public int getListSize(){
    return usernames.size();
}
public String getNameAtIndex(int i){
    return usernames.get(i);
}


public String getUid() {
    return this.uid;
}

public void setUid(String uid) {
    this.uid = uid;
}


public ArrayList<String> getList(){
    return this.usernames;
}

public void setList(ArrayList<String> list){
    list = this.usernames;
}


}