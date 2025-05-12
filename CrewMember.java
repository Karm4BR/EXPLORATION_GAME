package CrewTypes;


//FINAL PROJECT– COSC 242503 – Professor McCurry
//Implemented by - Giovanni MIQUELIN

//This class uses Concepts II: abstraction (abstract class and methods), constructors, encapsulation (protected/private fields with getters/setters), toString method, and polymorphism (subclasses implement unique behavior like special moves).
//PARENT OF ALL CREW CLASSES

public abstract class CrewMember {
	
	//Every crewMember Class Characteristics
	protected String crewName;
	protected int crewHp; // 100 to 300
	protected int crewPw; // 0 to 10
	protected int crewShield; // 0 to 100
	protected int crewAgility; // 0 to 10
	protected String crewSpecialMoveName;
	protected int maxHp = 500; // after defeating the Boss 500
	protected int maxShield = 300; //  after defeating the Boss  300
		
	
	public CrewMember(String crewName, int crewHp, int crewPw, int crewShield, int crewAgility, String crewSpecialMoveName) {
		this.crewName = crewName;
		this.crewHp = crewHp;
		this.crewPw = crewPw;
		this.crewShield = crewShield;
		this.crewAgility = crewAgility;
		this.crewSpecialMoveName = crewSpecialMoveName;
		
		
		this.maxHp = crewHp;        
	    this.maxShield = crewShield; 
	}
	//GETTERS AND SETTERS
	
    public int getCrewHp() {
        return crewHp;
    }

    public void setCrewHp(int crewHp) {
        this.crewHp = crewHp;
    }

    public int getCrewPw() {
        return crewPw;
    }

    public int getCrewShield() {
        return crewShield;
    }

    public void setCrewShield(int crewShield) {
        this.crewShield = crewShield;
    }

    public int getCrewAgility() {
        return crewAgility;
    }

    public String getCrewSpecialMoveName() {
        return crewSpecialMoveName;
    }

    public String getCrewName() {
        return crewName;
    }
	
    public int getMaxHp() {
        return maxHp;
    }

    public int getMaxShield() {
        return maxShield;
    }
	
    //INHERITED METHODS
	public abstract void performClassDuty(); //Special Move
	public abstract void ClassDutyDisplay(); //After selection the Character, it reveals what its special hability does
	
	
	
	public void statsDisplay() { //Display the classes
	    System.out.println(crewName + " → HP: " + crewHp + " | DMG: " + crewPw + " | Shield: " + crewShield + " | Agility: " + crewAgility + " | Special: " + crewSpecialMoveName);
	}
	
	
	@Override
	public String toString() {
        return crewName + " [STR: " + crewPw + ", SHIELD: " + crewShield + ", AGI: " + 
	crewAgility + "Special MOVE: " + crewSpecialMoveName + "]";
    }

	

}
