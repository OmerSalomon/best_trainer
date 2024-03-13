package genetic_algorithm;

import properties.Customer;
import properties.Trainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generation {
    private List<Solution> solutions;

    public Generation(int generationSize, List<Trainer> trainers, List<Customer> customers) {
        createRandomSolution(generationSize, trainers, customers);
    }

    public Generation(Generation a, Generation b) {
        createNextGeneration(a, b);
    }

    private void createNextGeneration(Generation a, Generation b) {
    }

    private void createRandomSolution(int generationSize, List<Trainer> trainers, List<Customer> customers) {
        solutions = new ArrayList<>();
        for (int i = 0; i < generationSize; i++) {
            solutions.add(new Solution(trainers, customers));
        }
    }
}
