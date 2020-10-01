package TaskList;

import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;
import ui.TextUi;
import Parser.Parser;
import Messages.Messages;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class manages the list of tasks in the following ways:
 * Adds Todo, Deadline and Event tasks to the list
 * Marks tasks as complete in the list
 * Deletes tasks in the list
 * Returns the list and number of tasks
 */
public class TaskList {
    private static TextUi ui;
    private static ArrayList<Task> taskArrayList;

    public TaskList(ArrayList<Task> taskArrayList){
        this.taskArrayList = taskArrayList;
        ui = new TextUi();
    }

    public TaskList(){
        taskArrayList = new ArrayList<Task>();
    }


    /**
     * Adds a Todo task
     * @param taskArray
     */
    public void addTodo(String[] taskArray){
        Task newTodo = new Todo(taskArray[1]);
        taskArrayList.add(newTodo);
    }


    /**
     * Adds a deadline task
     * @param taskArray
     */
    public void addDeadline(String[] taskArray){
        Task newDeadline = new Deadline(taskArray[1], taskArray[2]);
        taskArrayList.add(newDeadline);
    }


    /**
     * Adds an event task
     * @param taskArray
     */
    public void addEvent(String[] taskArray){
        Task newEvent = new Event(taskArray[1], taskArray[2]);
        taskArrayList.add(newEvent);
    }


    /**
     * @return taskArrayList
     */
    public ArrayList<Task> getTaskArrayList(){
        return taskArrayList;
    }


    /**
     * @return size of taskArrayList
     */
    public int getListSize(){
        return taskArrayList.size();
    }


    /**
     * Marks the given task as done
     * @param taskNumber the task to be marked as done
     * @param taskList
     * @throws IOException
     */
    public void taskDone(String taskNumber, ArrayList<Task> taskList) throws IOException {
        int taskNum = Integer.parseInt(taskNumber);
        taskNum = taskNum - 1;
        String taskStatus = Messages.taskComplete;
        char taskType = taskList.get(taskNum).getTaskType();
        switch (taskType) {
        case 'T':
            Task completedTodo = new Todo(taskList.get(taskNum).getTaskName());
            completedTodo.setTaskComplete();
            taskList.set(taskNum, completedTodo);
            break;

        case 'D':
            Task completedDeadline = new Deadline(taskList.get(taskNum).getTaskName(),
                    taskList.get(taskNum).getTimeline());
            completedDeadline.setTaskComplete();
            taskList.set(taskNum, completedDeadline);
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

        ui.printDoneTask(taskList, taskNum, taskStatus);
    }


    /**
     * Deletes the given task
     * @param taskNumber the task to be deleted
     * @param taskList
     * @throws IOException
     */
    public static void taskDelete(String taskNumber, ArrayList<Task> taskList) throws IOException{
        int taskNum = Integer.parseInt(taskNumber);
        taskNum = taskNum - 1;
        char taskType = taskList.get(taskNum).getTaskType();
        String taskStatus = (taskList.get(taskNum).isTaskComplete())
                ? Messages.taskComplete : Messages.taskIncomplete;
        if(taskType == 'T'){
            ui.displayDeleteTodo(taskList.get(taskNum).getTaskName(),
                    taskStatus, taskList.size() - 1, taskType);
        }else{
            ui.displayDeletedTodoWithTime(taskList.get(taskNum).getTaskName(),
                    taskStatus, taskList.size() - 1, taskType, taskList.get(taskNum).getTimeline());
        }
        taskArrayList.remove(taskNum);
    }





}
