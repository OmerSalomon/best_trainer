package genetic_algorithm;

import properties.*;

import java.util.ArrayList;
import java.util.Random;

public class TrainerSchedule {
    public static String[] DAYS_OF_WEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private Trainer trainer;
    private Customer[] schedule;
    public TrainerSchedule(Trainer trainer) {
        this.trainer = trainer;
        this.schedule = new Customer[Person.HOURS_IN_WEEK];
    }

    public TrainerSchedule(TrainerSchedule trainerScheduleA, TrainerSchedule trainerScheduleB){
        if (trainerScheduleA.trainer != trainerScheduleB.trainer)
            throw new IllegalArgumentException("Cannot create crossed trainerSchedule with different trainers");

        this.trainer = trainerScheduleA.trainer;
        this.schedule = new Customer[24 * 7];

        for (int i = 0; i < 10; i++) {
            Customer customerA = trainerScheduleA.popRandomCustomer();
            Customer customerB = trainerScheduleB.popRandomCustomer();

            trainerScheduleA.insertCustomer(customerB);
            trainerScheduleB.insertCustomer(customerA);
        }
    }

    public Customer popRandomCustomer(){
        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < schedule.length; i++) {
            if (schedule[i] != null)
                indexes.add(i);
        }

        if (indexes.isEmpty())
            throw new RuntimeException("Trainer schedule is empty");

        Random random = new Random();
        int randomIndex = indexes.get(random.nextInt(indexes.size()));

        Customer res = schedule[randomIndex];
        schedule[randomIndex] = null;

        return res;
    }

    public boolean isAvailable(){
        for (int i = 0; i < Person.HOURS_IN_WEEK; i++){
            if (trainer.getAccessibleTime()[i] && schedule[i] == null)
                return true;
        }
        return false;
    }

    public void insertCustomer(Customer customer){
        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < schedule.length; i++) {
            if (schedule[i] == null && trainer.getAccessibleTime()[i])
                indexes.add(i);
        }

        if (indexes.isEmpty())
            throw new RuntimeException("Schedule is Full");

        Random random = new Random();
        int randomScheduleIndex = indexes.get(random.nextInt(indexes.size()));

        schedule[randomScheduleIndex] = customer;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(trainer.toString());
        res.append("\n");

        for (int i = 0; i < 7; i++) {
            res.append(DAYS_OF_WEEK[i] + ": ");

            for (int j = 0; j < 24; j++) {
                int index = i * 24 + j;
                if (schedule[index] != null)
                    res.append(j).append(" ").append(schedule[index].toString()).append(", ");
            }
            res.append("\n");
        }

        res.append("Fitness: " + fitness());
        res.append("\n");

        return res.toString();
    }

    public int fitness(){
        int res = 0;

        for (int i = 0; i < schedule.length; i++) {
            Customer customer = schedule[i];
            if (customer != null){
                if (customer.getAccessibleTime()[i])
                    res += 100;
                if (trainer.getWorkouts().contains(customer.getDemandWorkout()))
                    res += 100;
            }
        }

        return res;
    }
}
