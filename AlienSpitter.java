package AlienTypes;

//FINAL PROJECT– COSC 242503 – Professor McCurry
//Implemented by - Giovanni MIQUELIN

import java.util.Random;

public class AlienSpitter extends Alien {

	public AlienSpitter() {
        super(generatePower(), "AlienSpitter", generateHP());
    }

    private static double generatePower() {
        return new Random().nextDouble(10, 21);
    }

    private static int generateHP() {
        return new Random().nextInt(15, 51);
    }

    @Override
    public int performAlienSpecial() {
    	System.out.println("💦 The Spitter spits toxic acid!");
        System.out.println("💥 It deals 25 damage directly!");
        return 25;
    }

}
