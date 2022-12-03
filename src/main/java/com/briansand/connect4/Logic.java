package com.briansand.connect4;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//import javax.swing.PopupFactory;

public class Logic implements MouseListener {
	Gui g;

	/*
	 * This class contains all the logic and mechanics of the game. The class
	 * implements MouseListener to allow tokens to be placed when the cells are
	 * clicked on.
	 * 
	 * There is a second array of integers which is used to track which cells have
	 * been pressed and whether they are red or blue. A value of 1 means the cell is
	 * red, 2 means it is blue, and 0 means it has no value. This is how the game
	 * checks for wins.
	 */

	int cellState[][] = new int[7][6]; // Array to track cell values
	int turnCounter = 0; // Integer to track how many turns have happened
	int turn = 1; // Integer to track the current turn
	int val; // Win check value

	// Allows Gui variables to be called with "g"
	public Logic(Gui g) {
		this.g = g;
	}

	// mouse Clicked method
	@Override
	public void mouseClicked(MouseEvent e) {

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {

				if (e.getSource() == g.cells[i][j]) {

					if (cellState[i][j] != 0) // Prevents clicking on cells already filled
						continue;

					if (cellState[i][5] == 0) {
						turnCounter += 1;
						if (turn == 1) {
							g.cells[i][5].setIcon(g.redIcon);
							cellState[i][5] = 1;
							turn = 2;
						} else if (turn == 2) {
							g.cells[i][5].setIcon(g.blueIcon);
							cellState[i][5] = 2;
							turn = 1;
						}

					} else if (cellState[i][4] == 0) {
						turnCounter += 1;
						if (turn == 1) {
							g.cells[i][4].setIcon(g.redIcon);
							cellState[i][4] = 1;
							turn = 2;
						} else if (turn == 2) {
							g.cells[i][4].setIcon(g.blueIcon);
							cellState[i][4] = 2;
							turn = 1;
						}
					} else if (cellState[i][3] == 0) {
						turnCounter += 1;
						if (turn == 1) {
							g.cells[i][3].setIcon(g.redIcon);
							cellState[i][3] = 1;
							turn = 2;
						} else if (turn == 2) {
							g.cells[i][3].setIcon(g.blueIcon);
							cellState[i][3] = 2;
							turn = 1;
						}
					} else if (cellState[i][2] == 0) {
						turnCounter += 1;
						if (turn == 1) {
							g.cells[i][2].setIcon(g.redIcon);
							cellState[i][2] = 1;
							turn = 2;
						} else if (turn == 2) {
							g.cells[i][2].setIcon(g.blueIcon);
							cellState[i][2] = 2;
							turn = 1;
						}
					} else if (cellState[i][1] == 0) {
						turnCounter += 1;
						if (turn == 1) {
							g.cells[i][1].setIcon(g.redIcon);
							cellState[i][1] = 1;
							turn = 2;
						} else if (turn == 2) {
							g.cells[i][1].setIcon(g.blueIcon);
							cellState[i][1] = 2;
							turn = 1;
						}
					} else if (cellState[i][0] == 0) {
						turnCounter += 1;
						if (turn == 1) {
							g.cells[i][0].setIcon(g.redIcon);
							cellState[i][0] = 1;
							turn = 2;
						} else if (turn == 2) {
							g.cells[i][0].setIcon(g.blueIcon);
							cellState[i][0] = 2;
							turn = 1;
						}
					}
					winLogic();
				}

				int winner = winLogic();

				if (winner == 1) {
					 System.out.println("Yes!");
				}

			}
		}
	}

	// Win checker method. Returns 1 when a win is detected.
	public int winLogic() {

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {

				val = cellState[i][j];
				
				if (i < 4)
					if (cellState[i + 1][j] == val)
						if (cellState[i + 2][j] == val)
							if (cellState[i + 3][j] == val)
								return 1;

			}
		}

		return 0;
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}
}
