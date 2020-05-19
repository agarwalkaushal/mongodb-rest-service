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

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}