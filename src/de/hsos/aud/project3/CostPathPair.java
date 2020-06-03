package de.hsos.aud.project3;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class CostPathPair<T extends Comparable<T>> {

    private double cost = 0;
    private List<Edge<T>> path = null;

    public CostPathPair(double cost, List<Edge<T>> path) {
        if (path == null)
            throw (new NullPointerException("path cannot be NULL."));

        this.cost = cost;
        this.path = path;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Edge<T>> getPath() {
        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CostPathPair<?> that = (CostPathPair<?>) o;

        if (Double.compare(that.cost, cost) != 0) return false;
        return Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(cost);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (path != null ? path.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Cost = ").append(cost).append("\n");
        for (Edge<T> e : path)
            builder.append("\t").append(e);
        return builder.toString();
    }
}