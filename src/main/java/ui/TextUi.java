package ui;


import Exceptions.DukeException;
import Tasks.Task;
import Messages.Messages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * TextUI class handles interactions with user
 */
public class TextUi {

    public static String initDonald(){
        System.out.println("Hello from\n" + Messages.DONALD_ICON);
        System.out.println(Messages.LINE_ICON);
        System.out.println(Messages.INTRO_MESSAGE);
        System.out.println(Messages.WHAT_MESSAGE);
        System.out.println(Messages.LINE_ICON);
        return Messages.LINE_ICON;
    }

    public static void printBye() {
        System.out.println(Messages.LINE_ICON);
        System.out.println(Messages.BYE_MESSAGE);
        System.out.println(Messages.LINE_ICON);
        System.out.println(Messages.BYE_ICON);
    }

    public static void displayToDo(String commandSubject, String taskCompletionStatus,
                                   int totalTasks, char taskType) {
        System.out.println(Messages.LINE_ICON);
        System.out.println("Got it. I've added this task:");
        System.out.println(" [" + taskType + "] [" + taskCompletionStatus + "] " + commandSubject);
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
        System.out.println(Messages.LINE_ICON);
    }

    public static void displayToDoWithTime(String commandSubject, String taskCompletionStatus,
                                   int totalTasks, char taskType, String timeline) {
        LocalDateTime time;
        time = LocalDateTime.parse(timeline, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        String adverb;
        adverb = (taskType == 'D')? "by: " : "at: ";
        System.out.println(Messages.LINE_ICON);
        System.out.println("Got it. I've added this task:");
        System.out.println(" [" + taskType + "] [" + taskCompletionStatus + "] "+ commandSubject + " (" + adverb +
                time.format(DateTimeFormatter.ofPattern("MMM dd yyyy 'at' HH:mm")) + ")");
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
        System.out.println(Messages.LINE_ICON);
    }


    public static void displayDeleteTodo(String commandSubject, String taskCompletionStatus,
                                   int totalTasks, char taskType) {
        System.out.println(Messages.LINE_ICON);
        System.out.println("Noted. I've removed this task:");
        System.out.println(" [" + taskType + "] [" + taskCompletionStatus + "] " + commandSubject);
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
        System.out.println(Messages.LINE_ICON);
    }

    public static void displayDeletedTodoWithTime(String commandSubject, String taskCompletionStatus,
                                   int totalTasks, char taskType, String timeline) {
        String adverb;
        adverb = (taskType == 'D')? "by:" : "at:";
        System.out.println(Messages.LINE_ICON);
        System.out.println("Noted. I've removed this task:");
        System.out.println(" [" + taskType + "] [" + taskCompletionStatus + "] "+ commandSubject + " (" + adverb +
                timeline + ")");
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
        System.out.println(Messages.LINE_ICON);
    }

    public static void printDoneTask(ArrayList<Task> taskList, int i, String taskStatus) {
        System.out.println(Messages.LINE_ICON);
        System.out.println("Nice! I've marked this task as done:");
        if(taskList.get(i).getTaskType() == 'T'){
            System.out.println( (i +1) + ".["  + taskList.get(i).getTaskType() + "] [" +
                    taskStatus + "] "+
                    taskList.get(i).getTaskName());
        } else{
            String adverb = (taskList.get(i).getTaskType() == 'D') ? "by:" : "at:";
            System.out.println( (i +1) + ".["  + taskList.get(i).getTaskType() + "][" +
                    taskStatus + "] "+
                    taskList.get(i).getTaskName() + "(" + adverb + taskList.get(i).getTimeline() + ") ");
        }
        System.out.println(Messages.LINE_ICON);
    }

    public static void taskList(ArrayList<Task> taskList) {
        System.out.println(Messages.LINE_ICON);
        if (taskList.size() == 0){
            System.out.println("There are no tasks left for you. Add a new task!");
        }
        else{
            System.out.println("Here are the tasks in your list:");
        }
        for(int i = 0; i < taskList.size(); i++){
            printOneTask(taskList, i);
        }
        System.out.println(Messages.LINE_ICON);
    }

    public static void printOneTask(ArrayList<Task> taskList, int i) {
        String taskStatus = (taskList.get(i).isTaskComplete())
                ? Messages.taskComplete : Messages.taskIncomplete;
        if(taskList.get(i).getTaskType() == 'T'){
            System.out.println( (i +1) + ".["  + taskList.get(i).getTaskType() + "] [" +
                    taskStatus + "] "+
                    taskList.get(i).getTaskName());
        } else{
            String adverb = (taskList.get(i).getTaskType() == 'D') ? "by:" : "at:";
            System.out.println( (i +1) + ".["  + taskList.get(i).getTaskType() + "][" +
                    taskStatus + "] "+
                    taskList.get(i).getTaskName() + "(" + adverb + taskList.get(i).getTimeline() + ") ");
        }
    }

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



}
