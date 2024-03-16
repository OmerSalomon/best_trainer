package genetic_algorithm;

import properties.Customer;
import properties.Trainer;

import java.util.List;

public class Solution {
    private List<TrainerSchedule> trainerSchedules;
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
