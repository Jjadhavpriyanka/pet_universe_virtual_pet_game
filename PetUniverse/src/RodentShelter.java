import java.util.ArrayList;

public class RodentShelter extends Shelter{
    //attributes
    private int numCompartments;
    private int numWheels;

    //constructor
    public RodentShelter() {
        super("Tiny Tunnels", 12);
        this.numCompartments = 6;
        this.numWheels = 4;
        //initialise rodent within shelter
        initialisepetsInShelter();
    }

    //getters and setters
    public int getNumCompartments() {
        return numCompartments;
    }

    public void setNumCompartments(int numCompartments) {
        this.numCompartments = numCompartments;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public void setNumWheels(int numWheels) {
        this.numWheels = numWheels;
    }

    //methods
    private void initialisepetsInShelter() {
        if (petsInShelter == null) {
            petsInShelter = new ArrayList<>();
        }

        // Add predetermined list of rodent
        petsInShelter.add(new Rodent("Whiskers", 12.0, true, "Hamster", "Wheel", "Brown", true, 88, 15, 85, 30));
        petsInShelter.add(new Rodent("Squeaky", 8.0, true, "Mouse", "Tube maze", "White", true, 78, 20, 80, 45));
        petsInShelter.add(new Rodent("Nibbles", 18.0, true, "Gerbil", "Burrow", "Golden", true, 85, 10, 90, 25));
        petsInShelter.add(new Rodent("Peanut", 24.0, true, "Rat", "Climbing structure", "Grey", true, 82, 12, 82, 30));
        petsInShelter.add(new Rodent("Cocoa", 14.0, true, "Guinea Pig", "Corner hideout", "Brown-white", false, 72, 30, 70, 40));
        petsInShelter.add(new Rodent("Dandy", 20.0, true, "Chinchilla", "Soft sand area", "Grey", false, 75, 20, 75, 25));
        petsInShelter.add(new Rodent("Thistle", 10.0, true, "Chipmunk", "Branches", "Striped brown", true, 85, 15, 85, 35));
        petsInShelter.add(new Rodent("Nutmeg", 9.0, true, "Gerbil", "Sand corner", "Sandy brown", true, 78, 25, 80, 50));
        petsInShelter.add(new Rodent("Velvet", 30.0, true, "Chinchilla", "Dust bath bowl", "Light grey", false, 88, 8, 90, 20));
        petsInShelter.add(new Rodent("Butterscotch", 7.0, true, "Hamster", "Maze area","Golden", true, 80, 20, 85, 45));
        petsInShelter.add(new Rodent("Puff", 16.0, true, "Guinea Pig", "Human's lap","White", false, 70, 22, 80, 20));
        petsInShelter.add(new Rodent("Comet", 12.0, true, "Rat", "Hanging ropes", "Black", true, 85, 18, 85, 25));
        petsInShelter.add(new Rodent("Mocha", 10.0, true, "Gerbil", "Wooden zone", "Dark brown", true, 75, 22, 80, 35));
        petsInShelter.add(new Rodent("Skippy", 6.0, true, "Mouse", "Flat surface", "Pale grey", true, 70, 30, 65, 30));
        petsInShelter.add(new Rodent("Brownie", 21.0, true, "Chinchilla", "Activity corner", "Dark brown", false, 75, 12, 80, 40));
        petsInShelter.add(new Rodent("Marble", 15.0, true, "Chipmunk", "Obstacle area", "Brown-white", true, 88, 15, 90, 20));
        petsInShelter.add(new Rodent("Twinkle", 11.0, true, "Hamster","Plastic tunnels", "Golden brown", true, 82, 18, 85, 30));
        petsInShelter.add(new Rodent("Ginger", 13.0, true, "Mouse", "Nest zone", "Golden tan", true, 78, 25, 78, 25));
        petsInShelter.add(new Rodent("Shadow", 19.0, true, "Rat", "Dark corners", "Black-white", true, 90, 10, 88, 40));
        petsInShelter.add(new Rodent("Fluffy", 25.0, true, "Guinea Pig", "Hammock", "Orange-white", false, 70, 15, 72, 35));
    }

    @Override
    public int checkCapacity() {
        int maxRodentsByWheels = numCompartments * 2; // Assume 2 rodents per wheels
        int effectiveCapacity = Math.min(capacity, maxRodentsByWheels);
        int remainingCapacity = effectiveCapacity - petsInShelter.size();
        return remainingCapacity;
    }

    @Override
    public void addPet(Pet pet) {
        if (!(pet instanceof Rodent)) {
            System.out.println("Only rodents are allowed in this shelter!");
            return;
        }

        int remainingCapacity = checkCapacity(); // Call checkCapacity to ensure accurate remaining capacity
        if (remainingCapacity == 0) {
            System.out.println("Sorry, no more places for rodents. Try again later.");
            return;
        }

        // Add the cat to the shelter
        petsInShelter.add(pet);
    }

    @Override
    public void removePet(Pet pet) {
        if (pet instanceof Rodent) { // Ensure it's a rodent
        Rodent rodent = (Rodent) pet; // Cast the pet to rodent
            if (!rodent.isAlive()) {
                petsInShelter.remove(rodent);
            } else {
                System.out.println(rodent.getPetName() + " is still alive and cannot be removed.");
            }
        } else {
            System.out.println("This pet is not a rodent and cannot be removed by RodentShelter.");
        }
    }

    @Override
    public void showPets() {
        if (petsInShelter.isEmpty()) {
            System.out.println("No rodents available for adoption.");
            return;
        } else {
            System.out.println("Rodents available for adoption:");
            for (int i = 0; i < petsInShelter.size(); i++) {
                Pet pet = petsInShelter.get(i); // Retrieve as a Pet object
                if (pet instanceof Rodent) { // Check if the Pet is actually a rodent
                    Rodent rodent = (Rodent) pet; // Cast Pet to rodent
                    /*System.out.println((i + 1) + ", Age: " + bird.getPetAge() + " years, Type: " + bird.getClass().getSimpleName())*/
                    /*System.out.println((i + 1) + "." + bird.toString());*/
                    System.out.println("-------------------------");
                    System.out.println("Rodent #" + (i + 1) + ":");
                    System.out.println(rodent.toString());
                }
            }
        }
    }

    @Override
    public Pet adoptPetFromShelter(int index) {
        ArrayList<Rodent> rodentList = getRodentsInShelter(); // Get the filtered list of rodent
        if (index < 0 || index >= rodentList.size()) {
            System.out.println("Invalid choice. Please try again.");
            return null;
        }

        Rodent adoptedRodent = rodentList.get(index); // Retrieve the selected rodent
        petsInShelter.remove(adoptedRodent); // Remove the rodent from the main shelter list
        return adoptedRodent;
    }

    //retrieve all rodent in the shelter
    public ArrayList<Rodent> getRodentsInShelter() {
        ArrayList<Rodent> rodentList = new ArrayList<>();
        for (Pet pet : petsInShelter) {
            if (pet instanceof Rodent) {
                rodentList.add((Rodent) pet);
            }
        }
        return rodentList;
    }

    @Override
    public String toString() {
        return super.toString() // Call the superclass's toString() method
            + "\nNumber of Wheels: \t" + this.numWheels + "\nNumber of Compartments: \t" + this.numCompartments;
    }
}
