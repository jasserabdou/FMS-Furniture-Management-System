public class KidsSetTest {

    public static void main(String[] args) {
        // Test 1
        KidsSet defaultKidsSet = new MyKidsSetItems("SET001", "Kid's Furniture", 1, 199.99, "DinosaurAdventure", "Dino Desk");
        System.out.println("Test 1:");
        defaultKidsSet.displayDetails();

        // Test 2
        System.out.println("\nTest 2: Show Price");
        defaultKidsSet.showPrice();

        // Test 3
        System.out.println("\nTest 3: Mystery Gift");
        String gift = defaultKidsSet.mysteryGift();
        System.out.println("Mystery Gift: " + gift);

        // Test 4
        KidsSet highPriceKidsSet = new MyKidsSetItems("SET002", "Kid's Furniture", 1, 600.0, "SpaceExplorer", "Rocket Chair");
        System.out.println("\nTest 4: Another Mystery Gift Test");
        highPriceKidsSet.displayDetails();

        // Test 5
        System.out.println("\nTest 5: Display Details");
        defaultKidsSet.displayDetails();
    }
}