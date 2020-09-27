package Tasks;

import Tasks.Task;

public class Todo extends Task {
    protected char taskType;
    protected String timeline;

    public Todo(String taskName) {
        super(taskName);
        this.taskType = 'T';
        this.timeline = " ";
    }

    public char getTaskType() {
        return taskType;
    }

}

