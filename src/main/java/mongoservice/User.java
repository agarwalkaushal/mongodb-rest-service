package mongoservice;

import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;


public class User {

    @Id
    public String id;

    public String number;

    public String firstName;
    public String lastName;
    public String location;

    public User() {}

    public User(String number, String firstName, String lastName, String location) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format(
                "User[number=%s, firstName='%s', lastName='%s',  location='%s']",
                 number, firstName, lastName, location);
    }

    public String getId() {
        return id;
    }
}