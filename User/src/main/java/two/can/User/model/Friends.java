package two.can.User.model;


public class Friends{


    String username;
    String uid;
    //              friend you're adding    your username
    public Friends(String frienduser, String username){
        this.username = frienduser;

        int compare = username.compareTo(frienduser);


        if(compare < 0){
            uid = username + frienduser;
        }else if(compare > 0){
            uid = frienduser + username;
        }

    }
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}