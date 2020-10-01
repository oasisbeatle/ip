package Parser;

import Exceptions.DonaldException;
import Storage.Storage;
import TaskList.TaskList;
import ui.TextUi;
import Messages.Messages;

import java.io.IOException;
import java.time.format.DateTimeParseException;

/**
 * Class that processes the user input and makes sense of command
 */
public class Parser {

    private String taskArray[] = new String[3];
    private TextUi ui;
    private TaskList tasks;
    private Storage storage;



    public Parser(Storage storage){
        ui = new TextUi();
        tasks = new TaskList();
        this.storage = storage;
    }

    /**
     * Makes sense of input and converts to command
     * @param userInput Input stream of user
     * @return taskArray that has the details of each task
     */
    public String[] generateTask(String userInput) {
        int listIndex = 0;
        int endPos = 0;
        int slashPos = 0;

        //get command
        if (userInput.contains(" ")) {
            endPos = userInput.indexOf(" ");
            taskArray[0] = userInput.substring(0, endPos);
            taskArray[1] = userInput.substring(endPos + 1);
            if (userInput.contains("/")) {
                slashPos = taskArray[1].indexOf("/");
                taskArray[2] = taskArray[1].substring(slashPos + 4);
                taskArray[1] = taskArray[1].substring(0, slashPos);
            }
            else{
                taskArray[2] = " ";
            }
        } else {
            taskArray[0] = userInput;
            taskArray[1] = " ";
            taskArray[2] = " ";
        }

        return taskArray;
    }


    /**
     * Manages each of the commands
     * @param userInput Input Stream of user
     * @throws DonaldException
     * @throws IOException
     */
    public void taskManager(String userInput) throws DonaldException, IOException {
        taskArray = generateTask(userInput);

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
                ui.taskFind(tasks.getTaskArrayList(), taskArray[1]);
                break;

            default:
                throw new DonaldException(Messages.COMMAND_NOT_FOUND_MESSAGE);

            }

        } catch(DonaldException e){
            System.out.println(Messages.LINE_ICON);
            System.out.println(e.getMessage());
            System.out.println(Messages.LINE_ICON);

        } catch(NumberFormatException e) {
            ui.printNumberFormatException();

        } catch(IndexOutOfBoundsException e){
            ui.printInvalidIndexError();

        } catch(DateTimeParseException e){
            ui.printInvalidDateFormat();
        }

    }


}