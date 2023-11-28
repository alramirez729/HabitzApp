import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {

        LinkedList<Habit> habits = new LinkedList<>();


        //virtual cottage inspiration
        //ideas: lofi beats application, habits to be checked off.

    }

    public void createHabit(LinkedList<Habit> habits)
    {
        Scanner input = new Scanner(System.in);
        String name;
        String description;
        System.out.println("Please enter the name of the habit you'd like to create.");
        name = input.nextLine();
        System.out.println("Please enter a brief description of your habit.");
        description = input.nextLine();


        //creates the habit given the user inputs, and then adds it to the linked list provided.
        Habit currHabit = new Habit(name, description);
        habits.add(currHabit);
    }

    public void completeHabit(LinkedList<Habit> habits)
    {
        String name = "habit";
        for(int i = 0; i < habits.size(); i++)
        {
            //loop through using the name to find the desired Habit object

        }
    }



}
