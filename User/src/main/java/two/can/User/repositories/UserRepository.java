package two.can.User.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import two.can.User.model.User;



@Repository
public interface UserRepository extends MongoRepository<User,String>{
    
    public default Boolean insertIfDoesntExist(User u) {

        
        if (findById(u.getUsername()).isPresent()){
            return false;
            
        }else{

            insert(u);
            return true;
        }
        
        
    }



}