package Tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Deadline is a task with a time by which it has to be completed.
 * Child class of task
 */
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


    /**
     * Gets the time in format to output to user
     * @return timeline
     */
    public String getTimeline() {
        return timeline.format(DateTimeFormatter.ofPattern("MMM dd yyyy 'at' HH:mm"));
    }


    /**
     * Gets the time in input format to save to file
     * @return timeline
     */
    public String getTimelineCustom(){
        return timeline.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
}
