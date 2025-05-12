package FinalProject;

import java.util.ArrayList;
import java.util.Random;

import CrewTypes.CrewMember;

public class PlayerObject {
	// Player Characteristics
	private String playerName;
	private int totalXp;
	private String playerEndRank;
	private ArrayList<String> inventory;
	
	

	// Where the player is in the map
	private int rowPosition;
	private int colPosition;

	// Player OBJECT
	public PlayerObject(String playerName, int totalXp, String playerEndRank, int colPosition, int rowPosition) {
		this.setPlayerName(playerName);
		this.setTotalXp(totalXp);
		this.setPlayerEndRank(playerEndRank);
		this.inventory = new ArrayList<>();
		this.setRowPosition(rowPosition);
		this.setColPosition(colPosition);
	}

	// GETTERS AND SETTERS
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getTotalXp() {
		return totalXp;
	}

	public void setTotalXp(int totalXp) {
		this.totalXp = totalXp;
	}

	public String getPlayerEndRank() {
		return playerEndRank;
	}

	public void setPlayerEndRank(String playerEndRank) {
		this.playerEndRank = playerEndRank;
	}

	public ArrayList<String> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<String> inventory) {
		this.inventory = inventory;
	}

	public int getColPosition() {
		return colPosition;
	}

	public void setColPosition(int colPosition) {
		this.colPosition = colPosition;
	}

	public int getRowPosition() {
		return rowPosition;
	}

	public void setRowPosition(int rowPosition) {
		this.rowPosition = rowPosition;
	}

	// Inventory Methods
	public void addToInventory(String item) {
		inventory.add(item);
	}

	public void printInventory() {
		if (inventory.isEmpty()) {
			System.out.println("Inventory is empty.");
		} else {
			System.out.println("Inventory:");
			for (String item : inventory) {
				System.out.println(item + "\\");
			}
		}
	}

	public boolean hasItem(String item) {
		return inventory.contains(item);
	}

	public void removeItem(String item) {
		inventory.remove(item);
	}

	// XP and RANK Methods

	
	
	//ITEM USAGE METHODS
	public void useItem(String itemName, CrewMember crew, Random rng) {
	    String item = itemName.toLowerCase();

	    switch (item) {
	        case "small med kit" -> {
	            crew.setCrewHp(crew.getCrewHp() + 25);
	            System.out.println("🩹 Healed 25 HP.");
	        }
	        case "medium med kit" -> {
	            crew.setCrewHp(crew.getCrewHp() + 75);
	            System.out.println("🩺 Healed 75 HP.");
	        }
	        case "big med kit" -> {
	            crew.setCrewHp(crew.getCrewHp() + 200);
	            System.out.println("🏥 Healed 200 HP.");
	        }
	        case "magic potion" -> {
	            int healed = (int) (crew.getCrewHp() * 0.5);
	            crew.setCrewHp(crew.getCrewHp() + healed);
	            System.out.println("✨ Magic Potion healed " + healed + " HP!");
	        }
	        case "gamblers potion" -> {
	            if (rng.nextBoolean()) {
	                crew.setCrewHp(crew.getCrewHp() + 50);
	                System.out.println("🎲 Lucky! Gained 50 HP!");
	            } else {
	                crew.setCrewHp(Math.max(0, crew.getCrewHp() - 50));
	                System.out.println("🎲 Oops! Lost 50 HP!");
	            }
	        }
	        case "energy cell" -> {
	            crew.setCrewShield(crew.getCrewShield() + 50);
	            System.out.println("🔋 Shield increased by 50!");
	        }
	        case "shield booster" -> {
	            crew.setCrewShield(crew.getCrewShield() + 100);
	            System.out.println("🛡️ Shield increased by 100!");
	        }
	        case "suspicious repair kit" -> {
	            if (rng.nextBoolean()) {
	                crew.setCrewShield(crew.getCrewShield() + 50);
	                System.out.println("🔧 Shield repaired +50!");
	            } else {
	                crew.setCrewShield(Math.max(0, crew.getCrewShield() - 50));
	                System.out.println("💥 Malfunction! Lost 50 shield.");
	            }
	        }
	        default -> {
	            System.out.println("⚠️ This item has no combat use or doesn't exist.");
	            return;
	        }
	    }

	    // Remove item only if it was usable
	    removeItem(itemName);
	    System.out.println("✅ Used \"" + itemName + "\" successfully.");
	}

}//END OF CODE

