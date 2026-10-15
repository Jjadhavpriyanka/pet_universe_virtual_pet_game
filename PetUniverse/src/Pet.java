
import java.util.Random;
import java.util.Scanner;

public abstract class Pet extends HealthStatus {
    Scanner scanner = new Scanner(System.in);
    //attributes
    protected String petType;
    protected String breed;
    protected String petName;
    protected double petAge;
    protected boolean isAlive;
    protected int healthLevel; 
    protected int energyLevel;
    protected int happinessLevel;
    protected int hungerLevel;
    protected int bondLevel;
    protected int tirednessLevel;
    protected String favoriteSpot;
    protected int playfulnessLevel;
    protected User owner;
    

    //constructor
    public Pet( String petName, double petAgeinMonths, boolean isAlive, String breed, String favoriteSpot, String petType, int happinessLevel, int hungerLevel, int healthLevel, int tirednessLevel) {
        this.petName = petName;
        this.petAge = petAgeinMonths;
        this.isAlive = isAlive;
        this.breed = breed;
        this.favoriteSpot = favoriteSpot;
        this.happinessLevel = happinessLevel;
        this.hungerLevel = hungerLevel;
        this.energyLevel = EnergyByAge(petAgeinMonths);
        this.healthLevel = healthLevel;
        this.tirednessLevel = tirednessLevel;
        this.isAlive = true;
        this.bondLevel = 0;
        this.petType = petType;
        this.playfulnessLevel = new Random().nextInt(100);
        this.owner = null;
    }

    
    //getters and setters
    public String getPetName() {
        return this.petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        return this.petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public double getPetAge() {
        if (this.petAge < 12) {
            return this.petAge = Math.round(this.petAge * 10.0)/10.0;
        } else {
            return this.petAge = Math.round((this.petAge / 12.0) * 10.0)/10.0;
        }
    }

    public void setPetAge(double petAge) {
        this.petAge = petAge;
    }

    public int getHealthLevel() {
        return this.healthLevel;
    }

    public void setHealthLevel(int healthLevel) {
        if (this.healthLevel >= 100) {
            this.healthLevel = 100;
        }
        
        if (this.healthLevel <= 0) {
            this.healthLevel = 00;
            checkLifeStatus();
        }
    }

    public int getEnergyLevel() {
        if (this.energyLevel >= 100) {
            this.energyLevel = 100;
        }

        if (this.energyLevel <= 0) {
            this.energyLevel = 0;
        }
        return this.energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public int getHappinessLevel() {
        return this.happinessLevel;
    }

    public void setHappinessLevel(int happinessLevel) {
        if (this.happinessLevel >= 100) {
            this.happinessLevel = 100;
        }
        if (this.happinessLevel <= 0) {
            this.happinessLevel = 0;
        }
        // Reduce happiness if energy, health, or hunger are too low
        if (energyLevel <= 40 || healthLevel <= 30 || hungerLevel >= 60 || tirednessLevel >= 60) {
            this.happinessLevel -= 40; // Adjust as needed
        }
    }

    public int getHungerLevel() {
        return this.hungerLevel;
    }

    public void setHungerLevel(int hungerLevel) {
        if (this.hungerLevel >= 80) {
            checkLifeStatus();
        }
        if (this.hungerLevel <= 20) {
            this.hungerLevel = 20;
        }
        if (this.hungerLevel >= 100) {
            this.hungerLevel = 100;
        }
    }

    public int getBondLevel() {
        return this.bondLevel;
    }

    public void setBondLevel(int bondLevel) {
        if (this.bondLevel > 100) {
            this.bondLevel = 100;
        }
        this.bondLevel = bondLevel;
    }

    public int getTirednessLevel() {
        return tirednessLevel;
    }

    public void setTirednessLevel (int tirednessLevel) {
        if(tirednessLevel >= 90) {
            this.tirednessLevel = 90;
        }
        if(tirednessLevel <= 20) {
            this.tirednessLevel = 20;
        }
    }

    public boolean isAlive() {
        return this.isAlive;
    }
    
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public String getbreed() {
        return this.breed;
    }

    public void setbreed(String breed) {
        this.breed = breed;
    }

    public String getFavoriteSpot() {
        return this.favoriteSpot;
    }

    public void setOwner(User newOwner) {
        if (this.owner == null) { // Only set owner if pet was unowned
            this.owner = newOwner;
            System.out.println(getPetName() + " has been adopted by " + newOwner.getCurrentName() + "!");
        } else {
            System.out.println(getPetName() + " already has an owner.");
        }
    }
    
    public User getOwner() {
        return owner;
    }

    public void applySetters() {
        setHealthLevel(this.healthLevel);
        setEnergyLevel(this.energyLevel);
        setHappinessLevel(this.happinessLevel);
        setHungerLevel(this.hungerLevel);
        setTirednessLevel(this.tirednessLevel);
        setBondLevel(this.bondLevel);
    }


    //methods
    //display age 
    public String displayAge() {
        return "Age: " + this.petAge + " months";
    }
    
    //calculate maximum energy based on age
    protected int EnergyByAge(double petAge) {
        if (petAge < 1.0) {
            return 90;
        } else if (petAge >= 1.0 && petAge <= 3.0) {
            return 100;
        } else if (petAge > 3.0 && petAge <= 6.0) {
            return 80;
        } else {
            return 70;
        }
    }

    //considering the health and hunger factor check life status of the pet (alive or not)
    @Override
    public void checkLifeStatus() {
        if(this.healthLevel <= 0) {
            this.isAlive = false;
            if(owner != null) {
                owner.removePet(this); // remove pet from owner list
            }
            System.out.println("Your pet, " + getPetName() + " has passed away.");    
            Shelter petShelter = owner.getShelterForPet(getPetType());
            owner.releasePet(getPetName(), petShelter);
        } else if (this.healthLevel < 20) {
            System.out.println("Your pet, " + getPetName() + " is sick and critical!");
        }
    }

    public void petHealthVital() {
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("Current health vital of " + getPetName() + ":");
        System.out.println("----------------------------");
        System.out.println("Health Level:     " + getHealthLevel() + 
                           "\nEnergy Level:     " + getEnergyLevel() +
                           "\nHappiness Level:  " + getHappinessLevel() +
                           "\nHunger Level:     " + getHungerLevel() + 
                           "\nTiredness Level: " + getTirednessLevel());
        System.out.println("-------------------------------------------");
        System.out.println();
    }

    //pets reaction to food if not hungry
    public abstract void notHungry();

    //pets reaction to food if hungry
    public abstract void Hungry();

    //pets sounds
    public abstract void sound(String state);

    //excitement reaction to play
    public abstract void reactionToPlay();

    //waking process
    public abstract void wakeUp();

    //nurture process
    public abstract void nurture();

    //feed method and its effect on happiness, hunger, energy and health
    public void feed(Food food) {
        //checking if pet is hungry before feeding
        if (hungerLevel <= 40) {
            //displaying pet's vital details
            petHealthVital();
            notHungry();
        } else {
            Hungry();
            //if pet is hungry ask user the food type
            System.out.println("Would you like to feed\n1. Healthy Food\n2. Junk Food\n3. Treat");

            //creating counter to check effect on health
            int junkFoodCount = 0;

            System.out.println("Enter your choice here:");
            while (!scanner.hasNextInt()) { // Ensure input is a valid integer
                System.out.println("Invalid input! Please enter a valid number:");
                scanner.next(); // Consume incorrect input
            }
            int FoodChoice = scanner.nextInt();
            scanner.nextLine();

            
            //depending on food choice the vital changes
            if (FoodChoice == 1) { // if user choses healthy option
                Food healthyFood = new HealthyFood();
                // List and select food items
                healthyFood.listFoodItems(); // Displays healthy food options
                Food selectedFood = healthyFood.selectFoodItem(); // User selects food item
    
                if (selectedFood != null) {
                    // Apply health, hunger, happiness and energy boosts from the respective food item influencing pet's vital
                    this.healthLevel += (selectedFood.getHealthEffect() + selectedFood.getNutritionalValue());               
                    this.energyLevel += selectedFood.getEnergyBoost();                   
                    this.happinessLevel += selectedFood.getHappinessBoost();                    
                    this.hungerLevel -= selectedFood.getHungerEffect();
                    applySetters();
                    petHealthVital();
    
                    System.out.println(getPetName() + "'s health and energy have improved due to eating " + selectedFood.getFoodName() + "!");   
                } else {
                    System.out.println("Invalid food selection. No food selected.");
                }
            } else if (FoodChoice == 2) { // if user choses junk option
                // Handle JunkFood 
                Food junkFood = new JunkFood();
                // List and select food items
                junkFood.listFoodItems(); // Displays healthy food options
                Food selectedFood = junkFood.selectFoodItem(); // User selects food

                if (selectedFood == null) {
                    System.out.println("No junk food selected. Please try again.");
                    return;
                }
    
                junkFoodCount++;
                this.healthLevel -= (selectedFood.getHealthEffect() + selectedFood.getHealthRiskFactor());
                this.energyLevel += (selectedFood.getEnergyBoost() + selectedFood.getSugarContent());
                this.happinessLevel += selectedFood.getHappinessBoost();
                this.hungerLevel -= selectedFood.getHungerEffect();
                applySetters();
                petHealthVital();
    
                if (junkFoodCount >= 3) {
                    System.out.println(getPetName() + "'s health condition has worsened due to continuous junk food " + selectedFood + "!");
                    this.healthLevel -= 10;
                    setHealthLevel(this.healthLevel);
                    
                } else {
                    System.out.println(getPetName() + "'s health condition can degrade due to junk food.");
                }
            } else if (FoodChoice == 3) {
                // Handle Treat
                Food treat = new Treat();
                // List and select food items
                treat.listFoodItems(); // Displays healthy food options
                Food selectedFood = treat.selectFoodItem(); // User selects food
                
                this.healthLevel -= (selectedFood.getHealthEffect());
                this.energyLevel += selectedFood.getEnergyBoost();
                this.happinessLevel += selectedFood.getHappinessBoost();
                this.hungerLevel -= selectedFood.getHungerEffect();
                applySetters();
                petHealthVital();
                
                System.out.println(getPetName() + " enjoyed the treat " + selectedFood + " and is feeling happier!");
                
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    public void playProcess(ToyAccessory toy, Activity activity) {
       
        ToyAccessory chosenToy = null;

        //displaying pet's vital details
        petHealthVital();

        if (activity == null) {
            activity = new Activity();
        }
        activity.displayActivities(getPetType());
        Activity selectedActivity = Activity.getActivity(getPetType());
        System.out.println();
        if (selectedActivity != null) {
            System.out.println("You chose the activity: " + selectedActivity.getActivityName());
            System.out.println();
            System.out.println("Details: " + selectedActivity.toString());
        }
        
        if (toy == null) {
            toy = new ToyAccessory();
        }
        toy.initialiseToyAccessoryList();

        if (selectedActivity.getNeedToy() == true) {
            System.out.println("Your pet, " + getPetName() + " will need toy to perform the " + selectedActivity.getActivityName() + " activity.");
            System.out.println("Press enter to show the toy list:");
            scanner.nextLine();
            
            toy.showAccessories();
            
            System.out.println("Enter the toy number: ");
            if (!scanner.hasNextInt()) { 
                System.out.println("\nInvalid input!!!!!!!! Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input buffer
                return;
            }
            int toyChoice = scanner.nextInt();
            scanner.nextLine();           

            chosenToy = toy.getAccessory(toyChoice - 1);

            
            // Check if pet has an owner before adding accessory
            if (getOwner() != null) {
                getOwner().addAccessoryToUserList(chosenToy); // Call method on owner
            } else {
                System.out.println("No owner assigned. Cannot add accessory.");
            }

            //checking if chosen toy needs cleaning
            if (chosenToy.needsCleaning()) {
                System.out.println("\n" + chosenToy.getAccessoryName() + " needs cleaning before playing!");
            }

            // Check if the toy is broken
            if (chosenToy.isBroken()) {
                System.out.println("\nOh no! The " + chosenToy.getAccessoryName() + " broke during the activity.");
                this.happinessLevel -= 10;
            } else {
                this.happinessLevel += chosenToy.getFunLevel();
            }
            this.hungerLevel += selectedActivity.getActivityDuration() * 0.5;
            this.energyLevel -= selectedActivity.getEnergyLoss();
            this.healthLevel -= selectedActivity.getHealthBenefit();
            this.happinessLevel += (chosenToy.getFunLevel() + selectedActivity.getFunFactor());
            this.tirednessLevel += selectedActivity.getActivityDuration();
            applySetters();
            petHealthVital();
        } else {
            System.out.println(getPetName() + " does not need any toy for " + selectedActivity.getActivityName());
            System.out.println();
            this.hungerLevel += selectedActivity.getActivityDuration() * 0.5;
            this.energyLevel -= selectedActivity.getEnergyLoss();
            this.healthLevel -= selectedActivity.getHealthBenefit();
            this.happinessLevel += (selectedActivity.getFunFactor());
            this.tirednessLevel += selectedActivity.getActivityDuration();
            applySetters();
            petHealthVital();
        }
        // Print success message
        if (getHealthLevel() <= 40 || getHungerLevel() >= 80) {
            checkLifeStatus();
        } else {
            System.out.println(getPetName() + " is having fun playing!");
        }
    }


    //play method and its effect on happiness, hunger, energy and health
    public void play(ToyAccessory toy, Activity activity, Food food) {
        if (!isAlive) {
            System.out.println(getPetName() + " is no longer alive and cannot play.");
            return;
        } else {
            if (hungerLevel >= 50) {
                System.out.println(getPetName() + " is very hungry. Need to be fed!");
                System.out.println("Would you like to feed " + getPetName() + "? (yes or no): ");
                String playChoice = scanner.nextLine().trim().toLowerCase();
                if (playChoice.equals("yes")) {
                    feed(food);
                } else {
                    System.out.println("Press enter to continue to play: ");
                    scanner.nextLine();
                    playProcess(toy, activity);
                }
            } else if (tirednessLevel >= 70) {
                System.out.println(getPetName() + " is too tired. Need to sleep!");
                System.out.println(getPetName() + " would you like to sleep (yes or no): ");
                String playChoice = scanner.nextLine().trim().toLowerCase();
                if (playChoice.equals("yes")) {
                    sleep();
                } else {
                    System.out.println("Press enter to continue to play: ");
                    scanner.nextLine();
                    playProcess(toy, activity);
                }
            } else if (tirednessLevel >= 50) {
                System.out.println(getPetName() + " is tired. Need to take short nap!");
                System.out.println(getPetName() + " would you like to take nap (yes or no): ");
                String playChoice = scanner.nextLine().trim().toLowerCase();
                if (playChoice.equals("yes")) {
                    rest();
                } else {
                    System.out.println("Press enter to continue to play: ");
                    scanner.nextLine();
                    playProcess(toy, activity);
                }
            } else {
                playProcess(toy, activity);
            }
        }
    }

    //short nap to gain energy and improve health condition
    public void rest() {
        //checking levels before resting
        if (getEnergyLevel() <= 40 || getHealthLevel() <= 40 || getTirednessLevel() >= 60) {
            System.out.println(getPetName() + " is now resting.");
            this.energyLevel += 20;
            this.hungerLevel += 10;
            if (this.energyLevel >= 100) {
            this.energyLevel = EnergyByAge(this.petAge);
            }
            applySetters();
            System.out.println(getPetName() + " has finished resting.");
            petHealthVital();

        } else {
            System.out.println(getPetName() + " does not need to rest right now!");
            petHealthVital();
        }
    }
    
    //long rest to gain energy and improve health condition
    public void sleep() {
        //checking energy level, health condition for sleep
        if(getEnergyLevel() <= 30 || getHealthLevel() <= 30 || getTirednessLevel() >= 80){
            System.out.println(getPetName() + " is now sleeping...");
            this.energyLevel = EnergyByAge(this.petAge);
            this.happinessLevel += 15;
            this.hungerLevel += 20;
            this.tirednessLevel -= 20;
            System.out.println(getPetName() + " has woken up! And is very hungry!");
        } else {
            System.out.println(getPetName() + " does not need to sleep.");
        }
    }

    //check the health condition of the pet 
    public void checkHealth() {
        petHealthVital();
        checkLifeStatus();
    }

    //bonding effects bond level and happiness
    public void bondWithOwner() {
        System.out.println("You are interacting with " + getPetName() + ".");
    }

    public void groom() {
        this.happinessLevel += 10;
        this.healthLevel += 10;
        applySetters();
        System.out.println(getPetName() + "has been groomed! They look clean and happy. Happiness is now.");
    }

    public void addDecorationToPetHouse(DecorationAccessory decoration) {
        System.out.println("Adding " + decoration.getAccessoryName() + " to your pet's space.");
        
        // Improve happiness and bond based on decoration's comfort factor
        this.happinessLevel = (this.happinessLevel + decoration.getComfortFactor());
        this.bondLevel = (this.bondLevel + decoration.getComfortFactor());
        
        System.out.println(getPetName() + " feels more comfortable and happy!");
        applySetters();
    }

    public void removeDecoration(DecorationAccessory decoration, User owner) {
        System.out.println("Removing " + decoration.getAccessoryName() + " from your pet’s space.");
    
        // Adjust happiness & bond level after removal
        this.happinessLevel = (happinessLevel - decoration.getComfortFactor());
        this.bondLevel = (bondLevel - decoration.getComfortFactor());
    
        System.out.println(getPetName() + " seems slightly less comfortable after removal.");
    
        // Add the decoration back to user's owned decorations list
        owner.addAccessoryToUserList(decoration);
        System.out.println("The decoration has been returned to your collection.");
        applySetters();
    }

    public void interactWithDecoration() {
        //display decorations owned by owner
        owner.displayOwnedDecorations();
        System.out.println("Choose the decoration item you want to place: ");
        int decorationChoice = scanner.nextInt() -1;
        scanner.nextLine();
        owner.selectDecorationForPet(decorationChoice);
        // Store the selected decoration in a variable
        DecorationAccessory decoration = owner.selectDecorationForPet(decorationChoice);
        System.out.println(getPetName() + " enjoys's interacting with " + decoration.getAccessoryName() + ".");
        this.happinessLevel = (this.happinessLevel + decoration.getComfortFactor());
        this.bondLevel = (this.bondLevel + decoration.getComfortFactor()); 
        applySetters();
    }

    public String toString() {
        System.out.println("------------------------------------------");
        if (petAge < 12) {
            return "Pet Name:            " + getPetName() + 
                   "\nType:                " + getPetType() + 
                   "\nAge:                 " + getPetAge() + " months" + 
                   "\nBreed:               " + getbreed() + 
                   "\nFavorite Spot:       " + getFavoriteSpot() +  
                   "\nEnergy Level:        " + getEnergyLevel() + 
                   "\nHunger Level:        " + getHungerLevel() + 
                   "\nHappiness Level:     " + getHappinessLevel() + 
                   "\nHealth Level:        " + getHealthLevel() + 
                   "\nTiredness Level:     " + getTirednessLevel() +
                   "\nBondLevel:           " + getBondLevel();
        } else {
            return "Pet Name:              " + getPetName() + 
                   "\nType:                  " + getPetType() + 
                   "\nAge:                   " + getPetAge() + " years" + 
                   "\nBreed:                 " + getbreed() + 
                   "\nFavorite Spot:         " + getFavoriteSpot() + 
                   "\nEnergy Level:          " + getEnergyLevel() + 
                   "\nHunger Level:          " + getHungerLevel() + 
                   "\nHappiness Level:       " + getHappinessLevel() + 
                   "\nHealth Level:          " + getHealthLevel() + 
                   "\nTiredness Level:       " + getTirednessLevel() +
                   "\nBondLevel:             " + getBondLevel();
        }
    }
    
}




    