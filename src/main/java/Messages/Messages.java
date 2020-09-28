package Messages;

/**
 * Class that contains all logos, messages, error messages and ASCII characters
 * Contains file path
 */
public class Messages {

    public static final String LINE_ICON = "-----------------------------";
    public static final String taskIncomplete = Character.toString((char) 0x2718);
    public static final String taskComplete = Character.toString((char) 0x2713);
    public static final String DONALD_ICON = "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠛⠋⠉⡉⣉⡛⣛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣿⣿⡿⠋⠁⠄⠄⠄⠄⠄⢀⣸⣿⣿⡿⠿⡯⢙⠿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣿⡿⠄⠄⠄⠄⠄⡀⡀⠄⢀⣀⣉⣉⣉⠁⠐⣶⣶⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣿⡇⠄⠄⠄⠄⠁⣿⣿⣀⠈⠿⢟⡛⠛⣿⠛⠛⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣿⡆⠄⠄⠄⠄⠄⠈⠁⠰⣄⣴⡬⢵⣴⣿⣤⣽⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣿⡇⠄⢀⢄⡀⠄⠄⠄⠄⡉⠻⣿⡿⠁⠘⠛⡿⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⡿⠃⠄⠄⠈⠻⠄⠄⠄⠄⢘⣧⣀⠾⠿⠶⠦⢳⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⣿⣶⣤⡀⢀⡀⠄⠄⠄⠄⠄⠄⠻⢣⣶⡒⠶⢤⢾⣿⣿⣿⣿⣿⣿⣿\n" +
            "⣿⣿⣿⣿⡿⠟⠋⠄⢘⣿⣦⡀⠄⠄⠄⠄⠄⠉⠛⠻⠻⠺⣼⣿⠟⠋⠛⠿⣿⣿\n" +
            "⠋⠉⠁⠄⠄⠄⠄⠄⠄⢻⣿⣿⣶⣄⡀⠄⠄⠄⠄⢀⣤⣾⣿⣿⡀⠄⠄⠄⠄⢹\n" +
            "⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢻⣿⣿⣿⣷⡤⠄⠰⡆⠄⠄⠈⠉⠛⠿⢦⣀⡀⡀⠄\n" +
            "⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⢿⣿⠟⡋⠄⠄⠄⢣⠄⠄⠄⠄⠄⠄⠄⠈⠹⣿⣀\n" +
            "⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠘⣷⣿⣿⣷⠄⠄⢺⣇⠄⠄⠄⠄⠄⠄⠄⠄⠸⣿\n" +
            "⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠹⣿⣿⡇⠄⠄⠸⣿⡄⠄⠈⠁⠄⠄⠄⠄⠄⣿\n" +
            "⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢻⣿⡇⠄⠄⠄⢹⣧⠄⠄⠄⠄⠄⠄⠄⠄⠘";
    public static final String INTRO_MESSAGE = "Hello! I'm Donald. I'm the greatest task manager of all time." +
                    "\nYou see no one manages " +
                    "the tasks better than I do. Some people say that I'm even better than Duke!";
    public static final String WHAT_MESSAGE = "So, what can I do for you?";
    public static final String FILE_PATH = "Donald.txt";
    public static final String BYE_MESSAGE = "Bye! MAKE ASSISTANTS GREAT AGAIN!";
    public static final String BYE_ICON = "          _____                    _____                    _____                    _____          \n" +
            "         /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\         \n" +
            "        /::\\____\\                /::\\    \\                /::\\    \\                /::\\    \\        \n" +
            "       /::::|   |               /::::\\    \\              /::::\\    \\              /::::\\    \\       \n" +
            "      /:::::|   |              /::::::\\    \\            /::::::\\    \\            /::::::\\    \\      \n" +
            "     /::::::|   |             /:::/\\:::\\    \\          /:::/\\:::\\    \\          /:::/\\:::\\    \\     \n" +
            "    /:::/|::|   |            /:::/__\\:::\\    \\        /:::/  \\:::\\    \\        /:::/__\\:::\\    \\    \n" +
            "   /:::/ |::|   |           /::::\\   \\:::\\    \\      /:::/    \\:::\\    \\      /::::\\   \\:::\\    \\   \n" +
            "  /:::/  |::|___|______    /::::::\\   \\:::\\    \\    /:::/    / \\:::\\    \\    /::::::\\   \\:::\\    \\  \n" +
            " /:::/   |::::::::\\    \\  /:::/\\:::\\   \\:::\\    \\  /:::/    /   \\:::\\ ___\\  /:::/\\:::\\   \\:::\\    \\ \n" +
            "/:::/    |:::::::::\\____\\/:::/  \\:::\\   \\:::\\____\\/:::/____/  ___\\:::|    |/:::/  \\:::\\   \\:::\\____\\\n" +
            "\\::/    / ~~~~~/:::/    /\\::/    \\:::\\  /:::/    /\\:::\\    \\ /\\  /:::|____|\\::/    \\:::\\  /:::/    /\n" +
            " \\/____/      /:::/    /  \\/____/ \\:::\\/:::/    /  \\:::\\    /::\\ \\::/    /  \\/____/ \\:::\\/:::/    / \n" +
            "             /:::/    /            \\::::::/    /    \\:::\\   \\:::\\ \\/____/            \\::::::/    /  \n" +
            "            /:::/    /              \\::::/    /      \\:::\\   \\:::\\____\\               \\::::/    /   \n" +
            "           /:::/    /               /:::/    /        \\:::\\  /:::/    /               /:::/    /    \n" +
            "          /:::/    /               /:::/    /          \\:::\\/:::/    /               /:::/    /     \n" +
            "         /:::/    /               /:::/    /            \\::::::/    /               /:::/    /      \n" +
            "        /:::/    /               /:::/    /              \\::::/    /               /:::/    /       \n" +
            "        \\::/    /                \\::/    /                \\::/____/                \\::/    /        \n" +
            "         \\/____/                  \\/____/                                           \\/____/         \n" +
            "                                                                                                    ";





    public static final String NOT_FOUND_MESSAGE = "There are no such items according to the keyword you've given. Sorry!";
    public static final String FOUND_MESSAGE = "I've found these many tasks: ";
    public static final String MATCHING_MESSAGE = "Here are the matching tasks in your list:";
}
