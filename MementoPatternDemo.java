import java.util.ArrayList;
import java.util.List;

class TaskMemento {
    private final List<String> tasks;

    public TaskMemento(List<String> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }

    public List<String> getTasks() {
        return tasks;
    }
}

class TaskManager {
    private List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public TaskMemento save() {
        return new TaskMemento(tasks);
    }

    public void restore(TaskMemento memento) {
        if (memento != null) {
            tasks = memento.getTasks();
        }
    }

    public void showTasks() {
        System.out.println("Tareas actuales: " + (tasks.isEmpty() ? "No hay tareas" : String.join(", ", tasks)));
    }
}

class History {
    private List<TaskMemento> mementos = new ArrayList<>();

    public void add(TaskMemento memento) {
        mementos.add(memento);
    }

    public TaskMemento undo() {
        if (!mementos.isEmpty()) {
            return mementos.remove(mementos.size() - 1);
        }
        return null;
    }
}

public class MementoPatternDemo {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        History history = new History();

        taskManager.addTask("Comprar leche");
        history.add(taskManager.save());

        taskManager.addTask("Hacer ejercicio");
        history.add(taskManager.save());

        taskManager.showTasks();

        taskManager.restore(history.undo());
        taskManager.showTasks();

        taskManager.restore(history.undo());
        taskManager.showTasks();
    }
}
