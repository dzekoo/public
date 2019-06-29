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
            Character firstjob = chars[0].charAt(0);
            Character DependeeJob = chars.length > 1 ? chars[1].charAt(0) : null;

            addJobs(firstjob, DependeeJob);
        }
    }

    private void addJobs(Character job, Character DependeeJob) throws SelfDependencyException {

        if (job.equals(DependeeJob)) {
            throw new SelfDependencyException();
        }
        if (DependeeJob == null) {
            jobGraph.addVertice(job - 'a');
        } else {
            jobGraph.addEdge(DependeeJob - 'a', job - 'a');
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
