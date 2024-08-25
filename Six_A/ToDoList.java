package Six_A;
import java.util.ArrayList;

public class ToDoList {
    private ArrayList<String> tasks;

    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    public void add(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void update(int serial_no, String newTask) {
        if (serial_no > 0 && serial_no <= tasks.size()) {
            tasks.set(serial_no - 1, newTask);
            System.out.println("Task at serial number " + serial_no + " updated to: " + newTask);
        } else {
            System.out.println("Invalid serial number. Please try again.");
        }
    }

    public void remove(int serial_no) {
        if (serial_no > 0 && serial_no <= tasks.size()) {
            String removedTask = tasks.remove(serial_no - 1); 
            System.out.println("Removed task: " + removedTask);
        } else {
            System.out.println("Invalid serial number Please try again.");
        }
    }

    public void display() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks assigned yet.");
        } /* {
            System.out.println("TO-DO LIST:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }*/
        else{
            for(String TASKS:tasks)
            {
                System.out.println(TASKS);
            }
        }
    }
}
