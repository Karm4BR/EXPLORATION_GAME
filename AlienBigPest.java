package AlienTypes;

//FINAL PROJECT– COSC 242503 – Professor McCurry
//Implemented by - Giovanni MIQUELIN

import java.util.Random;

public class AlienBigPest extends Alien {
	
	public AlienBigPest() {
        super(generatePower(), "AlienBIGPest", generateHP());
    }

    private static double generatePower() {
        return new Random().nextDouble(10, 21);
    }

    private static int generateHP() {
        return new Random().nextInt(35, 101);
    }

    @Override
    public int performAlienSpecial() {
        System.out.println("👀 The Big Pest crushes the ground with brute force just by LOOKING at you!");
        System.out.println("💥 It deals 5 unavoidable emotional damage to you!");
        return 5;
    }

}
