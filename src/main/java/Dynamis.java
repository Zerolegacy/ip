import java.util.Scanner;

//used regex.com to check regex used.
public class Dynamis {
    public static void main(String[] args) {
        String horLine = "----------------------------------------\n";
        System.out.println(horLine + "Hello! I'm Dynamis\nWhat can I do for you?\n" + horLine);
        TaskList taskList = new TaskList();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                taskList.listItems();
            } else if (input.matches("mark \\d+")) {
                int taskNumber = Integer.parseInt(input.split(" ")[1]);
                taskList.markItem(taskNumber);
            } else if (input.startsWith("todo ")) {
                if (!input.substring(5).equals("")) {
                    taskList.addItem(new Todo(input.substring(5)));
                } else {
                    System.out.println("No name detected! Please enter the name of your task!");
                }
            } else if (input.startsWith("deadline ")) {
                String[] parts = input.substring(9).split(" /by ");
                if (parts.length == 2) {
                    taskList.addItem(new Deadline(parts[0], parts[1]));
                } else {
                    System.out.println("Incorrect usage. Please Try again.");
                }
            } else if (input.startsWith("event ")) {
                String[] parts = input.substring(6).split(" /from | /to ");
                if (parts.length == 3) {
                    taskList.addItem(new Event(parts[0], parts[1], parts[2]));
                } else {
                    System.out.println("Incorrect usage. Please Try again.");
                }
            } else if (input.matches("delete \\d+")) {
                int taskNumber = Integer.parseInt(input.split(" ")[1]);
                taskList.deleteItem(taskNumber);
            } else {
                System.out.println("Invalid command, please try again.");
            }
            input = scanner.nextLine();
        }
        scanner.close();
        System.out.println(horLine + "Bye. Hope to see you again soon!\n" + horLine);
    }
}
