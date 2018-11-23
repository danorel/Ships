package ships.dev.functional;

import java.util.Scanner;

public class Game {
    private static final int boardSize = 7;
    private static final int numberOfShips = 3;
    private char[][] board = new char[boardSize][boardSize];

    public static void main(String[] args){
        Ships ships = new Ships();
        Game Options = new Game();

        System.out.println();
        Options.createBoard();
        ships.setBoard(Options.board);
        Options.setShips(ships);
        ships.showBoard();
        Options.play(ships);
    }

    private void createBoard(){
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                board[i][j] = '0';
            }
        }
    }

    private void setShips(Ships DC){
        for(int counter = 0; counter < numberOfShips; counter++){
            DC.setShip();
        }
    }

    private void play(Ships DC){
        int xMove, yMove;
        Scanner scanner = new Scanner(System.in);
        do{
            // X Check
            do{
                System.out.print("Enter X: ");
                String sX = scanner.nextLine();
                xMove = Integer.parseInt(sX);
                if(xMove < 1 || xMove > 7){
                    System.out.println("Invalid enter, repeat pls.");
                }
            } while(xMove < 1 || xMove > 7);
            // Y Check
            do{
                System.out.print("Enter Y: ");
                String sY = scanner.nextLine();
                yMove = Integer.parseInt(sY);
                if(yMove < 1 || yMove > 7){
                    System.out.println("Invalid enter, repeat pls.");
                }
            } while(yMove < 1 || yMove > 7);
            // Shoot(X,Y)
            DC.checkHit(xMove - 1, yMove - 1 );
            // Show Hidden Board
            DC.showHiddenBoard();
            if(DC.numberOfHits == 9){
                System.out.println("U won the game!");
            }
        } while(DC.numberOfHits != 9);
    }
}

