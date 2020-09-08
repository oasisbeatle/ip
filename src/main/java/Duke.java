import Exceptions.DukeException;
import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;

import java.util.Scanner;

public class Duke {

    //declare all constant integers
    private static final int MAX_ARRAY_LENGTH = 100;

    //declare all constant strings
    private static final String lineLogo = "-----------------------------";
    private static final String taskIncomplete = Character.toString((char) 0x2718);
    private static final String taskComplete = Character.toString((char) 0x2713);

    //declare string variables
    private static String userInput = " ";

    //declare array to store list of tasks
    private static Task[] taskArray = new Task[MAX_ARRAY_LENGTH];


    //main method
    public static void main(String[] args) throws DukeException {
        initDuke();
        Scanner in = new Scanner(System.in);
        while(true){
            userInput = in.nextLine();
            if(userInput.toLowerCase().equals("bye")){
                break;
            }
            taskManager(userInput);
        }

        printBye();

    }


    public static void taskManager(String userInput) throws DukeException {

        //declare integers
        int listIndex = 0;
        int endPos = 0;
        int slashPos = 0;

        //declare strings
        String commandName = " ";
        String commandSubject = " ";
        String timeline = " ";

        //get command
        if (userInput.contains(" ")) {
            endPos = userInput.indexOf(" ");
            commandName = userInput.substring(0, endPos);
            commandSubject = userInput.substring(endPos + 1);
            if (userInput.contains("/")) {
                slashPos = commandSubject.indexOf("/");
                timeline = commandSubject.substring(slashPos + 3);
                commandSubject = commandSubject.substring(0, slashPos - 1);
            }
        } else {
            commandName = userInput;
        }

        if (commandSubject == " ") {
            throw new DukeException("Sorry your command does not have any instructions, I cannot process it.");
        }

        //execution of the commands
        switch (commandName) {
        case "todo":
            taskArray[listIndex] = new Todo(commandSubject);
            displayToDo(lineLogo, commandSubject, taskIncomplete, listIndex + 1, 'T');
            listIndex++;
            break;


        case "deadline":
            if(timeline == " "){
                throw new DukeException("I require the submission date for this task. So please try again.");
            }
            taskArray[listIndex] = new Deadline(commandSubject, timeline);
            displayToDoWithTime(lineLogo, commandSubject, taskIncomplete, listIndex + 1,
                    'D', timeline);
            listIndex++;
            break;

        case "event":
            if(timeline == " "){
                throw new DukeException("I require the submission date for this task. So please try again.");
            }
            taskArray[listIndex] = new Event(commandSubject, timeline);
            displayToDoWithTime(lineLogo, commandSubject, taskIncomplete, listIndex + 1,
                    'E', timeline);
            listIndex++;
            break;

        case "done":
            taskDone(lineLogo, commandSubject, taskArray, taskComplete);
            break;

        case "list":
            taskList(lineLogo, taskArray, taskComplete, taskIncomplete, listIndex);
            break;

        default:
            throw new DukeException("Sorry! I can't find your command");

        }
}


    public static void taskList(String lineLogo, Task[] taskArrayList, String taskComplete,
            String taskIncomplete, int listIndex) {
        System.out.println(lineLogo);
        System.out.println("Here are the tasks in your list:");
        for(int i = 0; i < listIndex; i++){
            String taskStatus = (taskArrayList[i].isTaskComplete() == true)
                    ? taskComplete : taskIncomplete;
            System.out.println( (i+1) + ".["  + taskArrayList[i].getTaskType() + "] [" +
                    taskStatus + "] "+
                    taskArrayList[i].getTaskName());
        }
        System.out.println(lineLogo);
    }


    public static void displayToDo(String lineLogo, String commandSubject, String taskCompletionStatus,
            int totalTasks, char taskType) {
        System.out.println(lineLogo);
        System.out.println("Got it. I've added this task:");
        System.out.println(" [" + taskType + "] [" + taskCompletionStatus + "] " + commandSubject);
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
        System.out.println(lineLogo);
    }

    public static void displayToDoWithTime(String lineLogo, String commandSubject, String taskCompletionStatus,
            int totalTasks, char taskType, String timeline) {
        String adverb;
        adverb = (taskType == 'D')? "by:" : "at:";
        System.out.println(lineLogo);
        System.out.println("Got it. I've added this task:");
        System.out.println(" [" + taskType + "] [" + taskCompletionStatus + "] "+ commandSubject + " (" + adverb +
                timeline + ")");
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
        System.out.println(lineLogo);
    }

    public static void taskDone(String lineLogo, String commandSubject, Task[] taskArrayList, String taskComplete){
        int taskNum = Integer.parseInt(commandSubject);
        taskNum = taskNum - 1;
        taskArrayList[taskNum].setTaskComplete(true);
        System.out.println(lineLogo);
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("   ["  + taskArrayList[taskNum].getTaskType() + "] [" +
                taskComplete + "] "+
                taskArrayList[taskNum].getTaskName());
        System.out.println(lineLogo);
    }

    public static String initDuke() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        String lineLogo = "-----------------------------";
        System.out.println(lineLogo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println(lineLogo);
        return lineLogo;
    }

    public static void printBye() {
        System.out.println(lineLogo);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(lineLogo);
    }
}
