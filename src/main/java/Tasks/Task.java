package Tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Task {
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

    public void setTaskStatus(boolean taskStatus){this.isTaskComplete = taskStatus; }

    public char getTaskType() {
        return taskType;
    }

    public String getTimeline() {
        return timeline;
    }

    public String getTimelineCustom(){
        return timeline;
    }
}
