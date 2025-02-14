package Dynamis;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task{
    protected LocalDate dueBy;
    protected String dueByString;

    /*
     * Constructs a Deadline Object. A type of task for the tasklist.
     *
     * @param name The name or description of the task.
     * @param dueBy The due date of the task.
     */
    public Deadline(String name, String dueBy) {
        super(name);
        try {
            this.dueBy = LocalDate.parse(dueBy);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format");
            this.dueBy = null;
            this.dueByString = dueBy;
        }
    }

    @Override
    public String toString() {
        if (dueBy != null) {
            return "[D]" + super.toString() + " (by: "
                    + dueBy.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
        } else {
            return "[D]" + super.toString() + " (by: " + dueByString + ")";
        }
    }
}
