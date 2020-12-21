package kz.algorithm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class PercolationVizualizer {
    Map<Integer, Map<Integer, Integer>> jbuttons;
    int num;
    JButton buttons[];
    int [][]data;

    public PercolationVizualizer(int N) {
        this.num = N;
        this.buttons =new JButton[N*N];
        this.data = new int[N][N];
    }


    private void visualize(){

        JFrame simulation = new JFrame();

        JPanel pTop = new JPanel();
        pTop.setBackground(Color.PINK);
        pTop.setBounds(10, 10, 600, 40);
        JButton newBoardButton =new JButton("New Board");
        newBoardButton.setBounds(0,0,45,10);
        newBoardButton.setBackground(Color.white);
        JButton percolateButton = new JButton("Test Percolation");
        percolateButton.setBounds(0,0,45,10);
        percolateButton.setBackground(Color.white);
        pTop.add(newBoardButton);
        pTop.add(percolateButton);
        int[] xAxis = new int[num*num];
        int[] yAxis = new int[num*num];

        JPanel ptable = new JPanel();
        ptable.setBackground(Color.LIGHT_GRAY);
        ptable.setBounds(10, 60, 600, 600);
        jbuttons = new HashMap<>();
        int count = 0;
        int xaxis = 0;
        int yaxis = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j ++) {
                buttons[count] = new JButton();
                buttons[count].setBounds(xaxis,yaxis,5,5);
                ptable.add(buttons[count]);
                xAxis[count] = i;
                yAxis[count] = j;
                data[i][j] = 0;
                count++;
                yaxis +=5;
            }
            xaxis+=5;
            yaxis=0;
        }
        ptable.setLayout(new GridLayout(num,num));

        newBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i =0; i<num*num; i++){
                    buttons[i].setBackground(Color.BLACK);
                }

                Random random = new Random();
                for (int i =0; i<(num*num*0.5); i++){
                    int toColor = random.nextInt(num*num);
                    buttons[toColor].setBackground(Color.WHITE);
                    data[xAxis[toColor]][yAxis[toColor]] =1;
                }
            }
        });

        percolateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        JPanel pBottom = new JPanel();
        pBottom.setBackground(Color.PINK);
        pBottom.setBounds(10, 700, 600, 30);

        simulation.add(pTop);
        simulation.add(ptable);
        simulation.add(pBottom);
        simulation.setSize(700, 800);
        simulation.setLayout(null);
        simulation.setVisible(true);
    }

    public static void main(String[] args) {
        int N = 20;
        PercolationVizualizer vizualizer  =new PercolationVizualizer(N);
        vizualizer.visualize();
    }
}
