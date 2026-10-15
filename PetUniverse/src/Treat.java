import java.util.ArrayList;

public class Treat extends Food{
    //attribute
    private static ArrayList<Treat> treatList = new ArrayList<>();
    private boolean specialEvent;

    //constructor
    public Treat(String foodName, int energyBoost, int happinessBoost, int moodBoost, int healthEffect, int hungerEffect, boolean specialEvent) {
        super(foodName, energyBoost, happinessBoost, moodBoost, hungerEffect, healthEffect);
        this.specialEvent = specialEvent;
    }

    public Treat () {
        super();
        initialiseTreatList();
        
    }

    //getters and setters
    public boolean isSpecialEvent() {
        return specialEvent;
    }

    public void setSpecialEvent(boolean specialEvent) {
        this.specialEvent = specialEvent;
    }

    //methods
    private void initialiseTreatList() {
        if (treatList == null) {
            treatList = new ArrayList<>();
        }
        treatList.add(new Treat("Salmon bites", 5, 10, 8, 3, 6, true));
        treatList.add(new Treat("Catnip cookies", 4, 12, 9, 2, 5, true));
        treatList.add(new Treat("Tuna nuggets", 6, 9, 7, 1, 6, false));
        treatList.add(new Treat("Chewy liver treats", 7, 12, 10, 3, 8, true));
        treatList.add(new Treat("Peanut butter bones", 6, 10, 8, 2, 7, false));
        treatList.add(new Treat("Chicken jerky", 5, 11, 9, 4, 7, true));
        treatList.add(new Treat("Bloodworm cubes", 7, 9, 6, 3, 5, false));
        treatList.add(new Treat("Brine shrimp treats", 8, 10, 8, 2, 6, true));
        treatList.add(new Treat("Spiriluna discs", 6, 8, 7, 4, 5, true));
        treatList.add(new Treat("Honey seed sticks", 5, 10, 9, 3, 7, true));
        treatList.add(new Treat("Millet balls", 4, 8, 7, 2, 5, false));
        treatList.add(new Treat("Nut butter bars", 6, 9, 8, 3, 6, true));
        treatList.add(new Treat("Alfalfa cubes", 5, 8, 6, 4, 7, false));
        treatList.add(new Treat("Dried fish chips", 7, 10, 8, 3, 6, true));
        treatList.add(new Treat("Yogurt drops", 4, 10, 9, 2, 6, true));
        treatList.add(new Treat("Carrot sticks", 6, 9, 8, 4, 7, false));
        treatList.add(new Treat("Cheddar biscuits", 5, 11, 9, 1, 6, false));
        treatList.add(new Treat("Blueberry discs", 6, 10, 8, 3, 6, true));
        treatList.add(new Treat("Walnut twists", 5, 8, 6, 4, 6, false));
        treatList.add(new Treat("Herbal cubes", 6, 9, 7, 5, 7, true));
    }

    @Override
    public void listFoodItems() {
        if (treatList.isEmpty()) {
            System.out.println("You currently have no treats available.");
            return;
        } else {
            System.out.println("Treat Options:");
        for (int i = 0; i < treatList.size(); i++) {
            Treat treat = treatList.get(i);
            System.out.println("-----------------------------------");
            System.out.println("Treat #" + (i + 1) + ". " + "\n" + treat.toString());
            }
        }
    }

    @Override
    public Treat selectFoodItem() {
        // Get user selection
        System.out.println("Enter the food number of your choice:");
        int choice = scanner.nextInt();

        // Validate choice and apply the food effects
        if (choice > 0 && choice <= treatList.size()) {
            
            return treatList.get(choice - 1);
        } else {
            System.out.println("Invalid selection. Please try again.");
            return null;
        }
    }
    
}
