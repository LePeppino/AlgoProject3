package de.hsos.aud.project3;

import java.util.*;

/**
 * Prim's minimum spanning tree. Only works on undirected graphs. It finds a
 * subset of the edges that forms a tree that includes every vertex, where the
 * total weight of all the edges in the tree is minimized.
 */
public class Prim {

    public Prim() { }

    public CostPathPair<Integer> getMinimumSpanningTree(Graph<Integer> graph, Vertex<Integer> start) {
        if (graph == null)
            throw (new NullPointerException("Graph must be non-NULL."));

        // Prim's algorithm only works on undirected graphs
        if (graph.getType() != Graph.TYPE.UNDIRECTED)
            throw (new IllegalArgumentException("Undirected graphs only."));

        int cost = 0;

        final Set<Vertex<Integer>> unvisited = new HashSet<>();
        unvisited.addAll(graph.getVertices());
        unvisited.remove(start); // O(1)

        final List<Edge<Integer>> path = new ArrayList<Edge<Integer>>();
        final Queue<Edge<Integer>> edgesAvailable = new PriorityQueue<Edge<Integer>>();

        Vertex<Integer> vertex = start;
        while (!unvisited.isEmpty()) {
            // Add all edges to unvisited vertices
            for (Edge<Integer> e : vertex.getEdges()) {
                if (unvisited.contains(e.getToVertex()))
                    edgesAvailable.add(e);
            }

            // Remove the lowest cost edge
            final Edge<Integer> e = edgesAvailable.remove();
            cost += e.getCost();
            path.add(e); // O(1)

            vertex = e.getToVertex();
            unvisited.remove(vertex); // O(1)
        }

        return (new CostPathPair<Integer>(cost, path));
    }
}