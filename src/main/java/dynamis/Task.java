package dynamis;

public abstract class Task {
    protected Boolean isDone;
    protected String name;

    Task(String name) {
        this.isDone = false;
        this.name = name;
    }

    /*
     * Edits the isDone property.
     *
     * @param isDone the boolean value to change to.
     */
    public void editIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public boolean checkIfDone() {
        return this.isDone;
    }

    @Override
    public String toString() {
        if (isDone) {
            return "[X] " + name;
        } else {
            return "[ ] " + name;
        }
    }
}
