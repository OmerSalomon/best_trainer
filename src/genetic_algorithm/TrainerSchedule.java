package genetic_algorithm;

import properties.Pair;
import properties.Trainer;
import properties.WorkDay;

public class TrainerSchedule {
    private Trainer trainer;
    private WorkDay[] workWeek;
    public TrainerSchedule(WorkDay[] workWeek) {

    }

    public TrainerSchedule(TrainerSchedule a, TrainerSchedule b){
        if (!a.trainer.equals(b.trainer))
            throw new IllegalArgumentException("Cannot create crossed trainer schedule from trainer schedules with different trainers");
    }

    public void AddPair(Pair pair){

    }
}
