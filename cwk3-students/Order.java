/**
 * The Order class represents a purchase order within the FurnitureStore system.
 * Each order has a unique ID, references a specific FurnitureBase item, is
 * associated
 * with a Purchaser, and includes the quantity of items in the order. Orders are
 * created
 * when a purchaser decides to buy furniture items from the store. Order
 * details, including
 * the order ID, furniture item, purchaser, and quantity, can be displayed using
 * the
 * displayDetails method.
 */
public class Order {
    private String id; // Unique identifier for the order
    private FurnitureBase furnitureItem; // FurnitureBase item included in the order
    private Purchaser purchaser; // Purchaser associated with the order
    private int quantity; // Quantity of items in the order

    /**
     * Constructs a new Order with the given parameters.
     * 
     * @param id            The unique identifier for the order.
     * @param furnitureItem The FurnitureBase item included in the order.
     * @param purchaser     The Purchaser associated with the order.
     * @param quantity      The quantity of items in the order.
     */
    public Order(String id, FurnitureBase furnitureItem, Purchaser purchaser, int quantity) {
        this.id = id;
        this.furnitureItem = furnitureItem;
        this.purchaser = purchaser;
        this.quantity = quantity;
    }

    /**
     * Gets the unique identifier of the order.
     * 
     * @return The unique identifier of the order.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the FurnitureBase item included in the order.
     * 
     * @return The FurnitureBase item included in the order.
     */
    public FurnitureBase getFurnitureItem() {
        return furnitureItem;
    }

    /**
     * Gets the Purchaser associated with the order.
     * 
     * @return The Purchaser associated with the order.
     */
    public Purchaser getPurchaser() {
        return purchaser;
    }

    /**
     * Gets the quantity of items in the order.
     * 
     * @return The quantity of items in the order.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Displays detailed information about the order, including order ID, furniture
     * item,
     * purchaser, and quantity.
     */
    public void displayDetails() {
        System.out.println("\nOrder ID: " + id);
        System.out.println("Furniture Item: " + furnitureItem.getFurnitureType());
        System.out.println("Purchaser: " + purchaser.getName());
        System.out.println("Quantity: " + quantity);
    }
}
