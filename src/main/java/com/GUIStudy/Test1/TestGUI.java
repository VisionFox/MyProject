package com.GUIStudy.Test1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Random;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class TestGUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("LOL");
        f.setLayout(new FlowLayout());
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileFilter() {

            @Override
            public String getDescription() {
                // TODO Auto-generated method stub
                return ".txt";
            }

            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".txt");
            }
        });

        JButton bOpen = new JButton("打开文件");

        JButton bSave = new JButton("保存文件");

        f.add(bOpen);
        f.add(bSave);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250, 150);
        f.setLocationRelativeTo(null);

        f.setVisible(true);

        bOpen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal =  fc.showOpenDialog(f);
                File file = fc.getSelectedFile();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(f, "计划打开文件:" + file.getAbsolutePath());
                }

            }
        });
        bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal =  fc.showSaveDialog(f);
                File file = fc.getSelectedFile();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(f, "计划保存到文件:" + file.getAbsolutePath());
                }
            }
        });
    }
}
