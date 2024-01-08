public class Customer extends Person{
    private final Workout workoutDemand;

    public Customer(String id, String name, int age, Gender gender, Workout workoutDemand) {
        super(id, name, age, gender);
        this.workoutDemand = workoutDemand;
    }

    public Workout getWorkoutDemand() {
        return workoutDemand;
    }
}

