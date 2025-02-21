package dynamis;

import java.util.Scanner;

public class Ui {
    private final Scanner scanner;
    private final static String HORIZONTAL_LINE = "----------------------------------------\n";

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public String printWelcomeMessage() {
        return HORIZONTAL_LINE + "Hello! I'm Dynamis.\nWhat can I do for you?\n"
                + HORIZONTAL_LINE;
    }

    public String printGoodbyeMessage() {
        return HORIZONTAL_LINE + "Bye. Hope to see you again soon!\n"
                + HORIZONTAL_LINE;
    }

    public String readInput() {
        return scanner.nextLine();
    }

    public String printTaskList(TaskList taskList) {
        return taskList.listItems();
    }

    public String printToDoError() {
        return "No name detected! Please enter the name of your task!";
    }

    public String printIncorrectUsageError() {
        return "Incorrect usage! Please try again!";
    }

    public String printHelpMessage() {
        return HORIZONTAL_LINE +
                "Dynamis - Here are the available commands:\n" +
                "  todo <task>               - Adds a to-do task\n" +
                "  deadline <task> /by <yyyy-MM-dd> - Adds a deadline\n" +
                "  event <task> /from <start> /to <end> - Adds an event\n" +
                "  list                      - Lists all tasks\n" +
                "  mark <task_number>        - Marks a task as done\n" +
                "  remove <task_number>      - Removes a task\n" +
                "  find <keyword>            - Searches for tasks containing the keyword\n" +
                "  help                      - Shows this help message\n" +
                "  bye                       - Exits the program\n" +
                HORIZONTAL_LINE;
    }
}
