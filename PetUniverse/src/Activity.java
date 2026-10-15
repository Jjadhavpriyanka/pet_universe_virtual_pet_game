import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Activity {
    
    //attributes
    private String activityName;
    private int activityDuration;
    private boolean isOutdoor;
    private int energyLoss;
    private int funFactor;
    private int healthBenefit;
    private int bondingLevel;
    private String environmentType;
    private boolean needToy;
    private static HashMap<String, ArrayList<Activity>> petActivities;
    static Scanner scanner = new Scanner(System.in);
    

    //constructor
    

    public Activity(String activityName, int activityDuration, boolean isOutdoor, int energyLoss, int funFactor, int healthBenefit, int bondingLevel, String environmentType, boolean needToy) {
        this.activityName = activityName;
        this.activityDuration = activityDuration;
        this.isOutdoor = isOutdoor;
        this.energyLoss = energyLoss;
        this.funFactor = funFactor;
        this.healthBenefit = healthBenefit;
        this.bondingLevel = bondingLevel;
        this.environmentType = environmentType;
        this.needToy = needToy;
    }

    public Activity() {
        initialisePetActivitiesList();
    }




    //getters and setters
    public boolean getisOutdoor() {
        return isOutdoor;
    }

    public void setIsOutdoor(boolean isOutdoor) {
        this.isOutdoor = isOutdoor;
    }

    public int getHealthBenefit() {
        return healthBenefit;
    }

    public void setHealthBenefit(int healthBenefit) {
        this.healthBenefit = healthBenefit;
    }

    public int getBondingLevel() {
        return bondingLevel;
    }

    public void setBondngLevel(int bondingLevel) {
        this.bondingLevel = bondingLevel;
    }

    public int getEnergyLoss() {
        return energyLoss;
    }

    public void setEnergyLoss(int energyLoss) {
        this.energyLoss = energyLoss;
    }

    public int getFunFactor() {
        return funFactor;
    }

    public void setFunFactor(int funFactor) {
        this.funFactor = funFactor;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getActivityDuration() {
        return activityDuration;
    }

    public void setActivityDuration(int activityDuration) {
        this.activityDuration = activityDuration;
    }

    public String getEnvironmentType() {
        return environmentType;
    }

    public void setEnvironmentType(String environmentType) {
        this.environmentType = environmentType;
    }

    public boolean getNeedToy() {
        return needToy;
    }

    public void setNeedToy(boolean needToy) {
        this.needToy = needToy;
    }

    //methods

    private void initialisePetActivitiesList() {
        if (petActivities == null) {
            petActivities = new HashMap<>();
        }
        ArrayList<Activity> dogActivities = new ArrayList<>();
        dogActivities.add(new Activity("Fetch", 30, true, 4, 7, 6, 8, "Park", true));
        dogActivities.add(new Activity("Jogging", 45, true, 6, 5, 7, 7, "Trail", false));
        dogActivities.add(new Activity("Tug-of-War", 20, false, 3, 6, 4, 8, "Indoors", true));
        dogActivities.add(new Activity("Agility Training", 50, true, 5, 8, 8, 9, "Open Field", true));
        dogActivities.add(new Activity("Hide-and-Seek", 15, false, 2, 6, 3, 7, "Backyard", false));
        dogActivities.add(new Activity("Swimming", 40, true, 5, 7, 8, 8, "Pool", true));
        petActivities.put("Dog", dogActivities);

        // Populate activities for cats
        ArrayList<Activity> catActivities = new ArrayList<>();
        catActivities.add(new Activity("Laser Chase", 15, false, 4, 8, 5, 7, "Indoors", true));
        catActivities.add(new Activity("Climbing Scratcher", 30, false, 3, 6, 6, 7, "Indoors", true));
        catActivities.add(new Activity("Toy Hunting", 20, false, 3, 7, 5, 8, "Indoors", true));
        catActivities.add(new Activity("Outdoor Exploring", 45, true, 5, 7, 7, 8, "Garden", false));
        catActivities.add(new Activity("Feather Wand Play", 10, false, 2, 8, 4, 6, "Indoors", true));
        catActivities.add(new Activity("Hide-and-Seek", 15, false, 2, 7, 3, 8, "Indoors", false));
        petActivities.put("Cat", catActivities);

        // Populate activities for birds
        ArrayList<Activity> birdActivities = new ArrayList<>();
        birdActivities.add(new Activity("Flight Practice", 30, false, 5, 7, 7, 6, "Indoors", false));
        birdActivities.add(new Activity("Singing Session", 20, false, 5, 6, 4, 7, "Indoors", false));
        birdActivities.add(new Activity("Foraging Game", 25, false, 3, 8, 5, 7, "Cage", true));
        birdActivities.add(new Activity("Perch Exploration", 15, false, 2, 5, 4, 6, "Indoors", false));
        birdActivities.add(new Activity("Social Interaction", 40, false, 3, 8, 6, 9, "Indoors", false));
        birdActivities.add(new Activity("Bath Time", 10, false, 1, 7, 5, 8, "Basin", true));
        petActivities.put("Bird", birdActivities);

        // Populate activities for fish
        ArrayList<Activity> fishActivities = new ArrayList<>();
        fishActivities.add(new Activity("Pebble Reaaranging", 15, false, 4, 5, 3, 4, "Aquarium", true));
        fishActivities.add(new Activity("Bubble Play", 20, false, 1, 6, 2, 5, "Aquarium", true));
        fishActivities.add(new Activity("Exploring Decor", 30, false, 2, 7, 4, 5, "Aquarium", false));
        fishActivities.add(new Activity("Mirror Interaction", 10, false, 1, 5, 2, 6, "Aquarium", true));
        fishActivities.add(new Activity("Feeding time", 5, false, 5, 4, 1, 7, "Aquarium", false));
        fishActivities.add(new Activity("Light Dancing", 20, false, 5, 7, 3, 5, "Aquarium", true));
        petActivities.put("Fish", fishActivities);

        // Populate activities for rodents
        ArrayList<Activity> rodentActivities = new ArrayList<>();
        rodentActivities.add(new Activity("Running Wheel", 30, false, 5, 7, 6, 4, "Cage", true));
        rodentActivities.add(new Activity("Maze Exploration", 40, false, 4, 8, 7, 5, "Indoors", false));
        rodentActivities.add(new Activity("Tunnel Crawling", 25, false, 3, 6, 4, 7, "Cage", true));
        rodentActivities.add(new Activity("Foraging Activity", 30, false, 4, 7, 5, 8, "Cage", true));
        rodentActivities.add(new Activity("Ball Rolling", 20, false, 3, 8, 4, 7, "Indoors", true));
        rodentActivities.add(new Activity("Hide-and-Seek", 15, false, 2, 7, 3, 9, "Indoors", false));
        petActivities.put("Rodent", rodentActivities);
    }
    public void getActivityDetails() {
        //display details
        System.out.println(toString());
    }

    public void setEnvironment(String environment) {
        this.environmentType = environment;
        System.out.println("Environment set to: " + environment);
    }

    public void displayActivities(String petType) {
        if (petActivities.containsKey(petType)) {
            ArrayList<Activity> activities = petActivities.get(petType);
            System.out.println("Activities for " + petType + ":");
    
            for (int i = 0; i < activities.size(); i++) {
                Activity activity = activities.get(i);
                System.out.println("Activity # " + (i + 1) + ". " + "\n" + activity.toString());
            }
        } else {
            System.out.println("No activities available for " + petType + ".");
        }
    }

    public static Activity getActivity(String petType) {
        if(petActivities.containsKey(petType)) {
            ArrayList<Activity> activities = petActivities.get(petType);
            // User selects an activity
            System.out.print("Enter the activity number you would like your pet to do: ");
            int activityChoice = scanner.nextInt();
            scanner.nextLine();

            if (activityChoice > 0 && activityChoice <= activities.size()) {
                return activities.get(activityChoice - 1);
            } else {
                System.out.println("Invalid activity choice.");
                return null;
            }
            
        } else {
            System.out.println("No activites available for " + petType + ".");
            return null;
        }
    }

    //String activityName, int activityDuration, boolean isOutdoor, int energyLoss, int funFactor, int healthBenefit, int bondingLevel, String environmentType
    public String toString() {
        System.out.println("--------------------------------------");
        return "\nActivity Name:     " + this.activityName +
               "\nActivity Duration: " + this.activityDuration + 
               "\nIs Outdoor:        " + this.isOutdoor +
               "\nEnergy Loss:       " + this.energyLoss +
               "\nFun Factor:        " + this.funFactor + 
               "\nHealth Benefit:    " + this.healthBenefit + 
               "\nBonding Level:     " + this.bondingLevel + 
               "\nEnvironment:       " + this.environmentType;
    }
}
