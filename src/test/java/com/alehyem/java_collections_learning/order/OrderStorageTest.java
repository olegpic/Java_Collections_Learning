package com.alehyem.java_collections_learning.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the OrderStorage class.
 * <p>
 * Tests cover basic operations including adding orders, retrieving all orders,
 * and verifying encapsulation properties.
 * </p>
 */
class OrderStorageTest {

    private OrderStorage orderStorage;
    private Order testOrder1;
    private Order testOrder2;

    @BeforeEach
    void setUp() {
        orderStorage = new OrderStorage();
        testOrder1 = new Order(
                UUID.randomUUID(),
                UUID.randomUUID(),
                LocalDateTime.now(),
                Status.NEW
        );
        testOrder2 = new Order(
                UUID.randomUUID(),
                UUID.randomUUID(),
                LocalDateTime.now(),
                Status.PROCESSING
        );
    }

    @Test
    void testAddOrder_SingleOrder() {
        // Given an empty storage
        // When adding an order
        orderStorage.addOrder(testOrder1);

        // Then the order should be stored
        List<Order> orders = orderStorage.getAllOrders();
        assertEquals(1, orders.size());
        assertEquals(testOrder1.getId(), orders.get(0).getId());
    }

    @Test
    void testAddOrder_MultipleOrders() {
        // Given an empty storage
        // When adding multiple orders
        orderStorage.addOrder(testOrder1);
        orderStorage.addOrder(testOrder2);

        // Then all orders should be stored in order
        List<Order> orders = orderStorage.getAllOrders();
        assertEquals(2, orders.size());
        assertEquals(testOrder1.getId(), orders.get(0).getId());
        assertEquals(testOrder2.getId(), orders.get(1).getId());
    }

    @Test
    void testGetAllOrders_ReturnsNewList() {
        // Given storage with an order
        orderStorage.addOrder(testOrder1);

        // When getting all orders
        List<Order> firstCall = orderStorage.getAllOrders();
        List<Order> secondCall = orderStorage.getAllOrders();

        // Then different list instances should be returned
        assertNotSame(firstCall, secondCall, "getAllOrders should return new list instances");
        assertEquals(firstCall, secondCall, "But lists should contain the same orders");
    }

    @Test
    void testGetAllOrders_EncapsulationPreserved() {
        // Given storage with an order
        orderStorage.addOrder(testOrder1);

        // When getting all orders and modifying the returned list
        List<Order> orders = orderStorage.getAllOrders();
        orders.clear();

        // Then the storage should still contain the original order
        List<Order> ordersAfterModification = orderStorage.getAllOrders();
        assertEquals(1, ordersAfterModification.size());
        assertEquals(testOrder1.getId(), ordersAfterModification.get(0).getId());
    }

    @Test
    void testGetAllOrders_EmptyStorage() {
        // Given an empty storage
        // When getting all orders
        List<Order> orders = orderStorage.getAllOrders();

        // Then an empty list should be returned
        assertTrue(orders.isEmpty());
        assertEquals(0, orders.size());
    }

    @Test
    void testOrderStorage_PreservesOrderInsertionOrder() {
        // Given multiple orders created in specific order
        Order order1 = new Order(UUID.randomUUID(), UUID.randomUUID(), LocalDateTime.now(), Status.NEW);
        Order order2 = new Order(UUID.randomUUID(), UUID.randomUUID(), LocalDateTime.now(), Status.PROCESSING);
        Order order3 = new Order(UUID.randomUUID(), UUID.randomUUID(), LocalDateTime.now(), Status.COMPLETED);

        // When adding them to storage
        orderStorage.addOrder(order1);
        orderStorage.addOrder(order2);
        orderStorage.addOrder(order3);

        // Then they should be retrieved in the same order
        List<Order> retrievedOrders = orderStorage.getAllOrders();
        assertEquals(3, retrievedOrders.size());
        assertSame(order1, retrievedOrders.get(0));
        assertSame(order2, retrievedOrders.get(1));
        assertSame(order3, retrievedOrders.get(2));
    }
}

