import java.net.StandardSocketOptions;
import java.util.*;

public class Traversal
{
    //DFS
    public static void dfs(Graph g, String start)
    {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        stack.push(start);

        System.out.print("DFS starting from " + start + ": ");

        while(!stack.empty())
        {
            String county = stack.pop();

            if(!visited.contains(county))
            {
                System.out.print(county + " ");
                visited.add(county);

                for(String neighbour : g.getNeighbours(county))
                 if(!visited.contains(neighbour))
                     stack.push(neighbour);
            }
        }
        System.out.println();
    }

    //BFS
    public static void bfs(Graph g, String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(start);

        System.out.print("BFS starting from " + start + ": ");
        while (!queue.isEmpty()) {
            String county = queue.poll();
            if (!visited.contains(county)) {
                System.out.print(county + " ");
                visited.add(county);

                for (String neighbor : g.getNeighbours(county)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Graph g = new Graph();

        String[] counties = {"UC", "GC", "CC", "DC", "SC", "OC", "PC"};
        for (String c : counties) {
            g.addNode(c);
        }

        g.addEdge("UC", "GC");
        g.addEdge("UC", "DC");
        g.addEdge("UC", "SC");
        g.addEdge("GC", "CC");
        g.addEdge("CC", "DC");
        g.addEdge("DC", "PC");
        g.addEdge("SC", "OC");
        g.addEdge("OC", "PC");

        // Run traversals
        dfs(g, "UC");
        bfs(g, "UC");
    }
}
