package com.alehyem.java_collections_learning.order;

/**
 * Enum representing the possible statuses of an order.
 * <p>
 * Statuses flow through the order lifecycle:
 * NEW -> PROCESSING -> COMPLETED (or CANCELLED at any point)
 * </p>
 */
public enum Status {
    /**
     * Order has been created but not yet processed.
     */
    NEW,

    /**
     * Order is currently being processed.
     */
    PROCESSING,

    /**
     * Order processing has been completed successfully.
     */
    COMPLETED,

    /**
     * Order has been cancelled.
     */
    CANCELLED
}

