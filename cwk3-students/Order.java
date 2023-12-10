import java.util.Date;

public class Order {
    private String id;
    private FurnitureBase furnitureItem;
    private Purchaser purchaser;
    private int quantity;

    public Order(String id, FurnitureBase furnitureItem, Purchaser purchaser, int quantity) {
        this.id = id;
        this.furnitureItem = furnitureItem;
        this.purchaser = purchaser;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public FurnitureBase getFurnitureItem() {
        return furnitureItem;
    }

    public Purchaser getPurchaser() {
        return purchaser;
    }

    public int getQuantity() {
        return quantity;
    }

    public void displayDetails() {
        System.out.println("\nOrder ID: " + id);
        System.out.println("Furniture Item: " + furnitureItem.getFurnitureType());
        System.out.println("Purchaser: " + purchaser.getName());
        System.out.println("Quantity: " + quantity);
    }
}
