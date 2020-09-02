public class Deadline extends Task{
    protected boolean isTaskComplete;
    protected char taskType;
    protected String timeline;

    public Deadline(String taskName, String timeline) {
        super(taskName);
        this.taskType = 'D';
        this.timeline = timeline;
    }

    public char getTaskType() {
        return taskType;
    }

    public String getTimeline() {
        return timeline;
    }
}
