package properties;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.List;

public class Schedule {
    private EnumMap<DayOfWeek, List<Trainer>> workWeek;

    public Schedule() {
        // Correctly initialize the EnumMap with DayOfWeek as the key type
        workWeek = new EnumMap<>(DayOfWeek.class);
    }
}
