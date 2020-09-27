package Parser;

public class Parser {

    public String taskArray[] = new String[3];

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
                taskArray[2] = taskArray[1].substring(slashPos + 3);
                taskArray[1] = taskArray[1].substring(0, slashPos - 1);
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


}
