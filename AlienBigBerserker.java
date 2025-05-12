package AlienTypes;

//FINAL PROJECT– COSC 242503 – Professor McCurry
//Implemented by - Giovanni MIQUELIN
import java.util.Random;

public class AlienBigBerserker extends Alien {
	
	//RNG OBJECT
	Random rng = new Random();
		public AlienBigBerserker() {
	        super(generatePower(), "AlienSMALLBerserker", generateHP());
	    }

	    private static double generatePower() {
	        return new Random().nextDouble(30, 41);
	    }

	    private static int generateHP() {
	        return new Random().nextInt(100,201 );
	    }

	    @Override
	    public int performAlienSpecial() {
	    	int extraDamage = rng.nextInt(10, 26); // Random damage between 10 and 25
	        System.out.println("💢 The Big Berserker goes berserk and attacks!");
	        System.out.println("💥 He Deals " + extraDamage + " damage!");
	        
	        return extraDamage;
	        
	    }
}




