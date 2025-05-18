/** 	
 * ICSI/IECE 201 Introduction to Computer Science
 * Semester Fall 2024
 * Lab class Every Thursday 4.30pm - 5.25pm
 * Trinh Nguyen
 * TN623245
 * Tnguyen31@albany.edu
 * This program simulates a game where players select heroes, form teams, and compete based on the heroes' powers.
 *  
 */
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class P3Driver_TN623245 {
	private static ArrayList<Hero_TN623245> hero_list = new ArrayList<>();	// List of available heroes
	private static ArrayList<Player> player = new ArrayList<>();			// List of players
	private static final int TEAM_SIZE = 3;									// Fixed team size for each player
	private static int game_track =0;											// Counter to track the number of games played
	
	private static Scanner input = new Scanner(System.in);  // Scanner for input
	private static Random rand = new Random(); // Random number generator for health

	
	public static void main(String[]args) throws IOException {
	
		//Initialize text file reading
		File file = new File("text file.txt");
		Scanner myfile = new Scanner (file);
		
			
		//Read data from text file and initialize hero's object
	    while(myfile.hasNextLine()) {
	    	 String line = myfile.nextLine();			//Read each line from text file
	    	 String[] info = line.split(",");			//Split the line by commas to extract hero info
	    	 
	    	 //Get data for each record
	    	 	String type = info[0].trim();			// Hero type (Human, NonLiving, or Monster)
	    		String name = info[1].trim();			// Hero name		
	    		int health = 100;						// Default health (can be modified later)
	    		double power =	Double.parseDouble(info[3].trim());			// Hero's attack power
	    		String description =info[4].trim();		// Hero's description
	    		AttackType attackType = AttackType.valueOf(info[5].trim()); // Attack type as enum
	    		
	    		// Create AttackAbility object for the hero
	    		AttackAbility attackAbility = new AttackAbility(power, 0, attackType, description);		
	    		double speed = Double.parseDouble(info[6].trim());			// Hero's speed
	    		
	    		
	    		// Create hero based on type (Human, NonLiving, or Monster)
	    		if (type.equals("Human")) {
	                // Create Human object
	                Human hero_human = new Human(type, name, health, power, description, attackAbility, speed);
	                hero_list.add(hero_human); // Add hero to hero list     
                
	    		} else if (type.equals("NonLiving")) {
	                // Create NonLiving object
	                NonLiving hero_nonLiving = new NonLiving(type, name, health, power, description, attackAbility, speed);
	                hero_list.add(hero_nonLiving); // Add hero to hero list
              
                
	    		} else if (type.equals("Monster")) {
	                // Create Monster object with a placeholder for minPower
	                double minPower = 0; // set value for minPower
	                Monster hero_Monster = new Monster(type, name, health, power, description, attackAbility, speed, minPower);
	                hero_list.add(hero_Monster); // Add hero to hero list    
	    		}
            }
	    
         // Menu loop
            boolean check = true;
            while (check) {
                System.out.println("\nPlease choose the option you want by typing 1, 2, 3, 4, 5, or 6:");
                System.out.println("**********************************************");
                System.out.println("1. Show all characters");
                System.out.println("2. How many NonLiving characters?");
                System.out.println("3. Add players to the game");
                System.out.println("4. Build the teams");
                System.out.println("5. Start the game");
                System.out.println("6. Quit");
                System.out.println("**********************************************");

                int choice = input.nextInt();
                input.nextLine();  // Consume newline character

                // Process player choice
                switch (choice) {
                    case 1:
                        System.out.println("Option 1: Show all characters.");
                        // Print out the entire list of heroes
                        System.out.println("List of all available heroes:");
                        for (Hero_TN623245 hero_num : hero_list) {
                            System.out.println(hero_num);}	// Print each hero's detail
                        break;
                        
                    case 2:
                        System.out.println("Option 2: How many non-living?");
                        NonLiving.getNonLivingNumber();    // get the number of NonLiving heroes
                        System.out.println("Number of NonLiving heroes: " + NonLiving.getNonLivingNumber()); // display full message
                        break;
                        
                    case 3:
                        System.out.println("Option 3: Add players to the game.");
                      
                        // Add players 
            		    System.out.println("Enter the names for 2 players.");
            		  		
            		    // Player 1
            	        System.out.println("Enter player 1 name:");
            	        String player1Name = input.nextLine();
            	        addPlayer(player1Name);

            	        // Player 2
            	        System.out.println("Enter player 2 name:");
            	        String player2Name = input.nextLine();
            	        addPlayer(player2Name);
            		    
            	        displayPlayer();
            	        break;	
            		   
                    case 4:
                    	// Loop through each player to allow them pick heroes for their team
                        for (Player p : player) {
                            // Ensure not more than 3 heroes
                            while (p.getHeroes().size() < TEAM_SIZE) {
                                System.out.println(p.getPlayerName() + ", pick your team member!");
                                System.out.println("Select a hero of your choice:");

                                // Display available heroes
                                for (int i = 0; i < hero_list.size(); i++) {
                                    Hero_TN623245 hero_obj = hero_list.get(i);
                                    System.out.println((i + 1) + ". " + hero_obj.getName() + " - Power: " + hero_obj.getPower());
                                }

                                // Player selects a hero
                                boolean validSelection = false;
                                while (!validSelection) {
                                    System.out.println("Select a hero by entering the number (1 to " + hero_list.size() + "):");
                                    int selection = input.nextInt() - 1;  // Convert to index starting from 0
                                    input.nextLine();  // Consume newline character

                                    if (selection >= 0 && selection < hero_list.size()) {
                                        Hero_TN623245 selectedHero = hero_list.get(selection);
                                        p.addHero(selectedHero);           // Add hero to the player's team
                                        hero_list.remove(selection);      // Remove selected hero from available heroes
                               
                                        validSelection = true; // Hero was successfully selected
                                    } else {
                                        System.out.println("Invalid selection. Please choose a valid hero.");
                                    }
                                }

                            // Check if player has completed their team (TEAM_SIZE = 3)
                                if (p.getHeroes().size() == TEAM_SIZE) {
                                    System.out.println(p.getPlayerName() + ", your team is full!");
                                }
                            }
                        }

                        // After all players have added their heroes, display the teams
                        displayTeam();
                        break;
                        
                    case 5:
                        System.out.println("Option 5: Start the game.");
                     // Assign random health to each hero and display team powers
                        for (Player p : player) {
                            System.out.println("\n" + p.getPlayerName() + "'s team members:");
                            for (Hero_TN623245 hero : p.getHeroes()) {
                                int randomHealth = rand.nextInt(101);  // Random health between 0 and 100
                                hero.setHealth(randomHealth);
                                System.out.println(hero.getName() + " - Health: " + randomHealth + ", Power: " + hero.getPower());
                            }
                        }

                        // Calculate and display the total power of each team
                        double player1Power = calculateTotalPower(player.get(0));
                        double player2Power = calculateTotalPower(player.get(1));

                        System.out.println("\nTotal Power of " + player.get(0).getPlayerName() + "'s team: " + player1Power);
                        System.out.println("Total Power of " + player.get(1).getPlayerName() + "'s team: " + player2Power);
                		
                        // Determine the winner
                        if (player1Power > player2Power) {
                            System.out.println(player.get(0).getPlayerName() + " wins!");
                        } else if (player1Power < player2Power) {
                            System.out.println(player.get(1).getPlayerName() + " wins!");
                        } else {
                            System.out.println("It's a draw!");
                        }
                        saveResults();
                        break;
              
                    case 6:
                    	System.out.println("Option 6: Quit.");
                        System.out.println("Thank you, have a good day!");
                        check = false;    // Set flag to false to exit the loop and terminate the game
                        break;
                	}
               	}
            }
	// Method to add a player (ensure addPlayer is implemented correctly in your code)
	public static void addPlayer(String player_name) {
	    // Logic to add player with validation (this needs to be in your code)
	    Player newPlayer = new Player(player_name);
	    player.add(newPlayer);
	    System.out.println(player_name + " was added.");
	}
	
	//Method to display player
	public static void displayPlayer() {
		System.out.println("\nOur game is ready with two players:");
        for (Player i: player) {
        	System.out.println(i);}
        }
	
	//Method to display team
	public static void displayTeam() {
        for (Player p : player) {
            System.out.println(p.getPlayerName() + "'s team members:");
            p.displayHeroes();} 
    }

	// Method to calculate the total power of a player's team
	public static double calculateTotalPower(Player p) {
	    double totalPower = 0;
	    for (Hero_TN623245 hero : p.getHeroes()) {
	        totalPower += hero.getPower();	// Sum the power of each hero in the team
	    }
	    return totalPower;
	}
	
	// Method to save results to a file  
	public static void saveResults() throws IOException {
	    FileWriter writer = new FileWriter("saved.txt", true);  // 'true' to append to the file
	    writer.write("Game " + (game_track + 1) + " Results:\n");

	    // Save player information
	    for (Player p : player) {
	        writer.write(p.getPlayerName() + "'s team:\n");
	        for (Hero_TN623245 hero : p.getHeroes()) {
	            writer.write("  - " + hero.getName() + " - Health: " + hero.getHealth() + 
	                         ", Power: " + hero.getPower() + 
	                         ", Attack Type: " + hero.getAttackAbility().getAttackType() + "\n");
	        }
	    }

	    // Calculate total power of each team
	    double player1Power = calculateTotalPower(player.get(0));
	    double player2Power = calculateTotalPower(player.get(1));
	    writer.write("\nTotal Power of " + player.get(0).getPlayerName() + "'s team: " + player1Power + "\n");
	    writer.write("Total Power of " + player.get(1).getPlayerName() + "'s team: " + player2Power + "\n");

	    // check the winner and save to the file
	    if (player1Power > player2Power) {
	        writer.write(player.get(0).getPlayerName() + " is the winner!\n");
	    } else if (player1Power < player2Power) {
	        writer.write(player.get(1).getPlayerName() + " is the winner!\n");
	    } else {
	        writer.write("It's a tie!\n");
	    }

	    // Separate games with new line for readability
	    writer.write("====================================\n");

	    writer.close();  // Close the writer
	    game_track++;  // Increment the game count after saving the results
	}
    }

        
    
	
	