package com.assignment.Jobs;

import java.util.List;

import com.assignment.Exception.CircularDepndencyException;
import com.assignment.Exception.JobCircularDependencyException;
import com.assignment.Exception.SelfDependencyException;
import com.assignment.Graph.Graph;

public class JobsManager {

    private Graph jobGraph;

    public JobsManager(List<String> jobsList) throws SelfDependencyException {
        jobGraph = new Graph();
        processJobsList(jobsList);
    }

    private void processJobsList (List<String> jobsList) throws SelfDependencyException {
        for (String job : jobsList) {
            String[] chars = job.split(" => ");
            Character firstJob = chars[0].charAt(0);
            Character secondJob = chars.length > 1 ? chars[1].charAt(0) : null;

            addJobs(firstJob, secondJob);
        }
    }

    private void addJobs(Character start, Character end) throws SelfDependencyException {

        if (start.equals(end)) {
            throw new SelfDependencyException();
        }
        if (end == null) {
            jobGraph.addVertice(start - 'a');
        } else {
            jobGraph.addEdge(start - 'a', end - 'a');
        }
    }

    public List<Character> getJobOrder() throws JobCircularDependencyException {
        try {
            return jobGraph.getTopologicalOrder();
        } catch (CircularDepndencyException ex) {
            throw new JobCircularDependencyException();
        }

    }
}
