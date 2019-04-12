import java.util.LinkedList;

public class BellmanFord {
    public static int vertex;
    public static LinkedList<Integer> adjLinedList[];
    public static int[] cost;
    public static int[][] costBetweenNode;

    public static void addEdge(int nodeOne, int nodeTwo, int cost){
        adjLinedList[nodeOne].add(nodeTwo);
        adjLinedList[nodeTwo].add(nodeOne);
        costBetweenNode[nodeOne][nodeTwo] = cost;
        costBetweenNode[nodeTwo][nodeOne] = cost;
    }


    public BellmanFord(int totalVertex) {
        vertex = totalVertex;
        adjLinedList = new LinkedList[vertex];
        cost = new int[vertex];
        costBetweenNode = new int[vertex][vertex];

        for(int i = 0; i<vertex; i++){
            adjLinedList[i] = new LinkedList<>();
            cost[i] = 99999;
        }
    }

    public static void bellmanFordOnAction(int source,int[] order){
        int tempCost;
        int changeValue;
        cost[source] = 0;

        for(int k = 0; k<order.length; k++){
            changeValue = 0;
            for(int i = 0; i<order.length; i++){
                for(Integer x : adjLinedList[i]){

                    tempCost = cost[i] + costBetweenNode[i][x];

                    if(tempCost < cost[x]) {
                        cost[x] = tempCost;
                        System.out.println("New Cost of " + x  +" is : " + cost[x]);
                        ++changeValue;
                    }

                }
            }

                if(changeValue == 0) {
                    break;
                }
                if(k == order.length - 1 && changeValue > 0) {
                    System.out.println("This Graph has negetive value on edge.");
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
        addEdge(4,5,5);


        int[] order = {0,1,2,3,4,5};
        int source = 5;
        bellmanFordOnAction(source,order);

        for(int i = 0; i<vertex; i++)
            System.out.println(i + " : " + cost[i]);

    }
}
