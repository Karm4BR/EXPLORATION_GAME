package CrewTypes;

//FINAL PROJECT– COSC 242503 – Professor McCurry
//Implemented by - Giovanni MIQUELIN

public class CrewHeavy extends CrewMember {
	//Var for special hability
	private double dmgMultiplier = 1.0;
	
	
	public CrewHeavy() {
		super("Heavy", 300, 9, 100, 1, "Rage");
		
	}

	@Override
	public void performClassDuty() {
		 System.out.println("🔥 Rage is active: Your damage is permanently increased by 5%.");
		 dmgMultiplier += 0.05;
	}
	
	@Override
	public int getCrewPw() {
		int finalDmg = (int) (crewPw * dmgMultiplier);
        return  finalDmg;
    }
	
	@Override
	public void statsDisplay() {
		System.out.println("2 - " + crewName + "->" + " HP: " + crewHp + " Power/DMG: " + crewPw + " Shield: " +
	crewShield + " Agility: " + crewAgility + " SPECIAL HABILITY: " + crewSpecialMoveName +"\n-----------------------------------------------------");
		 
	}

	@Override
	public void ClassDutyDisplay() {
		System.out.println("You selected " + crewName +"!");
		System.out.println("........Initiating Sytems.....Uploding root comands...");
		System.out.println("YOUR SPECIAL HABILITY IS: Receive a 5% increase in DMG (it stacks) ");

	}
}
