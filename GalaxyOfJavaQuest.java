package FinalProject;

//FINAL PROJECT– COSC 242503 – Professor McCurry
//Implemented by - Giovanni MIQUELIN

public class GalaxyOfJavaQuest {
	public static void main(String[] args) {
		Story story = new Story();
		story.introduction();
		
		//TODO This is the General Comment and CODE EXPLANATION
		
		//THIS IS THE CLASS THAT STARTS EVERYTHING
		
		/**
		 * 🌌 Galaxy of JavaQuest – Game Story and Logic 🌌
		 *
		 * This is the main part of the game that runs the story, lets the player explore planets,
		 * and fight aliens. The player is the last crew member alive after an alien attack, and 
		 * their goal is to find the Captain's Key and save the galaxy.
		 * 
		 
		 * === HOW IT WORKS ===
		 * - The game starts with a story into Where the player types their name.
		 * - The player picks one crew member class (like Medic Scout Heavy, etc.)
		 *   Each class has different health, power, shield, and a special move.
		 * - The player sees 3 randon planets and chooses one to explore.
		 * - On each planet, a grid map is shown. The player moves around using W/A/S/D.
		 *   The map has:
		 *     👽 Aliens to fight
		 *     🔍 Clues to find the key
		 *     R - Resources (items to heal or protect)
		 *     🔑 The Captain's Key (needed to win)
		 *     🚀 Leave points to exit the planet
		 *
		 * === WHAT HAPPENS ON EACH TILE ===
		 * - Player might fight a random alien in turn-based combat.
		 * - Player can find items and choose to keep or leave them.
		 * - If the player finds the key, a boss fight begins.
		 * - After winning, the game shows XP, items collected, aliens kiled, and gives acievements.
		 *
		 * === HOW THE CODE IS SET UP ===
		 * - PlayerObject: tracks the players name, XP, position, and items.
		 * - CrewMember (and subclasses): defines player classes with their powers.
		 * - PlanetMaps: creates and shows the map for each planet.
		 * - Planets: lists planet names and which alien is on each.
		 * - Alien: basic enemy with HP and attack logic.
		 * - AlienEncounter: handls batle logic with options to fight, use items, or special moves.
		 * - ResourceEncounter: gives planet-specific items and counts what the player collects.
		 * - KeyEncounter: starts the final boss battle.
		 * - Story: main game loop (intro, movment, exploration, fights, ending).
		 *
		 * === COOL FEATURES ===
		 * - Fun text and emojis make it more interactive.
		 * - Player chooses their path through the galaxy.
		 * - Battles include fighting, using items, or using class powers.
		 * - Ending shows how well the player did.
		 * - GOD mode exists for testing or quick play.
		 * - Errors (like bad input) are handled with try/catch to avoid crashes.
		 *
		 * 
		 */

		
		
		
		
	}//End of main

}//End of code
