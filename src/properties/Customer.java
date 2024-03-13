package properties;

import java.util.Date;

public class Customer extends Person {
    private final Workout demandWorkout;

    public Customer(String id, String firstName, String lastName, Date birthDate, Gender gender, Workout demandWorkout) {
        super(id, firstName, lastName, birthDate, gender);
        this.demandWorkout = demandWorkout;
    }

    public Workout getDemandWorkout() {
        return demandWorkout;
    }
}

