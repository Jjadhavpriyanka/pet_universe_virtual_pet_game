import java.util.ArrayList;

public class ToyAccessory extends Accessory{
    
    //attributes
    private int funLevel;
    ArrayList<ToyAccessory> toyList = new ArrayList<>();;
    private boolean isBroken;
    private int usageCount;

    public ToyAccessory(String accessoryName, String accessoryColor, String size, int stylePoints, int comfortFactor,
            int durability, int funLevel) {
        super(accessoryName, accessoryColor, size, comfortFactor, durability);
        this.funLevel = funLevel;
        this.isBroken = false;
        this.usageCount = 0;
    }

    public ToyAccessory() {
        super();
        if (toyList == null) {
            toyList = new ArrayList<>();
        }
        initialiseToyAccessoryList();
    }

    public int getFunLevel() {
        return funLevel;
    }

    public void setFunLevel(int funLevel) {
        this.funLevel = funLevel;
    }

    public int getUsageCount() {
        return usageCount;
    }

    public int getToyList() {
        return toyList.size();
    }

    //methods

    public void initialiseToyAccessoryList(){
        
        toyList.add(new ToyAccessory("Chew Toy", "Red", "Small", 15, 10, 80, 50));
        toyList.add(new ToyAccessory("Glow Ball", "Yellow", "Small", 10, 8, 90, 40));
        toyList.add(new ToyAccessory("Bird Swing", "Brown", "Medium", 20, 15, 100, 60));
        toyList.add(new ToyAccessory("Puzzle Cube", "Green", "Medium", 25, 12, 75, 45));
        toyList.add(new ToyAccessory("Squeaky Hammer", "Blue", "Small", 15, 10, 70, 55));
        toyList.add(new ToyAccessory("Tumble Wheel", "Pink", "Large", 30, 20, 95, 70));
        toyList.add(new ToyAccessory("Tug Rope", "Multicolor", "Small", 10, 10, 80, 50));
        toyList.add(new ToyAccessory("Feather Wand", "Purple", "Medium", 18, 10, 85, 40));
        toyList.add(new ToyAccessory("Jingle Ball", "Metallic", "Small", 10, 8, 90, 30));
        toyList.add(new ToyAccessory("Interactive Tunnel", "Gray", "Large", 35, 25, 100, 80));
        toyList.add(new ToyAccessory("Rubber Tire", "Black", "Large", 30, 50, 80, 60));
        toyList.add(new ToyAccessory("Floating Bone", "Blue", "Medium", 40, 30, 60, 70));
        toyList.add(new ToyAccessory("Red Laser Pointer", "Red", "Small", 20, 10, 90, 85));
        toyList.add(new ToyAccessory("Climbing Tower", "Brown", "Large", 50, 60, 70, 95));
    }

    @Override
    public void addAccessory(Accessory accessory) { 
        if (accessory instanceof ToyAccessory) { 
            // Ensure the accessory is toy item 
            toyList.add((ToyAccessory)accessory); 
            // Add to the list 
            System.out.println(((ToyAccessory) accessory).getAccessoryName() + " added to toy list!"); 
        } else { 
            System.out.println("Only toy items can be added to the list!"); 
        } 
    }

    @Override
    // Show all accessory available
    public void showAccessories() {
        if (toyList.isEmpty()) {
            System.out.println("No toy currently in the store.");
            return;
        } else {
            System.out.println("Toys available to buy:");
        for (int i = 0; i < toyList.size(); i++) {
            ToyAccessory toyAccessory = toyList.get(i);
            System.out.println("-----------------------------------");
            System.out.println("Toy #" + (i + 1) + ". " + "\n" +toyAccessory.toString());
            }
        }
    }

    // get toy by index
    @Override
    public ToyAccessory getAccessory(int index) {

        // Validate the index 
        if (index < 0 || index >= toyList.size()) {
            System.out.println("Invalid choice. Please select a valid house.");
            return null;
        }

        // Retrieve the chosen toy 
        ToyAccessory chosenToy = toyList.get(index);

        return chosenToy;
    }

    // Specialised Methods
    public void useToy() {
        if (!isBroken) {
            usageCount++;
            durability -= 10;

            //check if toy broken after use
            if (durability <= 20) {
                isBroken = true;
            }
        } else {
            System.out.println(getAccessoryName() + "is broken and cannot be used.");
        }
    }

    //check if toy broken
    public boolean isBroken() {
        return isBroken;
    }

    // Method to display the toy's condition
    public String getCondition() {
        if (isBroken) {
            return "Broken";
        } else if (durability > 5) {
            return "Good";
        } else if (durability > 0) {
            return "Worn";
        } else {
            return "Broken";
        }
    }

    //how durability affects fun
    public int updateFunFactor() {
        return (durability > 5) ? funLevel : funLevel / 2; // Less fun if toy is worn out
    }

    @Override
    public void removeAccessories(Accessory accessory, int index, String petType) {
        if (accessory instanceof ToyAccessory) {
            Accessory boughtAccessory = accessoryList.remove(index);
            System.out.println("You have bought " + boughtAccessory.getAccessoryName() + " the " + boughtAccessory.getClass().getSimpleName());
        } else {
            System.out.println("You can only remove toy items.");
        }  
    }
}
