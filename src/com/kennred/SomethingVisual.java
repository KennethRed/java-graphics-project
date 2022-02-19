package com.kennred;

import javax.swing.*;

public class SomethingVisual extends JFrame {
    MyPanel panel;

    SomethingVisual() {
        panel = new MyPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panel);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
