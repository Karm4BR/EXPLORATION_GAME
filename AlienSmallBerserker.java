package AlienTypes;

//FINAL PROJECT– COSC 242503 – Professor McCurry
//Implemented by - Giovanni MIQUELIN

import java.util.Random;

public class AlienSmallBerserker extends Alien {
	public AlienSmallBerserker() {
        super(generatePower(), "AlienSMALLBerserker", generateHP());
    }

    private static double generatePower() {
        return new Random().nextDouble(10, 25);
    }

    private static int generateHP() {
        return new Random().nextInt(10, 51);
    }

    @Override
    public int performAlienSpecial() {
    	int extraDamage = 10; // Random damage between 10 and 25
        System.out.println("💢 The Small Berserker goes berserk and attacks!");
        System.out.println("💥 Deals an " + extraDamage + " damage!");
    	return 10;
        
    }
	

}
