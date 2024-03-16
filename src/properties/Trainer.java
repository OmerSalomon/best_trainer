package properties;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Trainer extends Person {
    private final List<String> workouts;
    private int[] dailyWorkHours;

    public Trainer(String id, String firstName, String lastName, Date birthDate, Gender gender, ArrayList<String> workouts, int[] dailyWorkHours) {
        super(id, firstName, lastName, birthDate, gender);
        this.workouts = workouts;
        this.dailyWorkHours = dailyWorkHours;
    }

    public List<String> getWorkouts() {
        return workouts;
    }

    public int[] getDailyWorkHours() {
        return dailyWorkHours;
    }
}
