package properties;

import properties.Customer;

import java.util.ArrayList;
import java.util.Date;

public class Trainer extends Person {
    private final ArrayList<Workout> workouts;
    private int[] weeklyWorkHours;

    public Trainer(String id, String firstName, String lastName, Date birthDate, Gender gender, ArrayList<Workout> workouts, int[] weeklyWorkHours) {
        super(id, firstName, lastName, birthDate, gender);
        this.workouts = workouts;
        this.weeklyWorkHours = weeklyWorkHours;
    }

    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    public int[] getWeeklyWorkHours() {
        return weeklyWorkHours;
    }
}
