package Tasks;

import Tasks.Task;

/**
 * Child class of task that implements a non-timed task called Todo
 */
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

