package Dynamis;

import java.io.IOException;

public class Dynamis {
    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    private static final String STORAGE_FILE_PATH = "./data/dynamis.txt";
    private static final int DEADLINE_PARTS = 2;
    private static final int EVENT_PARTS = 3;

    /*ß
     * Constructs a new dynamis object and loads previous tasks.
     * Creates new file if does not exist
     *
     * @param filePath The path to the file to load previous tasks from.
     */
    public Dynamis() {
        this.ui = new Ui();
        storage = new Storage(STORAGE_FILE_PATH);
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
            isRunning = true;
            storage.saveToFile(tasks.getTasks());
        }
        ui.printGoodbyeMessage();
    }

    public static void main(String[] args) throws IOException {
        new Dynamis().run();
    }

    private String processInput(String input) {
        if (input.equals("bye")) {
            return "Bye";
        } else if (input.equals("help")) {
            return ui.printHelpMessage();
        } else if (input.equals("list")) {
            return ui.printTaskList(tasks);
        } else if (input.matches("mark \\d+")) { //used regex.com to check regex used.
            int taskNumber = Integer.parseInt(input.split(" ")[1]);
            return tasks.markItem(taskNumber);
        } else if (input.startsWith("todo ")) {
            if (!input.substring(5).equals("")) {
                return tasks.addItem(new Todo(input.substring(5)));
            } else {
                return ui.printToDoError();
            }
        } else if (input.startsWith("deadline ")) {
            String[] parts = input.substring(9).split(" /by ");
            assert(parts.length >= 0);
            if (parts.length == DEADLINE_PARTS) {
                return tasks.addItem(new Deadline(parts[0], parts[1]));
            } else {
                return ui.printIncorrectUsageError();
            }
        } else if (input.startsWith("event ")) {
            String[] parts = input.substring(6).split(" /from | /to ");
            assert(parts.length >= 0);
            if (parts.length == EVENT_PARTS) {
                return tasks.addItem(new Event(parts[0], parts[1], parts[2]));
            } else {
                return ui.printIncorrectUsageError();
            }
        } else if (input.matches("delete \\d+")) {
            int taskNumber = Integer.parseInt(input.split(" ")[1]);
            return tasks.deleteItem(taskNumber);
        } else if (input.startsWith("find ")) {
            assert(input.length() > 5);
            String keyword = input.substring(5);
            return tasks.findTasks(keyword);
        } else {
            return "Invalid command, please try again.";
        }
    }

    public String getResponse(String input) {
        try {
            storage.saveToFile(tasks.getTasks());
        } catch (Exception e) {
            System.out.println(e);
        }
        return processInput(input);
    }
}
