import java.util.*;

// This is a console Tic tac toe game

public class TicTacToe {

    // These are to store the positions
    static ArrayList<Integer> playerPositions =new ArrayList<>();
    static ArrayList<Integer> computerPositions =new ArrayList<>();

    public static void main(String[] args) {
        char [][] gameBoard = {{' ','|',' ','|',' '},
                               {'-','+','-','+','-'},
                               {' ','|',' ','|',' '},
                               {'-','+','-','+','-'},
                               {' ','|',' ','|',' '} };

        while (true) {

            // This will ask  the user for entering the position
            System.out.print("Enter the position from (1-9) : ");
            Scanner scan = new Scanner(System.in);
            int UserPos = scan.nextInt();

            // This will check if , input by user is present in the user positions and computer positions and then will ask to input again if present
            while (playerPositions.contains(UserPos) || computerPositions.contains(UserPos)){   // or
                System.out.println("Position taken , Please choose another position !!");
                UserPos = scan.nextInt();
            }

            choiceGameBoard(gameBoard, UserPos, "User");

            // checks for winner after entering val for user
            String result = checkWinner();
            if (result.length()>0){
                System.out.println(result);
                break;
            }

            // This is to generate random number for computer
            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            System.out.println("Computer's position is : " + cpuPos);

            // This will check if , input by computer is present in the user positions and computer positions array and then will again generate another one
            while (computerPositions.contains(cpuPos) || playerPositions.contains(cpuPos)){
                cpuPos = rand.nextInt(9)+1;
            }

            choiceGameBoard(gameBoard, cpuPos, "computer");

            // This will print the values of X and 0 in board
            printGameBoard(gameBoard);

            // checks for winner after entering val for computer
            result = checkWinner();
            if(result.length()>0){
                System.out.println(result);
                break;
            }

        }

    }

    // This for printing the values on board
    public static void choiceGameBoard(char[][] gameBoard , int pos, String role){

        char symbol=' ';
        if(role.equals("User"))
        {
            symbol='X';
            playerPositions.add(pos);
        }
        else if (role.equals("computer")){
            symbol='0';
            computerPositions.add(pos);
        }

        switch (pos) {
            case 1:
                gameBoard[0][0]=symbol;
                break;
            case 2:
                gameBoard[0][2]=symbol;
                break;
            case 3:
                gameBoard[0][4]=symbol;
                break;
            case 4:
                gameBoard[2][0]=symbol;
                break;
            case 5:
                gameBoard[2][2]=symbol;
                break;
            case 6:
                gameBoard[2][4]=symbol;
                break;
            case 7:
                gameBoard[4][0]=symbol;
                break;
            case 8:
                gameBoard[4][2]=symbol;
                break;
            case 9:
                gameBoard[4][4]=symbol;
                break;
            default:
                break;
        }

    }

    //This for printing the board
    public static void printGameBoard(char[][] gameBoard){
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    // This is to check the winners
    public static String checkWinner() {

        // These are all winner positions
        List topRow= Arrays.asList(1,2,3);
        List midRow= Arrays.asList(4,5,6);
        List botRow= Arrays.asList(7,8,9);
        List leftCol= Arrays.asList(1,4,7);
        List midCol= Arrays.asList(2,5,8);
        List rightCol= Arrays.asList(3,6,9);
        List cross1= Arrays.asList(1,5,9);
        List cross2= Arrays.asList(3,5,7);

        List<List> winningPos = new ArrayList<List>();
        winningPos.add(topRow);
        winningPos.add(midRow);
        winningPos.add(botRow);
        winningPos.add(leftCol);
        winningPos.add(midCol);
        winningPos.add(rightCol);
        winningPos.add(cross1);
        winningPos.add(cross2);

        // this will traverse through winningPos and check
        for (List l :winningPos) {
            if (playerPositions.containsAll(l)){
                return "Congratulations , you won the game !!";
            }
            else if(computerPositions.containsAll(l)){
                return "Sorry , you lose by Computer :( , thanks for playing !!";
            }
            else if(playerPositions.size()+computerPositions.size()==9){
                return "This game is a Draw , please try again !!";
            }
        }
        return "";
    }
}
