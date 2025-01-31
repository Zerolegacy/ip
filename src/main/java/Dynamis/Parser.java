package Dynamis;

public class Parser {
    public String serialiseTask(Task task) {
        if (task instanceof Todo) {
            return "T | " + (task.isDone() ? "1" : "0") + " | " + task.name;
        } else if (task instanceof Deadline) {
            return "D | " + (task.isDone() ? "1" : "0") + " | " + task.name
                    + " | " + ((Deadline) task).dueBy;
        } else if (task instanceof Event) {
            return "E | " + (task.isDone() ? "1" : "0") + " | " + task.name
                    + " | " + ((Event) task).start + " | " + ((Event) task).end;
        } else {
            return "";
        }
    }

    public Task deserializeTask(String line) {
        String[] parts = line.split(" \\| ");

        Task task = null;
        switch (parts[0]) {
            case "T":
                task = new Todo(parts[2]);
                break;
            case "D":
                task = new Deadline(parts[2], parts[3]);
                break;
            case "E":
                task = new Event(parts[2], parts[3], parts[4]);
                break;
        }
        if (task != null && parts[1].equals("1")) {
            task.editDoneCheck(true);
        }
        return task;
    }
}
