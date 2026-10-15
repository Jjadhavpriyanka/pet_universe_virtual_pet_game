
import java.util.ArrayList;

public class BirdShelter extends Shelter{
    //attributes
    private int perchCount;
    private int nestBoxes;

    //constructor
    public BirdShelter() {
        super("Aviary Sanctuary", 21);
        this.perchCount = 10;
        this.nestBoxes = 5;
        initialiseBirdList();  
    }

    
    //getters and setters
    public int getPerchCount() {
        return perchCount;
    }

    public void setPerchCount(int perchCount) {
        this.perchCount = perchCount;
    }

    public int getNestBoxes() {
        return nestBoxes;
    }

    public void setNextBoxes(int nestBoxes) {
        this.nestBoxes = nestBoxes;
    }


    //methods
    private void initialiseBirdList() {
        if (petsInShelter == null) {
            petsInShelter = new ArrayList<>();
        }
        petsInShelter.add(new Bird("Sunny", 24, true, "Parakeet", "Sunlit Perch", 70, 20, 75, 40));
        petsInShelter.add(new Bird("Ruby", 12, true, "Cockatiel", "Swing perch", 85, 15, 90, 30));
        petsInShelter.add(new Bird("Bluebell", 36, true, "Budgerigar", "Bamboo Stick", 80, 10, 85, 35));
        petsInShelter.add(new Bird("Jasper", 48, true, "Lovebird", "Wicker perch", 70, 30, 80, 50));
        petsInShelter.add(new Bird("Scarlet", 24, true, "Scarlet Macaw", "Bark perch", 95, 5, 100, 20));
        petsInShelter.add(new Bird("Pip", 12, true,"Zebra Finch", "Coconut perch", 50, 40, 65, 45));
        petsInShelter.add(new Bird("Kiwi", 60, true, "African Grey", "Wooden pole", 90, 20, 95, 55));
        petsInShelter.add(new Bird("Goldie", 36, true, "Canary", "Ring perch", 80, 18, 90, 20));
        petsInShelter.add(new Bird("Ember", 24, true, "Sun Conure", "Rope perch", 85, 30, 80, 25));
        petsInShelter.add(new Bird("Midnight", 48, true, "Indian Ringneck", "Rubber perch", 75, 25, 85, 35));
        petsInShelter.add(new Bird("Daisy", 36, true, "Green Cheek Conure", "Padded perch", 65, 30, 70, 30));
        petsInShelter.add(new Bird("Thunder", 48, true, "Blue and Gold Macaw", "Branch perch", 95, 10, 100, 45));
        petsInShelter.add(new Bird("Frost", 24, true, "Cockatoo", "Bell Swing", 70, 40, 85, 40));
        petsInShelter.add(new Bird("Blaze", 12, true, "Sun Parakeet", "Vantage perch", 80, 30, 75, 25));
        petsInShelter.add(new Bird("Olive", 24, true, "Eclectus", "Cushion perch", 85, 25, 95, 35));
        petsInShelter.add(new Bird("Harmony", 36, true,  "Canary", "Ceramic perch", 80, 18, 90, 40));
        petsInShelter.add(new Bird("Sonny", 12, true, "Finch", "Woven perch", 60, 30, 70, 45));
        petsInShelter.add(new Bird("Bella", 60, true, "Amazon Parrot", "Indoor perch", 90, 15, 100, 30));
        petsInShelter.add(new Bird("Flame", 24, true, "Conure", "Padded Swing", 85, 30, 80, 35));
        petsInShelter.add(new Bird("Echo", 48, true, "Quaker Parrot", "Padded perch", 90, 20, 95, 45));
    }

    @Override
    public int checkCapacity() {
        int maxBirdsByPerches = perchCount * 2; // Assume 2 birds per perch
        int effectiveCapacity = Math.min(capacity, maxBirdsByPerches);
        int remainingCapacity = effectiveCapacity - petsInShelter.size();
        return remainingCapacity;
    }

    @Override
    public void addPet(Pet pet) {
        if (!(pet instanceof Bird)) {
            System.out.println("Only birds are allowed in this shelter!");
            return;
        }
        int remainingCapacity = checkCapacity(); // Call checkCapacity to ensure accurate remaining capacity
        if (remainingCapacity == 0) {
            System.out.println("Sorry, no more places for birds. Try again later.");
            return;
        }
        // Add the bird to the shelter
        petsInShelter.add(pet);
    }

    @Override
    public void removePet(Pet pet) {
        if (pet instanceof Bird) { // Ensure it's a bird
            Pet bird = pet; // Cast the pet to Bird
            if (!bird.isAlive()) {
                petsInShelter.remove(bird);
            } else {
                System.out.println(bird.getPetName() + " is still alive and cannot be removed.");
            }
        } else {
            System.out.println("This pet is not a bird and cannot be removed by BirdShelter.");
        }
    }

    @Override
    public void showPets() {
        if (petsInShelter.isEmpty()) {
            System.out.println("No birds available for adoption.");
            return;
        } else {
            System.out.println("Birds available for adoption:");
            for (int i = 0; i < petsInShelter.size(); i++) {
                Pet pet = petsInShelter.get(i); // Retrieve as a Pet object
                if (pet instanceof Bird) { // Check if the Pet is actually a Bird
                    Pet bird = pet; // Cast Pet to Bird
                    System.out.println("-------------------------");
                    System.out.println("Bird #" + (i + 1) + ":");
                    System.out.println(bird.toString());
                }
            }
        }
    }

    @Override
    public Pet adoptPetFromShelter(int index) {
        ArrayList<Bird> birdList = getBirdsInShelter(); // Get the filtered list of birds
        if (index < 0 || index >= birdList.size()) {
            System.out.println("Invalid choice. Please try again.");
            return null;
        }

        Pet adoptedBird = birdList.get(index); // Retrieve the selected bird
        petsInShelter.remove(adoptedBird); // Remove the bird from the main shelter list
        return adoptedBird;
    }

    //retrieve all birds in the shelter
    public ArrayList<Bird> getBirdsInShelter() {
        ArrayList<Bird> birdList = new ArrayList<>();
        for (Pet pet : petsInShelter) {
            if (pet instanceof Bird) {
                birdList.add((Bird) pet);
            }
        }
        return birdList;
    }

    public int checkPerchAvailability() {
        int remainingPerches = perchCount - petsInShelter.size();
        System.out.println("Remaining perches: " + remainingPerches);
        return remainingPerches;
    }

    // Method: Track Nesting Activity
    public void trackNestingActivity() {
        System.out.println("Monitoring nesting activities in the shelter...");
        for (Pet pet : petsInShelter) {
            if(pet instanceof Bird) {
                Pet bird = pet;
                System.out.println(bird.getPetName() + " is using a nest box.");
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() // Call the superclass's toString() method
            + "\nPerch Count: \t" + this.perchCount + "\nNest Boxes: \t" + this.nestBoxes;
    }
    
}
