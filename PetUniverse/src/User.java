
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class User {
    private Scanner scanner = new Scanner (System.in);

    public ArrayList<Pet> petsOwned; // Get the each player's pets using the playersPets map
    public static User currentUser;
    private String currentName;
    private String previousName;
    private int maxPetsAllowed;
    private ArrayList<ToyAccessory> ownedToys = new ArrayList<>();
private ArrayList<DecorationAccessory> ownedDecorations = new ArrayList<>();

    Shelter dogShelter = new DogShelter();
    Shelter catShelter = new CatShelter();
    Shelter fishShelter = new FishShelter();
    Shelter birdShelter = new BirdShelter();
    Shelter rodentShelter = new RodentShelter();

    //constructor
    public User(String initialName) {
        this.currentName = initialName;
        this.previousName = null;
        this.petsOwned = new ArrayList<>();
        this.maxPetsAllowed = 3;
    }
        
    //getters and setters
    public static void setCurrentUser(User user) {
        currentUser = user;
    }
    
    public static User getCurrentUser() {
        return currentUser;
    }

    public String getCurrentName() {
        return currentName;
    }

    public void changeName(String newName, ArrayList<Pet> existingPets) {
        this.currentName = newName;
        this.petsOwned = existingPets;
    }

    public void restorePreviousName() {
        if (previousName != null) {
            this.currentName = previousName; // Restore the previous name
            this.previousName = null;        // Clear previous name
        }
    }

    public ArrayList<Pet> getOwnedPets() {
        return petsOwned;
    }

    public void setOwnedPets(ArrayList<Pet> ownedPets) {
        this.petsOwned = ownedPets;
    }

    public int getMaxPetsAllowed() {
        return this.maxPetsAllowed;
    }

    public void setMaxPetsAllowed(int maxPetsAllowed) {
        this.maxPetsAllowed = maxPetsAllowed;
    }

    // Display user details
    public void getUserDetails() {
        System.out.println(toString());
        
    }

    //methods    
    public void displayPetsForPlayer(User player) {
        // Retrieve the player's name to use as the key for the HashMap
        String playerName = player.getCurrentName();
        petsOwned = newGame.playersPets.get(playerName); // Retrieve pets
        System.out.println(player);
        if (petsOwned == null || petsOwned.isEmpty()) {
            System.out.println("No pets found for " + playerName + ".");
            return; // Exit the method if no pets are found
        }
        System.out.println("\nList of pets owned by " + playerName);
        int counter = 1;
        for (Pet pet : petsOwned) {   
            System.out.println("----------------------------------");
            System.out.println("Pet #" + counter);
            System.out.println(pet);
            counter++;
        }
    }

    public void adoptPet(Shelter shelter, int petIndex) {
        Pet pet = shelter.adoptPetFromShelter(petIndex);
        if (pet == null) { // Ensure pet was retrieved successfully
            System.out.println("Invalid pet selection. Try again.");
            return;
        }
        System.out.println("\nYou have successfully adopted " + pet.getPetName() + "! " + pet.getPetName() + ", is now part of your family!");
        // Ensure pet list exists
        if (this.petsOwned == null) {
            this.petsOwned = new ArrayList<>(); // Prevent NullPointerException
        }
        pet.setOwner(this);
        this.petsOwned.add(pet); // Add pet to User's local list
        System.out.println("Number of pets owned: " + petsOwned.size());
    }

    public void releasePetMenu(User currentUser) {
        petsOwned = newGame.playersPets.get(currentUser.getCurrentName()); // Retrieve pets from HashMap
        displayPetsForPlayer(currentUser);   
        if (petsOwned == null || petsOwned.isEmpty()) {
            System.out.println("You don't own any pets to return!");
            return;
        }    
        System.out.print("\nEnter the name of the pet you want to release: ");
        String petName = scanner.nextLine().trim();
        System.out.println("Pet name entered: " + petName);
        System.out.println("\nChecking shelter...");
    
        for (Pet pet : petsOwned) {
            if (pet.getPetName().equalsIgnoreCase(petName)) {
                Shelter shelter = getShelterForPet(pet.getPetType());
    
                if (shelter != null) {
                    System.out.println("The name of shelter is " + shelter.getShelterName());
                    pet.setOwner(null);  // Set owner to null (removes ownership)
                    currentUser.releasePet(petName, shelter); // Release the pet
                    petsOwned.remove(pet); // Remove pet from list
                    break;
                } else {
                    System.out.println("Shelter not found for " + pet.getPetName() + ". Unable to release pet.");
                    return;
                }
            }
        }
    }

    public void releasePet(String petName, Shelter shelter) {
        if (petName == null || shelter == null) {
            System.out.println("Invalid parameters for pet release.");
            return;
        }    
        System.out.println("Verifying owned pets...");      
        System.out.println("\nReleasing " + petName + " to " + shelter.getShelterName());
        System.out.println();
    
        for (Pet pet : petsOwned) {
            
            if (pet.getPetName().equalsIgnoreCase(petName)) {
                petsOwned.remove(pet);
                shelter.returnPetToShelter(pet); // Return pet to shelter                
                return;
            }
        }    
        System.out.println("No pet found with the name: " + petName);
    }

    public Shelter getShelterForPet(String petType) {
        if ("Bird".equals(petType)) {
            return birdShelter; // Replace with your BirdShelter instance
        } else if ("Dog".equals(petType)) {
            return dogShelter; // Replace with your DogShelter instance
        } else if ("Cat".equals(petType)) {
            return catShelter; // Replace with your CatShelter instance
        } else if ("Fish".equals(petType)) {
            return fishShelter; // Replace with your FishShelter instance
        } else if ("Rodent".equals(petType)) {
            return rodentShelter; // Replace with your RodentShelter instance
        } else {
            System.out.println("No matching shelter found for pet type: " + petType);
            return null; // No matching shelter found
        }
    }  
    
    public void removePet(Pet pet) {
        petsOwned.remove(pet);
        System.out.println(pet.getPetName() + " has been removed from " + getCurrentName() + "'s pet list.");
    }

    public void showMenu() {
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1. Feed the pet");
        System.out.println("2. Play with the pet");
        System.out.println("3. Put pet to sleep");
        System.out.println("4. Put pet for nap");
        System.out.println("5. Groom pet");
        System.out.println("6. Nurture pet");
        System.out.println("7. Check pet's health");
        System.out.println("8. Choose another pet");
        System.out.println("9. Back to main menu");
    }
    
    public void interactWithPet(User currentUser) {
        System.out.println("\nYour Pets:");
        // Call displayPetsForPlayer to validate pet list initialization
        displayPetsForPlayer(currentUser);
        
        try {
            ArrayList<Pet> pets = newGame.playersPets.get(currentUser.getCurrentName()); // Retrieve pets from HashMap
            if (pets == null || pets.isEmpty()) {
                System.out.println("You don't own any pets to return!");
                return;
            }
            
            System.out.println("\nWhich pet would you like to interact with, enter the pet number?");
            int petChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            if (petChoice < 1 || petChoice > pets.size()) {
                System.out.println("\nInvalid choice! Please select a valid pet.");
            } else {
                Pet selectedPet = pets.get(petChoice - 1);
                //Ensure pet has an owner before interaction
                if (selectedPet.getOwner() == null) {
                    selectedPet.setOwner(currentUser);
                    System.out.println(selectedPet.getPetName() + " is now linked to " + currentUser.getCurrentName() + "!");
                }
                System.out.println("\nInteracting with " + selectedPet.getPetName() + ", the " + selectedPet.getPetType()+ ".");
                System.out.println();
                System.out.println("Current pet status: ");
                System.out.println(selectedPet.toString());
                System.out.println();
                // Add interaction logic here
                while (true) {
                    showMenu();
                
                    try {
                        System.out.println("\nEnter your choice here: ");
                        int userInteractChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume leftover newline character
                
                        if (userInteractChoice < 1 || userInteractChoice > 9) {
                            System.out.println("\nInvalid choice. Please select a number between 1 and 9.");
                            continue; // Ask for valid input again
                        }
                
                        switch (userInteractChoice) {
                            case 1:
                                selectedPet.feed(null);
                                break;
                            case 2:
                                selectedPet.play(null, null, null);
                                break;
                            case 3:
                                selectedPet.sleep();
                                break;
                            case 4:
                                selectedPet.rest();
                                break;
                            case 5:
                                selectedPet.groom();
                                break;
                            case 6:
                                selectedPet.nurture();
                                break;
                            case 7:
                                selectedPet.checkHealth();
                                break;
                            case 8:
                                System.out.println("Pet selection menu...");
                                break;
                            case 9:
                                System.out.println("Returning to main menu...");
                                newGame.playerChoice();
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                
                        if (userInteractChoice == 8) {
                            break; // Breaks the inner loop to allow choosing another pet
                        }
                
                        selectedPet.checkLifeStatus();
                    } catch (InputMismatchException e) {
                        System.out.println("\nInvalid input! Please enter a valid number......");
                        scanner.nextLine(); // Clear invalid input
                    }
                } 
            }
        } catch (InputMismatchException e) {
            System.out.println("\nInvalid input! Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    public void addAccessoryToUserList(Accessory accessory) {
        if (accessory instanceof ToyAccessory) {
            ownedToys.add((ToyAccessory) accessory); // Store toy separately
            System.out.println("Added " + accessory.getAccessoryName() + " to your toy collection.");
        } else if (accessory instanceof DecorationAccessory) {
            ownedDecorations.add((DecorationAccessory) accessory); // Store decoration separately
            System.out.println("Added " + accessory.getAccessoryName() + " to your decoration collection.");
        } else {
            System.out.println("Accessory type is not recognized.");
        }
    }

    public void displayOwnedToys() {
        System.out.println("\nYour Toy Collection:");
        for (ToyAccessory toy : ownedToys) {
            System.out.println("- " + toy.getAccessoryName());
        }
    }

    public void displayOwnedDecorations() {
        System.out.println("\nYour Decoration Collection:");
        for (DecorationAccessory decoration : ownedDecorations) {
            System.out.println("- " + decoration.getAccessoryName());
        }
    }

    public DecorationAccessory selectDecorationForPet(int selectionIndex) {
        if (selectionIndex < 1 || selectionIndex > ownedDecorations.size()) {
            System.out.println("Invalid selection. Please choose a valid decoration.");
            return null;
        }
    
        DecorationAccessory selectedDecoration = ownedDecorations.get(selectionIndex - 1);
        System.out.println("You selected: " + selectedDecoration.getAccessoryName());
        return selectedDecoration;
    }

    public void placeDecorationForPet(Pet pet, DecorationAccessory decoration) {
        if (decoration == null) {
            System.out.println("No decoration selected.");
            return;
        }
    
        pet.addDecorationToPetHouse(decoration); // Calls method in Pet class
        ownedDecorations.remove(decoration); // Remove from user's inventory
    
        System.out.println("Placed " + decoration.getAccessoryName() + " in " + pet.getPetName() + "'s space.");
    }



    public String toString() {
        ArrayList<Pet> petsOwned = newGame.playersPets.get(getCurrentName());
        int numberOfPetsOwned = (petsOwned != null) ? petsOwned.size() : 0; // Null check to avoid NullPointerException
        System.out.println("------------------------------");
        return "User Name:            " + getCurrentName() +
               "\nMax Pets Allowed :    " + this.maxPetsAllowed + 
               "\nNumber of Pets Owned: " + numberOfPetsOwned +
               "\nOwned Toys:           " + ownedToys.size() + 
               "\nOwned Decorations:    " + ownedDecorations.size();
    }
}
