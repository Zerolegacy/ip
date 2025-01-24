import java.util.ArrayList;

public class Todo {
    private ArrayList<Task> items;
    String horLine = "----------------------------------------\n";

    Todo() {
        this.items = new ArrayList<>();
    }

    public void addItem(String item){
        Task newTask = new Task(item);
        items.add(newTask);
        System.out.println(horLine + "added: " + newTask + "\n" +horLine);
    }

    public void listItems() {
        System.out.println(horLine);
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
        System.out.println(horLine);
    }

    public void markItem(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= items.size()) {
            Task newTask = items.get(taskNumber - 1).editDoneCheck(true);
            items.set(taskNumber - 1, newTask);
            System.out.println(horLine + "Nice! I've marked this task as done:\n" + newTask + "\n"+ horLine);
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
