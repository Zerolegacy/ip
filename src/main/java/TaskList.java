import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class TaskList {
    private ArrayList<Task> items;
    String horLine = "----------------------------------------\n";

    TaskList() {
        this.items = new ArrayList<>();
    }

    private static void writeToFile(String filePath, String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(textToAdd);
        fw.close();
    }

    private void saveToFile() {
        String tempStorage = "";
        for (int i = 0; i < items.size(); i++) {
            tempStorage = tempStorage + serialiseTask(items.get(i)) + "\n";
        }
        try {
            writeToFile("./data/dynamis.txt", tempStorage);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public void loadTasks() throws FileNotFoundException {
        File f = new File("./data/dynamis.txt");
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            Task task = deserializeTask(s.nextLine());
            if (task != null) {
                items.add(task);
            }
        }
    }

    private String serialiseTask(Task task) {
        if (task instanceof Todo) {
            return "T | " + (task.isDone() ? "1" : "0") + " | " + task.name;
        } else if (task instanceof Deadline) {
            return "D | " + (task.isDone() ? "1" : "0") + " | " + task.name
                    + " | " + ((Deadline) task).dueBy;
        } else if (task instanceof Event) {
            return "E | " + (task.isDone() ? "1" : "0") + " | " + task.name
                    + " | " + ((Event) task).start + " | " + ((Event) task).end;
        } else {
            return "";
        }
    }

    private Task deserializeTask(String line) {
        String[] parts = line.split(" \\| ");

        Task task = null;
        switch (parts[0]) {
        case "T":
            task = new Todo(parts[2]);
            break;
        case "D":
            task = new Deadline(parts[2], parts[3]);
            break;
        case "E":
            task = new Event(parts[2], parts[3], parts[4]);
            break;
        }
        if (task != null && parts[1].equals("1")) {
            task.editDoneCheck(true);
        }
        return task;
    }


    public void addItem(Task newTask){
        items.add(newTask);
        System.out.println(horLine + "Got it. I've added this task:");
        System.out.println(" " + newTask);
        System.out.println("Now you have " + items.size() + " tasks in the list.\n" + horLine);
        saveToFile();
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
            items.get(taskNumber - 1).editDoneCheck(true);
            System.out.println(horLine + "Nice! I've marked this task as done:\n" + items.get(taskNumber - 1).name + "\n"+ horLine);
            saveToFile();
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void deleteItem(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= items.size()) {
            System.out.println(horLine + "Noted. I've removed this task:");
            System.out.println(" " + items.get(taskNumber -1));
            items.remove(taskNumber -1);
            System.out.println("Now you have " + items.size() + " tasks in the list.\n" + horLine);
            saveToFile();
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
