package cyclechronicles;

/** An order for a bike shop. */
public record Order(Type type, String name) {
    /**
     * Determine the type of bike to be repaired.
     *
     * @return type of bicycle
     */
    public Type getBicycleType() {
        return this.type();
    }

    /**
     * Determine the customer who placed this order.
     *
     * @return name of customer
     */
    public String getCustomer() {
        return this.name;
    }
}
