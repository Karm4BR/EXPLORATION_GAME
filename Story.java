package FinalProject;

//This class uses Concepts II: constructor, getters/setters, encapsulation, collections (ArrayList for inventory), controlled access, and item-use logic with exception-safe flow using switch and random.


import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import AlienTypes.Alien;
import AlienTypes.AlienFactory;
import CrewTypes.CrewEngie;
import CrewTypes.CrewGOD;
import CrewTypes.CrewHeavy;
import CrewTypes.CrewMedic;
import CrewTypes.CrewMember;
import CrewTypes.CrewScientist;
import CrewTypes.CrewScout;
import CrewTypes.CrewSecurityGuard;
import Encounters.AlienEncounter;
import Encounters.KeyEncounter;
import Encounters.ResourceEncounter;
import Planet_Map.PlanetMaps;
import Planet_Map.Planets;
import Planet_Map.PlanetMaps.LocationType;

public class Story {
	// Create basic objects for functioning
	Scanner scan = new Scanner(System.in);
	Random rng = new Random();

	// Create Objects for story
	private PlayerObject player;
	private CrewMember chosenMember;
	Planets planet = new Planets();
	

	public void introduction() {
		
		try {
			// Begginign variables
			boolean restart = true;
	
			while (restart) {
				// MAIN STORYLINE
				System.out.println("📡 ...Static...");
				System.out.println("(PRESS ENTER TO CONTINUE THE GAME)");
				scan.nextLine();
				System.out.println("👤 \"Helloo?... Is anyone there?...\"");
				scan.nextLine();
				System.out.println("🔦 *Signal stabilizing...*");
				System.out.println("\n💾 [Press ENTER to initialize comms]");
				scan.nextLine();
	
				System.out
						.println("🧑‍🚀 \"Good... You're alive. I thought all Crew Members were lost in the invasion...\"");
				System.out.println(
						"🆘 Our Captain was taken by the aliens. Without the 🔑 Captain's Key, we can't seal the warp gate.");
				System.out.println("💥 The alien threat is spreading. You're the only one left who can stop this.");
				System.out.println("\n⚠️ [Press ENTER to accept your mission]");
				scan.nextLine();
	
				System.out.print("📝 Before we begin, tell me your name, soldier: (ENTER UR NAME) ");
				String playerName = scan.nextLine();
	
				// Create player object
				player = new PlayerObject(playerName, 0, "", 0, 0);
	
				System.out.println("\n🧠 Welcome, Commander " + playerName + ".");
				System.out.println("🛠️ We’ve deployed robotic avatars for remote planetary exploration.");
				System.out.println("🤖 I can connect you to one now... but only one. Choose wisely.");
				System.out.println("\n⚙️ [Press ENTER to proceed to robot selection]");
				scan.nextLine();
	
				// Display all class options with their stats
				new CrewMedic().statsDisplay();
				new CrewEngie().statsDisplay();
				new CrewScientist().statsDisplay();
				new CrewSecurityGuard().statsDisplay();
				new CrewHeavy().statsDisplay();
				new CrewScout().statsDisplay();
				new CrewGOD().statsDisplay();
	
				// Start class selection loop
				chosenMember = null;
	
				while (chosenMember == null) {
					System.out.print("\nType the class number to select your Crew Member: ");
	
					if (scan.hasNextInt()) {
						int chosenClass = scan.nextInt();
						scan.nextLine(); // Clear the buffer
	
						switch (chosenClass) {
						case 1 -> chosenMember = new CrewEngie();
						case 2 -> chosenMember = new CrewHeavy();
						case 3 -> chosenMember = new CrewMedic();
						case 4 -> chosenMember = new CrewScientist();
						case 5 -> chosenMember = new CrewScout();
						case 6 -> chosenMember = new CrewSecurityGuard();
						case 10 -> chosenMember = new CrewGOD();
						default -> System.out.println("❌ Invalid class number. Please try again.");
						}
	
					} else {
						System.out.println("❌ Invalid input. Please enter a number.");
						scan.nextLine(); // Clear invalid input
					}
				}
	
				chosenMember.ClassDutyDisplay();
	
				System.out.println("\nMission Begins...... (press Enter to continue / type -1 to restart)");
				String userInput = scan.nextLine();
				// In case you want to restart the game and choose another class
				restart = userInput.equals("-1");
	
			}
			System.out.println("\n🔧 SYSTEM NOTICE: Navigation system unstable...");
			System.out.println("🌍 You're cleared to explore planets — but due to technical faults,");
			System.out.println("⚠️ You may only choose **3 planets per mission cycle**.");
			System.out.println("\n🛰️ Choose wisely, Commander.");
			System.out.println("🕹️ [Press ENTER to begin planetary selection]");
			scan.nextLine();
	
			beginExplorationLoop();
		}  catch (InputMismatchException ime) {
		    System.out.println(" Invalid input type. Please enter the correct format.");
		    ime.printStackTrace();

		} catch (IllegalStateException ise) {
		    System.out.println(" Scanner is closed or not ready.");
		    ise.printStackTrace();

		} catch (NullPointerException npe) {
		    System.out.println(" A required object was not initialized properly.");
		    npe.printStackTrace();

		} catch (IndexOutOfBoundsException ioobe) {
		    System.out.println(" Tried to access an invalid index.");
		    ioobe.printStackTrace();

		} catch (Exception e) {
		    System.out.println(" General error in introduction.");
		    e.printStackTrace();
		}

	}// End of Introduction

	// Will show after the introduction
	public String ExplorePrologue() {
		 try {
		        System.out.println("\n---------🌍PLANETS AVAILABLE🌍---------");
		        planet.displayRandomPlanets();

		        List<String> validPlanets = planet.getAvailablePlanets();

		        while (true) {
		            try {
		                String PlanetChoosen = scan.nextLine().toLowerCase();

		                if (validPlanets.contains(PlanetChoosen)) {
		                    planet.travelToPlanet(PlanetChoosen);
		                    return PlanetChoosen;
		                } else {
		                    System.out.print("\t❌ Invalid planet name. Please type exactly one of the listed planets!\n");
		                }
		            } catch (NullPointerException npe) {
		                System.out.println("🚫 Planet name input was null.");
		                npe.printStackTrace();
		            } catch (Exception e) {
		                System.out.println("⚠️ Unexpected input error. Please try again.");
		                e.printStackTrace();
		            }
		        }

		    } catch (IllegalStateException ise) {
		        System.out.println("📛 Scanner is not ready.");
		        ise.printStackTrace();
		    } catch (Exception e) {
		        System.out.println("❌ General error in ExplorePrologue.");
		        e.printStackTrace();
		    }
		 return "unknown"; //In case Something goes WRONG
	}// End of Explore

	public void PlanetExploration() {
		try {
	        // Chosen Planet
	        String chosenPlanet = ExplorePrologue();

	        System.out.println("Analyzing Terrain.......(ENTER TO CONTINUE)");

	        System.out.println("READ THE MAP SUBTITLES FIRST " + player.getPlayerName());

	        // MAP SUBTITLES
	        try {
	            System.out.println("🤖 - YOUR ROBOT");
	            scan.nextLine();
	            System.out.println("👽 - Alien, good for gaining XP, or avoid to not lose health...");
	            scan.nextLine();
	            System.out.println("🔍 - Clue where the Key is... ");
	            scan.nextLine();
	            System.out.println("🚀 - Leave Point, go there to escape the planet...");
	            scan.nextLine();
	            System.out.println("R - Resources, can be used for Healing and Shield + Achievements...");
	            scan.nextLine();
	            System.out.println(" 🔑 - Where the captain Key resides...\n");
	            scan.nextLine();
	            System.out.println("----------------------------------");
	        } catch (Exception e) {
	            System.out.println("⚠️ Error during map subtitles display.");
	            e.printStackTrace();
	        }

	        // Setting Player Position
	        player.setRowPosition(0);
	        player.setColPosition(0);

	        PlanetMaps maps = new PlanetMaps(chosenPlanet);
	        maps.setLocation(0, 0, LocationType.PLAYER);
	        maps.displayMap();

	        if (chosenMember instanceof CrewGOD) {
	            StartGodMovementLoop(maps, player, chosenPlanet);
	        }

	        startMovementLoop(maps, player, chosenPlanet);

	    } catch (NullPointerException npe) {
	        System.out.println("🚫 Critical null error during planet exploration.");
	        npe.printStackTrace();
	    } catch (Exception e) {
	        System.out.println("❌ General error in PlanetExploration.");
	        e.printStackTrace();
	    }
	

	}// END OF PLANET EXPLORATION

	// -----------------PLAYER MOVEMENT STARTS HERE--------------------------------
	public void startMovementLoop(PlanetMaps map, PlayerObject player, String chosenPlanet) {
		try {
			while (true) {
				System.out.println("Use W (up), A (left), S (down), D (right) or Q to quit the GAME:");
				String input = scan.nextLine().toUpperCase();

				int row = player.getRowPosition();
				int col = player.getColPosition();

				map.setLocation(row, col, LocationType.NOTHING);

				switch (input) {
					case "W" -> row = Math.max(0, row - 1);
					case "S" -> row = Math.min(map.getRows() - 1, row + 1);
					case "A" -> col = Math.max(0, col - 1);
					case "D" -> col = Math.min(map.getCols() - 1, col + 1);
					case "Q" -> {
						System.out.println("👋 Exiting movement... ");
						System.out.println("WAS GOOD WHILE IT LASTED :( ");
						return;
					}
					default -> System.out.println("❌ Invalid input. Use W/A/S/D/Q.");
				}

				player.setRowPosition(row);
				player.setColPosition(col);
				LocationType Ptile = map.getLocation(row, col);

				switch (Ptile) {
					case ALIEN -> {
						Alien alien = AlienFactory.getRandomAlien();
						System.out.println("👽 You encountered a " + planet.getAlienByPlanet(chosenPlanet) + " (" + alien.getAlienName() + ")! Prepare for battle.");
						scan.nextLine();
						AlienEncounter.startFight(player, chosenMember, alien, scan);
					}
					case RESOURCE -> {
						String item = ResourceEncounter.getPlanetItem(chosenPlanet);
						System.out.println("🛠️ You found: " + item);
						System.out.print("Would you like to pick it up? (y/n): ");
						String choice = scan.nextLine().trim().toLowerCase();

						if (choice.equals("y")) {
							player.addToInventory(item);
							ResourceEncounter.collectItem(item);
							System.out.println("✅ " + item + " added to your inventory.");
						} else {
							System.out.println("❌ You left the " + item + " behind.");
						}
						scan.nextLine();
					}
					case CLUE -> {
						System.out.println("🧠 You found a clue. It points toward the key!");
						System.out.println("\"I light up the sky, then make a loud sound.\nYou see me in storms, when rain comes down.\nWhat am I?\" 🌩️🤔");
						scan.nextLine();
					}
					case KEY -> {
						System.out.println("🔑 YOU FOUND THE CAPTAIN’S KEY! Mission complete?");
						scan.nextLine();
						KeyEncounter.startKeyBossFight(player, chosenMember, scan);
						showCredits();
					}
					case LEAVE -> {
						System.out.println("🚀 You found a Leave Point.");
						System.out.print("Do you want to leave this planet? (y/n): ");
						String leaveChoice = scan.nextLine().trim().toLowerCase();

						if (leaveChoice.equals("y")) {
							System.out.println("🛸 Leaving planet and returning to exploration...");
							return;
						} else {
							System.out.println("🧭 Staying on the planet. Keep exploring!");
						}
					}
					case NOTHING -> {
						System.out.println("🛤️ You've already been here.");
						scan.nextLine();
					}
					case EMPTY -> {
						System.out.println("📡 It's just empty space.");
						scan.nextLine();
					}
					case PLAYER -> {
						System.out.println("🤖 That’s you!");
						scan.nextLine();
					}
				}

				map.setLocation(row, col, LocationType.PLAYER);
				map.displayMap();
			}
		} catch (java.util.InputMismatchException e) {
			System.out.println("❗ Input type mismatch. Please use proper keys like W/A/S/D or Q.");
			scan.nextLine(); // Clear buffer
		} catch (NullPointerException e) {
			System.out.println("🚫 Something went wrong (missing data or null reference). Please check your map or player setup.");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("❌ Unexpected error occurred during movement.");
			e.printStackTrace();
		}

	}// END OF LOOPED PLAYER MOVMENT

	// GOD MOVEMENT- SAME AS PLAYER BUT WITH A ONE TIME TP to move quickly across The map ------------------
	public void StartGodMovementLoop(PlanetMaps maps, PlayerObject player, String chosenPlanet) {
	    System.out.println("💫 GOD MODE: Choose your teleport location.");

	    System.out.print("Enter row (0 to " + (maps.getRows() - 1) + "): ");
	    int tpRow = scan.nextInt();
	    System.out.print("Enter column (0 to " + (maps.getCols() - 1) + "): ");
	    int tpCol = scan.nextInt();
	    scan.nextLine();

	    // Validate coordinates
	    if (tpRow >= 0 && tpRow < maps.getRows() && tpCol >= 0 && tpCol < maps.getCols()) {
	        maps.setLocation(player.getRowPosition(), player.getColPosition(), LocationType.NOTHING);
	        player.setRowPosition(tpRow);
	        player.setColPosition(tpCol);
	        System.out.println("🚀 Teleported to (" + tpRow + ", " + tpCol + ")!");
	        scan.nextLine();
	    } else {
	        System.out.println("❌ Invalid teleport coordinates. Staying in place.");
	    }

	    int row = player.getRowPosition();
	    int col = player.getColPosition();
	    LocationType Ptile = maps.getLocation(row, col);

	    // ----------- CASES OF ENCOUNTER ---------
	    switch (Ptile) {
	        case ALIEN -> {
	            Alien alien = AlienFactory.getRandomAlien();
	            System.out.println("👽 You encountered a " + planet.getAlienByPlanet(chosenPlanet) + " (" + alien.getAlienName() + ")! Prepare for battle.");
	            scan.nextLine();
	            AlienEncounter.startFight(player, chosenMember, alien, scan);
	        }

	        case RESOURCE -> {
	        	 String item = ResourceEncounter.getPlanetItem(chosenPlanet); //  Loot based on planet
	        	    System.out.println("🛠️ You found: " + item);
	        	    System.out.print("Would you like to pick it up? (y/n): ");
	        	    String choice = scan.nextLine().trim().toLowerCase();

	        	    if (choice.equals("y")) {
	        	        player.addToInventory(item);
	        	        ResourceEncounter.collectItem(item);
	        	        System.out.println("✅ " + item + " added to your inventory.");
	        	    } else {
	        	        System.out.println("❌ You left the " + item + " behind.");
	        	    }
	        	    scan.nextLine(); 
	        }

	        case CLUE -> {
	            System.out.println("🧠 You found a clue. It points toward the key!");
	            System.out.println("\"I light up the sky, then make a loud sound.\nYou see me in storms, when rain comes down.\nWhat am I?\" 🌩️🤔");
	            scan.nextLine();
	        }

	        case KEY -> {
	            System.out.println("🔑 YOU FOUND THE CAPTAIN’S KEY! Mission complete?");
	            scan.nextLine();
	            KeyEncounter.startKeyBossFight(player, chosenMember, scan);
	            showCredits();
	            return;
	        }

	        case LEAVE -> {
	            System.out.println("🚀 You found a Leave Point.");
	            System.out.print("Do you want to leave this planet? (y/n): ");
	            String leaveChoice = scan.nextLine().trim().toLowerCase();

	            if (leaveChoice.equals("y")) {
	                System.out.println("🛸 Leaving planet and returning to exploration...");
	                return;
	            } else {
	                System.out.println("🧭 Staying on the planet. Keep exploring!");
	            }
	        }

	        case NOTHING -> {
	            System.out.println("🛤️ You've already been here.");
	            scan.nextLine();
	        }

	        case EMPTY -> {
	            System.out.println("📡 It's just empty space.");
	            scan.nextLine();
	        }

	        case PLAYER -> {
	            System.out.println("🤖 That’s you!");
	            scan.nextLine();
	        }
	    }

	    // Update map
	    maps.setLocation(row, col, LocationType.PLAYER);
	    maps.displayMap();
	}


	// RESPONSIBLE FOR THE EXPLORATION LOOp
	public void beginExplorationLoop() {
		int planetsExplored = 0;
		int fuel = 6;

		try {
		    while (planetsExplored < 7) {
		        PlanetExploration(); // Explore one planet
		        planetsExplored++;

		        if (planetsExplored < 7) {
		            System.out.println("⛽ Fuel remaining: " + (fuel - planetsExplored));
		            System.out.println("Press ENTER to travel to the next planet...");
		            scan.nextLine();
		        } else {
		            System.out.println("\n🚫 YOU'VE RUN OUT OF FUEL!");
		            System.out.println("❌ GAME OVER: You failed to recover the Captain’s Key in time...");
		            showCredits(); // Credits on fail
		        }
		    }
		} catch (NullPointerException e) {
		    System.out.println("❗ A required game object was missing during exploration.");
		    e.printStackTrace();
		} catch (IllegalStateException e) {
		    System.out.println("! Illegal game state encountered. Please restart the game.");
		    e.printStackTrace();
		} catch (Exception e) {
		    System.out.println("! Unexpected error during exploration loop.");
		    e.printStackTrace();
		}

	}// END OF THE EXPLORATION LOOp
	
	
	//CREDITS
	public void showCredits() {
	   
		try {
		    System.out.println("\n=== 🧾 FINAL STATS ===");
		    System.out.println("✨ Total XP Gained: " + player.getTotalXp());
		    System.out.println("🎒 Total Items Collected: " + player.getInventory().size());
		    System.out.println("👾 Aliens Defeated: " + AlienEncounter.getTotalAliensKilled());
		    scan.nextLine();

		    showAchievements(player);

		    scan.nextLine();
		    System.out.println("\n=== GAME CREDITS ===");
		    System.out.println("🔧 Developer: Giovanni Miquelin");
		    System.out.println("🎨 Design: GIO + MyFriends");
		    System.out.println("🧪 Testing: Brave Players and a Lot of Patience");
		    System.out.println("💡 Inspiration: Classic Text-Based RPGs");
		    System.out.println("💾 Powered by Hoping a good Grade :)");
		    scan.nextLine();

		    System.out.println("\nThank you for playing! 🌌\n");
		    System.exit(0); //  Exit game

		} catch (NullPointerException e) {
		    System.out.println("❗ Error: Missing player data during credits display.");
		    e.printStackTrace();
		} catch (Exception e) {
		    System.out.println("! Unexpected error during credits screen.");
		    e.printStackTrace();
		}

	}
	
	public void showAchievements(PlayerObject player) {
		try {
		    int xp = player.getTotalXp();
		    int items = player.getInventory().size();
		    int aliens = AlienEncounter.getTotalAliensKilled();

		    System.out.println("\n🏆 === ACHIEVEMENTS UNLOCKED ===");

		    // XP-Based Achievements
		    if (xp >= 1500) System.out.println("🌟 XP Master: Earned 1000+ XP!");
		    if (xp >= 1000) System.out.println("💪 Battle-Hardened: Earned 500+ XP.");
		    if (xp < 1000) System.out.println("🛸 Rookie Explorer: Keep training!");

		    // Alien Kill Achievements
		    if (aliens >= 20) System.out.println("👽 Alien Slayer: Defeated 20+ aliens!");
		    if (aliens >= 10 && aliens < 20) System.out.println("🔫 Exterminator: Defeated 10+ aliens.");
		    if (aliens > 1) System.out.println("😨 Evader: More running than fighting!");
		    if (aliens <= 1) System.out.println("PACIFIST: What a warm Hearth!");

		    // Item Collection Achievements
		    if (items >= 15) System.out.println("🎒 Hoarder Supreme: Collected 15+ items.");
		    if (items >= 5 && items < 15) System.out.println("📦 Resourceful: Collected some useful gear.");
		    if (items < 5) System.out.println("🧼 Minimalist: Traveled light!");

		    // Bonus
		    if (aliens >= 15 && xp >= 1500 && items >= 20)
		        System.out.println("🏅 LEGENDARY COMMANDER: You did it all!");

		} catch (NullPointerException e) {
		    System.out.println("❗ Achievement display failed: Missing player data.");
		    e.printStackTrace();
		} catch (Exception e) {
		    System.out.println("❌ Unexpected error in achievements display.");
		    e.printStackTrace();
		}

	}


}// END OF CLASS
