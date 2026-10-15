import java.util.ArrayList;

public class HealthyFood extends Food{
    //attributes
    private static ArrayList<HealthyFood> healthyFoodList = new ArrayList<>();
    private int nutritionalValue;

    //constructor
    public HealthyFood(String foodName, int energyBoost, int happinessBoost, int moodBoost, int healthEffect, int hungerEffect, int nutritionalValue) {
        super(foodName, energyBoost, happinessBoost, moodBoost, healthEffect, hungerEffect);
        this.nutritionalValue = nutritionalValue;
    }

    public HealthyFood () {
        super();
        initialiseHealthyFoodList();
    }

    //getters and setters
    @Override
    public int getNutritionalValue() {
        return nutritionalValue;
    }


    //methods
    private void initialiseHealthyFoodList() {
        if (healthyFoodList == null) {
            healthyFoodList = new ArrayList<>();
        }
        healthyFoodList.add(new HealthyFood("Chicken breast", 8, 5, 4, 7, 8, 8));
        healthyFoodList.add(new HealthyFood("Salmon", 10, 6, 5, 6, 9, 9));
        healthyFoodList.add(new HealthyFood("Pumpkin", 4, 3, 2, 8, 7, 8));
        healthyFoodList.add(new HealthyFood("Tuna", 9, 7, 5, 8, 8, 8));
        healthyFoodList.add(new HealthyFood("Carrot", 6, 3, 2, 8, 9, 8));
        healthyFoodList.add(new HealthyFood("Sweet potato", 5, 4, 3, 8, 8, 8));
        healthyFoodList.add(new HealthyFood("Turkey meat", 8, 6, 5, 9, 10, 9));
        healthyFoodList.add(new HealthyFood("Green beans", 4, 2, 3, 9, 7, 7));
        healthyFoodList.add(new HealthyFood("Seaweed", 3, 3, 2, 8, 6, 7));
        healthyFoodList.add(new HealthyFood("Daphnia", 8, 5, 4, 9, 8, 8));
        healthyFoodList.add(new HealthyFood("Spirulina pellets", 6, 5, 3, 7, 7, 9));
        healthyFoodList.add(new HealthyFood("Brine Shrimp", 7, 6, 4, 9, 8, 8));
        healthyFoodList.add(new HealthyFood("Millet", 5, 4, 3, 7, 7, 8));
        healthyFoodList.add(new HealthyFood("Sunflower seeds", 7, 5, 4, 9, 7, 8));
        healthyFoodList.add(new HealthyFood("Apple", 4, 3, 2, 8, 6, 8));
        healthyFoodList.add(new HealthyFood("Kale", 3, 2, 4, 8, 5, 8));
        healthyFoodList.add(new HealthyFood("Almond", 6, 5, 4, 9, 7, 8));
        healthyFoodList.add(new HealthyFood("Oats", 5, 3, 2, 9, 8, 8));
        healthyFoodList.add(new HealthyFood("Broccoli", 4, 3, 3, 7, 6, 8));
        healthyFoodList.add(new HealthyFood("Peanuts", 7, 5, 4, 8, 7, 9));
    }


    @Override
    public void listFoodItems() {
        if (healthyFoodList.isEmpty()) {
            System.out.println("You currently have no healthy food available.");
            return;
        } else {
            System.out.println("Healthy Food Options:");
        for (int i = 0; i < healthyFoodList.size(); i++) {
            HealthyFood healthyFood = healthyFoodList.get(i);
            System.out.println("-----------------------------------");
            System.out.println("Food #" + (i + 1) + ". " + "\n" + healthyFood.toString());
            }
        }
    }

    @Override
    public HealthyFood selectFoodItem() {
        // Get user selection
        System.out.println("Enter the food number of your choice:");
        int choice = scanner.nextInt();

        // Validate choice and apply the food effects
        if (choice > 0 && choice <= healthyFoodList.size()) {
            
            return healthyFoodList.get(choice - 1);
        } else {
            System.out.println("Invalid selection. Please try again.");
            return null;
        }
    }
}
