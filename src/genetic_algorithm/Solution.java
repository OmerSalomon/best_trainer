package genetic_algorithm;

import properties.Customer;
import properties.Trainer;
import properties.Workout;

import java.util.ArrayList;
import java.util.Random;

public class Solution {
    private static final int GENDER_EQUALITY_POINTS = 5;
    private static final int AGE_DIFFERENCE_FACTOR = 1;
    private static final int WORKOUT_TIME_DELTA_FACTOR = 3;
    private static final int TRAINER_START_POINTS = 1000;

    private ArrayList<Trainer> trainers;

    public Solution(ArrayList<Trainer> trainers) {
        this.trainers = trainers;
    }

    public static Solution createRandomSolution(ArrayList<Trainer> trainers, ArrayList<Customer> customers) {
        for (Customer customer : customers){
            Random rand = new Random();
            int randomNum = rand.nextInt(trainers.size());
            trainers.get(randomNum).getCustomers().add(customer);
        }
        return new Solution(trainers);
    }

    public int fitness()
    {
        int totalDiscrepancies = 0;

        for (Trainer trainer : trainers){
            totalDiscrepancies += getTrainerDiscrepancies(trainer);
        }

        return totalDiscrepancies;
    }

    private int getTrainerDiscrepancies(Trainer trainer) {
        int discrepancies = TRAINER_START_POINTS;

        for (Customer customer : trainer.getCustomers()){
            if (customer.getGender() != trainer.getGender()){
                discrepancies += GENDER_EQUALITY_POINTS;
            }

            int absolutAgeDelta = Math.abs(trainer.getAge() - customer.getAge());
            discrepancies += absolutAgeDelta * AGE_DIFFERENCE_FACTOR;

            int workoutsDelta = getWorkoutMatchingPoint(trainer.getWorkouts(), customer.getDemandWorkout());
            discrepancies += workoutsDelta;
        }

        return discrepancies;
    }

    private int getWorkoutMatchingPoint(ArrayList<Workout> trainerWorkouts, Workout demandWorkout) {
        int smallestDiscrepancies = Integer.MAX_VALUE;

        if (trainerWorkouts.isEmpty())
            return 0;

        for (Workout workout : trainerWorkouts)
        {
            int discrepancies = 0;
            if (!workout.getType().equals(demandWorkout.getType()))
                discrepancies += 50;

            discrepancies += Math.abs(workout.getMinutes() - demandWorkout.getMinutes()) * WORKOUT_TIME_DELTA_FACTOR;

            if (discrepancies < smallestDiscrepancies)
                smallestDiscrepancies = discrepancies;
        }

        return smallestDiscrepancies;
    }
}
