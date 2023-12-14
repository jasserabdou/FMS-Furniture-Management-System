
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

public class FurnitureCategory {
  // Attributes
  private String id; // Unique identifier for the furniture category
  private String typeName; // Name of the furniture category
  private Double maximumLoad; // Maximum load the furniture can support in kilograms
  private boolean isOutdoor; // Indicates if the furniture is suitable for outdoor use
  private Purchaser recentPurchaser; // Details of the most recent purchaser of this furniture category
  private ArrayList<String> materials; // List of materials used in the furniture category

  // Constructor
  /**
   * Constructs a new FurnitureCategory with the given parameters.
   * 
   * @param id          The unique identifier for the furniture category.
   * @param typeName    The name of the furniture category.
   * @param maximumLoad The maximum load the furniture can support in kilograms.
   * @param isOutdoor   Indicates if the furniture is suitable for outdoor use.
   */
  public FurnitureCategory(String id, String typeName, Double maximumLoad, boolean isOutdoor) {
    this.id = id;
    this.typeName = typeName;
    this.maximumLoad = maximumLoad;
    this.isOutdoor = isOutdoor;
    this.recentPurchaser = null;
    this.materials = new ArrayList<>();
  }

  // Methods
  /**
   * Gets the unique identifier of the furniture category.
   * 
   * @return The unique identifier of the furniture category.
   */
  public String getID() {
    return id;
  }

  /**
   * Gets the name of the furniture category.
   * 
   * @return The name of the furniture category.
   */
  public String getTypeName() {
    return typeName;
  }

  /**
   * Gets the maximum load the furniture can support.
   * 
   * @return The maximum load the furniture can support in kilograms.
   */
  public Double getMaxLoad() {
    return maximumLoad;
  }

  /**
   * Gets the recommended room for placing the furniture.
   * 
   * @return The recommended room for placing the furniture (e.g., "Living Room").
   */
  public String getRoomRecommendation() {
    return "Living Room";
  }

  /**
   * Adds a new material to the list of materials used in the furniture.
   * 
   * @param material The material to be added.
   */
  public void addMaterial(String material) {
    materials.add(material);
  }

  /**
   * Checks if the furniture type is suitable for outdoor placement.
   * 
   * @return True if the furniture type is suitable for outdoor use and can
   *         support more than 50 kilograms; false otherwise.
   */
  public boolean isSuitableForOutdoor() {
    return isOutdoor && maximumLoad > 50.0;
  }

  /**
   * Displays detailed information about the furniture category, including recent
   * purchaser details if available.
   */
  public void displayDetails() {
    System.out.println("Furniture Category ID: " + id);
    System.out.println("Furniture Type Name: " + typeName);
    System.out.println("Maximum Load: " + maximumLoad);
    System.out.println("Is Suitable for Outdoor Use: " + isOutdoor);
    System.out.println("Recent Purchaser Details:");

    if (recentPurchaser != null) {
      recentPurchaser.displayDetails();
    } else {
      System.out.println("No recent purchaser associated with this category.");
    }
  }

  /**
   * Sets the most recent purchaser of the furniture category.
   * 
   * @param purchaser The purchaser to be set as the most recent purchaser.
   */
  public void setRecentPurchaser(Purchaser purchaser) {
    this.recentPurchaser = purchaser;
  }
}
