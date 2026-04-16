package com.alehyem.java_collections_learning.order;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory storage for orders using an ArrayList as the underlying data structure.
 * <p>
 * This class encapsulates a collection of Order objects and provides methods to add
 * and retrieve orders. It follows the principle of encapsulation by returning copies
 * of internal collections rather than exposing them directly.
 * </p>
 */
public class OrderStorage {

    private final ArrayList<Order> orders;

    /**
     * Constructs an empty OrderStorage instance.
     */
    public OrderStorage() {
        this.orders = new ArrayList<>();
    }

    /**
     * Adds an order to the storage.
     * <p>
     * The order is appended to the internal ArrayList without any validation or duplicate checks.
     * </p>
     *
     * @param order the order to add; must not be null
     */
    public void addOrder(Order order) {
        orders.add(order);
    }

    /**
     * Retrieves all orders currently stored in the storage.
     * <p>
     * Returns a new ArrayList containing all orders. This ensures the internal collection
     * is not directly exposed and modifications to the returned list do not affect the storage.
     * </p>
     *
     * @return a new ArrayList containing all stored orders
     */
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }
}

