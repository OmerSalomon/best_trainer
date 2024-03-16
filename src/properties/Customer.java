package properties;

import java.util.Date;

public class Customer extends Person {
    private final String demandWorkout;
    private final boolean[] freeDays;

    public Customer(String id, String firstName, String lastName, Date birthDate, Gender gender, String demandWorkout, boolean[] freeDays) {
        super(id, firstName, lastName, birthDate, gender);
        this.demandWorkout = demandWorkout;
        this.freeDays = freeDays;
    }

    public String getDemandWorkout() {
        return demandWorkout;
    }
}

