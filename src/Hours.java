public class Hours {
    private final int startHour;
    private final int endHour;

    public Hours(int startHour, int endHour) {
        if (!(startHour >= 0 && startHour <= 24 && endHour >= 0 && endHour <= 24))
            throw new IllegalArgumentException("hours should be between 0 and 24");
        if (startHour >= endHour)
            throw new IllegalArgumentException("hours end hour should be bigger then start hour");
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }
}
