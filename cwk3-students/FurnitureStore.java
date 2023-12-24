import java.util.*;

/**
 * The FurnitureStore class implements the FIRE FURNITUREInterface interface.
 * It represents a furniture store with information about furniture items,
 * customer orders,
 * and furniture suppliers.
 */
public class FurnitureStore implements FURNITUREInterface {

    // Attributes

    private String storeName; // Name of the furniture store
    private String location; // Location of the furniture store
    private ArrayList<FurnitureBase> furnitureItems; // List of furniture items in the store
    private ArrayList<Purchaser> customerOrders; // List of customer orders
    private ArrayList<FurnitureCategory> suppliers; // List of furniture suppliers

    // Furniture items
    FurnitureBase Sofa = new SofaItem("1", "Leather Sofa", 2, 800);
    FurnitureBase Bed = new BedroomCollection("2", "King Size Bed", 1, 1200);
    FurnitureBase Chair = new ChairItem("3", "Wooden Chair", 5, 100);
    FurnitureBase Table = new TableItem("4", "Dining Table", 3, 300);
    FurnitureBase Wardrobe = new WardrobeItem("5", "3-door Wooden Wardrobe", 4, 900);

    // Purchasers
    Purchaser IKEA = new Purchaser("1", "IKEA", "", "Email: ikea@example.com", null);
    Purchaser Walmart = new Purchaser("2", "Walmart", "", "Email: walmart@example.com", null);
    Purchaser WestElm = new Purchaser("3", "West Elm", "", "Email: westelm@example.com", null);
    Purchaser Target = new Purchaser("4", "Target", "", "Email: target@example.com", null);
    Purchaser HomeGoods = new Purchaser("5", "HomeGoods", "", "Email: homegoods@example.com", null);

    // Furniture categories
    FurnitureCategory SofaSupplier = new FurnitureCategory("1", "Sofa", 150.0, false,
            new ArrayList<>(Arrays.asList("Wood", "Leather")));
    FurnitureCategory BedSupplier = new FurnitureCategory("2", "Bed", 200.0, false,
            new ArrayList<>(Arrays.asList("Wood", "Metal")));
    FurnitureCategory ChairSupplier = new FurnitureCategory("3", "Chair", 100.0, true,
            new ArrayList<>(Arrays.asList("Plywood", "Metal")));
    FurnitureCategory TableSupplier = new FurnitureCategory("4", "Table", 80.0, true,
            new ArrayList<>(Arrays.asList("Wood", "Metal")));
    FurnitureCategory WardrobeSupplier = new FurnitureCategory("5", "Wardrobe", 300.0, false,
            new ArrayList<>(Arrays.asList("Wood", "Stainless steel")));

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

    @Override
    public void addFurniture(FurnitureBase furniture) {
        furnitureItems.add(furniture);
    }

    @Override
    public void addPurchaser(Purchaser purchaser) {
        customerOrders.add(purchaser);
    }

    @Override
    public void addCategory(FurnitureCategory category) {
        suppliers.add(category);
    }

    @Override
    public FurnitureBase getFurnitureByID(String id) {
        for (FurnitureBase furniture : furnitureItems) {
            if (furniture.getID().equals(id)) {
                return furniture;
            }
        }
        return null;
    }

    @Override
    public Purchaser getPurchaserByID(String id) {
        for (Purchaser purchaser : customerOrders) {
            if (purchaser.getID().equals(id)) {
                return purchaser;
            }
        }
        return null;
    }

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
        furnitureItems.addAll(List.of(Chair, Table, Sofa, Bed, Wardrobe));
        suppliers.addAll(List.of(ChairSupplier, TableSupplier, SofaSupplier, BedSupplier, WardrobeSupplier));

    }

    /**
     * Loads initial data for customerOrders.
     * This may involve instantiating new Purchaser objects
     * and adding them to the list.
     */
    private void loadOrders() {
        customerOrders.addAll(List.of(IKEA, Walmart, WestElm, Target, HomeGoods));

        for (Purchaser purchaser : customerOrders) {
            String itemName = purchaser.getName();
            int quantity = getQuantityForPurchaser(purchaser);

            for (int i = 0; i < quantity; i++) {
                purchaser.addToPurchaseHistory(itemName);
            }
        }
    }

    /**
     * Gets the quantity for a given purchaser.
     * Placeholder method, replace with actual logic.
     *
     * @param purchaser The purchaser for whom to retrieve the quantity.
     * @return The quantity for the purchaser.
     */
    private int getQuantityForPurchaser(Purchaser purchaser) {
        // Add your logic to retrieve the quantity based on the purchaser
        // For now, returning a default value of 1
        return 1;
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

}
