
/**
 * FurnitureCategory denotes a specific category or type within the FurnitureStore system.
 * Each category is distinct, such as chairs, tables, beds, or sofas. Every FurnitureCategory 
 * has a unique name, a general description outlining its features, and potentially other 
 * attributes like average price range, typical materials used, or general care instructions.
 * This categorization helps both the store's staff and customers in sorting, identifying, 
 * and narrowing down their product searches. It streamlines inventory management by 
 * grouping similar items, facilitating bulk operations, and assisting in sales analytics.
 * The FurnitureCategory also aids in promotional activities, allowing for category-wide 
 * discounts or special deals.
 */
import java.util.ArrayList;
import java.util.List;

public class FurnitureCategory {
    // attributes
    private String id;
    private String typeName;
    private Double maximumLoad;
    private boolean isOutdoor;
    private Purchaser recentPurchaser;
    private List<String> materials;

    // Constructor
    public FurnitureCategory(String id, String typeName, Double maximumLoad, boolean isOutdoor) {
        this.id = id;
        this.typeName = typeName;
        this.maximumLoad = maximumLoad;
        this.isOutdoor = isOutdoor;
        this.recentPurchaser = null;
        this.materials = new ArrayList<>();
    }

    // methods
    public String getID() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }

    public Double getMaxLoad() {
        return maximumLoad;
    }

    public String getRoomRecommendation() {
        return "Living Room";
    }

    // Method to add a new material to the materials list
    public void addMaterial(String material) {
        materials.add(material);
    }

    // Method to check if the furniture type is suitable for outdoor placement
    public boolean isSuitableForOutdoor() {
        // Check if the furniture type is explicitly labeled as suitable for outdoor use
        // and if it can support more than 50 kilograms
        return isOutdoor && maximumLoad > 50.0;
    }
}
