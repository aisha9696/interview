package kz.algorithm.princeton_algorithm.percolation;
/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class PercolationVizualizer {
    Map<Integer, Map<Integer, Integer>> jbuttons;
    int num;
    JButton buttons[];
    int[][] data;
    int[][] data_number;
    Percolation perc;
    double persent_of_perc;

    public PercolationVizualizer(int N, double persent_of_perc) {
        this.num = N;
        this.buttons = new JButton[N * N];
        this.data = new int[N][N];
        this.data_number = new int[N][N];
        this.persent_of_perc = persent_of_perc;
    }


    private void visualize() {

        JFrame simulation = new JFrame();

        JPanel pTop = new JPanel();
        pTop.setBackground(Color.PINK);
        pTop.setBounds(10, 10, 600, 40);
        JButton newBoardButton = new JButton("New Board");
        newBoardButton.setBounds(0, 0, 45, 10);
        newBoardButton.setBackground(Color.white);
        JButton percolateButton = new JButton("Test Percolation");
        percolateButton.setBounds(0, 0, 45, 10);
        percolateButton.setBackground(Color.white);
        pTop.add(newBoardButton);
        pTop.add(percolateButton);
        int[] xAxis = new int[num * num];
        int[] yAxis = new int[num * num];

        JPanel ptable = new JPanel();
        ptable.setBackground(Color.LIGHT_GRAY);
        ptable.setBounds(10, 60, 600, 600);
        jbuttons = new HashMap<>();
        int count = 0;
        int xaxis = 0;
        int yaxis = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                buttons[count] = new JButton();
                buttons[count].setBounds(xaxis, yaxis, 5, 5);
                ptable.add(buttons[count]);
                xAxis[count] = i;
                yAxis[count] = j;
                data[i][j] = 0;
                data_number[i][j] = count;
                count++;
                yaxis += 5;
            }
            xaxis += 5;
            yaxis = 0;
        }
        ptable.setLayout(new GridLayout(num, num));


        JPanel pBottom = new JPanel();
        pBottom.setBackground(Color.PINK);
        pBottom.setBounds(10, 700, 600, 30);

        JLabel l1 = new JLabel("");
        pBottom.add(l1);


        newBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perc = null;
                for (int i = 0; i < num * num; i++) {
                    buttons[i].setBackground(Color.BLACK);
                    data[xAxis[i]][yAxis[i]] = 0;
                }
                Random random = new Random();
                for (int i = 0; i < (num * num * persent_of_perc); i++) {
                    int toColor = random.nextInt(num * num);
                    buttons[toColor].setBackground(Color.WHITE);
                    data[xAxis[toColor]][yAxis[toColor]] = 1;
                }
                perc = new Percolation(num, data, data_number);
                perc.connectVNumber();
                perc.percolate();
                l1.setText("");
            }
        });

        percolateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < num; i++) {
                    for (int j = 0; j < num; j++) {
                        if (perc.isFull(i, j)) buttons[data_number[i][j]].setBackground(Color.BLUE);
                    }
                }
                if (perc.isPercolate()) l1.setText("System percolate!");
                else l1.setText("System isn't percolate!");
            }
        });


        simulation.add(pTop);
        simulation.add(ptable);
        simulation.add(pBottom);
        simulation.setSize(700, 800);
        simulation.setLayout(null);
        simulation.setVisible(true);
    }

    public static void main(String[] args) {
        int N = 50;
        PercolationVizualizer vizualizer = new PercolationVizualizer(30,0.78);
        vizualizer.visualize();
    }
}
*/