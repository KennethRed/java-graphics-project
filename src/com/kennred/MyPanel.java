package com.kennred;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;


public class MyPanel extends JPanel {

    final int FPS = 144;

    final int timeoutInMs = (int) Math.ceil((double) 1000 / FPS);

    final int FLOW_AMOUNT = 44;

    FlowyString[] flowyStrings = new FlowyString[this.FLOW_AMOUNT];

    MyPanel() {
        this.setPreferredSize(new Dimension(800, 800));
        new Timer(timeoutInMs, paintTimer).start();
        this.drawFlowyThings();
    }

    private void drawFlowyThings() {

        for (int i = 0; i < this.FLOW_AMOUNT; i++) {

            Random rd = new Random(); // creating Random object
            int particleCount = rd.nextInt(10,30);
            int particleStartSize =20;

            FlowyString flowyString;
            flowyString = new FlowyString();

            flowyString.setOriginX(150 + ((i + 1) * 20));
            flowyString.setOriginY(this.getHeight() == 0 ? 800 : this.getHeight());

            flowyString.setParticleStartSize(particleStartSize);
            flowyString.setParticleCount(particleCount);
            flowyString.setParticleDecrease(0.8);

            flowyString.setParticleOffsetX(Math.random()/3);

            flowyStrings[i] = flowyString;
        }
    }

    public void paint(Graphics g) {

        super.paint(g);

        Graphics2D g2D = (Graphics2D) g;

        for (FlowyString flowyString : flowyStrings) {
            flowyString.draw(g2D);
        }

        g.dispose();
    }

    Action paintTimer = new AbstractAction() { // functionality of our timer:

        final double INCREMENTS = 0.01;
        final double min = -1;
        final double max = 1;

        public void actionPerformed(ActionEvent e) {

            for (FlowyString flowyString : flowyStrings) {

                flowyString.setParticleOffsetX(
                        flowyString.isParticleOffsetXIncrementing
                                ? flowyString.getParticleOffsetX() + (INCREMENTS)
                                : flowyString.getParticleOffsetX() - (INCREMENTS)
                );

                if (flowyString.getParticleOffsetX() > max) {
                    flowyString.setParticleOffsetXIncrementing(false);
                }
                if (flowyString.getParticleOffsetX() < min) {
                    flowyString.setParticleOffsetXIncrementing(true);
                }
            }

            repaint();

        }

    };

    public static double mapRange(double a1, double a2, double b1, double b2, double s) {
        return b1 + ((s - a1) * (b2 - b1)) / (a2 - a1);
    }


}
