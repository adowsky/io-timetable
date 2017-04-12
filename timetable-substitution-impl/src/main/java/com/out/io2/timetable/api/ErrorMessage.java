package com.out.io2.timetable.api;


public class ErrorMessage {
    String message;
    String filed;

    public ErrorMessage(String message, String filed) {
        this.message = message;
        this.filed = filed;
    }

    public String getMessage() {
        return message;
    }

    public String getFiled() {
        return filed;
    }
}
