package properties;

import java.util.HashMap;
import java.util.Map;

public class WorkDay {

    Map<Customer, Workout> customerWorkoutMap;
    public WorkDay() {
        customerWorkoutMap = new HashMap<>();
    }
    int getTotalWorkTime(){
        return 0;
    }
}
