package Messages;

/**
 * Class that contains all logos, messages, error messages and ASCII characters
 * Contains file path
 */
public class Messages {

    /** General Messages */
    public static final String LINE_ICON = "-----------------------------";
    public static final String taskIncomplete = "N";
    public static final String taskComplete = "Y";
    public static final String DONALD_ICON = "         ________\n" +
            "        /        \\\n" +
            "     __/       (o)\\__\n" +
            "    /     ______\\\\   \\\n" +
            "    |____/__  __\\____|\n" +
            "       [  --~~--  ]\n" +
            "        |(  L   )|\n" +
            "  ___----\\  __  /----___\n" +
            " /   |  < \\____/ >   |   \\\n" +
            "/    |   < \\--/ >    |    \\\n" +
            "||||||    \\ \\/ /     ||||||\n" +
            "|          \\  /   o       |\n" +
            "|     |     \\/   === |    |\n" +
            "|     |      |o  ||| |    |\n" +
            "|     \\______|   +#* |    |\n" +
            "|            |o      |    |\n" +
            " \\           |      /     /\n" +
            " |\\__________|o    /     /\n" +
            " |           |    /     /";
    public static final String INTRO_MESSAGE = "Hello! I'm Donald. I'm the greatest task manager of all time." +
                    "\nYou see no one manages " +
                    "the tasks better than I do. Some people say that I'm even better than Duke!";
    public static final String WHAT_MESSAGE = "So, what can I do for you?";
    public static final String FILE_PATH = "Donald.txt";
    public static final String BYE_MESSAGE = "Bye!";
    public static final String BYE_ICON = "  ______      __    __       ___       ______  __  ___      ______      __    __       ___       ______  __  ___ \n" +
            " /  __  \\    |  |  |  |     /   \\     /      ||  |/  /     /  __  \\    |  |  |  |     /   \\     /      ||  |/  / \n" +
            "|  |  |  |   |  |  |  |    /  ^  \\   |  ,----'|  '  /     |  |  |  |   |  |  |  |    /  ^  \\   |  ,----'|  '  /  \n" +
            "|  |  |  |   |  |  |  |   /  /_\\  \\  |  |     |    <      |  |  |  |   |  |  |  |   /  /_\\  \\  |  |     |    <   \n" +
            "|  `--'  '--.|  `--'  |  /  _____  \\ |  `----.|  .  \\     |  `--'  '--.|  `--'  |  /  _____  \\ |  `----.|  .  \\  \n" +
            " \\_____\\_____\\\\______/  /__/     \\__\\ \\______||__|\\__\\     \\_____\\_____\\\\______/  /__/     \\__\\ \\______||__|\\__\\ \n";

    public static final String NOT_FOUND_MESSAGE = "There are no such items according to the keyword you've given. Sorry!";
    public static final String FOUND_MESSAGE = "I've found these many tasks: ";
    public static final String MATCHING_MESSAGE = "Here are the matching tasks in your list:";
    public static final String COMMAND_NOT_FOUND_MESSAGE = "Sorry! I can't find your command. Please retype your command.";
    public static final String FORMAT_EXCEPTION_MESSAGE = "Expected integer. Please enter a number.";
    public static final String FILE_CREATED_MESSAGE = "------------------------\n"
                    + "New File Created!\n" + "------------------------";
    public static final String TASK_ADDED_MESSAGE ="Got it. I've added this task:";
    public static final String TASK_REMOVED_MESSAGE ="Noted. I've removed this task:";
    public static final String TASK_DONE_MESSAGE = "Nice! I've marked this task as done:";
    public static final String TASKS_IN_LIST_MESSAGE = "Here are the tasks in your list: ";
    public static final String NO_TASKS_IN_LIST = "There are no tasks left for you. Add a new task!";
    public static final String BYE = "bye";


    /** Error Messages */
    public static final String SAVE_FILE_ERROR = "There was an error in loading the save file!";
    public static final String TASK_NUMBER_ERROR = "The task number entered does not exist. Re-enter the task number";
    public static final String DATE_FORMAT_ERROR = "The date has either not been entered or is in the wrong format. \n" +
                    "Enter the date in the format dd-MM-yyyy HH:mm";
}
