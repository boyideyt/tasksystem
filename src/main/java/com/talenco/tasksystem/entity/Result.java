package com.talenco.tasksystem.entity;

public class Result {
    private boolean signal;
    private String message;

    public Result(boolean signal, String message) {
        this.signal = signal;
        this.message = message;
    }

    public boolean isSignal() {
        return signal;
    }

    public void setSignal(boolean signal) {
        this.signal = signal;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
