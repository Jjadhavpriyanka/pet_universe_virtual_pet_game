import java.util.ArrayList;

public class DogShelter extends Shelter {
    //attributes
    private ArrayList<Dog> dogList;
    private int diggingPits;
    private int feedingZones;

    public DogShelter() {
        super("Puppy Paradise", 12); // Call the superclass constructor
        this.diggingPits = 5;
        this.feedingZones = 4;
        //initialise birds within shelter
        initialiseDogList();
    }

    //getters and setters
    public ArrayList<Dog> getDogList() {
        return dogList;
    }

    public void setDogList(ArrayList<Dog> dogList) {
        this.dogList = dogList;
    }

    public int getDiggingPits() {
        return diggingPits;
    }

    public void setDiggingPits(int diggingPits) {
        this.diggingPits = diggingPits;
    }

    public int getFeedingZones() {
        return feedingZones;
    }

    public void setFeedingZones(int feedingZones) {
        this.feedingZones = feedingZones;
    }


    //methods
    private void initialiseDogList() {
        if (petsInShelter == null) {
            petsInShelter = new ArrayList<>();
        }

        //String petName, double petAgeinMonths, boolean isAlive, int petPrice, String favoriteAcitivity, String breed, String favoriteFood, String favoriteSpot, String favoriteToy, String petType
        petsInShelter.add(new Dog("Max", 18, true, "Labrador Retriever", "Park", 90, 10, 88, 25));
        petsInShelter.add(new Dog("Bella", 24, true, "German Shepherd", "Backyard", 95, 30, 90, 45));
        petsInShelter.add(new Dog("Charlie", 12, true, "Beagle", "Living room", 80, 25, 8, 30));
        petsInShelter.add(new Dog("Daisy", 36, true, "Golden Retriever", "Pond", 488, 60, 92, 35));
        petsInShelter.add(new Dog("Rocky", 8, true, "Jack Russell Terrier", "Garden", 70, 40, 58, 45));
        petsInShelter.add(new Dog("Luna", 16, true, "Border Collie", "Open fields", 92, 10, 88, 20));
        petsInShelter.add(new Dog("Cooper", 10, true, "Bloodhound", "Hiking trail", 70, 70, 72, 40));
        petsInShelter.add(new Dog("Zoe", 20, true, "Rottweiler", "Doorstep", 85, 20, 78, 30));
        petsInShelter.add(new Dog("Milo", 6, true, "Shih Tzu", "Couch", 65, 45, 60, 35));
        petsInShelter.add(new Dog("Rosie", 15, true, "Australian Shepherd", "Yard", 88, 15, 88, 45));
        petsInShelter.add(new Dog("Teddy", 40, true, "Bulldog", "Patio", 60, 75, 68, 20));
        petsInShelter.add(new Dog("Chloe", 18, true, "Siberian Husky", "Snowy hill", 85, 35, 80, 30));
        petsInShelter.add(new Dog("Maximus", 22, true, "Doberman", "Hallway", 95, 20, 90, 45));
        petsInShelter.add(new Dog("Ruby", 14, true, "Miniature Schnauzer", "Obstacle course", 88, 40, 85, 40));
        petsInShelter.add(new Dog("Diesel", 8, true, "Pomeranian", "Window", 65, 15, 55, 50));
        petsInShelter.add(new Dog("Holly", 25, true, "Bernese Mountain Dog", "Trail", 82, 65, 80, 20));
        petsInShelter.add(new Dog("Benny", 12, true, "Cocker Spaniel", "Lawn", 83, 30, 85, 30));
        petsInShelter.add(new Dog("Coco", 5, true, "Chihuahua", "Sofa", 60, 10, 50, 35));
        petsInShelter.add(new Dog("Levi", 18, true, "Boxer", "Porch", 90, 25, 88, 45));
        petsInShelter.add(new Dog("Roxy", 28, true, "Fox Terrier", "Garden", 85, 20, 75, 35));
    }


    @Override
    public int checkCapacity() {
        int maxDogsByZones = feedingZones * 4; // Assume 4 dogs per zones
        int effectiveCapacity = Math.min(capacity, maxDogsByZones);
        int remainingCapacity = effectiveCapacity - petsInShelter.size();
        return remainingCapacity;
    }

    @Override
    public void addPet(Pet pet) {
        if (!(pet instanceof Dog)) {
            System.out.println("Only dogs are allowed in this shelter!");
            return;
        }

        int remainingCapacity = checkCapacity(); // Call checkCapacity to ensure accurate remaining capacity
        if (remainingCapacity == 0) {
            System.out.println("Sorry, no more places for dogs. Try again later.");
            return;
        }

        // Add the dog to the shelter
        petsInShelter.add(pet);
    }

    @Override
    public void removePet(Pet pet) {
        if (pet instanceof Dog) { // Ensure it's a Dog
        Dog dog = (Dog) pet; // Cast the pet to Dog
            if (!dog.isAlive()) {
                petsInShelter.remove(dog);
            } else {
                System.out.println(dog.getPetName() + " is still alive and cannot be removed.");
            }
        } else {
            System.out.println("This pet is not a dog and cannot be removed by DogShelter.");
        }
    }

    @Override
    public void showPets() {
        if (petsInShelter.isEmpty()) {
            System.out.println("No dogs available for adoption.");
            return;
        } else {
            System.out.println("dogs available for adoption:");
            for (int i = 0; i < petsInShelter.size(); i++) {
                Pet pet = petsInShelter.get(i); // Retrieve as a Pet object
                if (pet instanceof Dog) { // Check if the Pet is actually a dog
                    Dog dog = (Dog) pet; // Cast Pet to dog
                    System.out.println("-------------------------");
                    System.out.println("dog #" + (i + 1) + ":");
                    System.out.println(dog.toString());
                }
            }
        }
    }

    @Override
    public Pet adoptPetFromShelter(int index) {
        ArrayList<Pet> dogList = getDogsInShelter(); // Get the filtered list of dogs
        if (index < 0 || index >= dogList.size()) {
            System.out.println("Invalid choice. Please try again.");
            return null;
        }

        Pet adoptedDog = dogList.get(index); // Retrieve the selected dog
        petsInShelter.remove(adoptedDog); // Remove the bird from the main shelter list
        return adoptedDog;
    }

    //retrieve all birds in the shelter
    public ArrayList<Pet> getDogsInShelter() {
        ArrayList<Pet> dogList = new ArrayList<>();
        for (Pet pet : petsInShelter) {
            if (pet instanceof Dog) {
                dogList.add((Dog) pet);
            }
        }
        return dogList;
    }

    @Override
    public String toString() {
        return super.toString() + 
               "\nDigging pit Count:   " + this.diggingPits + 
               "\nFeeding Zones Count: " + this.feedingZones;
    }

    
}
