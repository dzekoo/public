package com.assignment.Exception;

public class SelfDependencyException extends Exception {
    public SelfDependencyException() {
        super("Error: JobsManager can't depend on themselves");
    }
}
