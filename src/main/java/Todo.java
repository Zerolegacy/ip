import java.util.ArrayList;

public class Todo {
    private ArrayList<String> items;
    String horLine = "----------------------------------------\n";

    Todo() {
        items = new ArrayList<>();
    }

    public void addItem(String item){
        items.add(item);
        System.out.println(horLine + "added: " + item + "\n" +horLine);
    }

    public void listItems() {
        System.out.println(horLine);
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
        System.out.println(horLine);
    }
}
