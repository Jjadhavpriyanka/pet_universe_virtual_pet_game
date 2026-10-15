import java.util.ArrayList;

public class CatShelter extends Shelter{
    private ArrayList<Cat> catList;
    private int scratchingPost;
    private int climbingTowers;


    //constructor
    public CatShelter() {
        super("Whisker Haven", 12);
        this.scratchingPost = 5;
        this.climbingTowers = 3;
        //initialise birds within shelter
        initialiseCatList();
    }

    //getters and setters
    public ArrayList<Cat> getCatList() {
        return catList;
    }

    public void setCatList(ArrayList<Cat> catList) {
        this.catList = catList;
    }

    public int getScratchingPost() {
        return scratchingPost;
    }

    public void setScratchingPost(int scratchingPost) {
        this.scratchingPost = scratchingPost;
    }

    public int getClimbingTowers() {
        return climbingTowers;
    }

    public void setClimbingTowers(int climbingTowers) {
        this.climbingTowers = climbingTowers;
    }


    //methods
    private void initialiseCatList() {
        if (petsInShelter == null) {
            petsInShelter = new ArrayList<>();
        }
        petsInShelter.add(new Cat("Luna", 12.5, true, "Siamese", "Sunny Windowsill", "Cream with dark spots", 88, 10, 92, 20));
        petsInShelter.add(new Cat("Oliver", 15.0, true, "British shorthair", "Cozy Couch", "Blue-grey", 82, 15, 88, 30));
        petsInShelter.add(new Cat("Bella", 10, true, "Bengal", "Treehouse", "Brown spotted", 90, 20, 75, 40));
        petsInShelter.add(new Cat("Simba", 18, true, "Maine Coon", "Bedside Table", "Golden", 92, 5, 85, 50));
        petsInShelter.add(new Cat("Daisy", 9, true, "Persian", "Fireplace mat", "White", 65 ,15 ,55, 25));
        petsInShelter.add(new Cat("Charlie", 7, true, "Ragdoll", "Under the bed","Light cream", 68, 10, 65, 35));
        petsInShelter.add(new Cat("Chloe", 5, true, "Russian Blue", "Balcony chair", "Silver", 78, 15, 90, 45));
        petsInShelter.add(new Cat("Coco", 12, true, "Scottish Fold", "Kitchen floor", "Grey Tabby", 72, 30, 50, 20));
        petsInShelter.add(new Cat("Max", 20, true, "Abyssinian", "Window seat", "Red", 88, 10, 92, 30));
        petsInShelter.add(new Cat("Molly", 11, true, "American shorthair", "Cat bed", "Black & white", 80, 25, 70, 40));
        petsInShelter.add(new Cat("Kitty", 14, true, "Oriental shorthair", "Cat tree", "White with black spots", 85, 20, 78, 25));
        petsInShelter.add(new Cat("Ginger", 6, true, "Dimestic shorthair","Balcony", "Orange tabby", 80, 25, 82, 35));
        petsInShelter.add(new Cat("Shophie", 9.5, true, "Burmese", "Sofa corner", "Dark brown", 75, 20, 65, 45));
        petsInShelter.add(new Cat("Felix", 8, true, "Exotic shorthair", "Living room couch", "Cream white", 68, 40, 58, 25));
        petsInShelter.add(new Cat("Mittens", 11, true, "American wirehair", "Bedroom window", "Grey tabby", 78, 25, 68, 20));
        petsInShelter.add(new Cat("Leo", 13, true, "Maine coon", "Fireplace mat", "Silver with stripes", 85, 10, 80, 35));
        petsInShelter.add(new Cat("Oscar", 10, true, "Siberian", "Treehouse platform", "Cream tabby", 82, 15, 75, 30));
        petsInShelter.add(new Cat("Lucy", 12, true, "Norwegian Forest", "Kitchen shelf", "Snow white", 88, 20, 70, 40));
        petsInShelter.add(new Cat("Jack", 9, true, "Abyssinian", "Deck chair", "Red auburn", 75, 15, 65, 25));
        petsInShelter.add(new Cat("Lily", 7, true, "Chartreux", "Wooden crate", "Blue grey", 78, 20, 75, 35));
    }

    @Override
    public int checkCapacity() {
        int maxCatsByTowers = climbingTowers * 4; // Assume 4 cats per tower
        int effectiveCapacity = Math.min(capacity, maxCatsByTowers);
        int remainingCapacity = effectiveCapacity - petsInShelter.size();
        return remainingCapacity;
    }

    @Override
    public void addPet(Pet pet) {
        if (!(pet instanceof Cat)) {
            System.out.println("Only cats are allowed in this shelter!");
            return;
        }

        int remainingCapacity = checkCapacity(); // Call checkCapacity to ensure accurate remaining capacity
        if (remainingCapacity == 0) {
            System.out.println("Sorry, no more places for cats. Try again later.");
            return;
        }

        // Add the cat to the shelter
        petsInShelter.add(pet);
    }

    @Override
    public void removePet(Pet pet) {
        if (pet instanceof Cat) { // Ensure it's a cat
        Cat cat = (Cat) pet; // Cast the pet to cat
            if (!cat.isAlive()) {
                petsInShelter.remove(cat);
            } else {
                System.out.println(cat.getPetName() + " is still alive and cannot be removed.");
            }
        } else {
            System.out.println("This pet is not a cat and cannot be removed by CatShelter.");
        }
    }

    @Override
    public void showPets() {
        if (petsInShelter.isEmpty()) {
            System.out.println("No cats available for adoption.");
            return;
        } else {
            System.out.println("Cats available for adoption:");
            for (int i = 0; i < petsInShelter.size(); i++) {
                Pet pet = petsInShelter.get(i); // Retrieve as a Pet object
                if (pet instanceof Cat) { // Check if the Pet is actually a cat
                    Cat cat = (Cat) pet; // Cast Pet to cat
                    System.out.println("-------------------------");
                    System.out.println("Cat #" + (i + 1) + ":");
                    System.out.println(cat.toString());
                }
            }
        }
    }

    @Override
    public Pet adoptPetFromShelter(int index) {
        ArrayList<Cat> catList = getCatsInShelter(); // Get the filtered list of cats
        if (index < 0 || index >= catList.size()) {
            System.out.println("Invalid choice. Please try again.");
            return null;
        }

        Cat adoptedCat = catList.get(index); // Retrieve the selected cat
        petsInShelter.remove(adoptedCat); // Remove the cat from the main shelter list
        return adoptedCat;
    }

    //retrieve all cats in the shelter
    public ArrayList<Cat> getCatsInShelter() {
        ArrayList<Cat> catList = new ArrayList<>();
        for (Pet pet : petsInShelter) {
            if (pet instanceof Cat) {
                catList.add((Cat) pet);
            }
        }
        return catList;
    }

    @Override
    public String toString() {
        return super.toString() // Call the superclass's toString() method
            + "\nScratching Post Count: \t" + this.scratchingPost + "\nClimbing Towers Count: \t" + this.climbingTowers;
    }
    
}
