import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraAlg {


    private HashMap<String, vertex> graph;
    private String start;

    public DijkstraAlg(HashMap<String, vertex> graph, String start) {
        this.graph = graph;
        this.start = start;
    }

    public HashMap<String, vertex> solve() {
        //initilize sources
        vertex first = this.graph.get(start);
        first.dist = 0.0;

        //add start to the queue
        PriorityQueue<vertex> Q = new PriorityQueue<>();
        Q.add(this.graph.get(start));

        while (!Q.isEmpty()) {
            //extract min
            vertex u = Q.poll();

            for (connect v : u.edges) {
                //vertex v
                vertex V = this.graph.get(v.vertex);

                if (relax(u, v)) {
                    if (Q.contains(V)) {
                        Q.remove(V);
                    }
                    Q.add(V);
                }
            }
        }
        return this.graph;
    }

    public boolean relax(vertex u, connect v) {
        double w = v.weight;
        vertex V = this.graph.get(v.vertex);
        if (V.dist > u.dist + w) {
            V.dist = u.dist + w;
            V.pi = u.name;
            return true;
        }
        return false;

    }
}
