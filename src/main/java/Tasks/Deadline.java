package Tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Deadline extends Task {
    protected boolean isTaskComplete;
    protected char taskType;
    protected LocalDateTime timeline;

    public Deadline(String taskName, String timeline) {
        super(taskName);
        this.taskType = 'D';
        this.timeline = LocalDateTime.parse(timeline, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }

    public char getTaskType() {
        return taskType;
    }

    public String getTimeline() {
        return timeline.format(DateTimeFormatter.ofPattern("MMM dd yyyy 'at' HH:mm"));
    }

    public String getTimelineCustom(){
        return timeline.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
}
