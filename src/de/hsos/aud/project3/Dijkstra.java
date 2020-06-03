package de.hsos.aud.project3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Dijkstra's shortest path. Only works on non-negative path weights. Returns a
 * tuple of total cost of shortest path and the path.
 *
 * Worst case: O(|E| + |V| log |V|)
 */
public class Dijkstra {

    private Dijkstra() { }

    public static Map<Vertex<Integer>, CostPathPair<Integer>> getShortestPaths(Graph<Integer> graph, Vertex<Integer> start) {
        final Map<Vertex<Integer>, List<Edge<Integer>>> paths = new HashMap<>();
        final Map<Vertex<Integer>, CostVertexPair<Integer>> costs = new HashMap<>();

        getShortestPath(graph, start, null, paths, costs);

        final Map<Vertex<Integer>, CostPathPair<Integer>> map = new HashMap<>();
        for (CostVertexPair<Integer> pair : costs.values()) {
            int cost = pair.getCost();
            Vertex<Integer> vertex = pair.getVertex();
            List<Edge<Integer>> path = paths.get(vertex);
            map.put(vertex, new CostPathPair<>(cost, path));
        }
        return map;
    }

    public static CostPathPair<Integer> getShortestPath(Graph<Integer> graph, Vertex<Integer> start, Vertex<Integer> end) {
        if (graph == null)
            throw (new NullPointerException("Graph must be non-NULL."));

        // Dijkstra's algorithm only works on positive cost graphs
        final boolean hasNegativeEdge = checkForNegativeEdges(graph.getVertices());
        if (hasNegativeEdge)
            throw (new IllegalArgumentException("Negative cost Edges are not allowed."));

        final Map<Vertex<Integer>, List<Edge<Integer>>> paths = new HashMap<>();
        final Map<Vertex<Integer>, CostVertexPair<Integer>> costs = new HashMap<>();
        return getShortestPath(graph, start, end, paths, costs);
    }

    private static CostPathPair<Integer> getShortestPath(Graph<Integer> graph,
                                                               Vertex<Integer> start, Vertex<Integer> end,
                                                               Map<Vertex<Integer>, List<Edge<Integer>>> paths,
                                                               Map<Vertex<Integer>, CostVertexPair<Integer>> costs) {
        if (graph == null)
            throw (new NullPointerException("Graph must be non-NULL."));
        if (start == null)
            throw (new NullPointerException("start must be non-NULL."));

        // Dijkstra's algorithm only works on positive cost graphs
        boolean hasNegativeEdge = checkForNegativeEdges(graph.getVertices());
        if (hasNegativeEdge)
            throw (new IllegalArgumentException("Negative cost Edges are not allowed."));

        for (Vertex<Integer> v : graph.getVertices())
            paths.put(v, new ArrayList<Edge<Integer>>());

        for (Vertex<Integer> v : graph.getVertices()) {
            if (v.equals(start))
                costs.put(v, new CostVertexPair<Integer>(0, v));
            else
                costs.put(v, new CostVertexPair<Integer>(Integer.MAX_VALUE, v));
        }

        final Queue<CostVertexPair<Integer>> unvisited = new PriorityQueue<>();
        unvisited.add(costs.get(start));

        while (!unvisited.isEmpty()) {
            final CostVertexPair<Integer> pair = unvisited.remove();
            final Vertex<Integer> vertex = pair.getVertex();

            // Compute costs from current vertex to all reachable vertices which haven't been visited
            for (Edge<Integer> e : vertex.getEdges()) {
                final CostVertexPair<Integer> toPair = costs.get(e.getToVertex()); // O(1)
                final CostVertexPair<Integer> lowestCostToThisVertex = costs.get(vertex); // O(1)
                final int cost = lowestCostToThisVertex.getCost() + e.getCost();
                if (toPair.getCost() == Integer.MAX_VALUE) {
                    // Haven't seen this vertex yet

                    // Need to remove the pair and re-insert, so the priority queue keeps it's invariants
                    unvisited.remove(toPair); // O(n)
                    toPair.setCost(cost);
                    unvisited.add(toPair); // O(log n)

                    // Update the paths
                    List<Edge<Integer>> set = paths.get(e.getToVertex()); // O(log n)
                    set.addAll(paths.get(e.getFromVertex())); // O(log n)
                    set.add(e);
                } else if (cost < toPair.getCost()) {
                    // Found a shorter path to a reachable vertex

                    // Need to remove the pair and re-insert, so the priority queue keeps it's invariants
                    unvisited.remove(toPair); // O(n)
                    toPair.setCost(cost);
                    unvisited.add(toPair); // O(log n)

                    // Update the paths
                    List<Edge<Integer>> set = paths.get(e.getToVertex()); // O(log n)
                    set.clear();
                    set.addAll(paths.get(e.getFromVertex())); // O(log n)
                    set.add(e);
                }
            }

            // Termination conditions
            if (end != null && vertex.equals(end)) {
                // We are looking for shortest path to a specific vertex, we found it.
                break;
            }
        }

        if (end != null) {
            final CostVertexPair<Integer> pair = costs.get(end);
            final List<Edge<Integer>> set = paths.get(end);
            return (new CostPathPair<>(pair.getCost(), set));
        }
        return null;
    }

    private static boolean checkForNegativeEdges(Collection<Vertex<Integer>> vertices) {
        for (Vertex<Integer> v : vertices) {
            for (Edge<Integer> e : v.getEdges()) {
                if (e.getCost() < 0)
                    return true;
            }
        }
        return false;
    }
}