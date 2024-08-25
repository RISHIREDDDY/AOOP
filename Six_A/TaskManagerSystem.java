package Six_A;
import java.util.ArrayList;
public class TaskManagerSystem {
    public static void main(String[] args)
    {
        ArrayList<String> task = new ArrayList<>();
        task.add("task1");
        task.add("task2");
        task.add("task3");
        task.add("task4");

        task.remove("task2"); //remove
        task.add("task5"); //update
        System.out.println(task);// display
        for(String itr:task) //display with iterator
        {
        System.out.println(itr);
        }

    }
}
