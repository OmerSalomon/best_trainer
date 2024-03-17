package properties;

import java.util.Date;

public abstract class Person {
    public static int HOURS_IN_WEEK = 24 * 7;
    private final String id;
    private final String firstName;
    private final String lastName;
    private final Date birthDate;
    private final Gender gender;
    private final boolean[] accessibleTime;

    public Person(String id, String firstName, String lastName, Date birthDate, Gender gender, boolean[] accessibleTime) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;

        if (accessibleTime.length != Person.HOURS_IN_WEEK)
            throw new IllegalArgumentException("accessible time length must be 24 * 7");
        this.accessibleTime = accessibleTime;
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

    public boolean[] getAccessibleTime() {
        return accessibleTime;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
