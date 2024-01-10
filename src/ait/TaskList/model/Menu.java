package ait.TaskList.model;

public enum Menu {
    SET_TASKLIST(1, "Month tasklist"),
    ADD_TASK(2, "Add task"),
    CHECK_TASKLIST(3, "Check tasklist"),
    TASK_TYPE(4, "Task by type"),
    TASK_PERSON(5, "Task by person"),
    TASK_DATE(6, "Tasks from ... to"),
    SAVE(7, "Save"),
    LOAD(8, "Load"),
    EXIT(9, "Exit");


    private int id;
    private String item;

    Menu(int id, String item) {
        this.id = id;
        this.item=item;
    }

    public static void printMenu(){
        Menu[] menu = Menu.values();
        for (int i = 0; i < menu.length; i++) {
            System.out.print(menu[i].id + ": " + menu[i].item + " | ");
        }
        System.out.println();
        System.out.println("Input your choice: ");
    }
}
