import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ArticulationPoint {
    private static int vertex;
    private static LinkedList<Integer> adjLinkedList[];
    private static int[] discTime ;
    private static int[] lowTime ;
    private static boolean[] visited;
    private static int time;
    private static int childNode;
    private static List<Integer> resultList;


    public ArticulationPoint(int totalVertex) {
        vertex = totalVertex;
        adjLinkedList = new LinkedList[vertex];
        discTime = new int[vertex];
        lowTime = new int[vertex];
        visited = new boolean[vertex];
        Arrays.fill(visited,false);
        time = 0;
        childNode = 0;
        resultList = new ArrayList<>();
        for(int i = 0; i<vertex; i++){
            adjLinkedList[i] = new LinkedList<>();
        }
    }
    public static void addEdge(int nodeOne, int nodeTwo){
        adjLinkedList[nodeOne].add(nodeTwo);
    }
    public static void articulationPointOnAction(){

        int source = 0;
        DFS(source);
        resultList.forEach(x -> System.out.print(x + " "));

    }
    public static void DFS(int source){
       visited[source] = true;
       discTime[source] = lowTime[source] = ++time;

       for(Integer x : adjLinkedList[source]){
           childNode++;
           if(!visited[x])
               DFS(x);
           if(visited[x] == true){
               lowTime[source] = Math.min(lowTime[source],discTime[x]);
           }
           lowTime[source] = Math.min(lowTime[source],lowTime[x]);
       }
       if(childNode > 1)
           resultList.add(source);
    }

    public static void main(String[] args) {
        int totalVertex = 8;
        new ArticulationPoint(totalVertex);
        addEdge(1,2);
        addEdge(2,0);
        addEdge(0,1);
        addEdge(0,3);
        addEdge(3,4);
        addEdge(4,5);
        addEdge(5,6);
        addEdge(6,4);
        addEdge(6,7);
        articulationPointOnAction();
    }
}
