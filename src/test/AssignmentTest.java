package test;

import com.assignment.Exception.JobCircularDependencyException;
import com.assignment.Exception.SelfDependencyException;
import com.assignment.Jobs.JobsManager;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AssignmentTest {

    private JobsManager jobsManager;

    @Test
    public void EmptyStringTest () throws SelfDependencyException, JobCircularDependencyException {
        List<String> jobs = new ArrayList<>();
        jobsManager = new JobsManager(jobs);
        List<Character> result = jobsManager.getJobOrder();
        Assert.assertEquals(result.size(), 0);
    }

    @Test
    public void SampleTest1 () throws SelfDependencyException, JobCircularDependencyException {
        List<String> jobs = new ArrayList<>();
        jobs.add("a => ");
        jobs.add("b => ");
        jobs.add("c => ");
        jobsManager = new JobsManager(jobs);
        List<Character> result = jobsManager.getJobOrder();
        Assert.assertEquals(result.size(), 3);
    }

    @Test
    public void SampleTest2 () throws SelfDependencyException, JobCircularDependencyException {
        List<String> jobs = new ArrayList<>();
        jobs.add("a => ");
        jobs.add("b => c");
        jobs.add("c => ");
        jobsManager = new JobsManager(jobs);
        List<Character> result = jobsManager.getJobOrder();
        Assert.assertEquals(result.size(), 3);
        int indexB = result.indexOf('b');
        int indexC = result.indexOf('c');
        Assert.assertEquals(indexC < indexB, true);
    }

    @Test
    public void SampleTest3 () throws SelfDependencyException, JobCircularDependencyException {
        List<String> jobs = new ArrayList<>();
        jobs.add("a => ");
        jobs.add("b => c");
        jobs.add("c => f");
        jobs.add("d => a");
        jobs.add("e => b");
        jobs.add("f => ");
        jobsManager = new JobsManager(jobs);
        List<Character> result = jobsManager.getJobOrder();
        Assert.assertEquals(result.size(), 6);
        int indexA = result.indexOf('a');
        int indexB = result.indexOf('b');
        int indexC = result.indexOf('c');
        int indexD = result.indexOf('d');
        int indexE = result.indexOf('e');
        int indexF = result.indexOf('f');
        Assert.assertEquals(indexF < indexC, true);
        Assert.assertEquals(indexC < indexB, true);
        Assert.assertEquals(indexB < indexE, true);
        Assert.assertEquals(indexA < indexD, true);
    }

    @Test
    public void SampleTest4 () throws SelfDependencyException, JobCircularDependencyException {
        List<String> jobs = new ArrayList<>();
        jobs.add("z => ");
        jobs.add("b => c");
        jobs.add("c => f");
        jobs.add("d => z");
        jobs.add("e => b");
        jobs.add("f => ");
        jobsManager = new JobsManager(jobs);
        List<Character> result = jobsManager.getJobOrder();
        Assert.assertEquals(result.size(), 6);
        int indexZ = result.indexOf('z');
        int indexB = result.indexOf('b');
        int indexC = result.indexOf('c');
        int indexD = result.indexOf('d');
        int indexE = result.indexOf('e');
        int indexF = result.indexOf('f');
        Assert.assertEquals(indexF < indexC, true);
        Assert.assertEquals(indexC < indexB, true);
        Assert.assertEquals(indexB < indexE, true);
        Assert.assertEquals(indexZ < indexD, true);
    }

    @Test(expected = SelfDependencyException.class)
    public void SelfDependencyTest () throws SelfDependencyException, JobCircularDependencyException {
        List<String> jobs = new ArrayList<>();
        jobs.add("a => ");
        jobs.add("b => ");
        jobs.add("c => c");

        jobsManager = new JobsManager(jobs);
        List<Character> result = jobsManager.getJobOrder();
        Assert.assertEquals(result.size(), 3);
    }

    @Test(expected = JobCircularDependencyException.class)
    public void CircularDependencyTest () throws SelfDependencyException, JobCircularDependencyException {
        List<String> jobs = new ArrayList<>();
        jobs.add("a => ");
        jobs.add("b => c");
        jobs.add("c => f");
        jobs.add("d => a");
        jobs.add("e => ");
        jobs.add("f => b");

        jobsManager = new JobsManager(jobs);
        List<Character> result = jobsManager.getJobOrder();
        Assert.assertEquals(result.size(), 6);
    }
}