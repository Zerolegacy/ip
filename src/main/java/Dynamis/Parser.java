package Dynamis;

public class Parser {

    /*
     * Converts a Task Object to a presentable String. Used to output List of Tasks.
     *
     * @param task The task to convert to string.
     * @return The presentable string format for the task.
     */
    public String serialiseTask(Task task) {
        if (task instanceof Todo) {
            return "T | " + (task.checkIfDone() ? "1" : "0") + " | " + task.name;
        } else if (task instanceof Deadline) {
            return "D | " + (task.checkIfDone() ? "1" : "0") + " | " + task.name
                    + " | " + ((Deadline) task).dueBy;
        } else if (task instanceof Event) {
            return "E | " + (task.checkIfDone() ? "1" : "0") + " | " + task.name
                    + " | " + ((Event) task).start + " | " + ((Event) task).end;
        } else {
            return "";
        }
    }

    /*
     * Converts the presentable string format of a task back to a Task object.
     *
     * @param line The string formatted version of a task.
     * @returns the task converted from the given string.
     */
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
            task.editIsDone(true);
        }
        return task;
    }
}
