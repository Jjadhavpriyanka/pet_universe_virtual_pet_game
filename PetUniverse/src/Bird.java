
public class Bird extends Pet {
    //attributes
    private int playfulnessLevel;
    

    public Bird(String petName, double petAge, boolean isAlive, String breed, String favoriteSpot, int happinessLevel, int hungerLevel, int healthLevel, int tirednessLevel) {
        super(petName, petAge, isAlive, breed, favoriteSpot, "Bird", happinessLevel, hungerLevel, healthLevel, tirednessLevel);
    }


    //methods
    @Override 
    public void sound(String state) { 
        switch (state.toLowerCase()) { 
            case "wakeup": 
                System.out.println(getPetName() + " stretches its wings and lets out a soft morning chirp."); 
                break; 
            case "play": 
                System.out.println(getPetName() + " flaps its wings excitedly and sings a cheerful tune!"); 
                break; 
            case "hungry": 
                System.out.println(getPetName() + " chirps loudly, demanding food!"); 
                break; 
            case "groom": 
                System.out.println(getPetName() + " preens its feathers while making soft, content chirps."); 
                break; 
            case "nurture": 
                System.out.println(getPetName() + " sings a sweet melody in response to your affection."); 
                break; 
            default: 
                System.out.println(getPetName() + " chirps softly."); 
                break; 
        } 
    } 

    public void flyAround() {
        if (this.energyLevel > 20) {
            System.out.println(getPetName() + " is flying around!");
        } else {
            System.out.println(getPetName() + " is too tired to fly.");
        }
    }

    @Override
    public void notHungry() {
        System.out.println(getPetName() + " pecks at the food but throw's away!");
    }

    @Override
    public void Hungry() {
        flyAround();
        
        if (getHungerLevel() >= 60) {
            sound("hungry");
        } else if (getHungerLevel() >= 40) {
            System.out.println(getPetName() + " flaps its wings, signaling hunger.");
        } else {
            System.out.println(getPetName() + " chirps contentedly.");
        }  
    }

    @Override
    public void feed(Food food) {
        super.feed(food);
    }

    @Override
    public void reactionToPlay() {
        if (playfulnessLevel > 70) {
            sound("play");
            System.out.println(getPetName() + " is feeling very playful! It starts hopping around excitedly.");
        } else if (playfulnessLevel > 40) {
            sound("play");
            System.out.println(getPetName() + " chirps loudly and flaps its wings playfully.");
        } else {
            System.out.println(getPetName() + " is curious but not too energetic, it pecks at a nearby toy.");
        }
    }

    @Override
    public void play(ToyAccessory toy, Activity activity, Food food) {
        reactionToPlay();
        super.play(toy, activity, food);
    }

    @Override
    public void rest() {
        System.out.println(getPetName() + " is resting on the " + this.favoriteSpot + ".");
        super.rest();
        wakeUp();
    }

    String nestMaterial = "soft feathers and twigs";
    public void buildNest(String nestMaterial) {
        System.out.println(getPetName() + " is building a nest with " + nestMaterial + ".");
    }

    @Override
    public void wakeUp() {
        System.out.println(getPetName() + " stretches its wings after a good rest.");
        sound("wakeup"); // Chirping when waking up
    }

    @Override
    public void sleep() {
        if(getEnergyLevel() <= 30 || getHealthLevel() <= 30 || getTirednessLevel() >= 80){
            buildNest(nestMaterial);
            System.out.println(getPetName() + " circles its sleeping spot a few times before lying down.");
            System.out.println(getPetName() + " snuggles into the nest and falls asleep.");
            this.energyLevel = EnergyByAge(this.petAge);
            this.happinessLevel += 15;
            this.hungerLevel += 20;
            this.tirednessLevel -= 20;
            wakeUp(); // Trigger wake-up behavior
            System.out.println(getPetName() + " wakes up, stretches, and wags its tail, and is very hungry!");  
        } else {
            System.out.println(getPetName() + " does not need to sleep.");
        }
    }

    public void preenFeathers() {
        System.out.println(getPetName() + " is preening its feathers.");
    }

    public void cleanFeathers() {
        System.out.println(getPetName() + " removes dirt and dust from its feathers.");
    }
    
    public void fluffFeathers() {
        System.out.println(getPetName() + " fluffs up its feathers to stay warm and comfortable.");
    }
    
    public void stretchWings() {
        System.out.println(getPetName() + " stretches its wings to stay flexible and ready to fly.");
    }

    @Override
    public void groom() {
        preenFeathers();
        sound("groom");
        cleanFeathers();
        fluffFeathers();
        stretchWings();
        super.groom();
    }

    String sound = "gentle talking";

    public void reactToSounds(String sound) {
        System.out.println(getPetName() + " reacts to the sound of " + sound + "!");
    }

    @Override
    public void nurture() {
        sound("nurture");
        System.out.println("Would you like to\n1. Talk\n2. Pet: ");
        int nurtureChoice = scanner.nextInt();
        scanner.nextLine();
        switch (nurtureChoice) {
            case 1:
                reactToSounds(sound);
                this.happinessLevel += 15; // Birds enjoy vocal interaction
                this.bondLevel += 10; // Strengthens familiarity
                System.out.println(getPetName() + " chirps back happily, recognizing your voice!");
                break;
    
            case 2:
                this.happinessLevel += 10; // Some birds enjoy head scratches
                this.bondLevel += 8; // Builds comfort
                System.out.println(getPetName() + " fluffs its feathers, enjoying your gentle touch!");
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
