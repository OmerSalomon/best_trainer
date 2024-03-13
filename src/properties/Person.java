package properties;

import java.util.Date;

public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Gender gender;

    public Person(String id, String firstName, String lastName, Date birthDate, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }
}
