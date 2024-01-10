package ait.TaskList.dao;

import ait.TaskList.model.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskListImpl implements TaskList{
    double taskList;
    List<Task> tasks = new ArrayList<>();

    public TaskListImpl(double taskList, List<Task> tasks) {
        this.taskList = taskList;
        this.tasks = tasks;
    }

    @Override
    public boolean addTask(Task task) {
        if(task==null || tasks.contains(task)){
            return false;
        }
        return tasks.add(task);
    }

    @Override
    public boolean checkTaskList() {
        double res = calcTaskList();
        return res < taskList;
    }

    private double calcTaskList() {
        return tasks.stream()
                .mapToDouble(Task ::getAmount)
                .sum();

    }

    @Override
    public double getTaskListByPerson(String person) {
        return tasks.stream()
                .filter(task->task.getPersonName().equalsIgnoreCase(person))
                .mapToDouble(Task ::getAmount)
                .sum();
    }

    @Override
    public double getTaskListByType(String type) {
        return tasks.stream()
                .filter(task->task.getTypeOfTask().equalsIgnoreCase(type))
                .mapToDouble(Task ::getAmount)
                .sum();
    }

    @Override
    public double getTaskListByDate(LocalDate from, LocalDate to) {
        return tasks.stream()
                .filter(task->task.getDate().isAfter(from)&&task.getDate().isBefore(to))
                .mapToDouble(Task ::getAmount)
                .sum();
    }
}
