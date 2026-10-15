import java.util.ArrayList;

public class JunkFood extends Food{
    //attributes
    private static ArrayList<JunkFood> junkFoodList = new ArrayList<>();
    private int healthRiskFactor;
    private int sugarContent;

    //constructor
    public JunkFood(String foodName, int energyBoost, int happinessBoost, int moodBoost, int healthEffect, int hungerEffect, int sugarContent, int healthRiskFactor) {
        super(foodName, energyBoost, happinessBoost, moodBoost, healthEffect, hungerEffect);
        this.healthRiskFactor = healthRiskFactor;
        this.sugarContent = sugarContent;
        
    }

    public JunkFood () {
        super();
        initialiseJunkFoodList();
        
    }

    //getters and setters
    @Override
    public int getSugarContent() {
        return this.sugarContent;
    }

    @Override
    public int getHealthRiskFactor() {
        return this.healthRiskFactor;
    }

    //methods
    private void initialiseJunkFoodList() {
        if (junkFoodList == null) {
            junkFoodList = new ArrayList<>();
        }
        junkFoodList.add(new JunkFood("Tuna bits", 5, 8, 5, 3, 7, 1, 6));
        junkFoodList.add(new JunkFood("Cheese crackers", 3, 7, 4, 4, 6, 2, 8));
        junkFoodList.add(new JunkFood("Fish-flavored chips", 4, 9, 6, 5, 7, 1, 7));
        junkFoodList.add(new JunkFood("Bacon bits", 8, 12, 9, 8, 9, 2, 9));
        junkFoodList.add(new JunkFood("Sausage nuggets", 5, 10, 6, 6, 7, 1, 7));
        junkFoodList.add(new JunkFood("Meat-flavored wafers", 7, 11, 7, 7, 8, 2, 8));
        junkFoodList.add(new JunkFood("Dried Shrimp Bites", 7, 8, 5, 4, 6, 1, 6));
        junkFoodList.add(new JunkFood("Flavored Flakes", 5, 10, 7, 5, 8, 2, 8));
        junkFoodList.add(new JunkFood("Sugar-Coated Pellets", 4, 12, 8, 6, 6, 2, 9));
        junkFoodList.add(new JunkFood("Seed Bars", 6, 9, 6, 4, 8, 2, 7));
        junkFoodList.add(new JunkFood("Cheese Drops", 4, 8, 5, 3, 6, 1, 6));
        junkFoodList.add(new JunkFood("Sweetened Fruit Mix", 5, 10, 7, 5, 7, 2, 8));
        junkFoodList.add(new JunkFood("Syrupy Nut Pieces", 7, 10, 8, 6, 8, 2, 8));
        junkFoodList.add(new JunkFood("Butter Popcorn", 5, 12, 7, 5, 9, 2, 7));
        junkFoodList.add(new JunkFood("Colored Cereal Bits", 6, 9, 6, 4, 7, 1, 6));
        junkFoodList.add(new JunkFood("High-Fat Seeds", 7, 11, 8, 6, 8, 2, 8));
        junkFoodList.add(new JunkFood("Yogurt-Coated Snacks", 5, 9, 7, 3, 7, 1, 6));
        junkFoodList.add(new JunkFood("Syrupy Wafers", 6, 10, 8, 5, 8, 2, 7));
        junkFoodList.add(new JunkFood("Salty Cheese Nuggets", 5, 8, 5, 4, 8, 2, 7));
        junkFoodList.add(new JunkFood("Artificial seed mix", 4, 9, 6, 3, 7, 1, 6));
    }

    @Override
    public void listFoodItems() {
        if (junkFoodList.isEmpty()) {
            System.out.println("You currently have no junk food available.");
            return;
        } else {
            System.out.println("Junk Food Options:");
        for (int i = 0; i < junkFoodList.size(); i++) {
            JunkFood junkFood = junkFoodList.get(i);
            System.out.println("-----------------------------------");
            System.out.println("Food #" + (i + 1) + ". " + "\n" + junkFood.toString());
            }
        }
    }

    @Override
    public JunkFood selectFoodItem() {
        // Get user selection
        System.out.println("Enter the food number of your choice:");
        int choice = scanner.nextInt();

        // Validate choice and apply the food effects
        if (choice > 0 && choice <= junkFoodList.size()) {
            
            return junkFoodList.get(choice - 1);
        } else {
            System.out.println("Invalid selection. Please try again.");
            return null;
        }
    }
}
