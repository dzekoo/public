package com.assignment.Exception;

public class CircularDepndencyException extends Exception {
    public CircularDepndencyException() {
        super("Error: Graph contain circular dependency");
    }

    public CircularDepndencyException (String s) {
        super(s);
    }
}
