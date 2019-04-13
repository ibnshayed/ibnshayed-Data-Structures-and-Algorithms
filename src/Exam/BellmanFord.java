package Exam;

import java.util.LinkedList;

public class BellmanFord {
    private static int vertex;
    private static LinkedList<Integer> graph[];
    private static int[] cost;
    private static int[][] costBetweenNode;

    public BellmanFord(int totalVertex) {
        vertex = totalVertex;
        graph = new LinkedList[vertex];
        cost = new int[vertex];
        costBetweenNode = new int[vertex][vertex];
        for(int i = 0; i<vertex; i++){
            graph[i] = new LinkedList<>();
            cost[i] = 9999;
        }
    }
    public static void addEdge(int nodeOne,int nodeTwo,int cost){
        graph[nodeOne].add(nodeTwo);
        graph[nodeTwo].add(nodeOne);
        costBetweenNode[nodeOne][nodeTwo] = cost;
        costBetweenNode[nodeTwo][nodeOne] = cost;

    }
    public static void bellmanFordOnAction(int source, int[] order){
        cost[source] = 0;
        int tempCost = 0;
        int changeValue;
        for(int i = 0; i<vertex; i++){
            changeValue = 0;
            for(int j = 0; j< order.length; j++){
                for(Integer x : graph[order[j]]){
                    tempCost = cost[order[j]] + costBetweenNode[order[j]][x];
                    if(tempCost<cost[x]){
                        cost[x] = tempCost;
                        changeValue++;
                    }
                }
            }
            if(changeValue <= 0)
                break;
            if(i == vertex - 1 && changeValue >= 0){
                System.out.println("This graph has negetive cycle.");
                break;
            }
        }
    }



    public static void main(String[] args) {
        int totalVertex = 6;
        new BellmanFord(totalVertex);
        addEdge(0,1,5);
        addEdge(0,2,10);
        addEdge(1,4,15);
        addEdge(2,3,20);
        addEdge(3,4,10);
        addEdge(3,5,15);
        addEdge(4,5,- 5);


        int[] order = {0,1,2,3,4,5};
        int source = 5;
        bellmanFordOnAction(source,order);

        for(int i = 0; i<vertex; i++)
            System.out.println(i + " : " + cost[i]);
    }
}
