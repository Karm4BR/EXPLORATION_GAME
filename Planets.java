package Planet_Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//This class uses Concepts II: interface implementation (SpaceShip), encapsulation with private fields and public methods, constructor logic in displayRandomPlanets, collections (List), and basic polymorphism through interface use and alien retrieval logic.


public class Planets implements SpaceShip {
	//Imports
	Scanner scan = new Scanner(System.in);
	
    // Planet names
    private String[] planetNames = {
        "desert planet",
        "ice world",
        "ocean planet",
        "storm realm",
        "jungle moon",
        "magma core"
    };
    
    //Check available planets
    private List<String> availablePlanets = new ArrayList<>();
    
 // Names for the Aliens depending on the planet
    private final List<String> alienTypes = List.of(
    	    "Sand Stalker",    // Desert Planet
    	    "Frost",    // Ice World
    	    "Drowning ", // Ocean Planet
    	    "Volt Fiend",      // Storm Realm
    	    "Viness",     // Jungle Moon
    	    "Ember"      // Magma Core
    	);  

    // Initiate Random
    Random rng = new Random();
    
    // Getter and Setter methods for Planets
    public String[] getPlanetNames() {
        return planetNames;
    }
    public void setPlanetNames(String[] planetNames) {
        this.planetNames = planetNames;
    }
   
    // Method to Display Random Planets
    public void displayRandomPlanets() {
        availablePlanets.clear(); 
        boolean[] used = new boolean[planetNames.length];
        int count = 0;

        while (count < 3) {
            int planet = rng.nextInt(planetNames.length);
            if (!used[planet]) {
                System.out.println("- " + planetNames[planet]);
                availablePlanets.add(planetNames[planet]); 
                used[planet] = true;
                count++;
            }
        }
    }

    //Return the SAME random planets
    public List<String> getAvailablePlanets() {
        return availablePlanets;
    }
    
    //Get Alien Name depending of the Planet
    public String getAlienByPlanet(String planetName) {
        for (int i = 0; i < planetNames.length; i++) {
            if (planetNames[i].equals(planetName)) {
                return alienTypes.get(i);
            }
        }
        return "Unknown Creature";
    }

    
    // INTERFACE METHOD
	@Override
	public void travelToPlanet(String planetName) {
		System.out.println("🌟 Initiating warp drive...(enter to continue travel)");
		scan.nextLine();
        System.out.println("🚀 Launching toward " + planetName + "...");
        scan.nextLine();
        System.out.println("🪐 Approaching the mysterious lands of " + planetName + "!");
        scan.nextLine();
        System.out.println("✨ Arrival complete. Welcome to " + planetName + "!\n");
        scan.nextLine();
        
        String alienName = getAlienByPlanet(planetName);
        System.out.println(" 👽  BEWARE 👽  , THIS PLACE IS FULL of " + alienName + " Alien Types");
        scan.nextLine();
        System.out.println("------------------------------------------");
		
	}
    
}//End of class

