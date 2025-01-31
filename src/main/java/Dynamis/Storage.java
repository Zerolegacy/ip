package Dynamis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void initializeFile() {
        try {
            File f = new File(this.filePath);
            if (!f.exists()) {
                f.getParentFile().mkdirs();
                f.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    private static void writeToFile(String filePath, String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(textToAdd);
        fw.close();
    }

    public void saveToFile(ArrayList<Task> tasks) throws IOException {
        String tempStorage = "";
        Parser parser = new Parser();
        for (int i = 0; i < tasks.size(); i++) {
            tempStorage = tempStorage + parser.serialiseTask(tasks.get(i)) + "\n";
        }
        try {
            writeToFile(this.filePath, tempStorage);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public ArrayList<Task> loadTasks() throws FileNotFoundException {
        ArrayList<Task> tasks = new ArrayList<>();
        File f = new File(this.filePath);
        Scanner s = new Scanner(f);
        Parser parser = new Parser();
        while (s.hasNext()) {
            Task task = parser.deserializeTask(s.nextLine());
            if (task != null) {
                tasks.add(task);
            }
        }
        return tasks;
    }
}
