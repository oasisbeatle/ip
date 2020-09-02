import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    public static void main(String[] args) {
        initDuke();
        String lineLogo = "-----------------------------";
        Scanner in = new Scanner(System.in);
        String line = " ";
        String command = " ";
        String commandSubject = " ";
        String adverb = " ";
        String timeline = " ";
        Task[] taskArrayList = new Task[100];
        int listIndex = 0;
        String taskIncomplete = Character.toString((char) 0x2718);
        String taskComplete = Character.toString((char) 0x2713);
        int endPos = 0;
        int slashPos = 0;

        while(true){
            line = in.nextLine();

            if(line.equals("bye")){
                break;
            }

            if(line.contains(" ")){
                endPos = line.indexOf(" ");
                command = line.substring(0, endPos);
                commandSubject = line.substring(endPos + 1);
                if(line.contains("/")){
                    slashPos = commandSubject.indexOf("/");
                    timeline = commandSubject.substring(slashPos + 3);
                    commandSubject = commandSubject.substring(0, slashPos - 1);
                }
            }
            else{
                command = line;
            }


            switch(command){
            case "todo":
                taskArrayList[listIndex] = new Todo(commandSubject);
                displayToDo(lineLogo, commandSubject, taskIncomplete, listIndex + 1, 'T');
                listIndex++;
                break;


            case "deadline":
                taskArrayList[listIndex] = new Deadline(commandSubject, timeline);
                displayToDoWithTime(lineLogo, commandSubject, taskIncomplete, listIndex + 1,
                        'D', timeline);
                listIndex++;
                break;

            case "event":
                taskArrayList[listIndex] = new Event(commandSubject, timeline);
                displayToDoWithTime(lineLogo, commandSubject, taskIncomplete, listIndex + 1,
                        'E', timeline);
                listIndex++;
                break;

            case "done":
                taskDone(lineLogo, commandSubject, taskArrayList, taskComplete);
                break;

            case "list":
                taskList(lineLogo, taskArrayList, taskComplete, taskIncomplete, listIndex);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + command);
            }

        }

        System.out.println(lineLogo);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(lineLogo);

    }

    private static void taskList(String lineLogo, Task[] taskArrayList, String taskComplete,
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
}
