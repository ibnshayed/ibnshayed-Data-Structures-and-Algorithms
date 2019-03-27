package main;

import java.util.*;
import java.util.LinkedList;

public class StronglyConnectedComponent
{
    private int vertex; // No. of vertices
    private LinkedList<Integer> mainGraph[]; //Adjacency List
    private LinkedList<Integer> reversGraph[];
    private Stack<Integer> stack;
    private boolean visited[];

    public StronglyConnectedComponent(int totalVertex)
    {
        this.vertex = totalVertex;
        mainGraph = new LinkedList[vertex];
        reversGraph = new LinkedList[vertex];
        stack = new Stack<>();
        visited = new boolean[vertex];
        Arrays.fill(visited,false);

        for (int i = 0; i< vertex; ++i){
            mainGraph[i] = new LinkedList<>();
            reversGraph[i] = new LinkedList<>();
        }

    }
    void addEdge(int nodeOne, int nodeTwo) {
        mainGraph[nodeOne].add(nodeTwo);
        reversGraph[nodeTwo].add(nodeOne);
    }

    void getStack(int source)
    {
        visited[source] = true;
        for(Integer x : mainGraph[source]){
            if(!visited[x])
                getStack(x);
        }
        stack.push(source);
    }

    void DFS(int source)
    {
        visited[source] = true;
        System.out.print(source + " ");

        for (Integer x : reversGraph[source]){
            if(!visited[x]){
                DFS(x);
            }
        }
    }

    void printSCCs()
    {
        getStack(0);
        Arrays.fill(visited,false);
        while (!stack.empty())
        {
            int currentNode = stack.pop();

            if (!visited[currentNode])
            {
                DFS(currentNode);
                System.out.println();
            }
        }
    }

    public static void main(String args[])
    {
        int tolalVertex = 8;
        StronglyConnectedComponent g = new StronglyConnectedComponent(tolalVertex);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(4,5);
        g.addEdge(5,6);
        g.addEdge(6,4);
        g.addEdge(6,7);

        System.out.println("Following are strongly connected components in given graph ");
        g.printSCCs();
    }
}

