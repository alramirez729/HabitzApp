import java.time.LocalTime;
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
            System.out.println("Please enter a menu option.\n 1. Create a habit \n 2. Print all the habits in the list \n 3. Edit Habit \n 4. Complete a habit \n 0. Exit");
            selection = input.nextInt();
            input.nextLine(); // Consume newline character after reading int

            if (selection == 1) {
                createHabit(habits);
            } else if (selection == 2) {
                printHabits(habits);
            } else if (selection == 3) {
                editHabit(habits);
            } else if (selection == 4){
                completeHabit(habits);
            }
        }
    }

    public static void createHabit(LinkedList<Habit> habits) {
        Scanner input = new Scanner(System.in);
        String name;
        String description;
        String answer;
        LocalTime time;

        System.out.println("Please enter the name of the habit you'd like to create:");
        name = input.nextLine();

        System.out.println("Please enter a brief description of your habit:");
        description = input.nextLine();

        System.out.println("Would you like to add a timeframe for this habit? ");
        answer = input.nextLine();
        if(answer.equals("y") || answer.equals("yes")){

            System.out.println("Please enter the time for the habit (in HH:MM format):");
            String timeString = input.nextLine();
            time = LocalTime.parse(timeString);
            Habit currHabit = new Habit(name, description, time);
        }
        else{
            // Creates the habit given the user inputs and adds it to the linked list provided
            Habit currHabit = new Habit(name, description);
            habits.add(currHabit);
        }


    }

    public static void printHabits(LinkedList<Habit> habits) {
        for (Habit e : habits) {
            System.out.print("\n" + (habits.indexOf(e) + 1) + ". " + e.getHabitName() + "; Completion status: ");
            if (e.isCompleted()) {
                System.out.print("Completed.\n");
            } else {
                System.out.print("Not completed.\n");
            }
        }
    }
    
    public static void editHabit(LinkedList<Habit> habits) {
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter the name of the habit you want to edit:");
    String habitName = input.nextLine();
    Habit foundHabit = null;

    for (Habit habit : habits) {
        if (habit.getHabitName().equals(habitName)) {
            foundHabit = habit;
            break;
        }
    }

    if (foundHabit == null) {
        System.out.println("Habit not found. Please try again.");
        return;
    }

    System.out.println("Editing habit: " + foundHabit.getHabitName());

    System.out.println("Enter the new name for the habit (or press enter to keep the same):");
    String newName = input.nextLine();
    if (!newName.isEmpty()) {
        foundHabit.setHabitName(newName);
    }

    System.out.println("Enter a new description for the habit (or press enter to keep the same):");
    String newDescription = input.nextLine();
    if (!newDescription.isEmpty()) {
        foundHabit.setDescription(newDescription);
    }

    System.out.println("Enter a new time for the habit in HH:MM format (or press enter to keep the same):");
    String newTime = input.nextLine();
    if (!newTime.isEmpty()) {
        foundHabit.setTime(LocalTime.parse(newTime));
    }
}


    public static void completeHabit(LinkedList<Habit> habits) {
        Scanner input = new Scanner(System.in);
        int exit = 0;

        while (exit != 1) {
            System.out.println("Please enter the name or priority of your habit:");
            String stringSearch = input.nextLine();
            boolean found = false;

            for (Habit e : habits) {
                if (e.getHabitName().equals(stringSearch)) {
                    e.setCompleted(true);
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
