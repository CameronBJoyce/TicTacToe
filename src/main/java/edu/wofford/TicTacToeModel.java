package edu.wofford;

public class TicTacToeModel {
    private String[][] board;
    private boolean win;
    public boolean playerTurn;

    public TicTacToeModel() {
        board = new String[3][3];
        makeBoard();
        win = false;
        playerTurn = true;
    }

    public void makeMove(int x, int y) {
        if(legalMove(x,y)) {
            if(playerTurn) {
                board[x][y] = "X";
            } else {
                board[x][y] = "O";
            }
            didWin();
            nextTurn();
            printTurn();

        } else {
            System.out.println("Not a valid move. Please try again");
        }
    }

    public boolean didWin() {
        if((checkDiagonal() || checkY() || checkX())) {
            win = true;
        }
        return win;
    }

    public String getMark(int x, int y) {
        return board[x][y];
    }

    public boolean isDraw() {
        int countEmpty = 0;
        for(int r = 0; r < 3;r++) {
            for(int c = 0; c <3; c++) {
                if(board[r][c].equals(" ")){
                    countEmpty++;
                }
            }
        }
        if(countEmpty == 0) {
            System.out.println("Tie");
            return true;
        } else {
            return false;
        }
    }

    public boolean legalMove(int x, int y) {
        if(x < 3 && y < 3 && x > -1 && y > -1) {
            return board[x][y].equals(" ");
        } else {
            return false;
        }
    }

   // public boolean getTurn() {  return playerTurn; }

    private void makeBoard(){
        for(int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = " ";
            }
        }
    }


    private boolean checkDiagonal() {
        if (board[0][0].equals(board[1][1]) && !board[0][0].equals(" ")){ //kind of ratchet
            if (board[1][1].equals(board[2][2])) { return true;}
        }
        if(board[0][2].equals(board[1][1]) && !board[0][2].equals(" ")) {
            if (board[1][1].equals(board[2][0])) { return true;}
        }
        return false;
    }

    private boolean checkY() {
        for(int row = 0; row < 3; row++) {
            if(board[row][0].equals(board[row][1]) && !board[row][1].equals(" ")) {
                if (board[row][1].equals(board[row][2])) { return true; }
            }
        }
        return false;
    }

    private boolean checkX() {
        for(int col = 0; col < 3; col++) {
            if(board[0][col].equals(board[1][col]) && !board[0][col].equals(" ")) {
                if (board[1][col].equals(board[2][col])) {
                    return true;
                }
            }
        }
        return false;
    }

    public String printTurn() { return ((playerTurn) ? "Player 1's turn" : "Player 2's turn"); }
    private void nextTurn() { playerTurn = !playerTurn; }
    public String printWinner(){return (!(playerTurn) ? "X wins" : "O wins"); }

    public void showBoard() {
        for (int row = 0; row < 3; row++)
        {
            System.out.print("");
            for (int col = 0; col < 3; col++)
            {
                if (col == 0 ||col == 1) {
                    System.out.print(board[row][col] + "|");
                } else {
                    System.out.print(board[row][col]);
                }

            }
            System.out.println();
            if (row == 0 || row == 1) {
                System.out.println("-----");
            }
        }
    }

//        for(int row = 0; row < 3; row++) {
//            int countX = 0;
//            int countO = 0;
//            for(int i = 0; i < 3; i++) {
//                String letter = board[row][i];
//                if(letter == "X") {
//                    countX++;
//                } else if (letter == "O") {
//                    countO++;
//                } else {}
//            }
//            if (countX == 3) {
//                System.out.println("Player 1 WON!");
//                return true;
//            } else if (countO== 3) {
//                System.out.println("Player 2 WON!");
//                return true;
//            } else { }
//        }
//        return false;
//    }

//
//        return(board[0][1],)
//        for(int col = 0; col < 3; col++) {
//            int countX = 0;
//            int countO = 0;
//            for(int i = 0; i < 3; i++) {
//                String letter = board[i][col];
//                if(letter == "X") {
//                    countX++;
//                } else if (letter == "O") {
//                    countO++;
//                } else {}
//            }
//            if (countX == 3) {
//                System.out.println("Player 1 WON!");
//                return true;
//            } else if (countO== 3) {
//                System.out.println("Player 2 WON!");
//                return true;
//            } else { }
//        }
//        return false;
}