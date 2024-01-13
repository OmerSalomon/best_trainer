package properties;

public class Customer extends Person {
    private final Workout demandWorkout;

    public Customer(String id, String name, int age, Gender gender, Workout demandWorkout) {
        super(id, name, age, gender);
        this.demandWorkout = demandWorkout;
    }

    public Workout getDemandWorkout() {
        return demandWorkout;
    }

    @Override
    public String toString() {
        return "[" + getName() + ": " + demandWorkout.toString() + "]";
    }
}

