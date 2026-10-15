import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class newGame {
    private static Scanner scanner = new Scanner(System.in);
    static Shelter dogShelter = new DogShelter();
    static Shelter catShelter = new CatShelter();
    static Shelter fishShelter = new FishShelter();
    static Shelter birdShelter = new BirdShelter();
    static Shelter rodentShelter = new RodentShelter();
    
    private static ArrayList <User> users = new ArrayList<>();
    public static HashMap<String, ArrayList<Pet>> playersPets = new HashMap<>();//stores players and pets 
    public static User currentUser;
    static ArrayList<Pet> existingPets;


    //constructor
    public newGame() {
        initializePlayers();
    }


    //getters ans setters
    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void removeUser(User userToRemove) {
        users.remove(userToRemove);
    }

    public ArrayList<Pet> getPetsOwned() {
        ArrayList<Pet> pets = newGame.playersPets.get(currentUser.getCurrentName()); //Fetch pets list
    
    if (pets == null) { 
        System.out.println("Warning: No pets found for " + currentUser.getCurrentName()); 
        pets = new ArrayList<>(); //Prevent NullPointerException
    }
    return pets; // Use currentName to fetch the pet list
    }

    //methods
    public static void initializePlayersAndPets() {
        ArrayList<User> users = newGame.getUsers();
        // Add players to the user list
        users.add(new User("Player #1"));
        users.add(new User("Player #2"));
        users.add(new User("Player #3"));
        users.add(new User("Player #4"));
        users.add(new User("Player #5"));

        playersPets.put("Player #1", new ArrayList<>());
        playersPets.put("Player #2", new ArrayList<>());
        playersPets.put("Player #3", new ArrayList<>());
        playersPets.put("Player #4", new ArrayList<>());
        playersPets.put("Player #5", new ArrayList<>());

        playersPets.get("Player #1").add(new Dog("Buddey", 18, true, "Golden Retriever", "Park bench", 90, 40, 90, 30));
        playersPets.get("Player #1").add(new Cat("Whisk", 24, true, "Siamese", "Window sill", "Cream", 100, 30, 90, 25));
        playersPets.get("Player #1").add(new Fish("Goldy", 12, true, "Goldfish", "Pond corner", "Golden", 90, 20, 80, 40));

        playersPets.get("Player #2").add(new Bird("Tweet", 12, true, "Canary", "Windowsill", 90, 30, 80, 30));
        playersPets.get("Player #2").add(new Rodent("Cheddy", 6, true, "Hamster", "Tunnel hideout", "Golden Brown", true, 90, 30, 80, 25));
        playersPets.get("Player #2").add(new Dog("Maximus", 24, true, "German Shephard", "Garden", 100, 50, 100, 35));

        playersPets.get("Player #3").add(new Cat("Rokus", 18, true, "Persian", "Cozy bed", "White", 90, 40, 100, 30));
        playersPets.get("Player #3").add(new Fish("Bubbly", 8, true, "Betta", "Plant cluster", "Blue", 100, 30, 90, 35));
        playersPets.get("Player #3").add(new Bird("Splashy", 24, true, "Parakeet", "Cage perch", 100, 20, 90, 25));

        playersPets.get("Player #4").add(new Rodent("Squak", 12, true, "Mouse", "Under the sofa", "Grey", true, 80, 40, 90, 20));
        playersPets.get("Player #4").add(new Dog("Roxi", 12, true, "Bulldog", "Living room", 80, 30, 80, 40));
        playersPets.get("Player #4").add(new Cat("Mits", 12, true, "Maine Coon", "Top of bookshelf", "Brown Tabby", 80, 20, 100, 40));

        playersPets.get("Player #5").add(new Fish("Splu", 6, true, "AngelFish", "Near heater", "Silver", 80, 40, 100, 35));
        playersPets.get("Player #5").add(new Bird("Flappino", 6, true, "Cockatiel", "Play gym", 80, 40, 100, 20));
        playersPets.get("Player #5").add(new Rodent("Nibbla", 9, true, "Guinea Pig", "Cozy nest", "White and brown", false, 100, 20, 100, 35));
    }

    private static void initializePlayers() {
        for (int i = 1; i <= 5; i++) {
            users.add(new User("Player #" + i));
        }
    }

    public static void changePlayerName(String oldName, String newName) {
        // Ensure the old name exists in the playersPets map
        if (playersPets.containsKey(oldName)) {
            // Retrieve pets linked to the old player name
            existingPets = playersPets.get(oldName);
    
            //Transfer pets to the new name before removing the old entry
            playersPets.put(newName, existingPets); 
            playersPets.remove(oldName); // Remove old entry after successful transfer
            
            System.out.println("\nThe player's name has been changed from " + oldName + " to " + newName + " and now has " + existingPets.size() + " pets.");
        } else {
            System.out.println("\nError: Player not found! Make sure you selected an existing player.");
        }
    }    

    public static void playerChoice() {
        System.out.println("\nWelcome to Pet Universe! A virtual pet game to experience fun with pets!");
        
        while(true) {
            System.out.println("\nMenu:\n1. Choose Player\n2. Add Player\n3. Remove Player\n4. Exit");
            System.out.println("\nEnter your choice here:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: 
                    selectPlayer();
                    break;
                case 2:     
                    if (users.size() >= 6) {
                        System.out.println("Maximum number of players (6) has been reached. Cannot add more players. You need to choose from existing players or remove a player from the list.");
                        return;
                    } else {
                        System.out.println("Enter player name: ");
                        String newPlayer = scanner.nextLine();

                        User newUser = new User(newPlayer);

                        // Add the new player to the global user list
                        newGame.getUsers().add(newUser); 
                        newGame.playersPets.put(newPlayer, new ArrayList<>());

                        // Set the new player as the current user
                        currentUser = newUser;

                        System.out.println("Welcome, " + newPlayer + "! You can now adopt maximum 3 pets.");

                        ArrayList<Pet> petsOwned = newGame.playersPets.get(newPlayer);
                            if (petsOwned == null) {
                                petsOwned = new ArrayList<>();
                                newGame.playersPets.put(newPlayer, petsOwned);
                            }

                        // Ask if they want to adopt a pet
                        System.out.print("Would you like to adopt a pet? (yes/no): ");
                        String adoptPetChoice = scanner.nextLine().trim().toLowerCase();

                        if (adoptPetChoice.equals("yes")) {
                            

                            // Loop to allow pet adoption up to 3 pets
                            while (petsOwned.size() < 3) {
                                             
                                userAdoptPet(); // Call pet adoption method

                                petsOwned = newGame.playersPets.get(newPlayer); // Refresh pets list

                                // If the player has reached max pets, stop
                                if (petsOwned.size() >= 3) {
                                    System.out.println("\nYou've adopted the maximum number of pets.");
                                    break;
                                }

                                // Ask if they want to adopt more
                                System.out.println("\nYou currently have " + petsOwned.size() + " pets.");
                                System.out.print("\nWould you like to adopt another pet? (yes/no) and the enter: ");
                                scanner.nextLine();
                                String adoptMore = scanner.nextLine().trim().toLowerCase();
                                if (!adoptMore.equals("yes")) {
                                    System.out.println("\nYou have adopted " + petsOwned.size() + " pet(s).");
                                    //System.out.println("\nReturning to main menu.");
                                    //selectPlayer(); // Go back to player selection
                                    break;
                                } 
                            }
                        } else {
                            System.out.println("\nReturning to main menu to choose a player.");
                            //selectPlayer(); // Return to the player selection screen
                            return;
                        }

                        // After pet adoption, ask if they want to continue or switch players
                        System.out.print("\nDo you want to continue with " + newPlayer + "? Or switch players? (continue/change): ");
                        scanner.nextLine();
                        String playerDecision = scanner.nextLine().trim().toLowerCase();

                        if (playerDecision.equals("change")) {
                            selectPlayer(); // Allow player switch
                        } else {
                            System.out.println("\nContinuing with " + newPlayer + ".");
                        }

                    }
                    
                case 3: 
                    System.out.println("Select the player you want to remove:");
                    ArrayList<User> users = newGame.getUsers(); //updated user list
                    for (int i = 0; i < users.size(); i++) {
                        System.out.println((i + 1) + ". " + users.get(i).getCurrentName());
                    }
                
                    System.out.print("\nEnter the player number to remove: ");
                    int playerChoice = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline
                
                    if (playerChoice >= 0 && playerChoice < users.size()) {
                        User userToRemove = users.get(playerChoice);
                        newGame.playersPets.remove(userToRemove.getCurrentName()); // Remove pets from playersPets
                        newGame.removeUser(userToRemove); // Remove user from the list
                        System.out.println(userToRemove.getCurrentName() + " has been removed successfully!");
                    } else {
                        System.out.println("Invalid selection. Please try again.");
                    }
                    break;
                case 4: 
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.print("Please enter valid number!");
            }
        }

    }

    public static void selectPlayer() {   
        while (true) {
            ArrayList<User> users = newGame.getUsers();
            if ( users.isEmpty()) {
                System.out.println("No players available. Please add a new player.");
                return;
            }

            System.out.println("\nPlayers List:");
            for (int i = 0; i < users.size(); i++) {
                System.out.println((i + 1) + ". " + users.get(i).getCurrentName());
            }
            System.out.println("\n7. Main menu");
            try {
                System.out.print("\nSelect a player by entering their number: ");

                if (!scanner.hasNextInt()) {  //Avoiding input issues
                    System.out.println("\nInvalid input! Please enter a number.");
                    scanner.nextLine(); // Clear invalid input
                    continue; // Restart loop
                }

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice >= 1 && choice <= users.size()) {
                    if (currentUser != null) {
                        currentUser.restorePreviousName(); // Restore previous name
                    }
                    currentUser = users.get(choice - 1);
                    System.out.println("\nYou selected " + currentUser.getCurrentName());

                    System.out.print("\nDo you want to change the name of the player? (yes/no): ");
                    String response = scanner.nextLine().trim().toLowerCase(); 
                    
                    if (response.equals("yes")) {
                        System.out.print("\nEnter the new name: ");
                        String newName = scanner.nextLine();

                        changePlayerName(currentUser.getCurrentName(), newName); // Update name in map
                        currentUser.changeName(newName, existingPets);
                        currentUser.getUserDetails();
                    } else if (response.equals("no")) {
                        currentUser.getUserDetails();
                    } else {
                        System.out.println("\nInvalid input! Please enter 'yes' or 'no'.");
                    }
                    userGameInteraction();
                } else if (choice == 7) {
                    playerChoice();
                } else {
                    System.out.println("\nInvalid choice. Please try again.........");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    public static void userGameInteraction() {
        System.out.println();
        System.out.println("\nWelcome, " + currentUser.getCurrentName().toUpperCase() + "!");

        int userInput = 0;
        while(userInput != 7) {
            
            System.out.println("\nWould you like to \n1. Adopt\n2. Interact with your pet\n3. Show owned pets\n4. Return pet to shelter\n5. Change player\n6. Show player details\n7. Exit ");
            System.out.println();
            System.out.println("\nEnter your choice here: "); 
            try {
                userInput = scanner.nextInt();
                scanner.nextLine(); // Consume the leftover newline character
                
                if (userInput == 1) {
                    // Retrieve the current user's pets
                    ArrayList<Pet> petsOwned = playersPets.get(currentUser.getCurrentName());  
                    if (petsOwned.size() >= 3) {
                        System.out.println("\nYou already have 3 pets. You can't add more. Choose a pet to return to shelter, if you want to adopt new pet.");
                    } else {
                        userAdoptPet();
                    }   
                } else if (userInput == 2) {
                    currentUser.interactWithPet(currentUser);   
                } else if (userInput == 3) {
                    currentUser.displayPetsForPlayer(currentUser);
                } else if (userInput == 4) {
                    //return pet to respective shelter
                    currentUser.releasePetMenu(currentUser);
                } else if (userInput == 5) {
                    //change player menu
                    selectPlayer();   
                }  else if (userInput == 6) {
                    System.out.println(currentUser.toString());
                } else if (userInput == 7) {
                    //goodbye message
                    System.out.println("\nThank you for playing the Virtual Pet Game.");
                    System.out.println("\nGoodbye!");
                    System.exit(0);
                } else {
                    System.out.println("\nInvalid entry! Please try again.");
                }
            } catch (Exception e) {
                System.out.println("\nInvalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
            System.out.println(); 
        }
    }

    public static void userAdoptPet() {
        System.out.println();
        System.out.println("\nWhich animal would you like to adopt:\n1. Dog\n2. Cat\n3. Fish\n4. Bird\n5. Rodent");
        System.out.println();
        System.out.println("\nEnter the number of the chosen pet type here: ");
        int petTypeToAdopt = scanner.nextInt();
        scanner.nextLine();

            switch (petTypeToAdopt) {
                case 1:
                    System.out.println("\nWelcome to DOG SHELTER!");
                    System.out.println();
                    System.out.println();
                    dogShelter.showPets();
                    System.out.println();
                    System.out.println("\nEnter the pet number you want to adopt: ");
                    int adoptedDogIndex = scanner.nextInt() - 1;
                    currentUser.adoptPet(dogShelter, adoptedDogIndex);
                    break;
                    
                case 2:
                    System.out.println("\nWelcome to CAT SHELTER!");
                    System.out.println();
                    System.out.println();
                    catShelter.showPets();
                    System.out.println();
                    System.out.println("\nEnter the pet number you want to adopt: ");
                    int adoptedCatIndex = scanner.nextInt() - 1;
                    currentUser.adoptPet(catShelter, adoptedCatIndex);
                    break;

                case 3:
                    System.out.println("\nWelcome to FISH SHELTER!");
                    System.out.println();
                    System.out.println();
                    fishShelter.showPets();
                    System.out.println();
                    System.out.println("\nEnter the pet number you want to adopt: ");
                    int adoptedFishIndex = scanner.nextInt() - 1;
                    currentUser.adoptPet(fishShelter, adoptedFishIndex);
                    break;
                
                case 4:
                    System.out.println("\nWelcome to BIRD SHELTER!");
                    System.out.println();
                    System.out.println();
                    birdShelter.showPets();
                    System.out.println();
                    System.out.println("\nEnter the pet number you want to adopt: ");
                    int adoptedBirdIndex = scanner.nextInt() - 1;
                    currentUser.adoptPet(birdShelter, adoptedBirdIndex);
                    break;

                case 5:
                    System.out.println("\nWelcome to RODENT SHELTER!");
                    System.out.println();
                    System.out.println();
                    rodentShelter.showPets();
                    System.out.println();
                    System.out.println("\nEnter the pet number you want to adopt: ");
                    int adoptedRodentIndex = scanner.nextInt() - 1;
                    currentUser.adoptPet(rodentShelter, adoptedRodentIndex);
                    break;
                         
                default:
                    System.out.println("\nInvalid entry! Please try again.");
                    break;
            }
    }


    public static void main(String[] args) {   
        initializePlayersAndPets();    
        newGame.playerChoice();

    }
}
