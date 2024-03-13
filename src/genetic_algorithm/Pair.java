package genetic_algorithm;

import properties.Customer;
import properties.Schedule;
import properties.Trainer;
import properties.Workout;

import java.util.ArrayList;

public class Pair{
    private Trainer trainer;
    private Schedule schedule;

    public Pair(Trainer trainer, Schedule schedule) {
        this.trainer = trainer;
        this.schedule = schedule;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public Schedule getSchedule() {
        return schedule;
    }
}
