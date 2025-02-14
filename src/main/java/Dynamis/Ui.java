package Dynamis;

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
}
