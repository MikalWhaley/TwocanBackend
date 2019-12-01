package two.can.Messages.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import two.can.Messages.model.Messages;


@Repository
public interface MessagesRepository extends MongoRepository<Messages, String> {
	
}