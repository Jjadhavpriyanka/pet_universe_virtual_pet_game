

public class Dog extends Pet{
    
    //constructors
    public Dog(String petName, double petAgeinMonths, boolean isAlive, String breed, String favoriteSpot, int happinessLevel, int hungerLevel, int healthLevel, int tirednessLevel) {
        super(petName, petAgeinMonths, isAlive, breed, favoriteSpot, "Dog", happinessLevel, hungerLevel, healthLevel, tirednessLevel);
    }

    //methods
    @Override
    public void sound(String state) {
        switch (state.toLowerCase()) {
            case "wakeup":
                System.out.println(getPetName() + " stretches and lets out a happy yawn with a soft bark.");
                break;
            case "play":
                System.out.println(getPetName() + " barks excitedly and wags its tail, ready to play!");
                break;
            case "hungry":
                System.out.println(getPetName() + " whines softly and paws at its food bowl.");
                break;
            case "groom":
                System.out.println(getPetName() + " shakes its fur and licks its paws after grooming.");
                break;
            case "nurture":
                System.out.println(getPetName() + " happily wags its tail and gives you affectionate licks!");
                break;
            default:
                System.out.println(getPetName() + " makes a soft woof.");
                break;
        }
    }

    @Override
    public void notHungry() {
        System.out.println("\n" + getPetName() + " wags its tail but refuses to eat.");
    }

    @Override
    public void Hungry() {
        if (getHungerLevel() >= 60) {
            System.out.println("\n" + getPetName() + " whines and scratches at the food bowl.");
        } else if (getHungerLevel() >= 40) {
            System.out.println("\n" + getPetName() + " looks at you with puppy eyes, begging for food.");
        }
    }

    @Override
    public void feed(Food food) {
        sound("hungry");
        super.feed(food);
    }

    @Override
    public void reactionToPlay() {
        if (playfulnessLevel > 70) {
            sound("play");
            wagTail();
        } else if (playfulnessLevel > 40) {
            System.out.println(getPetName() + " barks happily and jumps around excitedly.");
            wagTail();
        } else {
            System.out.println(getPetName() + " wags its tail lazily but still enjoys the game.");
        }
    }

    @Override
    public void play(ToyAccessory toy, Activity activity, Food food) {
        reactionToPlay(); // Dog reacts to play session
        super.play(toy, activity, food); // Maintain existing play logic
    }

    @Override
    public void wakeUp() {
        System.out.println(getPetName() + " stretches its legs and lets out a big yawn.");
        sound("wakeup"); // Dog makes a waking-up sound
        System.out.println(getPetName() + " wags its tail and looks around, ready for the day!");
    }

    @Override
    public void rest() {
        System.out.println(getPetName() + " is resting on the " + this.favoriteSpot + ".");
        super.rest();
        wakeUp();
    }

    @Override
    public void sleep() {
        if(getEnergyLevel() <= 30 || getHealthLevel() <= 30 || getTirednessLevel() >= 80){
            System.out.println(getPetName() + " circles its sleeping spot a few times before lying down.");
            System.out.println(getPetName() + " sighs softly and drifts into sleep."); 
            this.energyLevel = EnergyByAge(this.petAge);
            this.happinessLevel += 15;
            this.hungerLevel += 20;
            this.tirednessLevel -= 20;
            System.out.println(getPetName() + " wakes up, stretches, and wags its tail, and is very hungry!");
            wakeUp(); // Trigger wake-up behavior
        } else {
            System.out.println(getPetName() + " does not need to sleep.");
        }
    }

    // Specific grooming behaviors for dogs
    private void shakeFur() {
        System.out.println(getPetName() + " shakes its fur vigorously to remove dirt.");
    }

    private void lickPaws() {
        System.out.println(getPetName() + " licks its paws to clean them.");
    }

    private void scratchBody() {
        System.out.println(getPetName() + " scratches itself to stay comfortable.");
    }

    private void enjoyBrushing() {
        System.out.println(getPetName() + " enjoys being brushed.");
    }

    @Override
    public void groom() {
        shakeFur(); 
        sound("groom"); // Dog makes grooming-related sounds
        lickPaws();
        scratchBody();
        enjoyBrushing();
        super.groom(); // Maintain any inherited grooming behavior
    }

    // Specific affectionate behaviors for dogs
    private void giveAffection() {
        System.out.println(getPetName() + " licks your hand lovingly and rolls over for belly rubs.");
    }

    @Override
    public void nurture() {
        bondWithOwner();
        sound("nurture"); // Dog makes affectionate sounds
        wagTail();   
        // Simulate affectionate behaviors
        giveAffection();
        System.out.println("Would you like to\n1. Pet\n2. Talk\n3. Cuddle: ");
        int nurtureChoice = scanner.nextInt();
        scanner.nextLine();

        switch (nurtureChoice) {
            case 1:
                this.happinessLevel += 15; // Petting increases joy
                this.bondLevel += 10; // Strengthens trust
                System.out.println(getPetName() + " wags its tail happily, enjoying the attention!");
                break;
    
            case 2:
                this.happinessLevel +=10; // Talking builds connection
                this.bondLevel += 5; // Strengthens familiarity
                System.out.println(getPetName() + " perks up, listening attentively to your voice!");
                break;
    
            case 3:
                this.happinessLevel += 20; // Cuddling brings deep comfort
                this.bondLevel += 15; // Increases closeness
                System.out.println(getPetName() + " snuggles close, feeling safe and loved!");
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

    public void wagTail() {
        System.out.println(this.petName + " is wagging its tail happily!");
    }

    @Override
    public String toString() {
        return super.toString(); // Call the Pet toString() method
    }
}
