package com.assignment.Jobs;

import java.util.List;
import com.assignment.Graph.Graph;

public class Jobs {

    private Graph jobGraph;

    public Jobs (List<String> jobsList) {
        jobGraph = new Graph();

        for (String job : jobsList) {
            String[] chars = job.split(" => ");
            Character firstJob = chars[0].charAt(0);
            Character secondJob = chars[1].charAt(0);

            addEdge(firstJob, secondJob);
        }
    }

    private void addEdge(Character start, Character end) {
        jobGraph.addEdge(start - 'a', end - 'a');
    }

    public List<Character> getJobOrder() {
        return jobGraph.getTopologicalOrder();
    }
}
