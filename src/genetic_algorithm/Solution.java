package genetic_algorithm;

import properties.Customer;
import properties.Trainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    private List<Pair> pairs;
    public Solution(List<Trainer> trainers, List<Customer> customers){
        createRandomSolution();
    }

    public Solution(Solution a, Solution b){
        createCrossSolution();
    }

    private void createRandomSolution() {
    }

    private void createCrossSolution() {
    }
}
