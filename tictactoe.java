import java.util.Scanner;
public class tictactoe {
	      public static char[] board;
              public static String userLetter;
	      public static String computerLetter;
              static Scanner sc = new Scanner(System.in);
              static int count;

                  static char[] createBoard() {

		char[] board = new char[10];

		for(int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
		return board;
         }
               public static void showBoard() {
		System.out.println (board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("----------");
		System.out.println (board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("----------");
		System.out.println (board[7] + " | " + board[8] + " | " + board[9]);
	}
             public static String choose(String option) {

		if(option == "X") {
			userLetter = "X";
			computerLetter = "O";
		}
		else if(option == "O") {
			computerLetter = "X";
			userLetter = "O";
		}
		else {
			System.out.println("Incorrect Input");
		}
		return computerLetter;
	}


              public static void makeuserMove(){

	System.out.println("Enter the position between 1-9 you want to move:");

        int position = sc.nextInt();

        if(position >= 1 && position <= 9 && board[position] == 0) {
        	board[position] = userLetter.charAt(0);
        }
        else if (position >= 1 && position <= 9 && board[position] != 0){
        	System.out.println("Position is taken. \n ReEnter:");
        	position = sc.nextInt();
        	if(position >= 1 && position <= 9 && board[position] == 0)
        		board[position] = userLetter.charAt(0);
        }
        else {
        	System.out.println("Invalid Position.");
        }

        showBoard();
	}

                 public static void makecomputerMove() {
		int cposition = (int)Math.floor(Math.random() * (10-1))+1;

		if(board[cposition] == 0 ) {
			System.out.println("computer will put " + computerLetter.charAt(0) + " at position : " + cposition);
			board[cposition] = computerLetter.charAt(0);
		}
		else if(board[cposition] != 0){
			cposition = (int)Math.floor(Math.random() * (10-1))+1;
			if(board[cposition] == 0 ) {
				System.out.println("computer will put " + computerLetter.charAt(0) + " at position : " + cposition);
				board[cposition] = computerLetter.charAt(0);
			}
		}

		showBoard();
	}

	public static void Toss() {
		System.out.println("Toss! \nEnter 1 for Heads and 2 for Tails");
		int opt = sc.nextInt();
		int toss = (int)Math.floor(Math.random() * 10) %2;

		if(opt == toss) {
			System.out.println("user won the toss! So user starts the game.");
			count = 0;
		}
		else {
			System.out.println("computer won the toss! So computer starts the game.");
			count = 1;
		}

	}


          public static void main(String[] args) {
                 board = new char[10];
                 System.out.println("Please Choose X or O");
		 String option = sc.next().toUpperCase();
                  choose(option);
		 System.out.println("user is : " + userLetter);
		 System.out.println("computer is : " + computerLetter);
                 createBoard();
                 showBoard();
                 makeuserMove();
                 makecomputerMove();
                  Toss();

}
}
