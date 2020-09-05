package game;

import java.util.Random;

public class Game {

	public static void main(String[] args) {
		Random rnd = new Random();
		System.out.println("Welcome to Yatzy!");

		System.out.println("Please enter number of players");
		/*
		Scanner scan = new Scanner(System.in);
		int nbrPlayers = scan.nextInt();
		*/
		int nbrPlayers = 2;
		String[] playerNames = new String[nbrPlayers];
		//scan.nextLine();
//		for(int i=0;i<nbrPlayers;i++) {
//			System.out.print("Player " +(i+1) +"'s name:");
//			playerNames[i] = scan.nextLine();
//			if(i<nbrPlayers-1)
//				scan.nextLine();
//		}
		
		Player[] player = new Player[nbrPlayers];
		playerNames[0] = "hadji";
		playerNames[1] = "tiz";
		for(int i=0;i<nbrPlayers;i++) {
			player[i] = new Player(playerNames[i]);
		}
		
		Menu menu = new Menu(player);
		boolean playing = true;
		int currentPlayer = 0;
		
		while(playing) {
			System.out.println("It is " +player[currentPlayer].getName() +"'s turn");
			System.out.println();
			
			Round round = new Round(player[currentPlayer]);
			int[] diceToRoll = new int[5];
						
			//System.out.println("Keep: 1, Re-roll: 0");
			System.out.println("Use 1 to Keep and 0 to Reroll");
			for(int j=1;j<3;j++) {
				for(int i=0;i<5;i++) {
					System.out.print("Keep " +(i+1) +"? ");
					diceToRoll[i] = rnd.nextInt(6) + 1;
				}
				round.reRoll(diceToRoll);
			}
			
			
			System.out.println("Which row do you want to use? (1-15)");
			int row = rnd.nextInt(16) + 1;
			round.setResult(row);
			menu.update(currentPlayer,row,player[currentPlayer].getLatestChange());
			currentPlayer++;
			currentPlayer = currentPlayer%nbrPlayers;	
		}
		
		System.out.println("Thanks for playing!");
	}
}
