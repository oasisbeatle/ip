package ui;

import Tasks.Task;
import Messages.Messages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * TextUI class handles interactions with user
 */
public class TextUi {


    /**
     * Outputs the initialisation of Donald
     * @return
     */
    public static String initDonald(){
        System.out.println("Hello from\n" + Messages.DONALD_ICON);
        System.out.println(Messages.LINE_ICON);
        System.out.println(Messages.INTRO_MESSAGE);
        System.out.println(Messages.WHAT_MESSAGE);
        System.out.println(Messages.LINE_ICON);
        return Messages.LINE_ICON;
    }


    /**
     * Outputs the termination of Donald
     */
    public static void printBye() {
        System.out.println(Messages.LINE_ICON);
        System.out.println(Messages.BYE_MESSAGE);
        System.out.println(Messages.LINE_ICON);
        System.out.println(Messages.BYE_ICON);
    }


    /**
     * Displays a Todo task when added
     * @param commandSubject the subject of the command entered
     * @param taskCompletionStatus task completion status symbol
     * @param totalTasks number of tasks in the list
     * @param taskType type of task i.e. D, T or E
     */
    public static void displayToDo(String commandSubject, String taskCompletionStatus,
                                   int totalTasks, char taskType) {
        System.out.println(Messages.LINE_ICON);
        System.out.println(Messages.TASK_ADDED_MESSAGE);
        System.out.println(" [" + taskType + "] [" + taskCompletionStatus + "] " + commandSubject);
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
        System.out.println(Messages.LINE_ICON);
    }


    /**
     * Displays a timed task i.e. events and deadlines when added
     * @param commandSubject the subject of the command entered
     * @param taskCompletionStatus task completion status symbol
     * @param totalTasks number of tasks in the list
     * @param taskType type of task i.e. D, T or E
     * @param timeline time data of a task
     */
    public static void displayToDoWithTime(String commandSubject, String taskCompletionStatus,
                                           int totalTasks, char taskType, String timeline) {
        LocalDateTime time;
        time = LocalDateTime.parse(timeline, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        String adverb;
        adverb = (taskType == 'D')? "by: " : "at: ";
        System.out.println(Messages.LINE_ICON);
        System.out.println(Messages.TASK_ADDED_MESSAGE);
        System.out.println(" [" + taskType + "] [" + taskCompletionStatus + "] "+ commandSubject + " (" + adverb +
                time.format(DateTimeFormatter.ofPattern("MMM dd yyyy 'at' HH:mm")) + ")");
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
        System.out.println(Messages.LINE_ICON);
    }


    /**
     * Display the Todo task when deleted
     * @param commandSubject the subject of the command entered
     * @param taskCompletionStatus task completion status symbol
     * @param totalTasks number of tasks in the list
     * @param taskType type of task
     */
    public static void displayDeleteTodo(String commandSubject, String taskCompletionStatus,
                                         int totalTasks, char taskType) {
        System.out.println(Messages.LINE_ICON);
        System.out.println(Messages.TASK_REMOVED_MESSAGE);
        System.out.println(" [" + taskType + "] [" + taskCompletionStatus + "] " + commandSubject);
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
        System.out.println(Messages.LINE_ICON);
    }


    /**
     * Display timed tasks i.e. Deadlines and Events when deleted
     * @param commandSubject the subject of the command entered
     * @param taskCompletionStatus task completion status symbol
     * @param totalTasks number of tasks in the list
     * @param taskType type of task
     */
    public static void displayDeletedTodoWithTime(String commandSubject, String taskCompletionStatus,
                                                  int totalTasks, char taskType, String timeline) {
        String adverb;
        adverb = (taskType == 'D')? "by:" : "at:";
        System.out.println(Messages.LINE_ICON);
        System.out.println(Messages.TASK_REMOVED_MESSAGE);
        System.out.println(" [" + taskType + "] [" + taskCompletionStatus + "] "+ commandSubject + " (" + adverb +
                timeline + ")");
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
        System.out.println(Messages.LINE_ICON);
    }

    /**
     * Displays the individual task when it is marked done
     * @param taskList list of tasks
     * @param taskNum task number to be printed as done
     * @param taskStatus task completion status symbol
     */
    public static void printDoneTask(ArrayList<Task> taskList, int taskNum, String taskStatus) {
        System.out.println(Messages.LINE_ICON);
        System.out.println(Messages.TASK_DONE_MESSAGE);
        if(taskList.get(taskNum).getTaskType() == 'T'){
            System.out.println( (taskNum +1) + ".["  + taskList.get(taskNum).getTaskType() + "] [" +
                    taskStatus + "] "+
                    taskList.get(taskNum).getTaskName());
        } else{
            String adverb = (taskList.get(taskNum).getTaskType() == 'D') ? "by:" : "at:";
            System.out.println( (taskNum +1) + ".["  + taskList.get(taskNum).getTaskType() + "][" +
                    taskStatus + "] "+
                    taskList.get(taskNum).getTaskName() + "(" + adverb + taskList.get(taskNum).getTimeline() + ") ");
        }
        System.out.println(Messages.LINE_ICON);
    }


    /**
     * Displays the entire list of tasks
     * @param taskList list of tasks
     */
    public static void taskList(ArrayList<Task> taskList) {
        System.out.println(Messages.LINE_ICON);
        if (taskList.size() == 0){
            System.out.println(Messages.NO_TASKS_IN_LIST);
        }
        else{
            System.out.println(Messages.TASKS_IN_LIST_MESSAGE);
        }
        for(int i = 0; i < taskList.size(); i++){
            printOneTask(taskList, i);
        }
        System.out.println(Messages.LINE_ICON);
    }

    /**
     * Displays each task while displaying list or displays a task that is found using find
     * @param taskList list of tasks
     * @param taskNum individual task to be printed
     */
    public static void printOneTask(ArrayList<Task> taskList, int taskNum) {
        String taskStatus = (taskList.get(taskNum).isTaskComplete())
                ? Messages.taskComplete : Messages.taskIncomplete;
        if(taskList.get(taskNum).getTaskType() == 'T'){
            System.out.println( (taskNum +1) + ".["  + taskList.get(taskNum).getTaskType() + "] [" +
                    taskStatus + "] "+
                    taskList.get(taskNum).getTaskName());
        } else{
            String adverb = (taskList.get(taskNum).getTaskType() == 'D') ? "by:" : "at:";
            System.out.println( (taskNum +1) + ".["  + taskList.get(taskNum).getTaskType() + "][" +
                    taskStatus + "] "+ taskList.get(taskNum).getTaskName() + "(" +
                    adverb + " " + taskList.get(taskNum).getTimeline() + ") ");
        }
    }


    /**
     * Displays a list of tasks that match a particular keyword
     * @param taskList list of tasks
     * @param keyword keyword to search a task by
     */
    public static void taskFind(ArrayList<Task> taskList, String keyword){

        boolean isTaskFound = false;
        int taskNum = 0;

        System.out.println(Messages.LINE_ICON);
        System.out.println(Messages.MATCHING_MESSAGE);

        for(int i = 0; i < taskList.size(); i++){
            if(taskList.get(i).getTaskName().contains(keyword)){
                printOneTask(taskList, i);
                taskNum++;
                isTaskFound = true;
            }
        }

        if(isTaskFound == false){
            System.out.println(Messages.NOT_FOUND_MESSAGE);
        } else {
            System.out.println(Messages.FOUND_MESSAGE + " " + taskNum) ;
        }

        System.out.println(Messages.LINE_ICON);
    }

    /**
     * Displays the error when input format is incorrect
     */
    public static void printNumberFormatException(){
        System.out.println(Messages.LINE_ICON);
        System.out.println(Messages.FORMAT_EXCEPTION_MESSAGE);
        System.out.println(Messages.LINE_ICON);
    }

    /**
     * Displays the error when save file can't be loaded
     */
    public static void printIoException(){
        System.out.println(Messages.LINE_ICON);
        System.out.println(Messages.SAVE_FILE_ERROR);
        System.out.println(Messages.LINE_ICON);
    }

    /**
     * Displays the error when the task number does not exist
     */
    public static void printInvalidIndexError(){
        System.out.println(Messages.LINE_ICON);
        System.out.println(Messages.TASK_NUMBER_ERROR);
        System.out.println(Messages.LINE_ICON);
    }

    /**
     * Displays the error when the date is absent or is in the wrong format
     */
    public static void printInvalidDateFormat(){
        System.out.println(Messages.LINE_ICON);
        System.out.println(Messages.DATE_FORMAT_ERROR);
        System.out.println(Messages.LINE_ICON);
    }
}