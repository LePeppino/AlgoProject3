package de.hsos.aud.project3;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        int vertex1;
        int vertex2;
        double weight;
        int numberOfVertices = 0;
        int numberOfEdges = 0;
        ArrayList<Vertex> vertices = new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();

        var input = new Scanner(System.in);
        Scanner reader = null;
        String caseInput = "whatever";

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

        //Fill the Collection with Vertices
        for (int i = 0; i < numberOfVertices; i++) {
            vertices.add(new Vertex(i));
        }
        //Filling the collection of Edges
        while (reader.hasNext()) {
            vertex1 = reader.nextInt();
            vertex2 = reader.nextInt();
            weight = reader.nextDouble();
            Edge temp = new Edge(new Vertex(vertex1), new Vertex(vertex2), weight);
            edges.add(temp);
        }
        reader.close();

        System.out.println("Choose the Algorithm you would like to apply:\n(P)rim [Minimal Spanning Tree]\n(D)ijkstra [Shortest Path]");
        caseInput = input.next();

        switch (caseInput) {
            case "P":
                Graph graph = new Graph(Graph.TYPE.UNDIRECTED, vertices, edges);
                Prim prim = new Prim();
                prim.getMinimumSpanningTree(graph, vertices.iterator().next()).toString();
                break;
            case "D":


        }


    }
}
