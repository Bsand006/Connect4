package com.briansand.connect4;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Gui {

	/*
	 * This class creates the graphic user interface for the game. The game uses
	 * images of red and blue circles as the tokens for the game. The grid for the
	 * game is created using an array of JLabels and uses GridBagLayout to organize
	 * them. For loops are used to loop through all the cells and add the proper
	 * code to them all at once. All the logic for the game is in the other class
	 * Logic.
	 */

	// GUI variables

	JFrame f;
	JPanel p;
	JLabel cells[][];

	GridBagConstraints gbc;

	ImageIcon redIcon, whiteIcon, blueIcon;

	// Creates GUI
	void run() throws IOException {
		Logic l = new Logic(this);

		// Red and blue image circles for the game tokens. The white Icon is used to
		// properly size the cells
		redIcon = new ImageIcon(ImageIO.read(getClass().getResource("/red.png")));
		whiteIcon = new ImageIcon(ImageIO.read(getClass().getResource("/white.png")));
		blueIcon = new ImageIcon(ImageIO.read(getClass().getResource("/blue.png")));

		// Sets up the JFrame
		f = new JFrame();
		f.setTitle("Connect 4");
		f.setSize(650, 450);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// JPanel and GridBagLayout setup
		p = new JPanel();
		p.setLayout(new GridBagLayout());
		p.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;

		cells = new JLabel[7][6];

		// For loops to loop through all the cells
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {

				// Sets up the cells using GridBagConstraints and adds mouseListener to cells

				gbc.gridx = i;																															
				gbc.gridy = j;

				cells[i][j] = new JLabel(whiteIcon);
				cells[i][j].setSize(50, 50);
				cells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
				cells[i][j].addMouseListener(l);

				p.add(cells[i][j], gbc);

			}
		}

		// Adds components to frame and makes frame visible
		f.getContentPane().add(p);
		f.setVisible(true);
	}

	// Launches GUI
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				try {
					new Gui().run();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
