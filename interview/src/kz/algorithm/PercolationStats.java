package kz.algorithm;

import java.awt.*;
import java.util.Random;

public class PercolationStats {
    int[][] data;
    int[][] data_number;
    double x_mean;
    double [] x_means;

    // perform independent trials on an n-by-n grid
    // trials its number of tests, for n by n grid
    public PercolationStats(int n, int trials) {
        Random random = new Random();
        for (int i = 0; i < trials; i++) {
            this.data = new int[n][n];
            this.data_number = new int[n][n];
            int[] xAxis = new int[n * n];
            int[] yAxis = new int[n * n];
            int count = 0;

            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    this.data[k][j] = 0;
                    this.data_number[k][j] = count;
                    xAxis[count] = i;
                    yAxis[count] = j;
                    count++;
                }
            }

            double persent_of_perc = random.nextInt(99) / 100;
            double x_open_sides = n * n * persent_of_perc;
            for (int j = 0; j < x_open_sides; j++) {
                int randomI = random.nextInt(n * n);
                data[xAxis[randomI]][yAxis[randomI]] = 1;
            }

            Percolation perc = new Percolation(n, data,data_number);
            perc.connectVNumber();
            perc.percolate();

        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return 0.0;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return 0.0;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return 0.0;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return 0.0;
    }

    // test client (see below)
    public static void main(String[] args) {

    }

}