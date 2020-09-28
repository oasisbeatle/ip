package Tasks;

import Tasks.Task;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Events are tasks with a time to attend at.
 * Child class of task
 */
public class Event extends Task {
    protected boolean isTaskComplete;
    protected char taskType;
    protected LocalDateTime timeline;

    public Event(String taskName, String timeline) {
        super(taskName);
        this.taskType = 'E';
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
