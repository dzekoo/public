package com.assignment.Exception;

public class JobCircularDependencyException extends CircularDepndencyException {
    public JobCircularDependencyException() {
        super("Error: JobsManager can't have circular dependency");
    }
}
