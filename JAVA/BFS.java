import java.util.*;

public class BFS {
    private static int V;
    private static int cost[];
    private static Vector<Integer> adjListArray[];

    public BFS(int V) {
        this.V = V;
        adjListArray = new Vector[V];

        for (int i = 0; i < V; i++)
            adjListArray[i] = new Vector<>();
    }

    public static void addEdge(int u, int v) {
        adjListArray[u].add(v);
        adjListArray[v].add(u);
    }

    public static void displayGraph() {

        for (int i = 0; i < V; i++) {
            System.out.println("Node: " + i);
            System.out.print("Head ");
            for (Integer x : adjListArray[i]) {
                System.out.print(" -> " + x);
            }
            System.out.println();
        }

    }
    public static void BFSOnAction(int sourceNode){
        boolean visit[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();
        int currentNode;

        visit[sourceNode] = true;
        queue.add(sourceNode);


        while (!queue.isEmpty()){
            currentNode = queue.poll();
            bfs.add(currentNode);

            for (Integer x : adjListArray[currentNode]){
                if(!visit[x]){
                    visit[x] = true;
                    queue.add(x);
                }
            }

        }

        bfs.forEach(x -> System.out.print(x + " "));
        System.out.println();

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v = 6;
        BFS graph = new BFS(v);

        addEdge(0, 1);
        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(2, 4);
        addEdge(3, 4);
        addEdge(4, 5);
        addEdge(5, 1);
        addEdge(5, 0);
        addEdge(5, 3);

        displayGraph();
        BFSOnAction(0);
    }

}

