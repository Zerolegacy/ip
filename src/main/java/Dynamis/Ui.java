package Dynamis;

import java.util.Scanner;

public class Ui {
    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    String horLine = "----------------------------------------\n";
    public void printWelcomeMessage() {
        System.out.println(horLine + "Hello! I'm Dynamis.Dynamis\nWhat can I do for you?\n" + horLine);
    }

    public void printGoodbyeMessage() {
        System.out.println(horLine + "Bye. Hope to see you again soon!\n" + horLine);
    }

    public String readInput() {
        return scanner.nextLine();
    }

    public void printTaskList(TaskList taskList) {
        taskList.listItems();
    }

    public void printToDoError() {
        System.out.println("No name detected! Please enter the name of your task!");
    }

    public void printIncorrectUsageError() {
        System.out.println("Incorrect usage! Please try again!");
    }
}
