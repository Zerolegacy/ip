package Dynamis;

import java.io.IOException;

public class Dynamis {
    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    /*
     * Constructs a new dynamis object and loads previous tasks.
     * Creates new file if does not exist
     *
     * @param filePath The path to the file to load previous tasks from.
     */
    public Dynamis(String filePath) {
        this.ui = new Ui();
        storage = new Storage(filePath);
        storage.initializeFile();
        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (Exception e) {
            tasks = new TaskList();
        }
    }

    /*
     * Handles the main running flow of the program.
     */
    public void run() throws IOException {
        ui.printWelcomeMessage();
        ui.printTaskList(tasks);
        boolean isRunning = true;
        while (isRunning) {
            String input = ui.readInput();
            isRunning = processInput(input);
            storage.saveToFile(tasks.getTasks());
        }
        ui.printGoodbyeMessage();
    }

    public static void main(String[] args) throws IOException {
        new Dynamis("./data/dynamis.txt").run();
    }

    private boolean processInput(String input) {
        if (input.equals("bye")) {
            return false;
        } else if (input.equals("list")) {
            ui.printTaskList(tasks);
        } else if (input.matches("mark \\d+")) { //used regex.com to check regex used.
            int taskNumber = Integer.parseInt(input.split(" ")[1]);
            tasks.markItem(taskNumber);
        } else if (input.startsWith("todo ")) {
            if (!input.substring(5).equals("")) {
                tasks.addItem(new Todo(input.substring(5)));
            } else {
                ui.printToDoError();
            }
        } else if (input.startsWith("deadline ")) {
            String[] parts = input.substring(9).split(" /by ");
            if (parts.length == 2) {
                tasks.addItem(new Deadline(parts[0], parts[1]));
            } else {
                ui.printIncorrectUsageError();
            }
        } else if (input.startsWith("event ")) {
            String[] parts = input.substring(6).split(" /from | /to ");
            if (parts.length == 3) {
                tasks.addItem(new Event(parts[0], parts[1], parts[2]));
            } else {
                ui.printIncorrectUsageError();
            }
        } else if (input.matches("delete \\d+")) {
            int taskNumber = Integer.parseInt(input.split(" ")[1]);
            tasks.deleteItem(taskNumber);
        } else if (input.startsWith("find ")) {
            String keyword = input.substring(5);
            tasks.findTasks(keyword);
        } else {
            System.out.println("Invalid command, please try again.");
        }
        return true;
    }
}
