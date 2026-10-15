import java.util.ArrayList;
import java.util.Scanner;

public class Food {
    protected ArrayList<Food> foodList;
    protected String foodName;
    protected int energyBoost;
    protected int happinessBoost;
    protected int moodBoost;
    protected int healthEffect;
    protected int hungerEffect;   
    Scanner scanner = new Scanner(System.in);

    //constructor
    public Food(String name, int energyBoost, int happinessBoost, int moodBoost, int healthEffect, int hungerEffect) {
        this.foodName = name;
        this.energyBoost = energyBoost;
        this.happinessBoost = happinessBoost;
        this.moodBoost = moodBoost;
        this.healthEffect = healthEffect;
        this.hungerEffect = hungerEffect;
    }

    public Food () {
        
    }

    //getters and setters
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getEnergyBoost() {
        return energyBoost;
    }

    public void setEnergyBoost(int energyBoost) {
        this.energyBoost = energyBoost;
    }

    public int getHappinessBoost() {
        return happinessBoost;
    }

    public void setHappinessBoost(int happinessBoost) {
        this.happinessBoost = happinessBoost;
    }

    public int getHealthEffect() {
        return healthEffect;
    }

    public int getMoodBoost() {
        return moodBoost;
    }

    public void setMoodBoost(int moodBoost) {
        this.moodBoost = moodBoost;
    }

    public int getHungerEffect() {
        return hungerEffect;
    }

    public void setHungerEffect(int hungerEffect) {
        this.hungerEffect = hungerEffect;
    }

    //default methods
    public int getSugarContent() { //for junk food
        return 0;
    }

    public int getHealthRiskFactor() { //for junk food
        return 0;
    }

    public int getNutritionalValue() { //for healthy food 
        return 0;
    }
    
    //methods
    public void listFoodItems() {
        if (foodList.isEmpty()) {
            System.out.println("You currently have no food available.");
            return;
        } else {
            System.out.println("Food available:");
        for (int i = 0; i < foodList.size(); i++) {
            Food food = foodList.get(i);
            System.out.println("-----------------------------------");
            System.out.println("Food #" + (i + 1) + ". " + "\n" + food.toString());
            }
        }
    }

    public Food selectFoodItem() {
        // Get user selection
        System.out.println("Enter the food number of your choice:");
        int choice = scanner.nextInt();

        // Validate choice and apply the food effects
        if (choice > 0 && choice <= foodList.size()) {
            
            return foodList.get(choice - 1);
        } else {
            System.out.println("Invalid selection. Please try again.");
            return null;
        }
    }

    public String toString() {
        return             "Name: " + this.foodName + 
                           "\nEnergy Boost:        " + this.energyBoost + 
                           "\nHappiness Boost:     " + this.happinessBoost + 
                           "\nMood Boost:          " + this.moodBoost + 
                           "\nHealthEffect:         " + this.healthEffect + 
                           "\nHunger Effect: " + this.hungerEffect;
    }

}
