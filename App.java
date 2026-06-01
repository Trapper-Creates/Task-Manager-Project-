import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class App {
    public static void main(String[] args) {

        // Create an ArrayList to store tasks
        ArrayList<String> tasks = new ArrayList<>();
        

        try ( // Create a Scanner to read user input
                Scanner Input = new Scanner(System.in)) {
            System.out.println("Welcome to the Task Manager!");
            System.out.println("You can add tasks by typing them in, remove tasks by typing 'remove', list all tasks by typing 'list', or exit the program by typing 'exit'.");
            //main loop to continuously read user input until "exit" is entered
            while (true) {
                
                String Task = Input.nextLine();
                // Check if the user wants to remove a task
                if(Task.equalsIgnoreCase("remove")){
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to remove.");
                        continue; // Skip the rest of the loop and wait for the next input
                    }
                    
                    System.out.println("What task would you like to remove?");
                    String removedTask = Input.nextLine();
                    
                    // Check if the task exists before trying to remove it to avoid errors
                    if(tasks.contains(removedTask)){
                        // If the task exists, remove it and inform the user
                        tasks.remove(removedTask);
                        System.out.println("Task removed: " + removedTask);
                        
                    }
                    // If the task doesn't exist, inform the user
                    else {
                        System.out.println("Task not found.");
                    }
                }
                //simple if statement to check if the user wants to exit the program, if so break the loop and end the program
                else  if (Task.equalsIgnoreCase("exit")) {
                    System.out.println("Are you sure you want to exit? (yes/no)");
                    String confirmation = Input.nextLine();
                    if (confirmation.equalsIgnoreCase("yes")) {
                        System.out.println("Thanks for using the Task Manager!");
                        break;
                    }
                }
                // Check if the user wants to list all tasks
                else if (Task.equalsIgnoreCase("list")) {
                    System.out.println("Current tasks:");
                        List<String> SortedTasks = tasks.stream().sorted(Comparator.comparing(item -> item.toLowerCase())).collect(Collectors.toList());
                    SortedTasks.forEach(t -> System.out.println("- " + t));
                    //add the task to the list if it's not a command and inform the user
                } else {
                    tasks.add(Task);
                    System.out.println("Task added: " + Task);
                    System.out.println("Current tasks:");
                    //sort the tasks alphabetically and print them out
                    List<String> SortedTasks = tasks.stream().sorted(Comparator.comparing(item -> item.toLowerCase())).collect(Collectors.toList());
                    SortedTasks.forEach(t -> System.out.println("- " + t));
                    //for (String t : tasks) {
                    //    System.out.println("- " + t);
                    //}
                    
                }
            }       } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            }
}
}
