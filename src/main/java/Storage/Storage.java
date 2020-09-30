package Storage;

import Messages.Messages;
import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that deals with file management
 */
public class Storage {

    private String filePath;

    public Storage(String filePath){
        this.filePath = filePath;
    }

    /**
     * Reads Donald.txt and adds to the list of tasks
     * @return ArrayList of task from file
     * @throws IOException
     */
    public ArrayList<Task> readFile() throws IOException {
        File f = new File(Messages.FILE_PATH);
        ArrayList<Task> taskList = new ArrayList<>();

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
            System.out.println(Messages.FILE_CREATED_MESSAGE);

        }

        return taskList;

    }

    /**
     * Writes the task ArrayList to Donald.txt
     * @param taskList ArrayList of tasks
     * @throws IOException
     */
    public static void writeToFile(ArrayList<Task> taskList) throws IOException {
        FileWriter fw = new FileWriter(Messages.FILE_PATH);
        for(int i = 0; i < taskList.size(); i++) {
            String savedTask;
            savedTask = String.valueOf(taskList.get(i).getTaskType())+ "," + taskList.get(i).getTaskName()
                    + "," + taskList.get(i).isTaskComplete() + "," + taskList.get(i).getTimelineCustom() + ","
                    + "\n";
            fw.write(savedTask);
        }
        fw.close();
    }

}
