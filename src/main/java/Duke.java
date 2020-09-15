import Exceptions.DukeException;
import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

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
    private static ArrayList<Task> taskList = new ArrayList<Task>();


    //main method
    public static void main(String[] args) throws DukeException, IOException {
        initDuke();
        try {
            readFile(taskList);
        } catch (IOException e) {
            System.out.println("Unable to Read The File");
        }
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


    public static void taskManager(String userInput) throws DukeException, IOException {

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

        try {
            if (commandSubject == " " && !commandName.equals("list")) {
                throw new DukeException("Sorry your command does not have any instructions, I cannot process it. " +
                        "Please retype your command");
            }
        } catch(DukeException d) {
            System.out.println(lineLogo);
            System.out.println(d.getMessage());
            System.out.println(lineLogo);
            return;
        }


        //execution of the commands
        try {
            switch (commandName) {
            case "todo":
                Task newTodo = new Todo(commandSubject);
                taskList.add(newTodo);
                displayToDo(lineLogo, commandSubject, taskIncomplete, taskList.size(), 'T');
                writeToFile(taskList);
                break;


            case "deadline":
                if (timeline == " ") {
                    System.out.println("I require the submission date for this task. So please try again.");
                    break;
                }
                Task newDeadline = new Deadline(commandSubject, timeline);
                taskList.add(newDeadline);
                displayToDoWithTime(lineLogo, commandSubject, taskIncomplete, taskList.size(),
                        'D', timeline);
                writeToFile(taskList);
                break;

            case "event":
                if (timeline == " ") {
                    System.out.println("I require the event date for this task. So please try again.");
                    break;
                }
                Task newEvent = new Event(commandSubject, timeline);
                taskList.add(newEvent);
                displayToDoWithTime(lineLogo, commandSubject, taskIncomplete, taskList.size(),
                        'E', timeline);
                writeToFile(taskList);
                break;

            case "done":
                taskDone(lineLogo, commandSubject, taskList, taskComplete);
                writeToFile(taskList);
                break;

            case "list":
                taskList(lineLogo, taskList, taskComplete, taskIncomplete);
                break;

            case "delete":
                taskDelete(lineLogo, commandSubject, taskList);
                break;

            default:
                throw new DukeException("Sorry! I can't find your command. Please retype your command.");

            }
        } catch(DukeException e){
            System.out.println(lineLogo);
            System.out.println(e.getMessage());
            System.out.println(lineLogo);

        } catch(NumberFormatException e){
            System.out.println(lineLogo);
            System.out.println("Expected integer. Please enter a number.");
            System.out.println(lineLogo);
        }

}

    private static void taskDelete(String lineLogo, String commandSubject, ArrayList<Task> taskList) {
        int taskNum = Integer.parseInt(commandSubject);
        taskNum = taskNum - 1;
        char taskType = taskList.get(taskNum).getTaskType();
        String taskStatus = (taskList.get(taskNum).isTaskComplete())
                ? taskComplete : taskIncomplete;
        if(taskType == 'T'){
            displayDeleteTodo(lineLogo, taskList.get(taskNum).getTaskName(),
                    taskStatus, taskList.size() - 1, taskType);
        }else{
            displayDeletedTodoWithTime(lineLogo, taskList.get(taskNum).getTaskName(),
                    taskStatus, taskList.size() - 1, taskType, taskList.get(taskNum).getTimeline());
        }
        taskList.remove(taskNum);
    }


    public static void taskList(String lineLogo, ArrayList<Task> taskList, String taskComplete,
            String taskIncomplete) {
        System.out.println(lineLogo);
        if (taskList.size() == 0){
            System.out.println("There are no tasks left for you. Add a new task!");
        }
        else{
            System.out.println("Here are the tasks in your list:");
        }
        for(int i = 0; i < taskList.size(); i++){
            String taskStatus = (taskList.get(i).isTaskComplete())
                    ? taskComplete : taskIncomplete;
            taskPrinter(taskList, i, taskStatus);
        }
        System.out.println(lineLogo);
    }

    public static void taskPrinter(ArrayList<Task> taskList, int i, String taskStatus) {
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


    public static void displayDeleteTodo(String lineLogo, String commandSubject, String taskCompletionStatus,
                    int totalTasks, char taskType) {
        System.out.println(lineLogo);
        System.out.println("Noted. I've removed this task:");
        System.out.println(" [" + taskType + "] [" + taskCompletionStatus + "] " + commandSubject);
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
        System.out.println(lineLogo);
    }

    public static void displayDeletedTodoWithTime(String lineLogo, String commandSubject, String taskCompletionStatus,
                    int totalTasks, char taskType, String timeline) {
        String adverb;
        adverb = (taskType == 'D')? "by:" : "at:";
        System.out.println(lineLogo);
        System.out.println("Noted. I've removed this task:");
        System.out.println(" [" + taskType + "] [" + taskCompletionStatus + "] "+ commandSubject + " (" + adverb +
                timeline + ")");
        System.out.println("Now you have " + totalTasks + " tasks in the list.");
        System.out.println(lineLogo);
    }

    public static void taskDone(String lineLogo, String commandSubject, ArrayList<Task> taskList, String taskComplete) throws IOException {
        int taskNum = Integer.parseInt(commandSubject);
        taskNum = taskNum - 1;
        String taskStatus = taskComplete;
        char taskType = taskList.get(taskNum).getTaskType();
        switch (taskType) {
        case 'T':
            Task completedTodo = new Todo(taskList.get(taskNum).getTaskName());
            completedTodo.setTaskComplete();
            taskList.set(taskNum, completedTodo);
            writeToFile(taskList);
            break;

        case 'D':
            Task completedDeadline = new Deadline(taskList.get(taskNum).getTaskName(),
                    taskList.get(taskNum).getTimeline());
            completedDeadline.setTaskComplete();
            taskList.set(taskNum, completedDeadline);
            writeToFile(taskList);
            break;

        case 'E':
            Task completedEvent = new Event(taskList.get(taskNum).getTaskName(),
                    taskList.get(taskNum).getTimeline());
            completedEvent.setTaskComplete();
            taskList.set(taskNum, completedEvent);
            break;

        default:
            break;
        }

        System.out.println(lineLogo);
        System.out.println("Nice! I've marked this task as done:");
        taskPrinter(taskList, taskNum, taskStatus);
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

    public static void writeToFile(ArrayList<Task> taskList) throws IOException {
        FileWriter fw = new FileWriter("Duke.txt");
        for(int i = 0; i < taskList.size(); i++) {
            String savedTask;
            savedTask = String.valueOf(taskList.get(i).getTaskType())+ "," + taskList.get(i).getTaskName()
                    + "," + taskList.get(i).isTaskComplete() + "," + taskList.get(i).getTimeline() + ","
                    + "\n";
            fw.write(savedTask);
        }
        fw.close();
    }

    public static void readFile(ArrayList<Task> taskList) throws IOException{
        File f = new File("Duke.txt");

        if(f.exists()){
            Scanner fileRead = new Scanner(f);
            while(fileRead.hasNext()){
                String userInput = fileRead.nextLine();
                String taskInfo[] = userInput.split(",");
                switch (taskInfo[0]){
                case "T":
                    Todo oldTodo = new Todo(taskInfo[1]);
                    oldTodo.setTaskStatus(Boolean.parseBoolean(taskInfo[2]));
                    taskList.add(oldTodo);
                    break;
                case "D":
                    Deadline oldDeadline = new Deadline(taskInfo[1], taskInfo[3]);
                    oldDeadline.setTaskStatus(Boolean.parseBoolean(taskInfo[2]));
                    taskList.add(oldDeadline);
                    break;
                case "E":
                    Event oldEvent = new Event(taskInfo[1], taskInfo[3]);
                    oldEvent.setTaskStatus(Boolean.parseBoolean(taskInfo[2]));
                    taskList.add(oldEvent);
                    break;
                default:
                    break;
                }
            }
        } else {
            f.createNewFile();
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("File Created ^-^");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");
        }

    }


}