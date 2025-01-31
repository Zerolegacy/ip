package Dynamis;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> items;
    String horLine = "----------------------------------------\n";

    TaskList() {
        this.items = new ArrayList<>();
    }

    TaskList(ArrayList<Task> items) {
        this.items = items;
    }

    /*
     * Adds a new task to the TaskList object.
     *
     * @param newTask The task to add.
     */
    public void addItem(Task newTask){
        items.add(newTask);
        System.out.println(horLine + "Got it. I've added this task:");
        System.out.println(" " + newTask);
        System.out.println("Now you have " + items.size() + " tasks in the list.\n" + horLine);
    }

    /*
     * Prints the list of tasks in the TaskList Object.
     */
    public void listItems() {
        System.out.println(horLine);
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
        System.out.println(horLine);
    }

    /*
     * Marks a task as done.
     *
     * @param taskNumber The list number of the Task.
     */
    public void markItem(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= items.size()) {
            items.get(taskNumber - 1).editDoneCheck(true);
            System.out.println(horLine + "Nice! I've marked this task as done:\n"
                    + items.get(taskNumber - 1).name + "\n"+ horLine);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    /*
     * Deletes a task from the tasklist.
     */
    public void deleteItem(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= items.size()) {
            System.out.println(horLine + "Noted. I've removed this task:");
            System.out.println(" " + items.get(taskNumber - 1));
            items.remove(taskNumber - 1);
            System.out.println("Now you have " + items.size() + " tasks in the list.\n" + horLine);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public ArrayList<Task> getTasks() {
        return items;
    }
}
