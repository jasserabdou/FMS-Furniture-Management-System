import java.util.ArrayList;
import java.util.Arrays;

/**
 * The FurnitureStore class implements the FIRE FURNITUREInterface interface.
 * It represents a furniture store with information about furniture items,
 * customer orders, and furniture suppliers.
 */
public class FurnitureStore implements FURNITUREInterface {

    // Attributes

    private String storeName; // Name of the furniture store
    private String location; // Location of the furniture store
    private ArrayList<FurnitureBase> furnitureItems; // List of furniture items in the store
    private ArrayList<Purchaser> customerOrders; // List of customer orders
    private ArrayList<FurnitureCategory> suppliers; // List of furniture suppliers

    // Constructor

    /**
     * Constructs a new FurnitureStore with the given storeName and location.
     * Initializes lists for furnitureItems, customerOrders, and suppliers.
     * Calls methods to load initial data.
     *
     * @param storeName The name of the furniture store.
     * @param location  The location of the furniture store.
     */
    public FurnitureStore(String storeName, String location) {
        this.storeName = storeName;
        this.location = location;
        furnitureItems = new ArrayList<>();
        customerOrders = new ArrayList<>();
        suppliers = new ArrayList<>();
        loadFurnitureAndSuppliers();
        loadOrders();

    }

    // Implementation of the methods from FURNITURE interface

    /**
     * Adds a furniture item to the list of furniture items.
     *
     * @param furniture The furniture item to be added.
     */
    @Override
    public void addFurniture(FurnitureBase furniture) {
        furnitureItems.add(furniture);
    }

    /**
     * Adds a purchaser to the list of customer orders.
     *
     * @param purchaser The purchaser to be added.
     */
    @Override
    public void addPurchaser(Purchaser purchaser) {
        customerOrders.add(purchaser);
    }

    /**
     * Adds a furniture category to the list of suppliers.
     *
     * @param category The furniture category to be added.
     */
    @Override
    public void addCategory(FurnitureCategory category) {
        suppliers.add(category);
    }

    /**
     * Retrieves a furniture item based on its ID.
     *
     * @param id The ID of the furniture item.
     * @return The retrieved furniture item or null if not found.
     */
    @Override
    public FurnitureBase getFurnitureByID(String id) {
        for (FurnitureBase furniture : furnitureItems) {
            if (furniture.getID().equals(id)) {
                return furniture;
            }
        }
        return null;
    }

    /**
     * Retrieves a purchaser based on their ID.
     *
     * @param id The ID of the purchaser.
     * @return The retrieved purchaser or null if not found.
     */
    @Override
    public Purchaser getPurchaserByID(String id) {
        for (Purchaser purchaser : customerOrders) {
            if (purchaser.getID().equals(id)) {
                return purchaser;
            }
        }
        return null;
    }

    /**
     * Retrieves a furniture category based on its ID.
     *
     * @param id The ID of the furniture category.
     * @return The retrieved furniture category or null if not found.
     */
    @Override
    public FurnitureCategory getCategoryByID(String id) {
        for (FurnitureCategory category : suppliers) {
            if (category.getID().equals(id)) {
                return category;
            }
        }
        return null;
    }

    // Private methods as specified

    /**
     * Loads initial data for furnitureItems and suppliers.
     * This may involve instantiating new FurnitureBase and Purchaser objects
     * and adding them to the respective lists.
     */
    private void loadFurnitureAndSuppliers() {
        // Logic to populate furnitureItems and suppliers
        // This may involve instantiating new FurnitureBase and Purchaser objects and
        // adding them to the respective lists.
        furnitureItems.addAll(Arrays.asList(
                new SofaItem("1", "Leather Sofa", 2, 800),
                new BedroomCollection("2", "King Size Bed", 1, 1200),
                new ChairItem("3", "Wooden Chair", 5, 100),
                new TableItem("4", "Dining Table", 3, 300),
                new WardrobeItem("5", "3-door Wooden Wardrobe", 4, 900)));

        suppliers.addAll(Arrays.asList(
                new FurnitureCategory("1", "Sofa", 150.0, false, new ArrayList<>(Arrays.asList("Wood", "Leather"))),
                new FurnitureCategory("2", "Bed", 200.0, false, new ArrayList<>(Arrays.asList("Wood", "Metal"))),
                new FurnitureCategory("3", "Chair", 100.0, true, new ArrayList<>(Arrays.asList("Plywood", "Metal"))),
                new FurnitureCategory("4", "Table", 80.0, true, new ArrayList<>(Arrays.asList("Wood", "Metal"))),
                new FurnitureCategory("5", "Wardrobe", 300.0, false,
                        new ArrayList<>(Arrays.asList("Wood", "Stainless steel")))));
    }

    /**
     * Loads initial data for customerOrders.
     * This may involve instantiating new Purchaser objects
     * and adding them to the list.
     */
    private void loadOrders() {
        // Logic to populate customerOrders
        // This may involve instantiating new FurnitureCategory objects and adding them
        // to the list.
        customerOrders.addAll(Arrays.asList(
                new Purchaser("1", "IKEA", "Chair", "Email: ikea@example.com", null),
                new Purchaser("2", "Walmart", "Table", "Email: walmart@example.com", null),
                new Purchaser("3", "West Elm", "Sofa", "Email: westelm@example.com", null),
                new Purchaser("4", "Target", "Bed", "Email: target@example.com", null),
                new Purchaser("5", "HomeGoods", "Wardrobe", "Email: homegoods@example.com", null)));

        for (Purchaser purchaser : customerOrders) {
            String itemName = purchaser.getName();
            int quantity = getQuantityForPurchaser(purchaser);

            for (int i = 0; i < quantity; i++) {
                purchaser.addToPurchaseHistory(itemName);
            }
        }
    }

    /**
     * Links specific customer orders to their corresponding furniture pieces.
     * This may involve updating the furniture items with the purchaser information.
     * For the sake of this example, I'm linking the first customer order with the
     * first furniture item.
     */
    private void linkOrdersToFurniture() {
        for (int i = 0; i < Math.min(customerOrders.size(), furnitureItems.size()); i++) {
            Purchaser currentPurchaser = customerOrders.get(i);
            FurnitureBase currentFurniture = furnitureItems.get(i);

            currentPurchaser.addToPurchaseHistory(currentFurniture.getID());
            currentFurniture.associatePurchaser(currentPurchaser.getName());
        }
    }

    // Additional helper methods (optional)

    /**
     * Retrieves a FurnitureBase object based on the provided ID.
     *
     * @param id The ID of the furniture.
     * @return The retrieved FurnitureBase object.
     */
    private FurnitureBase retrieveFurniture(String id) {
        return getFurnitureByID(id);
    }

    /**
     * Retrieves a Purchaser object based on the provided ID.
     *
     * @param id The ID of the purchaser.
     * @return The retrieved Purchaser object.
     */
    private Purchaser retrievePurchaser(String id) {
        return getPurchaserByID(id);
    }

    /**
     * Retrieves a FurnitureCategory object based on the provided ID.
     *
     * @param id The ID of the furniture category.
     * @return The retrieved FurnitureCategory object.
     */
    private FurnitureCategory retrieveCategory(String id) {
        return getCategoryByID(id);
    }

    /**
     * Retrieves the quantity of items to be purchased for a given purchaser.
     * This method could be expanded to include more sophisticated logic
     * based on the purchaser details.
     *
     * @param purchaser The purchaser for whom the quantity is determined.
     * @return The quantity of items to be purchased.
     */
    private int getQuantityForPurchaser(Purchaser purchaser) {
        // Implement logic to determine the quantity based on purchaser details
        // For the sake of this example, returning a constant quantity.
        return 1;
    }

    /**
     * Returns a string representation of the FurnitureStore object.
     *
     * @return A string representation of the FurnitureStore.
     */
    @Override
    public String toString() {
        return "FurnitureStore{" +
                "storeName='" + storeName + '\'' +
                ", location='" + location + '\'' +
                ", furnitureItems=" + furnitureItems +
                ", customerOrders=" + customerOrders +
                ", suppliers=" + suppliers +
                '}';
    }
}
