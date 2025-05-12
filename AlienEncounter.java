package Encounters;

//This class uses Concepts II: encapsulation (private fields, public getters/setters), polymorphism (different CrewMember and Alien types), abstraction (CrewMember actions and duties), exception handling (user input handling and battle flow), and collections for game tracking.


import java.util.Random;
import java.util.Scanner;

import AlienTypes.Alien;
import CrewTypes.CrewMember;
import FinalProject.PlayerObject;

public class AlienEncounter {
	
	static Random rng = new Random();
	private static int totalAliensKilled;
	
    public static void startFight(PlayerObject player, CrewMember crew, Alien alien, Scanner scan) {
        System.out.println("⚔️ BATTLE STARTS NOW!");
        //ALL OF THE IMPORTANT VARIABLES FOR THE FIGHT
        int alienHp = alien.getAlienHp();
        double alienPw = alien.getAlienPw();

        int crewHp = crew.getCrewHp();
        int crewSh = crew.getCrewShield();
        int crewPw = crew.getCrewPw();
        int crewAg = crew.getCrewAgility();
        //FIGHT LOOP where each scenario is a different function
        while (alienHp > 0 && crewHp > 0) {
            System.out.println("\nYour HP: " + crewHp + " | Shield: " + crewSh + " | Alien HP: " + alienHp);
            System.out.println("Choose an action: [1] Inventory  [2] Fight  [3] Special");
            String choice = scan.nextLine();

            switch (choice) {
                case "1" -> handleInventory(player, scan, crew);
                case "2" -> alienHp = handleFight(crewPw, alienHp, scan);
                case "3" -> {
                    boolean escaped = handleSpecial(crew, scan, alien, crewPw);
                    if (escaped) return; 
                }
                default -> {
                    System.out.println("❌ Invalid input. Choose 1, 2, or 3.");
                    continue;
                }
            }
            //Alien Attack
            if (alienHp > 0) {
                
                if (rng.nextInt(100) < 30) {
                //  30 porcent chance to use special
                    System.out.println("⚠️ The alien is charging up a special move!");
                    
                    int specialDmg = alien.performAlienSpecial();
                    crewHp -= specialDmg;
                    
                    scan.nextLine();
                    System.out.println("😣 You now have " + crewHp + " HP remaining.");
                    scan.nextLine();
                    
                } else { // Regular attack
                    
                    int damage = alienAttack(crewAg, alienPw);
                    if (damage > 0) {
                        if (crewSh > 0) {
                            int absorbed = Math.min(damage, crewSh);
                            crewSh -= absorbed;
                            damage -= absorbed;
                            System.out.println("🛡️ Shield absorbed " + absorbed + " damage!");
                        }
                        if (damage > 0) {
                            crewHp -= damage;
                            System.out.println("💥 The alien hit you for " + damage + " damage!");
                        }
                    } else {
                        System.out.println("🌀 You dodged the alien's attack!");
                    }
                }
            }
        }

        if (crewHp <= 0) {
            System.out.println("💀 You were defeated...");
            System.out.println("GAME OVER");
            scan.nextLine();
        } else {
            System.out.println("✅ Alien defeated!");
            totalAliensKilled++;
            player.setTotalXp(player.getTotalXp() + 50);
            System.out.println("✨ You earned 50 XP. Total XP: " + player.getTotalXp());
            scan.nextLine();
        }

        crew.setCrewHp(crewHp);
        crew.setCrewShield(crewSh);
    }
    //CASE 1 - INVENTROY
    private static void handleInventory(PlayerObject player, Scanner scan, CrewMember crew) {
    	if (player.getInventory().isEmpty()) {
    	    System.out.println("❌ Your inventory is empty. Returning to battle...");
    	    scan.nextLine();
    	    return;
    	}

    	player.printInventory();
    	System.out.println("What item do you want to use? 🧪 (Q to go back)");
    	String choosedItem = scan.nextLine();

    	if (choosedItem.equalsIgnoreCase("q")) {
    	    System.out.println("🔙 Returning to battle...");
    	    scan.nextLine();
    	    return;
    	}

    	// If player has the item, use it
    	if (player.hasItem(choosedItem)) {
    	    player.useItem(choosedItem, crew, rng);
    	    scan.nextLine();
    	} else {
    	    System.out.println("⚠️ You don't have that item!");
    	    scan.nextLine();
    	}
    }
    	
    //FIGHT
    private static int handleFight(int crewPw, int alienHp, Scanner scan) {
        System.out.println("🗡️ You attacked the alien!");
        int rngBaseDmg = rng.nextInt(2,5); //Crits mechanic where the player can give up to 5 times his base dmg
        int damage = crewPw * rngBaseDmg ; 
        alienHp -= damage;
        System.out.println("You dealt " + damage + " damage!");
        scan.nextLine();
        return alienHp;
    }
    //ACTIVATES CHARACTERS SPECIAL
    private static boolean handleSpecial(CrewMember crew, Scanner scan, Alien alien, int crewPw) {
    	if (crew instanceof CrewTypes.CrewScientist scientist) {
            scientist.analyzeAlien(alien); //Special Case for Scientist
            scan.nextLine(); 
            
        }
    	if (crew instanceof CrewTypes.CrewScout) {
            System.out.println("🏃 You escaped the fight using your Special Jump ability!"); //Scout special Case
            return true; // exit the fight
    	}
    	if (crew instanceof CrewTypes.CrewSecurityGuard guard && guard.isDoubleDamageNextAttack()) {
    	      crewPw *= 2;
    	      guard.resetDoubleDamage(); // Reset after use
    	      System.out.println("💥 DOUBLE SHOT! You dealt " + crewPw + " damage!");
    	}
        crew.performClassDuty();
        scan.nextLine();
        return false;
    }
    //ALIEN ATTACK + CHANCE OF MISSING ATTACK
    public static int alienAttack(int agility, double alienPw) {
        
        boolean dodged = Math.random() * 100 < (agility * 2);
        if (dodged) {
            System.out.println("🌀 You dodged the alien's attack!");
            return 0;
        } else {
            int damage = (int) alienPw;
            System.out.println("💥 The alien hit you for " + damage + " damage!");
            return damage;
        }
    }

    
    //GETTERS AND SETTERS FOR MY SPECIAL VARS
	public static int getTotalAliensKilled() {
		return totalAliensKilled;
	}
	public static void setTotalAliensKilled(int total) {
	    totalAliensKilled = total;
	}


} 