package properties;

public class Pair {
    private final Customer customer;
    private final String workout;

    public Pair(Customer customer, String workout) {
        this.customer = customer;
        this.workout = workout;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getWorkout() {
        return workout;
    }
}
