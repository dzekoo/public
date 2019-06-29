package com.assignment.Graph;

import com.assignment.Exception.CircularDepndencyException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Graph {

    private final int MAX_VERTICES = 100;
    private final LinkedList<Integer>[] adjList;

    public Graph() {
        adjList = new LinkedList[MAX_VERTICES];
    }

    public void addEdge(int start, int end) {
        addVertice(start);
        addVertice(end);
        adjList[start].add(end);
    }

    public void addVertice(int vertice) {
        if (adjList[vertice] == null) {
            adjList[vertice] = new LinkedList<>();
        }
    }

    private int getVerticesCount() {
        return adjList.length;
    }

    private void getTopologicalOrderUtil(int currentVertex, boolean[] visited, Stack<Integer> stack) throws CircularDepndencyException {

        if (stack.contains(currentVertex)) {
            throw new CircularDepndencyException();
        }

        visited[currentVertex] = true;

        LinkedList<Integer> list = adjList[currentVertex];
        if (list == null)
            return;

        for (int adjacentVertex : list)
        {
            if (!visited[adjacentVertex])
            {
                getTopologicalOrderUtil(adjacentVertex, visited, stack);
            }
        }

        stack.push(currentVertex);
    }

    public List<Character> getTopologicalOrder() throws CircularDepndencyException{
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[getVerticesCount()];
        for (int itr = 0; itr < getVerticesCount(); itr++)
        {
            visited[itr] = false;
        }

        for (int itr = 0; itr < getVerticesCount(); itr++)
        {
            if (!visited[itr])
            {
                getTopologicalOrderUtil(itr, visited, stack);
            }
        }

        List<Character> result = new ArrayList<>();
        while (!stack.isEmpty())
        {
            result.add((char)('a' + stack.pop()));
        }
        return result;
    }

}
