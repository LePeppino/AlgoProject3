package de.hsos.aud.project3;

import java.util.*;

public class Graph<V> {

    /**
     * Edge as inner class to avoid privacy policy
     */
    public static class Edge<V>{
        private V vertex;

        public Edge(V v){
            vertex = v;
        }

        public V getVertex() {
            return vertex;
        }

        /**
         * String representation of Edge
         */
        @Override
        public String toString() {
            return "Edge [vertex= " + vertex + "]";
        }

    }

    /**
     * A Map is used to map each vertex to its list of adjacent vertices.
     */
    public Map<V, List<Edge<V>>> neighbors = new HashMap<>();

    private int nrEdges;

    /**
     * String representation of Graph
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (V v : neighbors.keySet())
            s.append("\n ").append(v).append(" -> ").append(neighbors.get(v));
        return s.toString();
    }

    /**
     * Add a vertex to the graph. Nothing happens if vertex is already in graph
     */
    public void add(V vertex) {
        if (neighbors.containsKey(vertex))
            return;
        neighbors.put(vertex, new ArrayList<>());
    }

    public int getNumberOfEdges(){
        int sum = 0;
        for(List<Edge<V>> outBounds : neighbors.values()){
            sum += outBounds.size();
        }
        return sum;
    }

    /**
     * True if graph contains vertex
     */
    public boolean contains(V vertex) {
        return neighbors.containsKey(vertex);
    }

    /**
     * Add an edge to the graph; if either vertex does not exist, it's added
     * This implementation allows the creation of multi-edges and self-loops
     */
    public void add(V from, V to) {
        this.add(from);
        this.add(to);
        neighbors.get(from).add(new Edge<V>(to));
    }

    /**
     * getDegree gets the number of edges for a vertex
     */
    public int getDegree(V vertex) {
        return neighbors.get(vertex).size();
    }

    /**
     * getNeighbors gets, which other vertices
     * are connected to a vertex
     */
    public List<V> getNeighbors(V vertex) {
        List<V> list = new ArrayList<V>();
        for(Edge<V> e: neighbors.get(vertex))
            list.add(e.vertex);
        return list;
    }

    /**
     * true if two vertices have a common edge
     */
    public boolean isEdge(V from, V to) {
        for(Edge<V> e :  neighbors.get(from)){
            if(e.vertex.equals(to))
                return true;
        }
        return false;
    }

}
