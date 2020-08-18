import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static final String DIVIDER = "-------------------------------------";
    private static final String EXIT_COMMAND = "bye";
    private static final String LIST_COMMAND = "list";

    private static ArrayList<Task> taskList = new ArrayList<>();

    private static String sandwichWithDivider(String text) {
        return DIVIDER + "\n" + text + "\n" + DIVIDER;
    }

    private static String prettyPrintTaskList() {
        String rv = "You have " + taskList.size() + " items.\n";
        for (int i = 0; i < taskList.size(); i++) {
            rv += "\n" + (i + 1) + ": " + taskList.get(i).toString();
        }
        return sandwichWithDivider(rv);
    }

    private static String processTask(String task) {
        taskList.add(new Task(task));
        return sandwichWithDivider("Successfully added: " + task);
    }

    private static final String HELLO_MESSAGE = sandwichWithDivider("Greetings! I am Duke."
            + "\nWhat can I do for you?");
    private static final String EXIT_MESSAGE = sandwichWithDivider("Bye! See you around!");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(HELLO_MESSAGE);
        while (true) {
            String input = sc.nextLine();
            if (input.equals(EXIT_COMMAND)) {
                System.out.println(EXIT_MESSAGE);
                break;
            } else if (input.equals(LIST_COMMAND)) {
                System.out.println(prettyPrintTaskList());
            } else {
                System.out.println(processTask(input));
            }
        }

        sc.close();
    }
}
