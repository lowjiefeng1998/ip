package duke.command;

import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;

import java.util.List;

/**
 * Encapsulates the logic for listing tasks.
 */
public class ListCommand extends Command {

    /**
     * Constructs a ListCommand.
     *
     * @param args Arguments are unused.
     */
    public ListCommand(String args) {
        super(args);
    }

    @Override
    public String execute(TaskList taskList, Storage storage) {
        StringBuilder string = new StringBuilder();
        List<Task> list = taskList.getTaskList();
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                string.append("\n");
            }
            string.append((i + 1) + ". ").append(list.get(i).toString());
        }
        return string.toString();
    }
}
