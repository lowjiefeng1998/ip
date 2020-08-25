package duke.command;

import duke.storage.Storage;
import duke.storage.StorageException;
import duke.task.Task;
import duke.task.TaskException;
import duke.task.TaskList;
import duke.task.TaskType;

/**
 * Encapsulates the logic for adding tasks.
 */
public class AddCommand extends Command {
    private final TaskType taskType;

    /**
     * Constructs a AddCommand with a given TaskType.
     *
     * @param args Arguments for the command.
     * @param taskType TaskType for which task to add.
     */
    public AddCommand(String args, TaskType taskType) {
        super(args);
        this.taskType = taskType;
    }

    @Override
    public String execute(TaskList taskList, Storage storage) throws TaskException, StorageException {
        Task newTask = null;
        switch (taskType) {
        case DEADLINE:
            newTask = taskList.addDeadline(args);
            break;
        case EVENT:
            newTask = taskList.addEvent(args);
            break;
        case TODO:
            newTask = taskList.addTodo(args);
            break;
        }
        storage.save(taskList);
        return "Alright! Adding one more item:\n" + newTask.toString();
    }
}
