import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String line = " ";
        ArrayList<String> list = new ArrayList<String>();

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
            if(!line.equals("bye") && !line.equals("list")){
                list.add(line);
                System.out.println(lineLogo);
                System.out.println("added: " + line);
                System.out.println(lineLogo);
            }
            else if(line.equals("list")){
                System.out.println(lineLogo);
                for(int i = 0; i < list.size(); i++){
                    System.out.println(i + ". " + list.get(i));
                }
                System.out.println(lineLogo);
            }
        }

        System.out.println(lineLogo);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(lineLogo);
    }
}
