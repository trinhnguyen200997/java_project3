import java.util.ArrayList;
public class Player {
	private String player_name;					// The name of the player
	private int score;							// The score of the player 
	private ArrayList<Hero_TN623245> team;		// List to hold the player's team of heroes
	private ArrayList<Hero_TN623245> heroes;	// List to hold available heroes that can be added to the team
    private static final int TEAM_SIZE = 3; 	// Constant that defines the maximum team size
    
    /**
     * Constructor to initialize a Player object
     * 
     * @param player_name The name of the player
     */
	public Player(String player_name) {
		this.player_name =player_name;		// Set the player's name using the setter
		this.score = 0;							// Initialized the player's team score
		this.team = new ArrayList<>(); 			// Initialize the team list 
		this.heroes = new ArrayList<>();		// Initialize the heroes list
	}
	
	//Getter method
	public String getPlayerName() {
		return player_name;						// Return the player's name				
	}
	

	// Method to add a hero to the team
	public void addHero(Hero_TN623245 hero) {
		// Check if the team has not yet reached the maximum size
		if (team.size() < TEAM_SIZE) {
	        team.add(hero);	// Add the hero to the heroes list
	        System.out.println(hero.getName() + " added to the team.");
	    } else {
	        System.out.println("Team is already full.");	// Print message if team size is full
	        System.out.println();
	    }
	}
	
	// Getter method to get the list of heroes
	public ArrayList<Hero_TN623245> getHeroes() {
        return team;
    }
	// Method to display all heroes in the heroes list
		public void displayHeroes() {
	        if (team.isEmpty()) {
	            System.out.println("No heroes added yet.");
	        } else {
	        	// Loop through the heroes list and display each hero's name and power
	            for (Hero_TN623245 hero : team) {
	                System.out.println(hero.getName() + " - Power: " + hero.getPower());
	            }}
	        }
	
	//Method to add player
    
    public void addPlayer(String player_name) {
      		//Check to make sure name is not null or empty
      		if(player_name == null || player_name.trim().isEmpty()) {
      			System.out.println("Name cannot be empty");
      			return;}
      		// Check to make sure the name is within a valid range
      		if(player_name.length() < 2 || player_name.length() > 25) {
      			System.out.println("Name must be within 2 to 25 characters");
      			return;}
      		this.player_name = player_name;	// Set the player's name
	}
	
	
	/**
     * Override the toString() method
     * 
     * @return A string representation of the player object
     */
    @Override
    public String toString() {
        return "Player name: " + player_name;
		}}

			
		
