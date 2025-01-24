import java.util.Scanner;

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
                taskList.addItem(new Todo(input.substring(5)));
            } else if (input.startsWith("deadline ")) {
                String[] parts = input.substring(9).split(" /by ");
                taskList.addItem(new Deadline(parts[0], parts[1]));
            } else if (input.startsWith("event ")) {
                String[] parts = input.substring(6).split(" /from | /to ");
                taskList.addItem(new Event(parts[0], parts[1], parts[2]));
            }
            input = scanner.nextLine();
        }
        scanner.close();
        System.out.println(horLine + "Bye. Hope to see you again soon!\n" + horLine);
    }
}
