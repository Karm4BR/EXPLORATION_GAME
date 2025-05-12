package Encounters;

import java.util.Random;
import java.util.Scanner;

import CrewTypes.CrewMember;
import FinalProject.PlayerObject;

//This class uses Concepts II: encapsulation (private fields, public getters/setters), polymorphism (different CrewMember and Alien types), abstraction (CrewMember actions and duties), exception handling (user input handling and battle flow), and collections for game tracking.


public class KeyEncounter {
    static Random rng = new Random();

    public static void startKeyBossFight(PlayerObject player, CrewMember crew, Scanner scan) {
        System.out.println("\n🚨 FINAL BOSS: DESTRUCTOR OVERLORD IS HERE!");

        // Boss Stats
        int bossHp = rng.nextInt(300, 501);
        double bossPw = rng.nextInt(20, 41);
        int bossShield = 50;
        double bossDmgMultiplier = 1.0;

        int crewHp = crew.getCrewHp();
        int crewSh = crew.getCrewShield();
        int crewPw = crew.getCrewPw();
        int crewAg = crew.getCrewAgility();
        
        //BOSS FIGHT = SAME SYSTEM AS ALINE ENCOUNTER WITH A FEW DIFFERENCES
        while (bossHp > 0 && crewHp > 0) {
            System.out.println("\nYour HP: " + crewHp + " | Shield: " + crewSh + " | Boss HP: " + bossHp + " | Boss Shield: " + bossShield);
            System.out.println("Choose an action: [1] Inventory  [2] Fight  [3] Special");
            String choice = scan.nextLine();

            switch (choice) {
                case "1" -> {
                    if (player.getInventory().isEmpty()) {
                        System.out.println("❌ Your inventory is empty. Returning to battle...");
                        scan.nextLine();
                        continue;
                    }
                    player.printInventory();
                    System.out.println("What item do you want to use? (or Q to go back)");
                    String item = scan.nextLine();
                    if (item.equalsIgnoreCase("q")) continue;
                    player.useItem(item, crew, rng);
                }
                case "2" -> {
                    int baseDmg = crewPw * rng.nextInt(2, 5);
                    System.out.println("🗡️ You dealt " + baseDmg + " damage!");
                    if (bossShield > 0) {
                        int absorbed = Math.min(baseDmg, bossShield);
                        bossShield -= absorbed;
                        baseDmg -= absorbed;
                        System.out.println("🛡️ Boss shield absorbed " + absorbed + " damage!");
                    }
                    if (baseDmg > 0) bossHp -= baseDmg;
                    scan.nextLine();
                }
                case "3" -> {
                    if (crew instanceof CrewTypes.CrewScientist scientist) {
                        System.out.println("🧪 Scanning Destructor Overlord...");
                        System.out.println("HP: " + bossHp + " | DMG: " + (int)(bossPw * bossDmgMultiplier));
                        System.out.println("Special Abilities: +5% DMG | Heal 30HP | Deal 30DMG");
                        scan.nextLine();
                    } else if (crew instanceof CrewTypes.CrewScout) {
                        System.out.println("🏃 You cannot escape the FINAL BOSS!");
                        scan.nextLine();
                    } else {
                        crew.performClassDuty();
                        scan.nextLine();
                    }
                }
                default -> System.out.println("❌ Invalid choice. Try again.");
            }

            if (bossHp > 0) {
                if (rng.nextInt(100) < 30) {
                    int specialType = rng.nextInt(3);
                    switch (specialType) {
                        case 0 -> {
                            bossDmgMultiplier += 0.2;
                            System.out.println("🔥 Destructor Overlord roars! Its power increases by 20%!");
                        }
                        case 1 -> {
                            bossHp += 50;
                            System.out.println("💉 Destructor Overlord regenerates 50 HP!");
                        }
                        case 2 -> {
                            System.out.println("💣 Destructor Overlord releases a massive blast: 30 DMG!");
                            if (crewSh > 0) {
                                int absorbed = Math.min(30, crewSh);
                                crewSh -= absorbed;
                                crewHp -= (30 - absorbed);
                            } else {
                                crewHp -= 30;
                            }
                        }
                    }
                    scan.nextLine();
                } else {
                    int dmg = (int)(bossPw * bossDmgMultiplier);
                    System.out.println("👊 Destructor Overlord attacks for " + dmg + " damage!");
                    if (crewSh > 0) {
                        int absorbed = Math.min(dmg, crewSh);
                        crewSh -= absorbed;
                        dmg -= absorbed;
                    }
                    crewHp -= dmg;
                    scan.nextLine();
                }
            }
        }

        if (crewHp <= 0) {
            System.out.println("💀 You were defeated by the Destructor Overlord...");
            System.out.println("GAME OVER");
            return;
        } else {
            System.out.println("🏆 You defeated the Destructor Overlord and recovered the CAPTAIN'S KEY!");
            scan.nextLine();
            player.setTotalXp(player.getTotalXp() + 1000);
            System.out.println("✨ +1000 XP! Total XP: " + player.getTotalXp());
            scan.nextLine();
            System.out.println("\n🎉 CONGRATULATIONS, COMMANDER!");
    	    System.out.println("🪐 You recovered the Captain’s Key and stopped the alien invasion.");
    	    System.out.println("🚀 MISSION SUCCESSFUL!\nThe End............");
    	    scan.nextLine();
        }

        crew.setCrewHp(crew.getMaxHp());
        crew.setCrewShield(crew.getMaxShield());
    }
}

