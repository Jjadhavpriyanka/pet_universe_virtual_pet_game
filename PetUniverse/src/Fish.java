

public class Fish extends Pet{
    //attributes
    private String color;
    private int cleanlinessLevel;
   
    //constructor
    public Fish(String petName, double petAgeinMonths, boolean isAlive, String breed, String favoriteSpot, String color, int happinessLevel, int hungerLevel, int healthLevel, int tirednessLevel) {
        super(petName, petAgeinMonths, isAlive, breed, favoriteSpot, "Fish", happinessLevel, hungerLevel, healthLevel, tirednessLevel);
        this.color = color;
        this.cleanlinessLevel = 70;
    }

    //getters and setters
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    //methods

    @Override
    public void sound(String state) {
        //fish do not make sounds
    }
    @Override
    public void notHungry() {
        System.out.println(getPetName() + " nibbles at the food but does not eat.");
    }

    @Override
    public void Hungry() {
        if (getHungerLevel() >= 60) {
            System.out.println(getPetName() + " swims frantically near the surface, searching for food!");
        } else if (getHungerLevel() >= 40) {
            System.out.println(getPetName() + " nibbles at floating objects, hoping it's food.");
        } else {
            System.out.println(getPetName() + " glides calmly through the water, showing no signs of hunger.");
        }  
    }

    @Override
    public void feed(Food food) {
        tankCleanliness();
        super.feed(food);
        swimAround();
    }

    @Override
    public void reactionToPlay() {
        if (playfulnessLevel > 70) {
            System.out.println(getPetName() + " is feeling very playful! It darts around the tank rapidly, creating bubbles!");
        } else if (playfulnessLevel > 40) {
            System.out.println(getPetName() + " swims in loops and nudges nearby decorations playfully.");
        } else {
            System.out.println(getPetName() + " moves slowly and watches the toy with curiosity.");
        }
    }

    @Override
    public void play(ToyAccessory toy, Activity activity, Food food) {
        reactionToPlay(); // Fish reacts based on playfulness level   
        performTricks(); // Fish performs tricks during play
        interactWithOtherFish();
        //System.out.println(getPetName() + " playfully interacts with " + toy.getAccessoryName() + ", nudging it gently.");   
        super.play(toy, activity, food); // Maintain existing play logic
    }

    @Override
    public void rest() {
        System.out.println(getPetName() + " drifts near " + this.favoriteSpot + ", relaxing in the water.");
        super.rest();
        wakeUp();
    }

    @Override
    public void wakeUp() {
        System.out.println(getPetName() + " swims gracefully, shaking off sleep with gentle fin movements.");
    }
    
    @Override
    public void sleep() {
        if(getEnergyLevel() <= 30 || getHealthLevel() <= 30 || getTirednessLevel() >= 80){
            System.out.println(getPetName() + " settles near the tank floor, slowing its movements and resting peacefully."); 
            this.energyLevel = EnergyByAge(this.petAge);
            this.happinessLevel += 15;
            this.hungerLevel += 20;
            this.tirednessLevel -= 20;
            wakeUp(); // Triggers wake-up behavior
            System.out.println(getPetName() + " wakes up, stretches, and wags its tail, and is very hungry!");   
        } else {
            System.out.println(getPetName() + " does not need to sleep.");
        }
    }

    // Specific grooming behaviors for fish
    private void glideThroughWater() {
        System.out.println(getPetName() + " gracefully glides through the water, smoothing its scales.");
    }

    private void rubAgainstPlants() {
        System.out.println(getPetName() + " rubs against aquatic plants to remove debris.");
    }

    private void flutterFins() {
        System.out.println(getPetName() + " spreads its fins gently, keeping them well-maintained.");
    }

    @Override
    public void groom() {
        glideThroughWater(); 
        rubAgainstPlants(); 
        flutterFins();
        super.groom(); // Maintain any inherited grooming logic
    }

    public void reactToWaterMovements(String movementType) {
        System.out.println(getPetName() + " reacts to the water movement caused by " + movementType + "!");
    }

    @Override
    public void nurture() {
        bondWithOwner();
        sound("nurture");         
        System.out.println("Would you like to\n1. Talk\n2. Watch\n3. Clean tank: ");
        int nurtureChoice = scanner.nextInt();
        scanner.nextLine();
        switch (nurtureChoice) {
            case 1:
                this.happinessLevel += 15; // Fish respond to familiar sounds
                this.bondLevel += 10;; // Strengthens familiarity
                System.out.println(getPetName() + " seems to recognize your voice and swims excitedly!");
                break;
    
            case 2:
                reactToWaterMovements("gentle waves"); // Fish responds to tank environment
                this.happinessLevel +=15; // Observing them calmly reduces stress
                this.bondLevel += 10; // Increases trust
                System.out.println(getPetName() + " enjoys your presence and feels at ease.");
                break;
    
            case 3:
                this.happinessLevel += 20; // Fish thrive in clean environments
                this.bondLevel += 15; // Improves physical well-being
                this.healthLevel += 12; // They associate you with care
                System.out.println(getPetName() + " swims happily in the fresh, clean water!");
                break;
    
            default:
                System.out.println("That action isn't recognized for nurturing.");
                return;
        }
        System.out.println(getPetName() + " enjoys spending time with you and feels loved!");
        this.tirednessLevel -= 5; 
        this.hungerLevel += 10;
        applySetters();
        reactToTouch(); // Reacts to taps on the tank
        swimAround();
    }

    public void swimAround() {
        System.out.println(getPetName() + " is swimming around!");
    }

    //how fish reacts to tanks cleanliness
    public void tankCleanliness() {
        if (cleanlinessLevel < 50) {
            System.out.println(getPetName() + " is unhappy because the tank is dirty.");
            this.healthLevel -= 10;
            this.happinessLevel -= 15;
        }
    }

    public void reactToTouch() {
        System.out.println(getPetName() + " reacts to a tap on the tank.");
        this.happinessLevel += 5;
    }

    public void performTricks() {
        System.out.println(getPetName() + " performs a trick by swimming in circles!");
        this.happinessLevel += 10;
        energyLevel -= 10;
    }

    public void interactWithOtherFish() {
        System.out.println(getPetName() + " is swimming alongside other fishes!");
        this.happinessLevel += 10;
    }

    @Override
    public String toString() {
        return super.toString() + // Call the Pet toString() method
               "\nColor:      " + this.color;
    }
}
