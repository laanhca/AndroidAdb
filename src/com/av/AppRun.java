package com.av;

import javax.swing.*;

public class AppRun {
    public static void main(String[] args) {
        AVForm f = new AVForm();
        f.setVisible(true);
        f.setSize(400,200);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
