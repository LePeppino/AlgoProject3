package de.hsos.aud.project3;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        DiGraph<Integer> diGraph = new DiGraph<>();

        /*
        Adds and values to test diGraph functionality
        */

        diGraph.add(0);
        diGraph.add(1);
        diGraph.add(2);
        diGraph.add(3);

        diGraph.add(0, 1, 1);
        diGraph.add(1, 2, 2);
        diGraph.add(2, 3, 2);
        diGraph.add(3, 0, 2);
        diGraph.add(1, 3, 1);
        diGraph.add(2, 1, 5);


        System.out.println("The nr. of vertices is: " + diGraph.neighbors.keySet().size());
        System.out.println("The nr. of edges is: " + diGraph.getNumberOfEdges());
        System.out.println("\nThe current diGraph:");
        System.out.println(diGraph.toString() + " \n");
        System.out.println("In-degrees for 0: " + diGraph.inDegree(0));
        System.out.println("Out-degrees for 0: " + diGraph.outDegree(0));
        System.out.println("In-degrees for 3: " + diGraph.inDegree(3));
        System.out.println("Out-degrees for 3: " + diGraph.outDegree(3));
        System.out.println("Outbounds for 1: "+ diGraph.outboundNeighbors(1));
        System.out.println("Inbounds for 1: "+ diGraph.inboundNeighbors(1));
        System.out.println("(0,2)? " + (diGraph.isEdge(0, 2) ? "It's an edge" : "It's not an edge"));
        System.out.println("(1,3)? " + (diGraph.isEdge(1, 3) ? "It's an edge" : "It's not an edge"));

        System.out.println("Cost for (1,3)? "+ diGraph.getCost(1, 3));
        /**/


    }
}
