package com.alehyem.java_collections_learning.order;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Immutable model representing an Order in the system.
 * <p>
 * An Order contains essential information about a customer order including a unique identifier,
 * the user who placed it, creation timestamp, and current processing status.
 * </p>
 */
public class Order {

    private final UUID id;
    private final UUID userId;
    private final LocalDateTime createdAt;
    private final Status status;

    /**
     * Constructs an Order with the specified parameters.
     *
     * @param id        the unique identifier of the order
     * @param userId    the unique identifier of the user who placed the order
     * @param createdAt the timestamp when the order was created
     * @param status    the current status of the order
     */
    public Order(UUID id, UUID userId, LocalDateTime createdAt, Status status) {
        this.id = id;
        this.userId = userId;
        this.createdAt = createdAt;
        this.status = status;
    }

    /**
     * Gets the unique identifier of the order.
     *
     * @return the order ID
     */
    public UUID getId() {
        return id;
    }

    /**
     * Gets the unique identifier of the user who placed the order.
     *
     * @return the user ID
     */
    public UUID getUserId() {
        return userId;
    }

    /**
     * Gets the timestamp when the order was created.
     *
     * @return the creation timestamp
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Gets the current status of the order.
     *
     * @return the order status
     */
    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", createdAt=" + createdAt +
                ", status=" + status +
                '}';
    }
}

