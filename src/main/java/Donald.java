import Exceptions.DonaldException;
import TaskList.TaskList;
import Messages.Messages;
import ui.TextUi;
import Parser.Parser;
import Storage.Storage;


import java.io.IOException;
import java.util.Scanner;

public class Donald {

    //declare string variables
    private static String userInput = " ";

    //Array to retrieve details of each task
    private static String taskArray[]  = new String[3];


    /** Instances of class objects to manage Duke**/
    private static TextUi ui;
    private static Parser parse;
    private static TaskList tasks;
    private static Storage storage;

    /**
     * Instantiates UI, Parser, Storage and taskList objects
     *
     * @param filePath path of file
     * @throws IOException if file is empty
     */
    public Donald(String filePath) {
        ui = new TextUi();
        storage = new Storage(Messages.FILE_PATH);
        parse = new Parser(storage);
        try {
            tasks = new TaskList(storage.readFile());
        } catch(IOException e) {
            ui.printIoException();
            tasks = new TaskList();
        }

    }

    /**
     * Runs Donald
     */
    public void run() {

        //Initialise Donald
        ui.initDonald();

        Scanner in = new Scanner(System.in);

        /**Loops Until User Enters 'Bye'**/
        while(true){
            userInput = in.nextLine();

            if(userInput.toLowerCase().equals(Messages.BYE)){
                break;
            }

            /** Processes the User Input **/
            parse.taskManager(userInput);
        }

        //Terminates Donald
        ui.printBye();
    }

    /**
     * Runs an instance of Donald
     * @param args if any
     */
    public static void main(String[] args) {
        new Donald(Messages.FILE_PATH).run();
    }


}