package properties;

import properties.Customer;

import java.util.ArrayList;

public class Trainer extends Person {
    private final ArrayList<Workout> workouts;
    private final ArrayList<Customer> customers;
    private final int workoutLimit;

    public Trainer(String id, String name, int age, Gender gender, ArrayList<Workout> workouts, int workoutLimit) {
        super(id, name, age, gender);
        this.workouts = workouts;
        this.workoutLimit = workoutLimit;
        this.customers = new ArrayList<>();
    }

    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    public int getWorkoutLimit() {
        return workoutLimit;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
