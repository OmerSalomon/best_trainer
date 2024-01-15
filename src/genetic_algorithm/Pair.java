package genetic_algorithm;

import properties.Customer;
import properties.Trainer;
import properties.Workout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Pair implements Iterable<Customer>{
    private static final int GENDER_FACTOR = 10;
    private static final int AGE_DIFF_FACTOR = 2;
    private static final int WORKOUT_MATCH_FACTOR = 30;
    private static final int WORKOUT_TIME_DIFF_FACTOR = 20;
    private final Trainer trainer;
    private final ArrayList<Customer> customers;

    public Pair(Trainer trainer) {
        this.trainer = trainer;
        customers = new ArrayList<>();
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public Customer getCustomer(int index){
        return customers.get(index);
    }

    @Override
    public Iterator<Customer> iterator() {
        return new CustomerIterator(customers);
    }

    @Override
    public void forEach(Consumer<? super Customer> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Customer> spliterator() {
        return Iterable.super.spliterator();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Trainer: ");
        res.append(trainer.toString());
        res.append("\n");
        res.append(" customers: ");
        for (Customer customer : this){
            res.append(customer.toString());
            res.append(", ");
        }

        return res.toString();
    }

    public int getDiscrepancy() {
        int pairDiscrepancy = 0;

        for (Customer customer : customers){
            pairDiscrepancy += getCustomerDiscrepancy(customer);
        }

        return pairDiscrepancy;
    }

    private int getCustomerDiscrepancy(Customer customer) {
        int customerDiscrepancy = 0;

        if (customer.getGender() != trainer.getGender())
            customerDiscrepancy += GENDER_FACTOR;

        int ageDiff = Math.abs(customer.getAge() - trainer.getAge()) ;
        customerDiscrepancy += ageDiff * AGE_DIFF_FACTOR;

        Workout workout = getTrainerMatchWorkout(customer.getDemandWorkout());
        if (workout == null)
            customerDiscrepancy += WORKOUT_MATCH_FACTOR;
        else {
            int timeDiff = Math.abs(workout.getMinutes() - customer.getDemandWorkout().getMinutes());
            customerDiscrepancy += timeDiff * WORKOUT_TIME_DIFF_FACTOR;
        }

        return customerDiscrepancy;
    }

    private Workout getTrainerMatchWorkout(Workout demandWorkout) {
        for (Workout workout : trainer.getWorkouts()){
            if (workout.getType().equals(demandWorkout.getType()))
                return workout;
        }
        return null;
    }

    public Customer popCustomer() {
        Customer res = customers.get(customers.size() - 1);
        customers.remove(customers.size() - 1);
        return res;
    }

    public boolean hasCustomers() {
        return !customers.isEmpty();
    }

    private static class CustomerIterator implements Iterator<Customer> {

        private final ArrayList<Customer> customers;
        private int index = 0;

        public CustomerIterator(ArrayList<Customer> customers){
            this.customers = customers;
        }

        @Override
        public boolean hasNext() {
            return index < customers.size();
        }

        @Override
        public Customer next() {
            Customer res = customers.get(index);
            index++;
            return res;
        }
    }
}
