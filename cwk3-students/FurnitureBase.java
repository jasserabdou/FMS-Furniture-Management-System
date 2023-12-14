
/**
 * FurnitureBase represents an individual furniture item within the FurnitureStore system.
 * Each FurnitureBase has a unique ID, a description detailing its characteristics, 
 * a type or category (like chair, table, bed), materials used, dimensions, 
 * and a price. The store's inventory is essentially a collection of FurnitureBase objects.
 * The system relies on the comprehensive data within each FurnitureBase 
 * to manage stock levels, make sales transactions, and provide detailed 
 * product information to both staff and customers. Properly maintained 
 * FurnitureBase records ensure that the store can track product availability, 
 * popularity, and sales trends over time.
 */

import java.util.ArrayList;

abstract class FurnitureBase {
   // attributes
   private String id; // Unique identifier for the furniture item
   private String furnitureCategory; // Category or type of the furniture item (e.g., chair, table, bed)
   private int itemCount; // Number of items available in the inventory
   private double price; // Price of the furniture item
   private static ArrayList<FurnitureBase> furnitureInventory = new ArrayList<>(); // Collection of all FurnitureBase
                                                                                   // objects in the inventory

   // constructor
   /**
    * Constructs a new FurnitureBase with default values.
    */
   public FurnitureBase() {
      this.id = "";
      this.furnitureCategory = "Undefined";
      this.itemCount = 0;
      this.price = 0.0;
      furnitureInventory.add(this);
   }

   /**
    * Constructs a new FurnitureBase with the given parameters.
    * 
    * @param id                The unique identifier for the furniture item.
    * @param furnitureCategory The category or type of the furniture item.
    * @param itemCount         The number of items available in the inventory.
    * @param price             The price of the furniture item.
    */
   public FurnitureBase(String id, String furnitureCategory, int itemCount, double price) {
      this.id = id;
      this.furnitureCategory = furnitureCategory;
      this.itemCount = itemCount;
      this.price = price;
      furnitureInventory.add(this);
   }

   // methods
   /**
    * Gets the unique identifier of the furniture item.
    * 
    * @return The unique identifier of the furniture item.
    */
   public String getID() {
      return id;
   }

   /**
    * Abstract method to calculate the discount for the furniture item.
    * 
    * @return The calculated discount for the furniture item.
    */
   public abstract double calculateDiscount();

   /**
    * Abstract method to get the type of the furniture item.
    * 
    * @return The type of the furniture item.
    */
   public abstract String getFurnitureType();

   /**
    * Gets the category or type of the furniture item.
    * 
    * @return The category or type of the furniture item.
    */
   public String getFurnitureCategory() {
      return furnitureCategory;
   }

   /**
    * Sets the category or type of the furniture item.
    * 
    * @param category The category or type to be set.
    */
   public void setFurnitureCategory(String category) {
      this.furnitureCategory = category;
   }

   /**
    * Displays detailed information about the furniture item, including ID,
    * category, item count, and price.
    */
   public void displayDetails() {
      System.out.println("\nFurniture ID: " + id);
      System.out.println("Furniture Category: " + furnitureCategory);
      System.out.println("Item Count: " + itemCount);
      System.out.println("Price: $" + price);
   }

   /**
    * Abstract method to associate a purchaser with the furniture item.
    * 
    * @param buyer The name of the purchaser to be associated.
    */
   public abstract void associatePurchaser(String buyer);

   /**
    * Displays detailed information about all furniture items in the inventory.
    */
   public static void showAllFurnitureDetails() {
      for (FurnitureBase furniture : furnitureInventory) {
         furniture.displayDetails();
      }
   }

   /**
    * Gets the price of the furniture item.
    * 
    * @return The price of the furniture item.
    */
   public double getPrice() {
      return price;
   }

   /**
    * Overrides the toString method to provide a string representation of the
    * furniture item.
    * 
    * @return A string representation of the furniture item.
    */
   @Override
   public String toString() {
      return "Furniture ID: " + id + "\nFurniture Category: " + furnitureCategory +
            "\nItem Count: " + itemCount + "\nPrice: $" + price;
   }
}
