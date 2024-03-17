package genetic_algorithm;

import properties.Customer;
import properties.Trainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    private List<TrainerSchedule> trainerSchedules;
    private List<Trainer> trainers;
    private List<Customer> customers;
    public Solution(List<Trainer> trainers, List<Customer> customers){
        this.trainers = trainers;
        this.customers = customers;
        trainerSchedules = new ArrayList<>();
        
        for (Trainer trainer : trainers){
            trainerSchedules.add(new TrainerSchedule(trainer));
        }
        
        createRandomSolution();
    }

    public Solution(Solution a, Solution b){
        this.trainers = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.trainerSchedules = new ArrayList<>();

        if (a.trainerSchedules.size() != b.trainerSchedules.size())
            throw new IllegalArgumentException("Can not create trainerSchedules with trainer schedules list of different sizes");

        for (int i = 0; i < a.trainerSchedules.size(); i++) {
            trainerSchedules.add(new TrainerSchedule(a.trainerSchedules.get(i), b.trainerSchedules.get(i)));
        }
    }

    private void createRandomSolution() {
        ArrayList<TrainerSchedule> availableTrainerSchedules = new ArrayList<>(trainerSchedules);
        for (Customer customer : customers){
            if (!availableTrainerSchedules.isEmpty()){
                Random random = new Random();

                int randomIndex = random.nextInt(availableTrainerSchedules.size());
                availableTrainerSchedules.get(randomIndex).insertCustomer(customer);

                if (!availableTrainerSchedules.get(randomIndex).isAvailable())
                    availableTrainerSchedules.remove(randomIndex);
            }
        }

    }

    private void createCrossSolution() {
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        for (TrainerSchedule trainerSchedule : trainerSchedules){
            res.append(trainerSchedule.toString());
            res.append("\n");
        }

        return res.toString();
    }
}
