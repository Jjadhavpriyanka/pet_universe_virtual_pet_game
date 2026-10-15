public class Rodent extends Pet{
    //attributes
    private String furColor;
    private boolean nocturnalActivity;
    
   //constructor
    public Rodent(String petName, double petAge, boolean isAlive, /*int petPrice, String favoriteAcitivity, */String breed,
            /*String favoriteFood, */String favoriteSpot, /*String favoriteToy, int scoreValue, */String furColor, boolean nocturnalActivity, int happinessLevel, int hungerLevel, int healthLevel, int tirednessLevel) {
        super(petName, petAge, isAlive, /*petPrice, favoriteAcitivity, */breed, /*favoriteFood, */favoriteSpot, /*favoriteToy, */"Rodent", /*scoreValue, */happinessLevel, hungerLevel, healthLevel, tirednessLevel);
        this.furColor = furColor;
        this.nocturnalActivity = nocturnalActivity;
    }

    //getters and setters
    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    public boolean isNocturnalActivity() {
        return nocturnalActivity;
    }

    public void setNocturnalActivity(boolean nocturnalActivity) {
        this.nocturnalActivity = nocturnalActivity;
    }

    //methods
    @Override
    public void sound(String state) {
        switch (state.toLowerCase()) {
            case "wakeup":
                System.out.println(getPetName() + " stretches and lets out a soft squeak as it wakes up.");
                break;
            case "play":
                System.out.println(getPetName() + " excitedly scurries around, squeaking and chattering!");
                break;
            case "hungry":
                System.out.println(getPetName() + " squeaks insistently and nibbles at its food bowl.");
                break;
            case "groom":
                System.out.println(getPetName() + " softly rustles as it cleans its fur.");
                break;
            case "nurture":
                System.out.println(getPetName() + " nuzzles against you and lets out soft, happy squeaks.");
                break;
            default:
                System.out.println(getPetName() + " makes small, curious squeaks.");
                break;
        }
    }

    @Override
    public void notHungry() {
        System.out.println(getPetName() + " sniffs the food but hides it for later.");
    }

    private void scurryAround() {
        System.out.println(getPetName() + " scurries around excitedly, searching for food.");
    }

    @Override
    public void Hungry() {
        scurryAround();
        if (getHungerLevel() >= 60) {
            sound("hungry");
        } else if (getHungerLevel() >= 40) {
            System.out.println(getPetName() + " scurries around searching for food.");
        } else {
            System.out.println(getPetName() + " calmly burrows, feeling satisfied.");
        }  
    }

    @Override
    public void feed(Food food) {
        super.feed(food);
        storeFood();
    }

    @Override
    public void reactionToPlay() {
        if (playfulnessLevel > 70) {
            sound("play");
            System.out.println(getPetName() + " is feeling very playful! It scurries around excitedly, jumping and rolling!");
        } else if (playfulnessLevel > 40) {
            sound("play");
            System.out.println(getPetName() + " nibbles on a toy and playfully pushes it around.");
        } else {
            System.out.println(getPetName() + " sniffs at the toy but seems uninterested.");
        }
    }

    @Override
    public void play(ToyAccessory toy, Activity activity, Food food) {
        reactionToPlay(); // Rodent reacts to play session
        System.out.println(getPetName() + " enjoys playing with " + toy.getAccessoryName() + ", rolling it around with its paws.");   
        super.play(toy, activity, food);
    }

    @Override
    public void rest() {
        //System.out.println(getPetName() + " curls up in " + this.favoriteSpot + " and rests peacefully.");
        if (this.energyLevel <= 20) {
            hideFromDanger(); // Rodent seeks safety when tired
        } else {
            exploreEnvironment(); // Otherwise, it explores its surroundings
        }
        super.rest();
        wakeUp();
    }

    @Override
    public void wakeUp() {
        System.out.println(getPetName() + " stretches its body and twitches its whiskers as it wakes up.");
        sound("wakeup"); // Soft squeaks or rustling noises
    }

    @Override
    public void sleep() {
        if (nocturnalActivity) {
            System.out.println(getPetName() + " is nocturnal and prefers sleeping during the day.");

            if(getEnergyLevel() <= 30 || getHealthLevel() <= 30 || getTirednessLevel() >= 80){
                burrowOrTunnel();
                System.out.println(getPetName() + " burrows into soft bedding and curls up snugly for a daytime rest.");
                this.energyLevel = EnergyByAge(this.petAge);
                this.happinessLevel += 15;
                this.hungerLevel += 20;
                this.tirednessLevel -= 20;
                
                wakeUp();
                System.out.println(getPetName() + " wakes up, stretches, and is full of energy for nighttime activity!");
            } else {
                System.out.println(getPetName() + " does not need to sleep yet.");
            }

        } else { // Normal diurnal activity
            if(getEnergyLevel() <= 30 || getHealthLevel() <= 30 || getTirednessLevel() >= 80){
                burrowOrTunnel();
                System.out.println(getPetName() + " burrows into soft bedding and curls up snugly to sleep.");
                this.energyLevel = EnergyByAge(this.petAge);
                this.happinessLevel += 15;
                this.hungerLevel += 20;
                this.tirednessLevel -= 20;
                
                wakeUp();
                System.out.println(getPetName() + " wakes up, stretches, and wags its tail, and is very hungry!");
            } else {
                System.out.println(getPetName() + " does not need to sleep.");
            }
        }
    }

    // Specific grooming behaviors for rodents
    private void cleanFur() {
        System.out.println(getPetName() + " licks its fur carefully, keeping it clean.");
    }

    private void adjustWhiskers() {
        System.out.println(getPetName() + " twitches its whiskers, grooming itself.");
    }

    private void scratchBody() {
        System.out.println(getPetName() + " scratches itself to stay comfortable.");
    }

    //Gnaw to Trim Teeth
    public void gnawToTrimTeeth() {
        System.out.println(this.petName + " is gnawing to keep its teeth healthy.");
    }

    @Override
    public void groom() {
        cleanFur();
        sound("groom"); // Rustling or soft squeaking
        adjustWhiskers();
        scratchBody();
        super.groom(); // Maintain inherited grooming logic
    }

    public void reactToEnvironmentalSounds(String sound) {
        System.out.println(getPetName() + " reacts to the subtle noise of " + sound + " by twitching its ears!");
    }

    @Override
    public void nurture() {
        sound("nurture"); // Soft squeaks or curious sniffing
        System.out.println("Would you like to\n1. Pet\n2. Talk\n3. Hand-feed: ");
        int nurtureChoice = scanner.nextInt();
        scanner.nextLine();
        switch (nurtureChoice) {
            case 1:
                reactToTouch(); // Enjoys being pet
                this.happinessLevel += 15; // Rodents love gentle strokes
                this.bondLevel += 10; // Builds trust
                System.out.println(getPetName() + " enjoys being gently petted and feels more connected.");
                break;
    
            case 2:
                this.happinessLevel += 10; // Some rodents respond to voices
                this.bondLevel += 5; // Familiarity builds over time
                System.out.println(getPetName() + " twitches its ears, recognizing your voice!");
                communicate();
                break;
    
            case 3:
                // Rodent responds to environment
                reactToEnvironmentalSounds("soft rustling");
                this.happinessLevel += 20; // Eating from the owner's hand builds strong trust
                this.bondLevel += 15; // Strengthens connection
                System.out.println(getPetName() + " happily eats from your hand, feeling safe and loved!");
                break;
    
            default:
                System.out.println("That action isn't recognized for nurturing.");
                return;
        }
        System.out.println(getPetName() + " nuzzles against you, enjoying gentle attention.");
        System.out.println(getPetName() + " enjoys spending time with you and feels loved!");
        this.tirednessLevel -= 5; 
        this.hungerLevel += 10;
        applySetters();
    }
    
    // Nest Building
    public void nestBuilding(String material) {
        System.out.println(this.petName + " is building a cozy nest using " + material + ".");
    }

    // Explore Environment
    public void exploreEnvironment() {
        System.out.println(this.petName + " is exploring its surroundings.");
        this.happinessLevel += 10;
        this.energyLevel -= 10;
    }

    // Hide from Danger
    public void hideFromDanger() {
        System.out.println(this.petName + " quickly hides to feel safe.");
        this.happinessLevel += 5;
    }

    // Communicate
    public void communicate() {
        System.out.println(this.petName + " is squeaking happily!");
        this.happinessLevel += 10;
    }

    // Burrow or Tunnel
    public void burrowOrTunnel() {
        System.out.println(this.petName + " is burrowing into the bedding!");
    }

    // Store Food
    public void storeFood() {
        System.out.println(this.petName + " is storing food in its favorite corner.");
        this.happinessLevel += 5;
    }

    // React to Touch
    public void reactToTouch() {
        System.out.println(this.petName + " reacts to being pet gently!");
        this.happinessLevel += 10;
    }   

    @Override
    public String toString() {
        return super.toString() + // Call the Pet toString() method
               "\nFur Color:  " + this.furColor ;
    }
}
