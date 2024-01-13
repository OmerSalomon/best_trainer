package genetic_algorithm;

import properties.Customer;
import properties.Trainer;
import properties.Workout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.concurrent.RecursiveTask;
import java.util.function.Consumer;

public class Pair implements Iterable<Customer>{
    private static final int GENDER_FACTOR = 10;
    private static final int AGE_DIFF_FACTOR = 2;
    private static final int WORKOUT_MATCH_FACTOR = 30;
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

        if (!trainerOfferTheRightWorkout(customer.getDemandWorkout()))
            customerDiscrepancy += WORKOUT_MATCH_FACTOR;

        return customerDiscrepancy;
    }

    private boolean trainerOfferTheRightWorkout(Workout demandWorkout) {
        for (Workout workout : trainer.getWorkouts()){
            if (workout.getType().equals(demandWorkout.getType()))
                return true;
        }
        return false;
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
