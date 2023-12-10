import java.util.*;

/**
 * This class implements the FIRE FURNITUREInterface interface
 **/
public class FurnitureStore implements FURNITUREInterface // do not change this header

{
    private String storeName;
    private String location;
    private List<FurnitureBase> furnitureItems;
    private List<Purchaser> customerOrders;
    private List<FurnitureCategory> suppliers;

    // Constructor
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
    private void loadFurnitureAndSuppliers() {
        // Logic to populate furnitureItems and suppliers
        // This may involve instantiating new FurnitureBase and Purchaser objects and
        // adding them to the respective lists.

    }

    void loadOrders() {
        // Logic to populate customerOrders
        // This may involve instantiating new FurnitureCategory objects and adding them
        // to the list.

    }

    private void linkOrdersToFurniture() {
        // Logic to link specific customer orders to their corresponding furniture
        // pieces
        // This may involve updating the furniture items with the purchaser information.
        // For the sake of this example, I'm linking the first customer order with the
        // first furniture item.
        if (!customerOrders.isEmpty() && !furnitureItems.isEmpty()) {
            customerOrders.get(0).addToPurchaseHistory(furnitureItems.get(0).getID());
            furnitureItems.get(0).associatePurchaser(customerOrders.get(0).getName());
        }
    }

    // Additional helper methods (optional)
    private FurnitureBase retrieveFurniture(String id) {
        return getFurnitureByID(id);
    }

    private Purchaser retrievePurchaser(String id) {
        return getPurchaserByID(id);
    }

    FurnitureCategory retrieveCategory(String id) {
        return getCategoryByID(id);
    }

    public FurnitureBase[] getFurnitureInventory() {
        return null;
    }

    public Purchaser[] getPurchaserList() {
        return null;
    }

}
