import java.util.ArrayList;

public class Trainer extends Person{
    private final ArrayList<Workout> workouts;
    private final int workoutLimit;

    public Trainer(String id, String name, int age, Gender gender, ArrayList<Workout> workouts, int workoutLimit) {
        super(id, name, age, gender);
        this.workouts = workouts;
        this.workoutLimit = workoutLimit;
    }

    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    public int getWorkoutLimit() {
        return workoutLimit;
    }
}
