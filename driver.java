
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class driver {

    public static void main(String[] args) throws IOException {


        //start hash table
        HashMap<String, vertex> graph = new HashMap<>();
        String start = "";

        //read data in
        //File file = new File("graph24-6.txt");
      File file = new File("WarAndPeace.txt_11765_90758_graph.txt");
        Scanner sc = new Scanner(file);
        String st;
        String[] connections;
        while (sc.hasNextLine()) {
            connections = sc.nextLine().split("\\s+");

            //get first entry
            if(graph.size() == 0){
                start = connections[0];
            }

            //if new entry
            if (!graph.containsKey(connections[0])) {
                vertex temp = new vertex(0.0,null,connections[0]);
                for (int i = 1; i < connections.length - 1; i = i + 2) {
                    //read data
                    String v = connections[i];
                    double w = Double.parseDouble(connections[i + 1]);
                    connect newConnect = new connect(v,w);
                    temp.addEdge(newConnect);
                }
                graph.put(connections[0],temp);


            }  else {
                //take priority queue, add stuff, replace back into hashmap
                vertex temp = graph.get(connections[0]);
                for (int i = 1; i < connections.length - 1; i = i + 2) {
                    //read data
                    String v = connections[i];
                    double w = Double.parseDouble(connections[i + 1]);
                    connect newConnect = new connect(v,w);
                    temp.addEdge(newConnect);
                }
                graph.replace(connections[0],temp);


            }


        }



        //print the data
        for (HashMap.Entry<String,vertex> entry : graph.entrySet()){
            //print name(key)
            System.out.print(entry.getKey());
            //print vertex data
            vertex v = entry.getValue();
            System.out.print("  pi:" + v.pi + "  d:" + v.dist);
            for(connect cc: v.edges){
                System.out.print("  " + cc.vertex + ": " + cc.weight);
            }
            System.out.println();
        }



        DijkstraAlg alg = new DijkstraAlg(graph, start);
        graph = alg.solve();

        //print the data
        for (HashMap.Entry<String,vertex> entry : graph.entrySet()){
            //print name(key)
            System.out.print(entry.getKey());
            //print vertex data
            vertex v = entry.getValue();
            System.out.print("  pi:" + v.pi + "  d:" + v.dist);
            for(connect cc: v.edges){
                System.out.print("  " + cc.vertex + ": " + cc.weight);
            }
            System.out.println();
        }


    }
}