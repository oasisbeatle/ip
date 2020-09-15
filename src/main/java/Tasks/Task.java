package Tasks;

import sun.tools.tree.BooleanExpression;

public class Task {
    protected String taskName;
    protected boolean isTaskComplete;
    protected char taskType;
    protected String timeline;

    public Task(String taskName){
        this.taskName = taskName;
        this.isTaskComplete = false;
        this.taskType = ' ';
    }

    public String getTaskName() {
        return taskName;
    }

    public boolean isTaskComplete() {
        return isTaskComplete;
    }

    public void setTaskComplete() {
        this.isTaskComplete = true;
    }

    public char getTaskType() {
        return taskType;
    }

    public String getTimeline() {
        return timeline;
    }
}
