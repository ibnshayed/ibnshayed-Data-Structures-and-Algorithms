package main;

import java.util.Arrays;
import java.util.LinkedList;

public class DFS {
    private  static int vertex;
    private static LinkedList<Integer> adjLinkedList[];
    private static int[] visit;

    public DFS(int v) {
      this.vertex = v;
      adjLinkedList = new LinkedList[vertex];
      visit = new int[vertex];
        Arrays.fill(visit,0);
      for(int i = 0; i<vertex; i++){
          adjLinkedList[i] = new LinkedList<>();
      }
    }

    public static void addEdge(int nodeOne,int nodeTwo){
        adjLinkedList[nodeOne].add(nodeTwo);
        adjLinkedList[nodeTwo].add(nodeOne);
    }

    public static void DFSOnAction(int source){

        visit[source] = 1;
        System.out.print(source + " ");
        for(Integer x : adjLinkedList[source]){
            if(visit[x] == 0)
                DFSOnAction(x);
        }
        visit[source] = 2;

    }

    public static void main(String[] args) {
        int totalVertex = 6;
        new DFS(totalVertex);

        addEdge(0,1);
        addEdge(0,2);
        addEdge(1,3);
        addEdge(1,4);
        addEdge(3,4);
        addEdge(3,5);
        addEdge(4,5);
        int sourceNode = 0;
        DFSOnAction(sourceNode);
    }

}
