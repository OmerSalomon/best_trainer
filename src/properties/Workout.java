package properties;

public class Workout {
    private String type;
    private int minutes;

    public Workout(String type, int minutes) {
        this.type = type;
        this.minutes = minutes;
    }

    public String getType() {
        return type;
    }

    public int getMinutes() {

        return minutes;
    }

    @Override
    public String toString() {
        return  getType();
    }
}
