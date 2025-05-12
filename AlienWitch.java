package AlienTypes;

import java.util.Random;

//FINAL PROJECT– COSC 242503 – Professor McCurry
//Implemented by - Giovanni MIQUELIN

public class AlienWitch extends Alien {

	public AlienWitch() {
        super(generatePower(), "AlienWitch", generateHP());
    }

    private static double generatePower() {
        return new Random().nextDouble(10, 31);
    }

    private static int generateHP() {
        return new Random().nextInt(50, 151);
    }

    @Override
    public int performAlienSpecial() {
    	Random rng = new Random();
    	int witchHeal = rng.nextInt(10,51);
    	System.out.println("🔮 The Alien Witch casts a dark ritual...");
        System.out.println("💫 She heals herself for " + witchHeal + " HP!");
        
        this.alienHp += witchHeal;
        
        return 0;
    }

	

}
