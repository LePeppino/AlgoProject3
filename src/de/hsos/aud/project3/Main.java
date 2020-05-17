package de.hsos.aud.project3;

public class Main {

    public static void main(String[] args) {

        DiGraph diGraph = new DiGraph(true);
        Node a = new Node(0, "A");
        Node b = new Node(1, "B");
        Node c = new Node(2, "C");
        Node d = new Node(3, "D");
        Node e = new Node(4, "E");

        diGraph.addEdge(a,b);
        diGraph.addEdge(b,c);
        diGraph.addEdge(b,d);
        diGraph.addEdge(c,e);
        diGraph.addEdge(b,a);

        diGraph.printEdges();

        System.out.println(diGraph.hasEdge(a,b));
        System.out.println(diGraph.hasEdge(d,a));
    }
}
