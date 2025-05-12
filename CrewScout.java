package CrewTypes;


//FINAL PROJECT– COSC 242503 – Professor McCurry
//Implemented by - Giovanni MIQUELIN


public class CrewScout extends CrewMember{

	public CrewScout() {
		super("Scout", 100, 8, 20, 10, "ESCAPE");
		
	}

	@Override
	public void performClassDuty() { //This way because Scout is special and I was lazy to reput the print here
		
		
	}
	@Override
	public void statsDisplay() {
		System.out.println("5 - " + crewName + "->" + " HP: " + crewHp + " Power/DMG: " + crewPw + " Shield: " +
	crewShield + " Agility: " + crewAgility + " SPECIAL HABILITY: " + crewSpecialMoveName +"\n-----------------------------------------------------");
		
	}

	@Override
	public void ClassDutyDisplay() {
		System.out.println("You selected " + crewName +"!");
		System.out.println("........Initiating Sytems.....Uploding root comands...");
		System.out.println("YOUR SPECIAL HABILITY IS:  YOU CAN ESCAPE FIGHTS   ");

	}
	

}
