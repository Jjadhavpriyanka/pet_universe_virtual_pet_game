


public class Cat extends Pet{
    //attributes
    private String furColor;
    
    //constructor
    public Cat(String petName, double petAge, boolean isAlive, String breed, String favoriteSpot, String furColor, int happinessLevel, int hungerLevel, int healthLevel, int tirednessLevel) {
        super(petName, petAge, isAlive, breed, favoriteSpot, "Cat", happinessLevel, hungerLevel, healthLevel, tirednessLevel);
        this.furColor = furColor;
    }

    //getters and setters
    public String getFurColor() {
        return this.furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    //methods
    @Override
    public void sound(String state) {
        switch (state.toLowerCase()) {
            case "wakeup":
                System.out.println(getPetName() + " lets out a soft yawn and purrs sleepily.");
                break;
            case "play":
                System.out.println(getPetName() + " meows excitedly and swipes at the toy!");
                break;
            case "hungry":
                System.out.println(getPetName() + " meows loudly and nudges you for food.");
                break;
            case "groom":
                System.out.println(getPetName() + " purrs softly while licking its fur.");
                break;
            case "nurture":
                System.out.println(getPetName() + " purrs happily and rubs against you.");
                break;
            default:
                System.out.println(getPetName() + " makes a soft sound.");
                break;
        }
    }

    @Override 
    public void notHungry() {
        System.out.println(getPetName() + " sniffs the food, then bats the food around like a toy.");
    }

    @Override
    public void Hungry() {
        if (getHungerLevel() >= 60) {
            System.out.println(getPetName() + " meows loudly and knocks things over in frustration!");
            sound("hungry");
        } else if (getHungerLevel() >= 40) {
            System.out.println(getPetName() + " stares at you expectantly, waiting for food.");
            sound("hungry");
        } else {
            System.out.println(getPetName() + " purrs softly, feeling satisfied.");
        }  
    }

    @Override
    public void feed(Food food) {
        super.feed(food);
    }
   
    @Override
    public void reactionToPlay() {
        if (playfulnessLevel > 80) {
            System.out.println(getPetName() + " is extremely playful and zooms around the room!");
        } else if (playfulnessLevel > 50) {
            System.out.println(getPetName() + " pounces happily and flicks its tail with excitement.");
        } else if (playfulnessLevel > 30) {
            System.out.println(getPetName() + " swats at the toy lazily but still enjoys it.");
        } else {
            System.out.println(getPetName() + " seems uninterested and just stretches.");
        }
    }

    @Override
    public void play(ToyAccessory toy, Activity activity, Food food) {
        sound("play");
        reactionToPlay();
        super.play(toy, activity, food);
    }

    @Override
    public void rest() {
        System.out.println(getPetName() + " curls up in " + this.favoriteSpot + " and starts resting.");
        super.rest();
        wakeUp();
    }

    @Override
    public void wakeUp() {
        System.out.println(getPetName() + " stretches its legs and arches its back after a restful nap.");
        System.out.println(getPetName() + " lets out a soft yawn and blinks sleepily.");
        
        // Purring indicates comfort and happiness upon waking
        sound("wakeup"); 
    }

    // Specific grooming behaviors
    private void lickFur() {
        System.out.println(getPetName() + " licks its fur carefully to stay clean.");
    }

    private void cleanPaws() {
        System.out.println(getPetName() + " uses its tongue to clean its paws.");
    }

    private void fluffTail() {
        System.out.println(getPetName() + " shakes its tail and fluffs up its fur.");
    }

    private void stretchBody() {
        System.out.println(getPetName() + " stretches out comfortably after grooming.");
    }
    
    public void climb(String object) {
        System.out.println(this.petName + " climbs " + object + "!");
    }

    @Override
    public void groom() {
        sound("groom");
        lickFur();
        cleanPaws();
        fluffTail();
        stretchBody();
        super.groom(); // Maintain any existing grooming logic in superclass
        
    }

    // Specific behavior for cats
    private void kneadPaws() {
        System.out.println(getPetName() + " kneads your lap gently, showing comfort and trust.");
    }

    @Override
    public void nurture() {
        bondWithOwner();
        sound("nurture"); // Cat purrs or meows softly
        System.out.println(getPetName() + " purrs happily and rubs against you, enjoying your affection.");   
        // Simulate kneading (common cat bonding behavior)
        kneadPaws();
        System.out.println("Would you like to\n1. Pet\n2. Talk\n3. Cuddle: ");
        int nurtureChoice = scanner.nextInt();
        scanner.nextLine();

        switch (nurtureChoice) {
            case 1:
                this.happinessLevel += 15; // Petting increases joy
                this.bondLevel += 10; // Strengthens trust
                System.out.println(getPetName() + " purrs softly, enjoying the gentle affection.");
                break;
    
            case 2:
                this.happinessLevel +=10; // Talking builds connection
                this.bondLevel += 5; // Strengthens familiarity
                System.out.println(getPetName() + " flicks its ears, acknowledging your presence.");
                break;
    
            case 3:
                if (bondLevel > 50) { // Cats cuddle more when trust is built
                    this.happinessLevel += 20; // Cuddling brings deep comfort
                    this.bondLevel += 15; // Increases closeness
                    System.out.println(getPetName() + " curls up next to you, feeling safe.");
                } else {
                    System.out.println(getPetName() + " seems unsure about cuddling. Strengthen your bond first!");
                }
                break;
    
            default:
                System.out.println("That action isn't recognized for nurturing.");
                return;
        }       
        System.out.println(getPetName() + " enjoys spending time with you and feels loved!");
        this.tirednessLevel -= 5; 
        this.hungerLevel += 10;
        applySetters();
    }

    @Override
    public String toString() {
        return super.toString(); // Call the Pet toString() method
    }
}


