package Encounters;


//This class uses Concepts II: encapsulation (private fields with public accessors), collections (Map for tracking item counts), abstraction (static utility methods), and controlled randomness for resource encounters based on planet context.


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ResourceEncounter {
	//Count how much of the items there is, like 3 medKits
	private static final Map<String, Integer> itemCountPerItem = new HashMap<>();
	//Count how many items the player pickedUp in total
	private static int totalItemsPicked;
	
	//ALL ITEMS
	private static final String[] availableItems = {
		    //  Useful Items
		    "Small Med Kit",             //Regains 25 Hp
		    "Medium Med Kit",		//Regains 75hp
		    "Big Med Kit",  		// Regains 200 hp
		    "Magic Potion",			//Recover 50% life
		    "Gamblers Potion",		//Lost 50 or wins 50 hp
		    
		    "Energy Cell",         // used for gaining shield
		    "Shield Booster",      // used for gaining 100 shield
		    "Suspicious Repair Kit", //Gains 50 or loses 50 shield
		    
		    
		    //DOUBLED TO INCREASE CHANCE
		    "Small Med Kit",             
		    "Medium Med Kit",		
		    "Big Med Kit",  		
		    "Magic Potion",			
		    "Gamblers Potion",		
		    
		    "Energy Cell",         
		    "Shield Booster",      
		    "Suspicious Repair Kit", 


		    // Collectables (they will be available in all planets with equal chance)
		    "Alien Artifact",      
		    "Alien Goo",           
		    "Alien Rock",          
		    "Alien Bones",         
		    "Meteor Shard",       
		    "Plasma Crystal",      
		    "Void Shell",          
		    "Scrap Metal",         
		    "Rusty Cogwheel",      
		    "Ancient Circuit",    
		    "Frozen Plant",        
		    "Volcanic Ember" ,
		    "Melted Glass",
		    "Rubber Duck",
		    "Quantum Marble",
		    "Shattered Hologram",
		    "Crystal Feather",
		    "Time Capsule Fragment",
		    "Zero-G Pebble",
		    "Synthetic Leaf",
		    "Echo Disk",
		    "Glowing Fungus",
		    "Mini Star Core",
		    "Alien Toothbrush"
		    
		};
	
	
	//Getters and Setters
	public int getTotalItemsPicked() {
		return totalItemsPicked;
	}
	public void setTotalItemsPicked(int totalItemsPicked) {
		this.totalItemsPicked = totalItemsPicked;
	}

	
	
	
	//PRINT ITEMS COLLECTED
	public static void printCollectedItems() {
		System.out.println("🎒 Items collected:");
		if (itemCountPerItem.isEmpty()) {
			System.out.println("No items Collected...");
		} else {
			for (Map.Entry<String, Integer> entry : itemCountPerItem.entrySet()) {
				System.out.println("- " + entry.getKey() + ": " + entry.getValue());
			}
		}
	}
	// Counts items picked up
	public static void collectItem(String itemName) {
		int count = itemCountPerItem.getOrDefault(itemName, 0);
		itemCountPerItem.put(itemName, count + 1);
		totalItemsPicked++;
	}
	
	//GETS A RANDOM ITEM
	public static String getRandomItem() {
		Random rng = new Random();
		int index = rng.nextInt(availableItems.length);
		return availableItems[index];
	}
	
	//----------------- TO MAKE PLANETS GIVE RNG LOOT
	public static String getPlanetItem(String planetName) {
	    String[] desertItems = {"Sand Water Bottle", "Sun-Baked Med Kit", "Dune Crystal"};
	    String[] iceItems = {"Frozen Core", "Ice Med Kit", "Thermal Blanket"};
	    String[] oceanItems = {"Seaweed Med Kit", "Water Crystal", "Coral Fragment"};
	    String[] stormItems = {"Volt Battery", "Charged Shield", "Lightning Vial"};
	    String[] jungleItems = {"Jungle Herb", "Camouflage Cloak", "Bio-Med Kit"};
	    String[] magmaItems = {"Magma Rock", "Lava-Proof Kit", "Fire Crystal"};

	    Random rng = new Random();

	    return switch (planetName.toLowerCase()) {
	        case "desert planet" -> desertItems[rng.nextInt(desertItems.length)];
	        case "ice world" -> iceItems[rng.nextInt(iceItems.length)];
	        case "ocean planet" -> oceanItems[rng.nextInt(oceanItems.length)];
	        case "storm realm" -> stormItems[rng.nextInt(stormItems.length)];
	        case "jungle moon" -> jungleItems[rng.nextInt(jungleItems.length)];
	        case "magma core" -> magmaItems[rng.nextInt(magmaItems.length)];
	        default -> getRandomItem(); // fallback to generic
	    };
	}

	


}//End of Class
