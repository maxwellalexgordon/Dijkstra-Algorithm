import java.util.LinkedList;
import java.util.PriorityQueue;

public class vertex implements Comparable<vertex>{
    public Double dist;
    public String pi;
    public String name;
    public PriorityQueue<connect> edges;

    public vertex(Double d, String p, String n){
        this.dist = Double.POSITIVE_INFINITY;
        this.pi = p;
        this.name = n;
        this.edges = new PriorityQueue<>();
    }

    public void addEdge(connect c){
        this.edges.add(c);
    }


    @Override
    public int compareTo(vertex vertex) {
        return this.dist.compareTo(vertex.dist);
    }
}


