import java.util.LinkedList;
import java.util.PriorityQueue;


public class Dijkstra {
    public static int vertex;
    public static LinkedList<Integer> adjLinedList[];
    public static int[] cost;
    public static int[][] costBetweenNode;

    public Dijkstra(int totalVertex) {
        vertex = totalVertex;
        adjLinedList = new LinkedList[vertex];
        cost = new int[vertex];
        costBetweenNode = new int[vertex][vertex];

        for(int i = 0; i<vertex; i++){
            adjLinedList[i] = new LinkedList<>();
            cost[i] = Integer.MAX_VALUE;
        }
    }

    public static void addEdge(int nodeOne, int nodeTwo, int cost){
        adjLinedList[nodeOne].add(nodeTwo);
        adjLinedList[nodeTwo].add(nodeOne);
        costBetweenNode[nodeOne][nodeTwo] = cost;
        costBetweenNode[nodeTwo][nodeOne] = cost;
    }

    public static void dijkstraOnAction(int source){
        boolean[] visit = new boolean[vertex];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int currentNode;
        int tempCost;

        priorityQueue.add(source);
        cost[source] = 0;

        while (!priorityQueue.isEmpty()){
            currentNode = priorityQueue.remove();

            if(!visit[currentNode]){
                visit[currentNode] = true;
                for(Integer x : adjLinedList[currentNode]){
                    priorityQueue.add(x);
                    tempCost = cost[currentNode] + costBetweenNode[currentNode][x];
                    if(tempCost < cost[x])
                        cost[x] = tempCost;


                }

            }
        }

    }


    public static void main(String[] args) {
        int totalVertex = 8;
        new Dijkstra(totalVertex);
        addEdge(0,1,10);
        addEdge(0,2,5);
        addEdge(0,6,15);
        addEdge(1,2,15);
        addEdge(1,3,2);
        addEdge(1,4,10);
        addEdge(2,3,5);
        addEdge(2,5,7);
        addEdge(2,6,10);
        addEdge(3,4,7);
        addEdge(4,7,10);
        addEdge(5,7,15);

        int source = 3;
        dijkstraOnAction(source);

        for(int i = 0; i<vertex; i++)
            System.out.println(i + " : " + cost[i]);

    }

}
