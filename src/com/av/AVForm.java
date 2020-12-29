package com.av;

import javax.swing.*;
import java.awt.*;
import java.awt.desktop.OpenFilesEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AVForm extends JFrame {
    private JTabbedPane tabbedPaneHome;
    private JTextField tfAPIKey;
    private JTextField tfListID;
    private JButton BChoiceFile;
    private JPanel panelMain;
    private JTextField tfSTT;
    private JButton startButton;
    private JButton stopButton;
    private JTextArea txtLog;
    StringBuilder logApp;
    public static File fileIndex= new File("D:\\AIRDROP\\AUTOIT\\HIBS_REG\\HIBS_REG\\output\\index.txt");
    public static File file= new File("D:\\AIRDROP\\AUTOIT\\HIBS_REG\\HIBS_REG\\output\\account_Thanhcong_0.txt");

    public AVForm( ) {
        logApp = new StringBuilder(txtLog.getText());
        add(panelMain);
        //setSize(400, 600);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DoInNewThread("127.0.0.1:"+tfSTT.getText()).start();

                txtLog.setText(logApp.append(tfSTT.getText()+" is stared \n").toString());
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JFrame.EXIT_ON_CLOSE;
            }
        });
        BChoiceFile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser j = new JFileChooser(new File("D:\\"));
                int r = j.showOpenDialog(null);
                if (r == JFileChooser.APPROVE_OPTION)

                {
                    tfListID.setText(j.getSelectedFile().getAbsolutePath());
                }
                else
                    tfListID.setText("cancelled");
            }
//

        });

    }


}
