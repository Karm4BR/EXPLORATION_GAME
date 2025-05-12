package CrewTypes;


//FINAL PROJECT– COSC 242503 – Professor McCurry
//Implemented by - Giovanni MIQUELIN

public class CrewScientist extends CrewMember {

	public CrewScientist() {
		super("Scientist", 150, 3, 50, 7, "Kovalzki Analysis");
		
	}

	@Override
	public void performClassDuty() {
		
		
	}
	//SPECIAL SCIENTIST HABILITY, SINCE IT REQUIRES IMPORT OF ALIEN, I separated it from the Normal PerfomClassDuty 
	public void analyzeAlien(AlienTypes.Alien alien) {
	    System.out.println("🧪 " + crewSpecialMoveName + " Activated!");
	    System.out.println("🔬 Enemy Name: " + alien.getAlienName());
	    System.out.println("❤️ Enemy HP: " + alien.getAlienHp());
	    System.out.println("💥 Enemy Power: " + alien.getAlienPw());
	}

	
	@Override
	public void statsDisplay() {
		System.out.println("4 - " + crewName + "->" + " HP: " + crewHp + " Power/DMG: " + crewPw + " Shield: " +
	crewShield + " Agility: " + crewAgility + " SPECIAL HABILITY: " + crewSpecialMoveName +"\n-----------------------------------------------------");
		
	}

	@Override
	public void ClassDutyDisplay() {
		System.out.println("You selected " + crewName +"!");
		System.out.println("........Initiating Sytems.....Uploding root comands...");
		System.out.println("YOUR SPECIAL HABILITY IS: CAN SEE ENEMY BASE DMG (fun facts > combat)  ");

	}
	
	

}
