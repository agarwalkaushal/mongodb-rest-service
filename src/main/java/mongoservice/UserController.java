package mongoservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping("/user")
    public String newUser(@RequestBody User user) {
        try {
            String id = repository.findByNumber(user.number).getId();
            return "User exists";
        } catch (NullPointerException e) {
            repository.save(user);
        }
        return user.getId();
    }
}