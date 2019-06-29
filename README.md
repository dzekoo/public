Java Progam for coding challenge

PROBLEM STATEMENT :
List of dependent jobs are provided. We need to print the jobs in the order such that all the jobs which are dependent on job X should be printed before it.

SOLUTION:
I have used directed acyclic graph. All jobs are represented as vertices and directed edge is used to represent dependency.
Topological sorting is used to get the jobs in correct order.

DIRECTORY STRUCTURE

src/com/assignment : contains the business logic
    /Exceptions : Exception for jobs.
    /Graph : Logic for graph creation. Graph is represented using adjacency list.
    /Jobs : JobsManager contains a private graph for all the listed jobs.

src/test : functional tests in junit
