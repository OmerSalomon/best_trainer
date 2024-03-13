package genetic_algorithm;

import properties.Customer;
import properties.Trainer;

import java.util.ArrayList;

public class Algorithm {
    private final ArrayList<Trainer> trainers;

    private final ArrayList<Customer> customers;

    public Algorithm(ArrayList<Trainer> trainers, ArrayList<Customer> customers) {
        this.trainers = trainers;
        this.customers = customers;
    }

    public Solution findBestSolution(int generationSize ,int generationsAmount){
        Generation generation = new Generation(trainers, customers, generationSize);
        for (int i = 0; i < generationsAmount; i++) {
            generation = generation.createNextGeneration();
        }

        return generation.findBestSolution();
    }


}
