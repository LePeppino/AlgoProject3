package de.hsos.aud.project3;

import java.util.Objects;

public class CostVertexPair<T extends Comparable<T>> implements Comparable<CostVertexPair<T>> {

    private double cost = Integer.MAX_VALUE;
    private Vertex<T> vertex = null;

    public CostVertexPair(int cost, Vertex<T> vertex) {
        if (vertex == null)
            throw (new NullPointerException("vertex cannot be NULL."));

        this.cost = cost;
        this.vertex = vertex;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Vertex<T> getVertex() {
        return vertex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, vertex);
    }

    @Override
    public boolean equals(Object e1) {
        if (!(e1 instanceof CostVertexPair))
            return false;

        final CostVertexPair<?> pair = (CostVertexPair<?>)e1;
        if (this.cost != pair.cost)
            return false;

        if (!this.vertex.equals(pair.vertex))
            return false;

        return true;
    }

    @Override
    public int compareTo(CostVertexPair<T> p) {
        if (p == null)
            throw new NullPointerException("CostVertexPair 'p' must be non-NULL.");

        if (this.cost < p.cost)
            return -1;
        if (this.cost > p.cost)
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(vertex.getValue()).append(" (").append(vertex.weight).append(") ").append(" cost=").append(cost).append("\n");
        return builder.toString();
    }
}