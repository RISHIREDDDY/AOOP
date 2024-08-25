package Six_A;
import java.util.*;
public class Main_ToDoList {
    public static void main(String[] args) {
        ToDoList todolist = new ToDoList();
        Scanner obj = new Scanner(System.in);
        String choice = "";

        while (!choice.equalsIgnoreCase("exit")) {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Display Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option (add/update/remove/display/exit): ");
            choice = obj.nextLine();

            if (choice.equalsIgnoreCase("add")) {
                System.out.println("Enter task to add:");
                String taskAdd = obj.nextLine();
                todolist.add(taskAdd);
            } else if (choice.equalsIgnoreCase("update")) {
                System.out.println("Enter the index of the task to update:");
                int indexToUpdate = obj.nextInt() - 1;
                obj.nextLine();
                System.out.println("Enter the new task description:");
                String newTaskUpdate = obj.nextLine();
                todolist.update(indexToUpdate, newTaskUpdate);
            } else if (choice.equalsIgnoreCase("remove")) {
                System.out.println("Enter the index of the task to remove:");
                int indexToRemove = obj.nextInt() - 1;
                obj.nextLine(); 
                todolist.remove(indexToRemove);
            } else if (choice.equalsIgnoreCase("display")) {
                todolist.display();
            } else if (choice.equalsIgnoreCase("exit")) {
                System.out.println("You have exited the TO-DO LIST.");
            } else {
                System.out.println("Please enter a valid option!");
            }
        }
    }
}
