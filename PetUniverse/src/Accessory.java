
import java.util.ArrayList;

public class Accessory {
    protected String accessoryName;
    protected String accessoryColor;
    protected String size;
    protected int comfortFactor;
    protected int durability;
    protected ArrayList<Accessory> accessoryList;
    protected int timeLeftForCleaning = 0; // Tracks toy usage


    //constructor
    public Accessory(String accessoryName, String accessoryColor, String size, int comfortFactor, int durability) {
        this.accessoryName = accessoryName;
        this.accessoryColor = accessoryColor;
        this.size = size;
        this.comfortFactor = comfortFactor;
        this.durability = durability;
        this.accessoryList = new ArrayList<>();
    }

    public Accessory(){
        
    }


    //getters and setters
    public ArrayList<Accessory> getAccessoryList() {
        return accessoryList;
    }

    public String getAccessoryName() {
        return accessoryName;
    }

    public int getAccessoryCount() {
        return accessoryList.size();
    }

    public void setAccessoryName(String accessoryName) {
        this.accessoryName = accessoryName;
    }

    public String getAccessoryColor() {
        return accessoryColor;
    }

    public void setAccessoryColor(String accessoryColor) {
        this.accessoryColor = accessoryColor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getComfortFactor() {
        return comfortFactor;
    }

    public void setComfortFactor(int comfortFactor) {
        this.comfortFactor = comfortFactor;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    //methods
    // Shared Methods
    public void displayDetails() {
        System.out.println(toString());
    }

    public String toString() {    
        return "Name:       " + this.accessoryName + 
               "\nColor:      " + this.accessoryColor +
               "\nDurability: " + this.durability + 
               "\nSize:       " + this.size;
    }

    public void addAccessory(Accessory accessory) { 
        if (accessory instanceof Accessory) { 
            // Ensure the accessory 
            accessoryList.add((Accessory)accessory); 
            // Add to the list 
            System.out.println(((Accessory) accessory).getAccessoryName() + " added to accessory list!"); 
        } else { 
            System.out.println("Only accessories can be added to the list!"); 
        } 
    }

    // Show all accessory available
    public void showAccessories() {
        if (accessoryList.isEmpty()) {
            System.out.println("No accessory currently in the store.");
            return;
        } else {
            System.out.println("Accessories available to buy:");
        for (int i = 0; i < accessoryList.size(); i++) {
            Accessory accessory = accessoryList.get(i);
            System.out.println("Accessory # " + (i + 1) + 
            accessory.toString());
            }
        }
    }

    // Get accessory by index
    public Accessory getAccessory(int index) {

        // Validate the index 
        if (index < 0 || index >= accessoryList.size()) {
            System.out.println("Invalid choice. Please select a valid house.");
            return null;
        }
        // Retrieve the chosen accessory 
        Accessory chosenAccessory = accessoryList.get(index);
        return chosenAccessory;
    }

    

    public void removeAccessories(Accessory accessory, int index, String petType) {
        Accessory boughtAccessory = accessoryList.remove(index);
        System.out.println("You have bought " + boughtAccessory.getAccessoryName() + " the " + boughtAccessory.getClass().getSimpleName());
    }

    public boolean needsCleaning() {
        return timeLeftForCleaning >= 5; // Needs cleaning after 5 uses
    }

    public void cleanedAccessory() {
        timeLeftForCleaning = 0; // toy is cleaned
    }
}
    


