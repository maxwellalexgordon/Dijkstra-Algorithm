public class connect implements Comparable<connect>{
    String vertex;
    Double weight;

    public connect(String v, Double w){
        vertex = v;
        weight = w;
    }

    @Override
    public int compareTo(connect other){
        return this.weight.compareTo(other.weight);
    }
}
