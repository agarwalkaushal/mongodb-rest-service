package mongoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/foo")
    public String test() {
        return "bar";
    }

    @GetMapping("/user/{number}")
    public User getUser(@PathVariable String number) {
        return repository.findByNumber(number);
    }

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

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User user, @PathVariable String id) {
        try {
            repository.findById(id)
                    .map(updatingUser -> {
                        updatingUser.setFirstName(user.getFirstName());
                        updatingUser.setLastName(user.getLastName());
                        updatingUser.setNumber(user.getNumber());
                        updatingUser.setLocation(user.getLocation());
                        return repository.save(updatingUser);
                    });
        } catch (NullPointerException e) {
            //TODO: Return for not found user
        }
        return user;
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable String id) {
        repository.deleteById(id);
    }
}