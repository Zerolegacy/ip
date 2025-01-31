import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    protected String startString;
    protected String endString;
    protected LocalDate start;
    protected LocalDate end;

    public Event(String name, String start, String end) {
        super(name);
        try {
            this.start = LocalDate.parse(start);
        } catch (DateTimeParseException e) {
            this.start = null;
            this.startString = start;
        }
        try {
            this.end = LocalDate.parse(end);
        } catch (DateTimeParseException e) {
            this.end = null;
            this.endString = end;
        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: "
                + (start != null ? start.format(DateTimeFormatter.ofPattern("MMM d yyyy")) : startString) + " to: "
                + (end != null ? end.format(DateTimeFormatter.ofPattern("MMM d yyyy")) : endString) + ")";
    }
}
