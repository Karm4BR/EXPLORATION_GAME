package CrewTypes;


//FINAL PROJECT– COSC 242503 – Professor McCurry
//Implemented by - Giovanni MIQUELIN

public class CrewGOD extends CrewMember{

	public CrewGOD() {
		super("GodMode", 9999999, 999999, 999999, 0, "Obliterate");
		
	}

	@Override
	public void performClassDuty() {
		System.out.println("🕊️ GOD DOES NOTHING... JUST WATCHES AND PITIES THE CREATURE BEFORE HIM.");

		
	}

	@Override
	public void statsDisplay() {
		System.out.println(" 10 - Easy mode/Developer Mode");
		
	}

	@Override
	public void ClassDutyDisplay() {
		System.out.println("You selected " + crewName +"!");
		System.out.println("........Initiating Sytems.....Uploding root comands...");
		System.out.println("You are invincible to explore the whole game");
		
	}
	
	

}
