package kz.algorithm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;


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
                JButton buttons[] = new JButton[100];

                Map<JButton,Map<Integer, Integer>> jbuttons = new HashMap<>();
                int count = 0;
                int xaxis = 0;
                int yaxis = 0;
                for (int i = 0; i < num; i++) {
                    for (int j = 0; j < num; j ++) {
                        buttons[count] = new JButton();
                        buttons[count].setBounds(xaxis,yaxis,35,35);
                        buttons[count].setBackground(Color.WHITE);
                        ptable.add(buttons[count]);
                        jbuttons.put(buttons[count], (Map<Integer, Integer>) new HashMap<>().put(i,j));
                        count++;
                        yaxis +=35;
                    }
                    xaxis+=35;
                    yaxis=0;
                }
                ptable.setLayout(new GridLayout(10,10));



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