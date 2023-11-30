import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<Habit> habits = new LinkedList<>();

        // Thread for running the GUI
        Thread guiThread = new Thread(() -> {
            HabitsGUI gui = new HabitsGUI(habits);
            gui.setVisible(true);
        });
        guiThread.start();

        Scanner input = new Scanner(System.in);
        int selection = -1;

        while (selection != 0) {
            System.out.println("Please enter a menu option.\n 1. Create a habit \n 2. Print all the habits in the list \n 3. Complete a habit.\n 0. Exit");
            selection = input.nextInt();
            input.nextLine(); // Consume newline character after reading int

            if (selection == 1) {
                createHabit(habits);
            } else if (selection == 2) {
                printHabits(habits);
            } else if (selection == 3) {
                completeHabit(habits);
            }
        }
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

    public static void completeHabit(LinkedList<Habit> habits) {
        Scanner input = new Scanner(System.in);
        int exit = 0;

        while (exit != 1) {
            System.out.println("Please enter the name or priority of your habit");
            String stringSearch = input.nextLine();
            boolean found = false;

            for (Habit e : habits) {
                if (e.habitName.equals(stringSearch)) {
                    e.complete();
                    found = true;
                    exit = 1;
                    break; // Exit loop if habit is found and completed
                }
            }

            if (!found) {
                System.out.println("Could not find the habit you were looking for. Please try again.");
            }
        }
    }

}
