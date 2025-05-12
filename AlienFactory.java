package AlienTypes;

//FINAL PROJECT– COSC 242503 – Professor McCurry
//Implemented by - Giovanni MIQUELIN

import java.util.Random;

public class AlienFactory {
	public static Alien getRandomAlien() {
		
		//CLASS FOR CHOSING/PICKING A RANDOM ALIEN
	        Random rng = new Random();
	        int roll = rng.nextInt(100); // 0–99

	        if (roll < 5) return new AlienWitch();                  // 5%
	        else if (roll < 20) return new AlienSpitter();          // 15%
	        else if (roll < 55) return new AlienSmallPest();        // 35%
	        else if (roll < 60) return new AlienBigBerserker();     // 5%
	        else if (roll < 70) return new AlienSmallBerserker();   // 10%
	        else if (roll < 80) return new AlienBigPest();          // 10%
	        else return new AlienMediumPest();                      // 20%
	    }

}
