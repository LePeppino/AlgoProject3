package de.hsos.aud.project3;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int numberOfVertices = 0;
        int numberOfEdges = 0;
        Collection<Vertex> vertices = null;
        Collection<Edge> edges = null;

        var input = new Scanner(System.in);
        Scanner reader = null;
        String caseInput = "whatever";

        System.out.println("Specify absolute path to the file containing the graph:");

        String path = input.nextLine();

        try {
            reader = new Scanner(new File(path));
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
            edges.add(new Edge(new Vertex(reader.nextInt()), new Vertex(reader.nextInt()), reader.nextDouble()));
        }
        reader.close();

        System.out.println("Choose the Algorithm you would like to apply:\n(P)rim [Minimal Spanning Tree]\n(D)ijkstra [Shortest Path]\n(M)ax Flow");

        switch (caseInput) {
            case "P":
                Graph graph = new Graph(Graph.TYPE.UNDIRECTED, vertices, edges);
                Prim prim = new Prim();
                prim.getMinimumSpanningTree(graph, vertices.iterator().next());
                break;
            case "D":


        }


    }
}
