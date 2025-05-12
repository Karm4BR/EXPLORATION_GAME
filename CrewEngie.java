package CrewTypes;

//FINAL PROJECT– COSC 242503 – Professor McCurry
//Implemented by - Giovanni MIQUELIN

import java.util.Scanner;

public class CrewEngie extends CrewMember {
	//Scanner object
	Scanner scan = new Scanner(System.in);

	public CrewEngie() {
		super("Engienier", 200, 5, 50, 5, "Electric Field Stabilization");
		
	}

	@Override
	public void performClassDuty() {
		crewShield += 20;
		
		setCrewShield(crewShield);
		
        System.out.println("⚡ " + crewSpecialMoveName + " activated! Gained +20 Shield.");
        System.out.println("🛡️ Current Shield: " + crewShield);
        
	}

	@Override
	public void statsDisplay() {
		System.out.println("1 - " + crewName + "->" + " HP: " + crewHp + " Power/DMG: " + crewPw + " Shield: " +
	crewShield + " Agility: " + crewAgility + " SPECIAL HABILITY: " + crewSpecialMoveName +"\n-----------------------------------------------------");
		
	}

	@Override
	public void ClassDutyDisplay() {
		System.out.println("You selected " + crewName +"! (Enter to continue)");
		scan.nextLine();
		System.out.println("........Initiating Sytems.....Uploding root comands...");
		System.out.println("YOUR SPECIAL HABILITY IS: GAIN 20 shield  ");
		scan.nextLine();
		
	}

}
