import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        int selection = -1;
        Scanner input = new Scanner(System.in);

        //creating list of habits
        LinkedList<Habit> habits = new LinkedList<>();


        while(selection != 0)
        {
            System.out.println("Please enter a menu option.\n 1. Create a habit \n 2. Print all the habits in the list \n 3. Complete a habit.\n0. Exit");
            selection = input.nextInt();
            if(selection == 1)
            {
                createHabit(habits);
            }
            if(selection == 2){
                printHabits(habits);
            }
            if(selection == 3){
                completeHabit(habits);
            }
        }
        //virtual cottage inspiration
        //ideas: lofi beats application, habits to be checked off.

    }

    public static void createHabit(LinkedList<Habit> habits)
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

    public static void printHabits(LinkedList<Habit> habits)
    {
        for(Habit e : habits){
            System.out.print("\n" + (habits.indexOf(e)+ 1) + ". "+ e.habitName + "; Completion status: ");
            if(e.completed){
                System.out.print("Completed.\n");
            }
            else{
                System.out.print("Not completed.\n");
            }
        }
    }

    public static void completeHabit(LinkedList<Habit> habits)
    {
        int exit = 0;
        while(exit != 1){
            System.out.println("Please enter the name or priority of your habit");
            Scanner input = new Scanner(System.in);
           // int numSearch = input.nextInt();
            String stringSearch = input.nextLine();
            for(Habit e : habits)
            {
                if(e.habitName.equals(stringSearch)) //add a way to see whether the user is searching for the habit via name or via index " || habits.get(numSearch).equals(e) "
                {
                    e.complete();
                    exit = 1;
                    return;
                }
                else{
                    System.out.println("Could not find the habit you were looking for please try again.");
                }
            }

        }
    }



}
