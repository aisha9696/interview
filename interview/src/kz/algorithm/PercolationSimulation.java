package kz.algorithm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PercolationSimulation {
    public PercolationSimulation() {
        JFrame main = new JFrame();

        JButton b = new JButton("simulate");
        b.setBounds(30, 100, 100, 40);
        main.add(b);
        main.setSize(200, 300);
        main.setLayout(null);
        main.setVisible(true);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int num = 10;
                main.setVisible(false);
                JFrame simulation = new JFrame();

                JPanel pTop = new JPanel();
                pTop.setBackground(Color.PINK);
                pTop.setBounds(10, 10, 350, 30);


                JPanel ptable = new JPanel();
                ptable.setBackground(Color.LIGHT_GRAY);
                ptable.setBounds(10, 50, 350, 350);

                int count = 0;
                for (int i = 0; i < num*35; i+=35) {
                    for (int j = 0; j < num*35; j+=35) {
                        JPanel box= new JPanel();
                        box.setBounds(i,j,35,40);
                        JLabel text= new JLabel();
                        text.setText(String.valueOf(count));
                        count++;
                        box.add(text);
                        box.setBackground(Color.WHITE);
                        ptable.add(box);
                    }
                }

                JTable jTable = new JTable();
                jTable.addColumn();

                JPanel pBottom = new JPanel();
                pBottom.setBackground(Color.PINK);
                pBottom.setBounds(10, 410, 350, 30);

                simulation.add(pTop);
                simulation.add(ptable);
                simulation.add(pBottom);
                simulation.setSize(400, 500);
                simulation.setLayout(null);
                simulation.setVisible(true);


            }
        });
    }
}