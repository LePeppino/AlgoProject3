package de.hsos.aud.project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Vertex<Integer> from;
        Vertex<Integer> to;
        double weight;
        int numberOfVertices = 0;
        int numberOfEdges = 0;
        List<Vertex<Integer>> vertices = new ArrayList<>();
        List<Edge<Integer>> edges = new ArrayList<>();

        var input = new Scanner(System.in);
        Scanner reader = null;
        String caseInput;

        System.out.println("Specify absolute path to the file containing the graph:");

        String path = input.nextLine();

        try {
            reader = new Scanner(new File(path)).useLocale(Locale.US); // for reading double values from file
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found");
            e.printStackTrace();
        }
        assert reader != null;

        numberOfVertices = reader.nextInt();
        numberOfEdges = reader.nextInt();

        //Filling the collection with vertices
        //Filling the collection with edges
        while (reader.hasNext()) {
            from = new Vertex<>(reader.nextInt());
            to = new Vertex<>(reader.nextInt());
            weight = reader.nextDouble();
            Edge<Integer> temp = new Edge<>(from,to, weight);
            from.addEdge(temp);
            to.addEdge(temp);
            vertices.add(from);
            vertices.add(to);
            edges.add(temp);
        }
        reader.close();

        System.out.println("Choose the Algorithm you would like to apply:" +
                "\n(K)ruskal [Minimal Spanning Tree]" +
                "\n(D)ijkstra [Shortest Path]");
        caseInput = input.next();

        switch (caseInput) {
            case "K":
                Graph<Integer> graphKruskal = new Graph<>(Graph.TYPE.UNDIRECTED, vertices, edges);
                Kruskal kruskalAlgo = new Kruskal();
                System.out.println(kruskalAlgo.getMinimumSpanningTree(graphKruskal).toString());
                break;
            case "D":


        }


    }
}
