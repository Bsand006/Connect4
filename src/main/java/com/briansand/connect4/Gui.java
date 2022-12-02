package com.briansand.connect4;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Gui {

	JFrame f;
	JPanel p;
	JLabel cells[][];

	GridBagConstraints gbc;

	void run() {

		f = new JFrame();
		f.setTitle("Connect 4");
		f.setSize(650, 450);

		p = new JPanel();
		p.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		cells = new JLabel[7][6];

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {

				cells[i][j] = new JLabel();
				cells[i][j].setSize(150,150);
				gbc.gridx = i;
				gbc.gridy = j;
				gbc.ipadx = 50;
				gbc.ipady = 50;

				cells[i][j].setText("-");
				
				p.add(cells[i][j], gbc);

			}
		}

		f.getContentPane().add(p);
		f.setVisible(true);
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Gui().run();
			}
		});
	}

}
