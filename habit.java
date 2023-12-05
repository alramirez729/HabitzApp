import java.time.LocalTime;

public class Habit {
    private String habitName;
    private String description;
    private boolean completed = false;
    private LocalTime time;

    public Habit(String habitName, String description, LocalTime time) {
        this.habitName = habitName;
        this.description = description;
        this.time = time;
    }

    public Habit(String habitName, String description){
        this.habitName = habitName;
        this.description = description;
        this.time = null;
    }

    public String getHabitName() {
        return habitName;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
