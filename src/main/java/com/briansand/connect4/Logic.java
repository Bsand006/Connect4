package com.briansand.connect4;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Logic implements MouseListener {
	Gui g;

	static final boolean PLAYER_RED = false;
    static final boolean PLAYER_BLUE = true;

    boolean player = PLAYER_RED;
	int turnCounter = 0;

	public Logic(Gui g) {
		this.g = g;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {

				if (e.getSource() == g.cells[i][j]) {
				    if (player == PLAYER_RED)
				        g.cells[i][j].setIcon(g.redIcon);
				    else
                        g.cells[i][j].setIcon(g.blueIcon);

				    // Switch!
				    player = !player;
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
