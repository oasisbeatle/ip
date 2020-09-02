import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

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
        ArrayList<Task> taskArrayList = new ArrayList<>();
        Task currentTask;
        String taskIncomplete = Character.toString((char) 0x274C);
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
                taskArrayList.add(new Task('T', false, commandSubject, null));
                displayToDo(lineLogo, commandSubject, taskIncomplete, Task.getTotalTasks(), Task.getTaskType());
                break;

            case "deadline":
                taskArrayList.add(new Task('D', false, commandSubject, timeline));
                displayToDoWithTime(lineLogo, commandSubject, taskIncomplete, Task.getTotalTasks(),
                        Task.getTaskType(), timeline);
                break;

            case "event":
                taskArrayList.add(new Task('E', false, commandSubject, timeline));
                displayToDoWithTime(lineLogo, commandSubject, taskIncomplete, Task.getTotalTasks(), Task.getTaskType(), timeline);
                break;

            case "done":
                int taskNum = Integer.parseInt(commandSubject);
                taskNum--;
                currentTask = taskArrayList.get(taskNum);
                currentTask.setIsTaskComplete(true);
                System.out.println(lineLogo);
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("   ["  + currentTask.getTaskType() + "] [" + taskComplete + "] "+
                        currentTask.getTaskName());
                System.out.println(lineLogo);
                break;

            case "list":
                break;

            }

        }


        System.out.println(lineLogo);
        System.out.println("Bye. Hope to see you again soon!");
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
