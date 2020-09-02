public class Todo extends Task {
    protected char taskType;

    public Todo(String taskName) {
        super(taskName);
        this.taskType = 'T';
    }

    public char getTaskType() {
        return taskType;
    }
}

