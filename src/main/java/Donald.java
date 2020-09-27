import Exceptions.DukeException;
import TaskList.TaskList;
import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;
import Messages.Messages;
import ui.TextUi;
import Parser.Parser;
import Storage.Storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Donald {

    //declare all constant integers
    private static final int MAX_ARRAY_LENGTH = 100;


    //declare string variables
    private static String userInput = " ";

    //declare array to store list of tasks
    private static String taskArray[]  = new String[3];

    private static TextUi ui;
    private static Parser parse;
    private static TaskList tasks;
    private static Storage storage;

    public Donald(String filePath) throws IOException {
        ui = new TextUi();
        parse = new Parser();
        storage = new Storage(Messages.FILE_PATH);
        try {
            tasks = new TaskList(storage.readFile());
        } catch(IOException e) {
            System.out.println("Cant Read");
            tasks = new TaskList();
        }

    }


    public void run() throws IOException, DukeException {
        ui.initDonald();
        Scanner in = new Scanner(System.in);
        while(true){
            userInput = in.nextLine();
            if(userInput.toLowerCase().equals("bye")){
                break;
            }
            taskManager(userInput);
        }

        ui.printBye();
    }

    //main method
    public static void main(String[] args) throws IOException, DukeException {
        new Donald(Messages.FILE_PATH).run();
    }


    public static void taskManager(String userInput) throws DukeException, IOException {
        taskArray = parse.generateTask(userInput);

        //execution of the commands
        try {
            switch (taskArray[0]) {
            case "todo":
                tasks.addTodo(taskArray);
                ui.displayToDo(taskArray[1], Messages.taskIncomplete, tasks.getListSize(), 'T');
                storage.writeToFile(tasks.getTaskArrayList());
                break;


            case "deadline":
                tasks.addDeadline(taskArray);
                ui.displayToDoWithTime(taskArray[1], Messages.taskIncomplete, tasks.getListSize(),
                        'D', taskArray[2]);
                storage.writeToFile(tasks.getTaskArrayList());
                break;

            case "event":
                tasks.addEvent(taskArray);
                ui.displayToDoWithTime(taskArray[1], Messages.taskIncomplete, tasks.getListSize(),
                        'E', taskArray[2]);
                storage.writeToFile(tasks.getTaskArrayList());
                break;

            case "done":
                tasks.taskDone(taskArray[1], tasks.getTaskArrayList());
                storage.writeToFile(tasks.getTaskArrayList());
                break;

            case "list":
                ui.taskList(tasks.getTaskArrayList());
                break;

            case "delete":
                 tasks.taskDelete(taskArray[1], tasks.getTaskArrayList());
                 storage.writeToFile(tasks.getTaskArrayList());
                break;

            case "find":
                break;

            default:
                throw new DukeException("Sorry! I can't find your command. Please retype your command.");

            }
        } catch(DukeException e){
            System.out.println(Messages.LINE_ICON);
            System.out.println(e.getMessage());
            System.out.println(Messages.LINE_ICON);

        } catch(NumberFormatException e){
            System.out.println(Messages.LINE_ICON);
            System.out.println("Expected integer. Please enter a number.");
            System.out.println(Messages.LINE_ICON);
        }

}



}