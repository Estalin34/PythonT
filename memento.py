class TaskMemento:
    def __init__(self, tasks):
        self.tasks = list(tasks)  

class TaskManager:
    def __init__(self):
        self.tasks = []

    def add_task(self, task):
        self.tasks.append(task)

    def remove_task(self, task):
        if task in self.tasks:
            self.tasks.remove(task)

    def save(self):
        return TaskMemento(self.tasks)

    def restore(self, memento):
        if memento:
            self.tasks = memento.tasks

    def show_tasks(self):
        print(f"Tareas actuales: {', '.join(self.tasks) if self.tasks else 'No hay tareas'}")

class History:
    def __init__(self):
        self.mementos = []

    def add(self, memento):
        self.mementos.append(memento)

    def undo(self):
        if self.mementos:
            return self.mementos.pop()
        return None


task_manager = TaskManager()
history = History()

task_manager.add_task("Comprar leche")
history.add(task_manager.save())  

task_manager.add_task("Hacer ejercicio")
history.add(task_manager.save())  

task_manager.show_tasks()  

task_manager.restore(history.undo())
task_manager.show_tasks()  

task_manager.restore(history.undo())
task_manager.show_tasks()  
