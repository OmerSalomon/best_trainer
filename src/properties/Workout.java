package properties;

import java.util.List;

public class Workout {
    private String workoutType;
    private String workoutLength;

    public Workout(String workoutType, String workoutLength) {
        this.workoutType = workoutType;
        this.workoutLength = workoutLength;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public String getWorkoutLength() {
        return workoutLength;
    }
}
