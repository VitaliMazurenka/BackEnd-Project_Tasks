package ait.TaskList.dao;

import ait.TaskList.model.Task;

import java.time.LocalDate;

public interface TaskList {
    boolean addTask(Task task);
    boolean checkTaskList();
    double getTaskListByPerson(String person);
    double getTaskListByType(String type);
    double getTaskListByDate(LocalDate from, LocalDate to);
}
