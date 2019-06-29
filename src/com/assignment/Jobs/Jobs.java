package com.assignment.Jobs;

import java.util.List;

import com.assignment.Exception.CircularDepndencyException;
import com.assignment.Exception.JobCircularDependencyException;
import com.assignment.Exception.SelfDependencyException;
import com.assignment.Graph.Graph;

public class Jobs {

    private Graph jobGraph;

    public Jobs (List<String> jobsList) throws SelfDependencyException {
        jobGraph = new Graph();

        for (String job : jobsList) {
            String[] chars = job.split(" => ");
            Character firstJob = chars[0].charAt(0);
            Character secondJob = chars[1].charAt(0);

            addEdge(firstJob, secondJob);
        }
    }

    private void addEdge(Character start, Character end) throws SelfDependencyException {

        if (start.equals(end)) {
            throw new SelfDependencyException();
        }

        jobGraph.addEdge(start - 'a', end - 'a');
    }

    public List<Character> getJobOrder() throws JobCircularDependencyException {
        try {
            return jobGraph.getTopologicalOrder();
        } catch (CircularDepndencyException ex) {
            throw new JobCircularDependencyException();
        }

    }
}
