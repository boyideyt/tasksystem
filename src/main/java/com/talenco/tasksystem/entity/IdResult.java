package com.talenco.tasksystem.entity;

public class IdResult extends Result {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IdResult(boolean signal, String message, int id) {
        super(signal, message);
        this.id = id;
    }

    public IdResult(boolean signal, String message) {
        super(signal, message);
    }
}
