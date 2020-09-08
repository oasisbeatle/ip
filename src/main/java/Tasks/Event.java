package Tasks;

import Tasks.Task;

public class Event extends Task {
    protected boolean isTaskComplete;
    protected char taskType;
    protected String timeline;

    public Event(String taskName, String deadline) {
        super(taskName);
        this.taskType = 'E';
        this.timeline = deadline;
    }


    public char getTaskType() {
        return taskType;
    }

    public String getTimeline() {
        return timeline;
    }
}
