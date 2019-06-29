package com.assignment;

import com.assignment.Jobs.JobsManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> jobs = new ArrayList<>();
        jobs.add("a => ");
        jobs.add("b => c");
        jobs.add("c => f");
        jobs.add("d => a");
        jobs.add("e => b");
        jobs.add("f => ");
        try {
            JobsManager jobsManager = new JobsManager(jobs);
            List<Character> result = jobsManager.getJobOrder();
            StringBuilder builder = new StringBuilder(result.size());
            for(Character ch: result)
            {
                builder.append(ch);
            }
            System.out.println(builder.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
