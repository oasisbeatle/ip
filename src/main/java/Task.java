import sun.tools.tree.BooleanExpression;

public class Task {
    private static char taskType;
    private static boolean isTaskComplete;
    private static String taskName;
    private static int totalTasks = 0;
    private static String timeFrame;

    public Task(char taskType, boolean isTaskComplete, String taskName, String timeFrame){
        Task.taskType = taskType;
        Task.isTaskComplete = false;
        Task.taskName = taskName;
        Task.timeFrame = timeFrame;
        totalTasks++;
    }

    public static String getTaskName() {
        return taskName;
    }

    public static char getTaskType() {
        return taskType;
    }

    public static String getTimeFrame() {
        return timeFrame;
    }

    public static boolean isTaskComplete() {
        return isTaskComplete;
    }

    public static void setIsTaskComplete(boolean isTaskComplete) {
        Task.isTaskComplete = isTaskComplete;
    }

    public static int getTotalTasks() {
        return totalTasks;
    }
}
