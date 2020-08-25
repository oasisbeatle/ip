import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String line = " ";
        ArrayList<String> list = new ArrayList<String>();
        String taskComplete = Character.toString((char) 0x2713);
        String taskIncomplete = Character.toString((char) 0x274C);
        ArrayList<String> listCompletion = new ArrayList<String>();


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

            if(!line.equals("bye") && !line.equals("list") && !line.startsWith("done")){
                list.add(line);
                listCompletion.add(taskIncomplete);
                System.out.println(lineLogo);
                System.out.println("added: " + line);
                System.out.println(lineLogo);
            }
            else if(line.equals("list")){
                System.out.println(lineLogo);
                System.out.println("Here are the tasks in your list:");
                for(int i = 0; i < list.size(); i++){
                    System.out.println((i+1) + ".[" + listCompletion.get(i) + "] " + list.get(i));
                }
                System.out.println(lineLogo);
            }
            else if(line.startsWith("done")){
                String taskString = line.substring(5);
                int taskNum = Integer.parseInt(taskString);
                taskNum--;
                listCompletion.set(taskNum, taskComplete);
                System.out.println(lineLogo);
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("   ["  + listCompletion.get(taskNum) + "] "+ list.get(taskNum));
                System.out.println(lineLogo);
            }
        }

        System.out.println(lineLogo);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(lineLogo);
    }
}
