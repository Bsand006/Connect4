package com.briansand.connect4;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Logic implements MouseListener {
	Gui g;

	int turn = 1;
	int turnCounter = 0;

	public Logic(Gui g) {
		this.g = g;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {

				if (e.getSource() == g.cells[i][j]) {
				    g.cells[i][j].setIcon(g.redIcon);
				}
			}
		}
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
