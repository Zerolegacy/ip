public class Task {
    private Boolean doneCheck;
    private String name;

    Task(String name) {
        this.doneCheck = false;
        this.name = name;
    }

    Task(Boolean doneCheck, String name) {
        this.doneCheck = doneCheck;
        this.name = name;
    }

    public Task editDoneCheck(Boolean doneCheck) {
        return new Task(doneCheck, this.name);
    }

    @Override
    public String toString() {
        if (doneCheck) {
            return "[X] " + name;
        }
        else {
            return "[ ] " + name;
        }
    }
}
