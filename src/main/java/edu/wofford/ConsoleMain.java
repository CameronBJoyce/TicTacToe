package edu.wofford;

import java.util.Scanner;

public class ConsoleMain {

	public static void main(String[] args) {
		TicTacToeModel ttModel = new TicTacToeModel();
		Scanner input = new Scanner(System.in);

		int x;
		int y;
		while (!ttModel.didWin() && !ttModel.isDraw()) {
			System.out.println(ttModel.printTurn());
			x = input.nextInt();
			y = input.nextInt();
			ttModel.makeMove(x, y);
			ttModel.showBoard();
		}
		System.out.println(ttModel.printWinner());
	}
}