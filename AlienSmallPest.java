package AlienTypes;

//FINAL PROJECT– COSC 242503 – Professor McCurry
//Implemented by - Giovanni MIQUELIN

import java.util.Random;

public class AlienSmallPest extends Alien {

    public AlienSmallPest() {
        super(generatePower(), "AlienSMALLPest", generateHP());
    }

    private static double generatePower() {
        return new Random().nextDouble(0, 0.5);
    }

    private static int generateHP() {
        return new Random().nextInt(1, 20);
    }

    @Override
    public int performAlienSpecial() {
    	System.out.println("👀 The pest stares menacingly!");
        System.out.println("🧠 It creeps you out... You take 2 damage.");
        return 2;
        
    }
}
