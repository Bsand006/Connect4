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

    JFrame f;
    JPanel p;
    JLabel cells[][];

    GridBagConstraints gbc;

    ImageIcon redIcon, whiteIcon, blueIcon;

    void run() throws IOException {
        Logic l = new Logic(this);

        redIcon = new ImageIcon(ImageIO.read(getClass().getResource("/red.png")));
        whiteIcon = new ImageIcon(ImageIO.read(getClass().getResource("/white.png")));
        blueIcon = new ImageIcon(ImageIO.read(getClass().getResource("/blue.png")));

        f = new JFrame();
        f.setTitle("Connect 4");
        f.setSize(650, 450);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close when we click the x button
        
        p = new JPanel();
        p.setLayout(new GridBagLayout());
        p.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        cells = new JLabel[7][6];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                // Update the GBC to the current cell
                gbc.gridx = i;
                gbc.gridy = j;

                cells[i][j] = new JLabel(whiteIcon);
                cells[i][j].setSize(50, 50);
                cells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                cells[i][j].addMouseListener(l); // set Logic as mouse listener for the cell
               
                // cells[i][j].setText("-");

                p.add(cells[i][j], gbc);

            }
        }

        f.getContentPane().add(p);
        f.setVisible(true);
    }

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
