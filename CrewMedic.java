package CrewTypes;


//FINAL PROJECT– COSC 242503 – Professor McCurry
//Implemented by - Giovanni MIQUELIN

public class CrewMedic extends CrewMember{

	public CrewMedic() {
		super("Medic", 125, 2, 100, 7, "Fast MedKit");
		
	}

	@Override
	public void performClassDuty() {
		int healedAmount = 40;
        crewHp += healedAmount;
        setCrewHp(crewHp);
        System.out.println("🩺 You used " + crewSpecialMoveName + "! Healed for " + healedAmount + " HP.");
        System.out.println("❤️ Current HP: " + crewHp);
		
	}
	@Override
	public void statsDisplay() {
		System.out.println("3 - " + crewName + "->" + " HP: " + crewHp + " Power/DMG: " + crewPw + " Shield: " +
	crewShield + " Agility: " + crewAgility + " SPECIAL HABILITY: " + crewSpecialMoveName +"\n-----------------------------------------------------");
		
	}

	@Override
	public void ClassDutyDisplay() {
		System.out.println("You selected " + crewName +"!");
		System.out.println("........Initiating Sytems.....Uploding root comands...");
		System.out.println("YOUR SPECIAL HABILITY IS: GAIN 40 hp   ");

	}
}
