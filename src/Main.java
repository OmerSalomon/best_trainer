import genetic_algorithm.Algorithem;
import genetic_algorithm.Generation;
import properties.Customer;
import properties.Gender;
import properties.Trainer;
import properties.Workout;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers = createCustomerList();
        ArrayList<Trainer> trainers = createTrainerList();
        Generation generation = Generation.createRandomGeneration(trainers, customers, 10);
    }


    public static ArrayList<Customer> createCustomerList(){
        Customer customer_1 = new Customer("123", "Omer", 14, Gender.MALE, new Workout("soccer", 30));

        // Second customer
        Customer customer_2 = new Customer("124", "Emma", 22, Gender.FEMALE, new Workout("cycling", 45));

        // Third customer
        Customer customer_3 = new Customer("125", "John", 30, Gender.MALE, new Workout("running", 60));

        // Fourth customer
        Customer customer_4 = new Customer("126", "Alice", 27, Gender.FEMALE, new Workout("badminton", 40));

        // Fifth customer
        Customer customer_5 = new Customer("127", "Max", 20, Gender.MALE, new Workout("boxing", 50));

        // Sixth customer
        Customer customer_6 = new Customer("128", "Lucy", 19, Gender.FEMALE, new Workout("running", 35));

        // Seventh customer
        Customer customer_7 = new Customer("129", "David", 24, Gender.MALE, new Workout("soccer", 45));

        // Eighth customer
        Customer customer_8 = new Customer("130", "Sara", 31, Gender.FEMALE, new Workout("boxing", 30));

        // Ninth customer
        Customer customer_9 = new Customer("131", "Mike", 28, Gender.MALE, new Workout("cycling", 60));

        // Tenth customer
        Customer customer_10 = new Customer("132", "Zoe", 26, Gender.FEMALE, new Workout("kickboxing", 50));

        ArrayList<Customer> customers = new ArrayList<>();

        customers.add(customer_1);
        customers.add(customer_2);
        customers.add(customer_3);
        customers.add(customer_4);
        customers.add(customer_5);
        customers.add(customer_6);
        customers.add(customer_7);
        customers.add(customer_8);
        customers.add(customer_9);
        customers.add(customer_10);

        return customers;
    }

    public static ArrayList<Trainer> createTrainerList() {
        //trainer 1;
        ArrayList<Workout> workouts_1 = new ArrayList<>();
        workouts_1.add(new Workout("soccer", 45));
        workouts_1.add(new Workout("running", 90));
        workouts_1.add(new Workout("boxing", 90));
        Trainer trainer_1 = new Trainer("123", "Omer", 12, Gender.MALE, workouts_1, 100);

        // Second trainer and their workouts
        ArrayList<Workout> workouts_2 = new ArrayList<>();
        workouts_2.add(new Workout("tennis", 60));
        workouts_2.add(new Workout("badminton", 30));
        Trainer trainer_2 = new Trainer("456", "Emma", 8, Gender.FEMALE, workouts_2, 120);

        // Third trainer and their workouts
        ArrayList<Workout> workouts_3 = new ArrayList<>();
        workouts_3.add(new Workout("cycling", 45));
        workouts_3.add(new Workout("running", 30));
        workouts_3.add(new Workout("swimming", 60));
        Trainer trainer_3 = new Trainer("789", "Alex", 10, Gender.MALE, workouts_3, 110);

        ArrayList<Trainer> trainers = new ArrayList<>();
        trainers.add(trainer_1);
        trainers.add(trainer_2);
        trainers.add(trainer_3);

        return trainers;
    }
}