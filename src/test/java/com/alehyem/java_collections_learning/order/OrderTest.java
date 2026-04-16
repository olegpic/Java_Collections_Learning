package com.alehyem.java_collections_learning.order;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the Order class.
 * <p>
 * Tests verify that Order instances are properly constructed with all required fields
 * and that getters return the correct values.
 * </p>
 */
class OrderTest {

    @Test
    void testOrderCreation() {
        // Given
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        LocalDateTime createdAt = LocalDateTime.now();
        Status status = Status.NEW;

        // When
        Order order = new Order(id, userId, createdAt, status);

        // Then
        assertNotNull(order);
        assertEquals(id, order.getId());
        assertEquals(userId, order.getUserId());
        assertEquals(createdAt, order.getCreatedAt());
        assertEquals(status, order.getStatus());
    }

    @Test
    void testOrderImmutability() {
        // Given
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        LocalDateTime createdAt = LocalDateTime.now();
        Order order = new Order(id, userId, createdAt, Status.NEW);

        // When retrieving values
        UUID retrievedId = order.getId();
        UUID retrievedUserId = order.getUserId();
        LocalDateTime retrievedCreatedAt = order.getCreatedAt();
        Status retrievedStatus = order.getStatus();

        // Then they should match the original values
        assertEquals(id, retrievedId);
        assertEquals(userId, retrievedUserId);
        assertEquals(createdAt, retrievedCreatedAt);
        assertEquals(Status.NEW, retrievedStatus);
    }

    @Test
    void testOrderWithDifferentStatuses() {
        // Given IDs and creation time
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        LocalDateTime createdAt = LocalDateTime.now();

        // When creating orders with different statuses
        Order newOrder = new Order(id, userId, createdAt, Status.NEW);
        Order processingOrder = new Order(id, userId, createdAt, Status.PROCESSING);
        Order completedOrder = new Order(id, userId, createdAt, Status.COMPLETED);
        Order cancelledOrder = new Order(id, userId, createdAt, Status.CANCELLED);

        // Then each should have the correct status
        assertEquals(Status.NEW, newOrder.getStatus());
        assertEquals(Status.PROCESSING, processingOrder.getStatus());
        assertEquals(Status.COMPLETED, completedOrder.getStatus());
        assertEquals(Status.CANCELLED, cancelledOrder.getStatus());
    }

    @Test
    void testOrderToString() {
        // Given an order
        UUID id = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        LocalDateTime createdAt = LocalDateTime.now();
        Order order = new Order(id, userId, createdAt, Status.NEW);

        // When calling toString
        String result = order.toString();

        // Then it should contain all order information
        assertNotNull(result);
        assertTrue(result.contains("Order"));
        assertTrue(result.contains("id="));
        assertTrue(result.contains("userId="));
        assertTrue(result.contains("createdAt="));
        assertTrue(result.contains("status="));
    }
}

