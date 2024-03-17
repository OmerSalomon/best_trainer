package properties;

import java.util.Date;

public class Customer extends Person {
    private final int demandWorkout;

    public Customer(String id, String firstName, String lastName, Date birthDate, Gender gender, boolean[] accessibleTime, int demandWorkout) {
        super(id, firstName, lastName, birthDate, gender, accessibleTime);
        this.demandWorkout = demandWorkout;
    }

    public int getDemandWorkout() {
        return demandWorkout;
    }
}

