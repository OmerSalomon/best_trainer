package properties;

import java.util.Date;
import java.util.List;

public class Trainer extends Person {
    private final List<Integer> workouts;

    public Trainer(String id, String firstName, String lastName, Date birthDate, Gender gender, boolean[] accessibleTime, List<Integer> workouts) {
        super(id, firstName, lastName, birthDate, gender, accessibleTime);
        this.workouts = workouts;
    }

    public List<Integer> getWorkouts() {
        return workouts;
    }

}
