package com.example.comparejson.model;

import java.util.List;
import java.util.Objects;

/**
 * @author Nabeel Bhatti
 */
public class Difference {

    private int size;
    private List<Object> products;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Object> getProducts() {
        return products;
    }

    public void setProducts(List<Object> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Difference)) return false;
        Difference that = (Difference) o;
        return getSize() == that.getSize() && Objects.equals(getProducts(), that.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSize(), getProducts());
    }

    @Override
    public String toString() {
        return "Difference{" +
                "size=" + size +
                ", products=" + products +
                '}';
    }
}
