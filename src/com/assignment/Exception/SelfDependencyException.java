package com.assignment.Exception;

public class SelfDependencyException extends Exception {
    public SelfDependencyException() {
        super("Error: Jobs can't depend on themselves");
    }
}
