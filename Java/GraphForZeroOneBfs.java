package main;


import java.util.Deque;
import java.util.LinkedList;


public class GraphForZeroOneBfs {
    private static int V;
    private static LinkedList<Integer> adjListArray[];
    private static int[] cost;
    private static int costBetweenNode[][];

    public GraphForZeroOneBfs(int V) {
        this.V = V;
        adjListArray = new LinkedList[V];
        cost = new int[V];
        costBetweenNode = new int[V][V];
        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
            cost[i] = Integer.MAX_VALUE;
        }

    }

    public static void addEdge(int nodeOne, int nodeTwo, int cost) {
        adjListArray[nodeOne].add(nodeTwo);
        adjListArray[nodeTwo].add(nodeOne);
        costBetweenNode[nodeOne][nodeTwo] = cost;
        costBetweenNode[nodeTwo][nodeOne] = cost;
    }

    public static void zeroOneBfs(int source, int minCost, int maxCost) {
        boolean visit[] = new boolean[V];
        Deque<Integer> deque = new LinkedList<>();
        int currentNode;
        int tempCost;

        deque.add(source);
        cost[source] = 0;

        while (!deque.isEmpty()) {
            currentNode = deque.poll();

            if(!visit[currentNode]){
                visit[currentNode] = true;
                for (Integer x : adjListArray[currentNode]) {

                        if (costBetweenNode[currentNode][x] == minCost)
                            deque.addFirst(x);
                        else deque.addLast(x);

                            tempCost = cost[currentNode] + costBetweenNode[currentNode][x];

                            if (cost[x] > tempCost){

                                cost[x] = tempCost;

                            }
                }

            }


        }
    }

    public static int[] getCost() {
        return cost;
    }

    public static void main(String[] args) {
        int v = 7;
        GraphForZeroOneBfs graphForZeroOneBfs = new GraphForZeroOneBfs(v);

        addEdge(0, 1, 2);
        addEdge(0, 3, 5);
        addEdge(0, 6, 5);
        addEdge(1, 3, 2);
        addEdge(1, 6, 5);
        addEdge(1, 2, 5);
        addEdge(1, 4, 2);
        addEdge(2, 6, 2);
        addEdge(2, 6, 2);
        addEdge(2, 5, 2);
        addEdge(4, 5, 5);

        zeroOneBfs(6, 2, 5);

        for (int i = 0; i < v; i++) {
            System.out.println(i + ": " + cost[i]);
        }


    }

}
