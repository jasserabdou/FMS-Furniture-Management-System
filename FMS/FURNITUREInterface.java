
/**
 * This interface provides a blueprint for basic operations on furniture, purchasers, 
 * and furniture categories within a furniture management system.
 */
public interface FURNITUREInterface {

    /**
     * Adds a new piece of furniture to the system.
     *
     * @param furniture The FurnitureBase object to be added.
     */
    void addFurniture(FurnitureBase furniture);

    /**
     * Adds a new purchaser to the system.
     *
     * @param purchaser The Purchaser object to be added.
     */
    void addPurchaser(Purchaser purchaser);

    /**
     * Adds a new category for furniture in the system.
     *
     * @param category The FurnitureCategory object to be added.
     */
    void addCategory(FurnitureCategory category);

    /**
     * Retrieves a piece of furniture by its unique ID.
     *
     * @param id The unique identifier of the desired furniture.
     * @return FurnitureBase object with the matching ID or null if not found.
     */
    FurnitureBase getFurnitureByID(String id);

    /**
     * Retrieves a purchaser by its unique ID.
     *
     * @param id The unique identifier of the desired purchaser.
     * @return Purchaser object with the matching ID or null if not found.
     */
    Purchaser getPurchaserByID(String id);

    /**
     * Retrieves a furniture category by its unique ID.
     *
     * @param id The unique identifier of the desired furniture category.
     * @return FurnitureCategory object with the matching ID or null if not found.
     */
    FurnitureCategory getCategoryByID(String id);
}
