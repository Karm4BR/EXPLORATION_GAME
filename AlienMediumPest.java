package AlienTypes;

//FINAL PROJECT– COSC 242503 – Professor McCurry
//Implemented by - Giovanni MIQUELIN

import java.util.Random;

public class AlienMediumPest extends Alien{
	
	public AlienMediumPest() {
        super(generatePower(), "AlienMEDIUMPest", generateHP());
    }

    private static double generatePower() {
        return new Random().nextDouble(0.5, 2);
    }

    private static int generateHP() {
        return new Random().nextInt(5, 35);
    }

    @Override
    public int performAlienSpecial() {
    	System.out.println("👀 The medium pest stares with hostility...");
        System.out.println("🧠 You feel a strange psychic pressure. You take 2 damage!");
		return 2;
    }

}
