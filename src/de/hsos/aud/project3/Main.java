package de.hsos.aud.project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Vertex from;
        Vertex to;
        double weight;
        int numberOfVertices = 0;
        int numberOfEdges = 0;
        List<Vertex> vertices = new ArrayList<Vertex>();
        List<Edge> edges = new ArrayList<Edge>();

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
            from = new Vertex(reader.nextInt());
            to = new Vertex(reader.nextInt());
            weight = reader.nextDouble();
            Edge temp = new Edge(from,to, weight);
            from.addEdge(temp);
            to.addEdge(temp);
            vertices.add(from);
            vertices.add(to);
            edges.add(temp);
        }
        reader.close();

        System.out.println("Choose the Algorithm you would like to apply:" +
                "\n(K)ruskal [Minimal Spanning Tree]" +
                "\n(P)rim [Minimal Spanning Tree]" +
                "\n(D)ijkstra [Shortest Path]");
        caseInput = input.next();

        switch (caseInput) {
            case "K":
                Graph<Integer> graphKruskal = new Graph(vertices, edges);
                Kruskal kruskal = new Kruskal();
                System.out.println(kruskal.getMinimumSpanningTree(graphKruskal).toString());
                break;
            case "D":


        }


    }
}
