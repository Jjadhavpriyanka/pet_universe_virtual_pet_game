

import java.util.ArrayList;

public class Shelter {
    
    // attributes for shelter
    protected String shelterName; // Shelter name
    protected ArrayList<Pet> petsInShelter;
    protected int capacity; // Number of pets the shelter can accommodate

    

    // Constructor
    public Shelter(String shelterName, int capacity) {
        this.shelterName = shelterName;
        this.capacity = capacity;
    }

    public Shelter () {
        this.petsInShelter = new ArrayList<>();

    }

    //getters and setters
    public String getShelterName() {
        return shelterName;
    }

    public void setShelterName(String shelterName) {
        this.shelterName = shelterName;
    }

    public ArrayList<Pet> getPetsInShelter() {
        return petsInShelter;
    }

    public void setPetsInShelter(ArrayList<Pet> petsInShelter) {
        this.petsInShelter = petsInShelter;
    }

    public int getCapacity() {
        return capacity;
    }

    //methods
    //display shelter information
    public String toString() {
        return "Shelter Name: \t" + this.shelterName + "\nCapacity: \t" + this.capacity;
    }

    //Adding pets
    public void addPet(Pet pet) {
        if (remainingCapacity == 0) {
            System.out.println("Sorry no more places for the pet. Try after some days.");
        } else {
            petsInShelter.add(pet);
        }
    }

    //removing pets if died
    public void removePet(Pet pet) {
        //checking if pet is not alive
        if(!pet.isAlive()) {
            petsInShelter.remove(pet);
        } else {
            System.out.println(pet.getPetName() + " is alive and cannot be removed from the shelter.");
        } 
    }

    // Show all pets available
    public void showPets() {
        if (petsInShelter.isEmpty()) {
            System.out.println("No pets currently in the shelter.");
            return;
        } else {
            System.out.println("Pets available for adoption:");
        for (int i = 0; i < petsInShelter.size(); i++) {
            Pet pet = petsInShelter.get(i);
            System.out.println((i + 1) + ". " + pet.getPetName() + ", Age: " + pet.getPetAge() + ", Type: " + pet.getClass().getSimpleName());
            }
        }
    }

    // Adopt a pet by index
    public Pet adoptPetFromShelter(int index) {
        if (index < 0 || index >= petsInShelter.size()) {
            System.out.println("Invalid choice. Please select a valid pet.");
            return null;
        }
        Pet adoptedPet = petsInShelter.remove(index);
        return adoptedPet;
    }

    public boolean canAcceptPet(Pet pet) {
        // Check if shelter can accept the pet based on type and capacity
        if (petsInShelter.size() >= capacity) {
            System.out.println("Shelter is at full capacity. Cannot accept more pets.");
            return false; // No capacity available
        }
        if ((pet instanceof Bird && this instanceof BirdShelter) ||
            (pet instanceof Dog && this instanceof DogShelter) ||
            (pet instanceof Cat && this instanceof CatShelter) ||
            (pet instanceof Fish && this instanceof FishShelter) ||
            (pet instanceof Rodent && this instanceof RodentShelter)) {
            return true; // Shelter matches pet type
        }
        System.out.println("Shelter type mismatch. Cannot accept " + pet.getPetName());
        return false;
    }

    public void returnPetToShelter(Pet pet) {
        if (canAcceptPet(pet)) {
            checkCapacity(); // Output remaining capacity
            addPet(pet); // Add pet to shelter
            System.out.println(pet.getPetName() + " has been returned to " + this.shelterName);
        } else {
            System.out.println("Unable to return " + pet.getPetName() + " to the shelter.");
        }
    }


    //Checking Capacity of the shelter
    int remainingCapacity = 0;
    public int checkCapacity() {
        remainingCapacity = capacity - petsInShelter.size();
        System.out.println("Remaining capacity in the shelter: " + remainingCapacity);
        return remainingCapacity;
    }
}
