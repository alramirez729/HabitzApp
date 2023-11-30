public class Habit {
    String habitName;
    String description;
    boolean completed = false;

    //above are the qualities that the habit should have so far:
    // {name of habit, description of habit, whether it's been done}

    public Habit(String habitName, String  description)
    {
        this.habitName = habitName;
        this.description = description;
    }

    public String getHabitName(){
        return habitName;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public String getDescription(){
        return description;
    }


    public void complete(){
        completed = true;
    }
}
