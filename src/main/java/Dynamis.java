import java.util.Scanner;

public class Dynamis {
    public static void main(String[] args) {
        String horLine = "----------------------------------------\n";
        System.out.println(horLine + "Hello! I'm Dynamis\nWhat can I do for you?\n" + horLine);

        Scanner scanner = new Scanner(System.in);
        String echoInput = scanner.nextLine();
        while (!echoInput.equals("bye")) {
            System.out.println(horLine + echoInput + "\n" + horLine);
            echoInput = scanner.nextLine();
        }
        System.out.println(horLine + "Bye. Hope to see you again soon!\n" + horLine);
    }
}
