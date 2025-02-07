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
    public String addItem(Task newTask){
        items.add(newTask);
        return horLine + "Got it. I've added this task:\n"
                + " " + newTask + "\nNow you have " + items.size() + " tasks in the list.\n" + horLine;
    }

    /*
     * Prints the list of tasks in the TaskList Object.
     */
    public String listItems() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            result.append(i + 1).append(". ").append(items.get(i)).append("\n");
        }
        return result.toString();
    }

    /*
     * Marks a task as done.
     *
     * @param taskNumber The list number of the Task.
     */
    public String markItem(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= items.size()) {
            items.get(taskNumber - 1).editDoneCheck(true);
            return horLine + "Nice! I've marked this task as done:\n"
                    + items.get(taskNumber - 1).name + "\n"+ horLine;
        } else {
            return "Invalid task number.";
        }
    }

    /*
     * Deletes a task from the tasklist.
     */
    public String deleteItem(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= items.size()) {
            Task taskToDelete = items.get(taskNumber - 1);
            items.remove(taskNumber - 1);
            return horLine + "Noted. I've removed this task:\n "
                    + taskToDelete + "\n"+ horLine
                    + "\nNow you have " + items.size() + " tasks in the list.\n" + horLine;
        } else {
            return "Invalid task number.";
        }
    }

    public ArrayList<Task> getTasks() {
        return items;
    }

    /*
     * Searches the TaskList for tasks that contains a substring of a given keyword.
     *
     * @param keyword The substring to search for.
     */
    public String findTasks(String keyword) {
        StringBuilder result = new StringBuilder();

        result.append(horLine).append("Here are the matching tasks in your list:\n");
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).name.toLowerCase().contains(keyword.toLowerCase())) {
                result.append(i + 1).append(". ").append(items.get(i)).append("\n");
            }
        }
        result.append("End of search\n").append(horLine);
        return result.toString();
    }
}
