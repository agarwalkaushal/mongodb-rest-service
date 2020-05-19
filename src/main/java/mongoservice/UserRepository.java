package mongoservice;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByFirstName(String firstName);
    public User findByNumber(String number);
    public List<User> findByLastName(String lastName);

}