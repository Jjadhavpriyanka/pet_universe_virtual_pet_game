import java.util.ArrayList;

public class FishShelter extends Shelter{
    //attributes
    private String decorativeStyle; // coral, cave, pirate
    private int size; //in litres
    private int requiredCleaningDays;
    private ArrayList<Fish> fishList;

    //constructor
    public FishShelter() {
        super("Aquarium Fish", 21);
        this.decorativeStyle = "Ocean Theme";
        this.size = 100;
        this.requiredCleaningDays = 7;
        initialiseFishList();
    }
    

    //getters and setters
    public String getDecorativeStyle() {
       
        return decorativeStyle;
    }
    public void setDecorativeStyle(String decorativeStyle) {
        this.decorativeStyle = decorativeStyle;
    }
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRequiredCleaningDays() {
        return requiredCleaningDays;
    }

    public void setRequiredCleaningDays(int requiredCleaningDays) {
        this.requiredCleaningDays = requiredCleaningDays;
    } 

    
    //methods
    private void initialiseFishList() {
        if (petsInShelter == null) {
            petsInShelter = new ArrayList<>();
        }
        petsInShelter.add(new Fish("Bubbles", 6.0, true, "Betta Fish", "Floating plants", "Blue", 88, 15, 85, 20));
        petsInShelter.add(new Fish("Goldie", 12.0, true, "Goldfish", "Tank bottom", "Golden", 78, 25, 70, 45));
        petsInShelter.add(new Fish("Splash", 9.0, true, "Koi", "Pond surface", "Orange-white", 82, 18, 85, 30));
        petsInShelter.add(new Fish("Angel", 16.0, true, "Angelfish", "Coral ornaments", "Silver", 78, 30, 65, 25));
        petsInShelter.add(new Fish("Spike", 20.0, true, "Pufferfish", "Coral reef", "Yellow-black", 70, 40, 55, 40));
        petsInShelter.add(new Fish("Neon", 8.0, true, "Neon Tetra", "Driftwood", "Neon-blue", 90, 10, 88, 35));
        petsInShelter.add(new Fish("Shadow", 14.0, true, "Plecostomus", "Rock caves", "Brown-black", 68, 35, 50, 40));
        petsInShelter.add(new Fish("Flare", 10.0, true, "Guppy", "Bright-lit zones", "Rainbow", 85, 22, 80, 35));
        petsInShelter.add(new Fish("Crystal", 24.0, true, "Zebra Danio", "Dense plants", "Silver-striped", 88, 25, 85, 45));
        petsInShelter.add(new Fish("Reefy", 12.0, true, "Clownfish", "Sea anemone", "Orange-white", 85, 55, 75, 30));
        petsInShelter.add(new Fish("Dotty", 18.0, true, "Oscar Fish", "Open water areas", "Black-orange", 80, 65, 68, 25));
        petsInShelter.add(new Fish("Pearl", 9.0, true, "Pearl Gourami", "Water surface", "Pearl-white", 78, 40, 70, 30));
        petsInShelter.add(new Fish("Tiger", 14.0, true, "Tiger Barb", "Pebble layers", "Orange-striped", 85, 30, 80, 40));
        petsInShelter.add(new Fish("Sunny", 7.0, true, "Mollies", "Behind decorations", "Yellow", 72, 50, 65, 25));
        petsInShelter.add(new Fish("Flash", 6.0, true, "Cherry Barb", "Near rocks", "Red", 90, 25, 88, 35));
        petsInShelter.add(new Fish("Aqua", 20.0, true, "Discus", "Central tank", "Blue-green", 75, 50, 55, 45));
        petsInShelter.add(new Fish("Jade", 18.0, true, "Dwarf Gourami", "Heater area", "Jade-green", 72, 60, 65, 50));
        petsInShelter.add(new Fish("Coral", 15.0, true, "Firefish", "Reef caves", "Orange-red", 80, 55, 65, 30));
        petsInShelter.add(new Fish("Sonic", 12.0, true, "Rainbowfish", "Open swim areas", "Multi-colored", 85, 40, 75, 25));
        petsInShelter.add(new Fish("Marble", 19.0, true, "Black Ghost Knife", "Dark tank areas", "Black-white", 65, 55, 50, 30));
    }

    @Override
    public int checkCapacity() {
        int maxFishByTowers = size * 4; // Assume 4 fish per tower
        int effectiveCapacity = Math.min(capacity, maxFishByTowers);
        int remainingCapacity = effectiveCapacity - petsInShelter.size();
        return remainingCapacity;
    }

    @Override
    public void addPet(Pet pet) {
        if (!(pet instanceof Fish)) {
            System.out.println("Only fish are allowed in this shelter!");
            return;
        }

        int remainingCapacity = checkCapacity(); // Call checkCapacity to ensure accurate remaining capacity
        if (remainingCapacity == 0) {
            System.out.println("Sorry, no more places for fish. Try again later.");
            return;
        }

        // Add the fish to the shelter
        petsInShelter.add(pet);
    }

    @Override
    public void removePet(Pet pet) {
        if (pet instanceof Fish) { // Ensure it's a fish
        Fish fish = (Fish) pet; // Cast the pet to fish
            if (!fish.isAlive()) {
                petsInShelter.remove(fish);
                //System.out.println(fish.getPetName() + " has been removed from the fish shelter: " + this.shelterName);
            } else {
                System.out.println(fish.getPetName() + " is still alive and cannot be removed.");
            }
        } else {
            System.out.println("This pet is not a fish and cannot be removed by FishShelter.");
        }
    }

    @Override
    public void showPets() {
        if (petsInShelter.isEmpty()) {
            System.out.println("No fish available for adoption.");
            return;
        } else {
            System.out.println("Fish available for adoption:");
            for (int i = 0; i < petsInShelter.size(); i++) {
                Pet pet = petsInShelter.get(i); // Retrieve as a Pet object
                if (pet instanceof Fish) { // Check if the Pet is actually a fish
                    Fish fish = (Fish) pet; // Cast Pet to fish
                    System.out.println("-------------------------");
                    System.out.println("Fish #" + (i + 1) + ":");
                    System.out.println(fish.toString());
                }
            }
        }
    }

    @Override
    public Pet adoptPetFromShelter(int index) {
        ArrayList<Fish> fishList = getFishInShelter(); // Get the filtered list of fish
        if (index < 0 || index >= fishList.size()) {
            System.out.println("Invalid choice. Please try again.");
            return null;
        }

        Fish adoptedFish = fishList.get(index); // Retrieve the selected fish
        petsInShelter.remove(adoptedFish); // Remove the fish from the main shelter list
        return adoptedFish;
    }

    //retrieve all birds in the shelter
    public ArrayList<Fish> getFishInShelter() {
        ArrayList<Fish> fishList = new ArrayList<>();
        for (Pet pet : petsInShelter) {
            if (pet instanceof Fish) {
                fishList.add((Fish) pet);
            }
        }
        return fishList;
    }

    @Override
    public String toString() {
        return super.toString() // Call the superclass's toString() method
            + "\nDecorative Style of Tank: \t" + this.decorativeStyle + "\nSize of tank: \t" + this.size + "\nDays until next cleaning: " + this.requiredCleaningDays;
    }

    public Fish getFishAtIndex(int index) {
        if (index >= 0 && index < fishList.size()) {
            return fishList.get(index); // Return the fish object at the specified index
        }
        return null; // If index is invalid
    }
    
}
