package de.hsos.aud.project3;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        DiGraph<Integer> graph = new DiGraph<>();

        graph.add(0);
        graph.add(1);
        graph.add(2);
        graph.add(3);

        graph.add(0, 1, 1);
        graph.add(1, 2, 2);
        graph.add(2, 3, 2);
        graph.add(3, 0, 2);
        graph.add(1, 3, 1);
        graph.add(2, 1, 5);


        System.out.println("The nr. of vertices is: " + graph.neighbors.keySet().size());
        System.out.println("The nr. of edges is: " + graph.getNumberOfEdges()); // to be fixed
        System.out.println("The current graph: " + graph);
        System.out.println("In-degrees for 0: " + graph.inDegree(0));
        System.out.println("Out-degrees for 0: " + graph.outDegree(0));
        System.out.println("In-degrees for 3: " + graph.inDegree(3));
        System.out.println("Out-degrees for 3: " + graph.outDegree(3));
        System.out.println("Outbounds for 1: "+ graph.outboundNeighbors(1));
        System.out.println("Inbounds for 1: "+ graph.inboundNeighbors(1));
        System.out.println("(0,2)? " + (graph.isEdge(0, 2) ? "It's an edge" : "It's not an edge"));
        System.out.println("(1,3)? " + (graph.isEdge(1, 3) ? "It's an edge" : "It's not an edge"));

        System.out.println("Cost for (1,3)? "+ graph.getCost(1, 3));
    }
}
