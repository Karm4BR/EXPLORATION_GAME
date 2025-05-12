package Planet_Map;


//FINAL PROJECT– COSC 242503 – Professor McCurry
//Implemented by - Giovanni MIQUELIN

//This class uses Concepts II: constructor to initialize the map, encapsulation with private fields and public getters/setters, collections (HashMap), enum abstraction for LocationType, and controlled map generation logic.

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PlanetMaps {
	
	//Random Object
	Random rng = new Random();
	
	//Initializng each of the Planets Size by Name
	private static final Map<String, int[]> planetSizes = new HashMap<>();
	static {
        planetSizes.put("desert planet", new int[]{6, 16});
        planetSizes.put("ice world", new int[]{8, 8});
        planetSizes.put("ocean planet", new int[]{10, 10});
        planetSizes.put("storm realm", new int[]{16, 20});//Only 20 by 20 because is where the Key resides
        planetSizes.put("jungle moon", new int[]{12, 12});
        planetSizes.put("magma core", new int[]{14, 10});
    }
	
	
	
	//Initializing normal variables
	private int rows;
	private int cols;
	private LocationType[][] PlanetsMap;
	
	//ENUM
	public enum LocationType{
		EMPTY,
		RESOURCE,
		ALIEN,
		CLUE,
		KEY,
		NOTHING,
		LEAVE,
		PLAYER
	}
	
	//CONSTRUCTOR
	public PlanetMaps(String planetMap) {
		int[] Planetsize = planetSizes.getOrDefault(planetMap.toLowerCase(), new int[]{10, 10});
		this.rows = Planetsize[0];
	    this.cols = Planetsize[1];
		PlanetsMap = new LocationType[rows][cols];
		initializePlanetsMap();
	}
	
	
	//Getters and Setters
	public LocationType getLocation(int row, int col) {
	    return PlanetsMap[row][col];
	}

	public void setLocation(int row, int col, LocationType type) {
	    PlanetsMap[row][col] = type;
	}

	public int getRows() {
	    return rows;
	}

	public int getCols() {
	    return cols;
	}
	
	//INITIALIZE PlanetsMap
	private void initializePlanetsMap() {
	    // Fill map with random terrain (ALIEN, RESOURCE, EMPTY)
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            int chance = rng.nextInt(101);
	            if (chance < 40) {
	                PlanetsMap[i][j] = LocationType.ALIEN;
	            } else if (chance < 65 ) {
	                PlanetsMap[i][j] = LocationType.RESOURCE;
	            } else {
	                PlanetsMap[i][j] = LocationType.EMPTY;
	            }
	        }
	    }

	    // Special tiles based on map size
	    if (rows > 15 && cols > 15) {
	        PlanetsMap[15][15] = LocationType.KEY;
	        PlanetsMap[10][10] = LocationType.LEAVE;
	    }

	    if (rows > 9 && cols > 8) {
	        PlanetsMap[9][8] = LocationType.CLUE;
	    }

	    if (rows > 5 && cols > 5) {
	        PlanetsMap[5][5] = LocationType.LEAVE;
	    }

	    if (rows > 1 && cols > 2) {
	        PlanetsMap[0][1] = LocationType.EMPTY;
	        PlanetsMap[0][2] = LocationType.LEAVE;
	    }




    }
	
	//DISPLAY MAP - good for multiple endings - PACIFIST - GENOCIDE - NORMAL
	public void displayMap() {
		//shows planet size like 12x12
		System.out.println("🌍 Planet Map (" + rows + "x" + cols + ")");
		
		//Display 0 1 2 3 5 like in BatleShip game
		 System.out.print("    ");
		 for (int col = 0; col < cols; col++) {
		        System.out.printf("%2d ", col);
		    }
		    System.out.println(); // Newline after header

		    // Each row
		    for (int row = 0; row < rows; row++) {
		        System.out.printf("%2d |", row); 
		        for (int col = 0; col < cols; col++) {
		            switch (PlanetsMap[row][col]) {
		                case EMPTY -> System.out.print(" . ");
		                case RESOURCE -> System.out.print(" R ");
		                case ALIEN -> System.out.print("👽 ");
		                case CLUE -> System.out.print(" 🔍 ");
		                case KEY -> System.out.print(" 🔑 ");
		                case NOTHING -> System.out.print(" # ");
		                case LEAVE -> System.out.print(" 🚀 ");
		                case PLAYER -> System.out.print(" 🤖 ");
		            }
		        }
		        System.out.println(); 
		    }
			
	}//End of display Map
	
		

}//End of Class
