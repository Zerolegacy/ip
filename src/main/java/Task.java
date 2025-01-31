public abstract class Task {
    protected Boolean doneCheck;
    protected String name;

    Task(String name) {
        this.doneCheck = false;
        this.name = name;
    }

    public void editDoneCheck(Boolean doneCheck) {
        this.doneCheck = doneCheck;
    }

    public boolean isDone() {
        return this.doneCheck;
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
