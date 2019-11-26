package Twocan.TwocanBackend.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

public class Group{


@Id
String uid;

ArrayList<String> usernames = new ArrayList<String>();


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