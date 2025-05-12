package AlienTypes;

//FINAL PROJECT– COSC 242503 – Professor McCurry
//Implemented by - Giovanni MIQUELIN

//This class uses Concepts II: abstraction (abstract class and method), constructors, encapsulation (private/protected fields with getters/setters), and polymorphism (subclasses will implement performAlienSpecial).
//Bassicaly IS the PARENT OF ALL ALIEN CLASSES

public abstract class Alien {
	protected int alienHp; // 10 - 1000
	private String alienName;
	protected double alienPw;//0 - 5
	
	public Alien(double alienPw, String alienName, int alienHp) {
		this.alienHp = alienHp;
		this.setAlienName(alienName);
		this.alienPw =alienPw;
	}
	
	public abstract int performAlienSpecial();

	//GETTERS AND SETTERS
	public String getAlienName() {
        return alienName;
    }

    public void setAlienName(String alienName) {
        this.alienName = alienName;
    }

    public int getAlienHp() {
        return alienHp;
    }

    public void setAlienHp(int alienHp) {
        this.alienHp = alienHp;
    }

    public double getAlienPw() {
        return alienPw;
    }

    public void setAlienPw(double alienPw) {
        this.alienPw = alienPw;
    }
	
}
