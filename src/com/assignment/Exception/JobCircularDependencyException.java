package com.assignment.Exception;

public class JobCircularDependencyException extends CircularDepndencyException {
    public JobCircularDependencyException() {
        super("Error: Jobs can't have circular dependency");
    }
}
