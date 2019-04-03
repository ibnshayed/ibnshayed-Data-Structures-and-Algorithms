import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
    public static int vertex;
    public static LinkedList<Integer> adjLinkedList[];
    public static int[] inDegree;
    public static int[] answare;

    public TopologicalSort(int totalVertex){
        vertex = totalVertex;
        adjLinkedList = new LinkedList[vertex];
        inDegree = new int[vertex];
        Arrays.fill(inDegree,0);
        answare = new int[vertex];
        for(int i = 0; i<vertex; i++){
            adjLinkedList[i] = new LinkedList<>();
        }
    }
    public static void addEdge(int nodeOne,int nodeTwo){
        adjLinkedList[nodeOne].add(nodeTwo);
        inDegree[nodeTwo] += 1;
    }

    public static void topologicalSortOnAction(){
        Queue<Integer> queue = new LinkedList<>();
        int currentNode,k = 0;
        for(int i = 0; i<vertex; i++){
            if(inDegree[i] <= 0)
                queue.add(inDegree[i]);
        }
        while(!queue.isEmpty()){
            currentNode = queue.poll();
            answare[k++] = currentNode;
            for(Integer x : adjLinkedList[currentNode]){
                inDegree[x] -= 1;
                if(inDegree[x] == 0){
                    queue.add(x);
                }
            }
        }
    }

    public static void main(String[] args) {
        int totalVertex = 7;
        new TopologicalSort(totalVertex);
        addEdge(0,1);
        addEdge(0,5);
        addEdge(1,2);
        addEdge(1,3);
        addEdge(2,3);
        addEdge(3,4);
        addEdge(5,3);
        addEdge(5,6);
        addEdge(6,4);

        topologicalSortOnAction();
        for (Integer x : answare)
            System.out.print(x + " ");
    }
}
