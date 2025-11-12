import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<String, List<String>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addNode(String county)
    {
        adjList.putIfAbsent(county, new ArrayList<>());
    }

    public void addEdge(String county1, String county2)
    {
        adjList.get(county1).add(county2);
        adjList.get(county2).add(county1);
    }

    public List<String> getNeighbours(String county)
    {
        return adjList.get(county);
    }
}
