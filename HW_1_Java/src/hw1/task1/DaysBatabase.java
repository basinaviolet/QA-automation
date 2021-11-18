package main.task1;

public enum DaysBatabase {
    MONDAY (1, "Monday"),
    TUESDAY (2, "Tuesday"),
    WEDNESDAY (3, "Wednesday"),
    THURSDAY (4, "Thursday"),
    FRIDAY (5, "Friday"),
    SATURDAY (6, "Saturday"),
    SUNDAY (7, "Sunday");

    private final int dayNum;
    private final String dayName;

    DaysBatabase(int dayNum, String dayName){
        this.dayNum = dayNum;
        this.dayName = dayName;
    }

    public int getDayNum() {
        return dayNum;
    }

    public String getDayName() {
        return dayName;
    }

    @Override
    public String toString() {
        return dayNum + ": " + dayName + '\'';
    }
}
