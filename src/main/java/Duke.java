import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String line = " ";

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

        while(!line.equals("bye")){
            line = in.nextLine();
            if(!line.equals("bye")){
                System.out.println(lineLogo);
                System.out.println(line);
                System.out.println(lineLogo);
            }
        }

        System.out.println(lineLogo);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(lineLogo);
    }
}
