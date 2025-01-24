import java.util.Scanner;

public class Dynamis {
    public static void main(String[] args) {
        String horLine = "----------------------------------------\n";
        System.out.println(horLine + "Hello! I'm Dynamis\nWhat can I do for you?\n" + horLine);
        Todo toDoList = new Todo();
        Scanner scanner = new Scanner(System.in);
        String echoInput = scanner.nextLine();
        while (!echoInput.equals("bye")) {
            if (!echoInput.equals("list")) {
                toDoList.addItem(echoInput);
            }
            else {
                toDoList.listItems();
            }
            echoInput = scanner.nextLine();
        }
        System.out.println(horLine + "Bye. Hope to see you again soon!\n" + horLine);
    }
}
