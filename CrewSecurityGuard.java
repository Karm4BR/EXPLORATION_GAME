package CrewTypes;


//FINAL PROJECT– COSC 242503 – Professor McCurry
//Implemented by - Giovanni MIQUELIN

public class CrewSecurityGuard extends CrewMember{

		//Special Security Guard Var
	boolean doubleDamageNextAttack;
	
	public CrewSecurityGuard() {
		super("Security Guard", 180, 10, 50, 2, "Extra Ammo");
		
	}

	@Override
	public void performClassDuty() {
		System.out.println("🧨 You loaded extra ammo: next attack will deal DOUBLE damage!");
	    doubleDamageNextAttack = true;
		
	}
	@Override
	public void statsDisplay() {
		System.out.println("6 - " + crewName + "->" + " HP: " + crewHp + " Power/DMG: " + crewPw + " Shield: " +
	crewShield + " Agility: " + crewAgility + " SPECIAL HABILITY: " + crewSpecialMoveName +"\n-----------------------------------------------------");
		
	}

	@Override
	public void ClassDutyDisplay() {
		System.out.println("You selected " + crewName +"!");
		System.out.println("........Initiating Sytems.....Uploding root comands...");
		System.out.println("YOUR SPECIAL HABILITY IS: NEXT ATTACK GIVES double DMG  ");

	}
	
	//SPECIAL HABILTIES USED BY GUARD METHODS
	public void resetDoubleDamage() {
	    doubleDamageNextAttack = false;
	}

	public boolean isDoubleDamageNextAttack() {
	    return doubleDamageNextAttack;
	}

}
