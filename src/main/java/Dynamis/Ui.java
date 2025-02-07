package Dynamis;

import java.util.Scanner;

public class Ui {
    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    String horLine = "----------------------------------------\n";
    public String printWelcomeMessage() {
        return horLine + "Hello! I'm Dynamis.\nWhat can I do for you?\n" + horLine;
    }

    public String printGoodbyeMessage() {
        return horLine + "Bye. Hope to see you again soon!\n" + horLine;
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
