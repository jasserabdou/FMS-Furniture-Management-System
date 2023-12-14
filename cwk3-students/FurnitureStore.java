import java.util.*;

/**
 * This class implements the FIRE FURNITUREInterface interface
 **/
public class FurnitureStore implements FURNITUREInterface {

    // Attributes
    private String storeName; // Name of the furniture store
    private String location; // Location of the furniture store
    private List<FurnitureBase> furnitureItems; // List of furniture items in the store
    private List<Purchaser> customerOrders; // List of customer orders
    private List<FurnitureCategory> suppliers; // List of furniture suppliers

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
        linkOrdersToFurniture();
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
        // Logic to populate furnitureItems and suppliers
        // This may involve instantiating new FurnitureBase and Purchaser objects
        // and adding them to the respective lists.
    }

    /**
     * Loads initial data for customerOrders.
     * This may involve instantiating new FurnitureCategory objects
     * and adding them to the list.
     */
    private void loadOrders() {
        // Logic to populate customerOrders
        // This may involve instantiating new FurnitureCategory objects
        // and adding them to the list.
    }

    /**
     * Links specific customer orders to their corresponding furniture pieces.
     * This may involve updating the furniture items with the purchaser information.
     * For the sake of this example, I'm linking the first customer order with the
     * first furniture item.
     */
    private void linkOrdersToFurniture() {
        if (!customerOrders.isEmpty() && !furnitureItems.isEmpty()) {
            customerOrders.get(0).addToPurchaseHistory(furnitureItems.get(0).getID());
            furnitureItems.get(0).associatePurchaser(customerOrders.get(0).getName());
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
    FurnitureCategory retrieveCategory(String id) {
        return getCategoryByID(id);
    }

    /**
     * Gets an array of all furniture items in the store's inventory.
     * 
     * @return An array of FurnitureBase objects representing the furniture
     *         inventory.
     */
    public FurnitureBase[] getFurnitureInventory() {
        return null; // Placeholder, implementation required.
    }

    /**
     * Gets an array of all purchasers in the store.
     * 
     * @return An array of Purchaser objects representing the purchaser list.
     */
    public Purchaser[] getPurchaserList() {
        return null; // Placeholder, implementation required.
    }
}
