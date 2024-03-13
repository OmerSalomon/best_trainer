package genetic_algorithm;

import properties.Customer;
import properties.Trainer;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {
    private final List<Trainer> trainers;

    private final ArrayList<Customer> customers;

    public Algorithm(ArrayList<Trainer> trainers, ArrayList<Customer> customers) {
        this.trainers = trainers;
        this.customers = customers;
    }

    public Solution findBestSolution(int generationSize ,int generationsAmount){
        return null;
    }
}
