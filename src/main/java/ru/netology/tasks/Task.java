package ru.netology.tasks;

public class Task {
    protected int id;

    public Task(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean matches(String query) {
        return false;
    }

}
