package de.hsos.aud.project3;

import java.util.Objects;

public class Edge<T extends Comparable<T>> implements Comparable<Edge<T>> {

    public Vertex<T> from = null;
    public Vertex<T> to = null;
    public double cost = 0;

    public Edge(Vertex<T> from, Vertex<T> to, double cost) {
        if (from == null || to == null)
            throw (new NullPointerException("Both 'to' and 'from' vertices need to be non-NULL."));

        this.cost = cost;
        this.from = from;
        this.to = to;
    }

    public Edge(Edge<T> e) {
        this(e.from, e.to, e.cost);
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Vertex<T> getFromVertex() {
        return from;
    }

    public Vertex<T> getToVertex() {
        return to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, cost);
    }

    @Override
    public boolean equals(Object e1) {
        if (!(e1 instanceof Edge))
            return false;

        final Edge<T> e = (Edge<T>) e1;

        final boolean costs = this.cost == e.cost;
        if (!costs)
            return false;

        final boolean from = this.from.equals(e.from);
        if (!from)
            return false;

        final boolean to = this.to.equals(e.to);
        if (!to)
            return false;

        return true;
    }

    @Override
    public int compareTo(Edge<T> e) {
        if (this.cost < e.cost)
            return -1;
        if (this.cost > e.cost)
            return 1;

        final int from = this.from.compareTo(e.from);
        if (from != 0)
            return from;

        final int to = this.to.compareTo(e.to);
        if (to != 0)
            return to;

        return 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ").append(from.value).append("(").append(from.weight).append(") ").append("]").append(" -> ")
                .append("[ ").append(to.value).append("(").append(to.weight).append(") ").append("]").append(" = ").append(cost).append("\n");
        return builder.toString();
    }
}