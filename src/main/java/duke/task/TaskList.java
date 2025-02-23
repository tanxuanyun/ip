package duke.task;
import java.util.ArrayList;

/**
 * Encapsulates a list of tasks.
 */
public class TaskList {

    private ArrayList<Task> tasks;

    /**
     * Constructs a new {@code TaskList} with no tasks.
     */
    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    /**
     * Sets {@code tasks} in a {@code ArrayList}.
     * @param tasks The ArrayList of tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Gets {@code tasks} from {@code ArrayList}.
     * @return The ArrayList of tasks.
     */
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Adds a task in the {@code ArrayList}.
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Removes a task from the {@code ArrayList}
     * @param index The index of the task to remove.
     * @return The task object that was deleted.
     */
    public Task removeTask(int index) {
        assert 0 <= index && index < tasks.size();
        Task task = tasks.get(index - 1);
        tasks.remove(index - 1);
        return task;
    }

    /**
     * Gets the total number of tasks.
     * @return The total number of tasks.
     */
    public int getNumberOfTasks() {
        return this.tasks.size();
    }

    /**
     * Sets the task status.
     * @param taskId The id of the task.
     * @param isDone The status to be change to.
     * @return The task which status is set.
     */
    public Task changeTaskStatus(int taskId, boolean isDone) {
        assert 0 <= taskId && taskId < tasks.size();
        Task task = tasks.get(taskId - 1);
        task.setIsDone(isDone);
        return task;
    }

    //@@author DanielLimWeiEn -reused

    /**
     * Finds tasks with user input.
     * @param target The user input.
     * @return The ArrayList of task with user input.
     */
    public ArrayList<Task> findMatchTasks(String target) {
        ArrayList<Task> filtered = new ArrayList<>();
        if (target.equals("")) {
            return this.tasks;
        }

        for (Task task : this.tasks) {
            if (task.getDescription().contains(target)) {
                filtered.add(task);
            }
        }

        return filtered;
    }
    //@@author

    /**
     * Finds deadline which are unmarked
     * @return The ArrayList of deadlines which are unmarked.
     */
    public ArrayList<Task> findRemindTasks() {
        ArrayList<Task> filtered = new ArrayList<>();

        for (Task task : this.tasks) {
            if (task.toString().contains("[D]") && task.getStatusIcon().equals(" ")) {
                filtered.add(task);
            }
        }

        return filtered;
    }
}
