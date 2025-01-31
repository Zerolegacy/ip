package Dynamis;

public abstract class Task {
    protected Boolean doneCheck;
    protected String name;

    Task(String name) {
        this.doneCheck = false;
        this.name = name;
    }

    /*
     * Edits the doneCheck property.
     *
     * @param doneCheck the boolean value to change to.
     */
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
