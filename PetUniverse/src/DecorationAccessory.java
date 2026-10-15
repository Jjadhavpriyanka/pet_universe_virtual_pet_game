import java.util.ArrayList;

public class DecorationAccessory extends Accessory{
    //attributes
    private ArrayList<DecorationAccessory> decorationList = new ArrayList<>();
    
    //constructor
    public DecorationAccessory(String accessoryName, String accessoryColor, String size, int comfortFactor, int durability) {
        super(accessoryName, accessoryColor, size, comfortFactor, durability);
        this.decorationList = new ArrayList<>();
        decorationList.add(new DecorationAccessory("Aquarium Castle", "Gray", "Large", 5, 100));
        decorationList.add(new DecorationAccessory("Mirror Perch", "White", "Medium", 2, 70));
        decorationList.add(new DecorationAccessory("Mini Plant", "Green", "Small", 1, 90));
        decorationList.add(new DecorationAccessory("Glow Pebbles", "Neon Blue", "Small", 2, 85));
        decorationList.add(new DecorationAccessory("Bamboo Tunnel", "Brown", "Medium", 2, 95));
        decorationList.add(new DecorationAccessory("Ceramic Cave", "Beige", "Large", 3, 100));
        decorationList.add(new DecorationAccessory("Rainbow Ladder", "Multicolor", "Medium", 2, 85));
        decorationList.add(new DecorationAccessory("Hanging Lantern", "Gold", "Small", 5, 80));
        decorationList.add(new DecorationAccessory("Driftwood Sculpture", "Dark Brown", "Large", 5, 95));
        decorationList.add(new DecorationAccessory("Coral Reef Model", "White", "Medium", 8, 90));
        decorationList.add(new DecorationAccessory("Coral Reef Model", "Red", "Medium", 3, 95));
        decorationList.add(new DecorationAccessory("Wooden Tunnel", "Brown", "Small", 5, 90));
        decorationList.add(new DecorationAccessory("Hide-and-Seek Hut", "Green", "Medium", 5, 100));
        decorationList.add(new DecorationAccessory("Rolling Exercise Ball", "Blue", "Large", 3, 120));
        decorationList.add(new DecorationAccessory("Mini Climbing Wall", "Gray", "Medium", 8, 90));
        decorationList.add(new DecorationAccessory("Chewable Toy Box", "Red", "Small", 2, 85));
        decorationList.add(new DecorationAccessory("Mirror Toy", "White", "Small", 1, 70));
        decorationList.add(new DecorationAccessory("Swing Perch", "Brown", "Medium", 5, 90));
        decorationList.add(new DecorationAccessory("Feather-Themed Wall Art", "Blue", "Large", 2, 100));
        decorationList.add(new DecorationAccessory("Hanging Bell Toy", "Gold", "Small", 2, 80));
        decorationList.add(new DecorationAccessory("Bird Ladder", "Red", "Medium", 2, 110));
        decorationList.add(new DecorationAccessory("Cat Hammock", "White", "Small", 5, 90));
        decorationList.add(new DecorationAccessory("Climbing Pole", "Beige", "Medium", 5, 110));
        decorationList.add(new DecorationAccessory("Scratch-Resistant Mat", "Grey", "Large", 3, 120));
        decorationList.add(new DecorationAccessory("Feline Window Perch", "Black", "Medium", 2, 100));
        decorationList.add(new DecorationAccessory("Elegant Cat Tower", "Brown", "Large", 5, 140));
        decorationList.add(new DecorationAccessory("Dog Paw Rug", "Brown", "Medium", 2, 100));
        decorationList.add(new DecorationAccessory("Chew-Resistant Bed", "Beige", "Large", 3, 120));
        decorationList.add(new DecorationAccessory("Playful Dog Banner", "Blue", "Small", 1, 80));
        decorationList.add(new DecorationAccessory("Pet Food Station", "Gray", "Medium", 5, 110));
        decorationList.add(new DecorationAccessory("Indoor Dog Slide", "Green", "Large", 4, 130));
        decorationList.add(new DecorationAccessory("Dog Bone Rug", "Brown", "Medium", 5, 100));
        decorationList.add(new DecorationAccessory("Scratching Post", "Grey", "Medium", 2, 120));
        decorationList.add(new DecorationAccessory("Elegant Cat Tower", "Brown", "Large", 4, 150));
        decorationList.add(new DecorationAccessory("Paw Print Wall Art", "Red", "Medium", 2, 110));
        decorationList.add(new DecorationAccessory("Elegant Dog Statue", "Grey", "Large", 3, 150));
        decorationList.add(new DecorationAccessory("Catnip Garden Mat", "Green", "Small", 8, 85));
        decorationList.add(new DecorationAccessory("Doggy Welcome Sign", "Green", "Small", 5, 70));
        decorationList.add(new DecorationAccessory("Feline Royal Cushion", "Purple", "Medium", 5, 110));
    }

    
    //getters and setters
    public ArrayList<DecorationAccessory> getDecorationList() {
        return decorationList;
    }

    //methods
    @Override
    public void addAccessory(Accessory accessory) { 
        if (accessory instanceof DecorationAccessory) { 
            // Ensure the accessory is decorative item 
            decorationList.add((DecorationAccessory)accessory); 
            // Add to the list 
            System.out.println(((DecorationAccessory) accessory).getAccessoryName() + " added to decoration list!"); 
        } else { 
            System.out.println("Only decorative items can be added to the list!"); 
        } 
    }

    @Override
    // Show all decorative items available
    public void showAccessories() {
        if (decorationList.isEmpty()) {
            System.out.println("No toy currently in the store.");
            return;
        } else {
            System.out.println("Toys available to buy:");
        for (int i = 0; i < decorationList.size(); i++) {
            DecorationAccessory decorationAccessory = decorationList.get(i);
            System.out.println("-----------------------------------");
            System.out.println("Toy #" + (i + 1) + ". " + "\n" + decorationAccessory.toString());
            }
        }
    }

    // get decoration item by index
    @Override
    public Accessory getAccessory(int index) {
        // Validate the index 
        if (index < 0 || index >= decorationList.size()) {
            System.out.println("Invalid choice. Please select a valid house.");
            return null;
        }
        // Retrieve the chosen decoration 
        DecorationAccessory chosenDecoration = decorationList.get(index);
        return chosenDecoration;
    }

    @Override
    public void removeAccessories(Accessory accessory, int index, String petType) {
        if (accessory instanceof DecorationAccessory) {
            Accessory boughtAccessory = accessoryList.remove(index);
            System.out.println("You have bought " + boughtAccessory.getAccessoryName() + " the " + boughtAccessory.getClass().getSimpleName());
        } else {
            System.out.println("You can only remove decorative items.");
        }  
    }
}
