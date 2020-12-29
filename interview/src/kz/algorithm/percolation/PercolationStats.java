package kz.algorithm.percolation;

import java.util.Random;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    int[][] data;
    int[][] data_number;
    double x_mean;
    double [] x_means;
    int trials;
    int n;

    // perform independent trials on an n-by-n grid
    // trials its number of tests, for n by n grid
    public PercolationStats(int n, int trials) {
        this.trials=trials;
        this.n = n;
        this.x_means = new double[trials];
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
                    xAxis[count] = k;
                    yAxis[count] = j;
                    count++;
                }
            }
            int random_perc =random.nextInt(99);
            double persent_of_perc = random_perc*0.01;
            int x_open_sides = (int) (n * n * persent_of_perc);
            x_mean+=x_open_sides;
            x_means[i]=(double)x_open_sides/n/n;
            for (int j = 0; j < x_open_sides; j++) {
                int randomI = random.nextInt((n * n)-1);
                data[xAxis[randomI]][yAxis[randomI]] = 1;
            }

            Percolation perc = new Percolation(n, data,data_number);
            perc.connectVNumber();
            perc.percolate();

        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return x_mean/this.trials/n/n;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        if (1 == trials) {
            return Double.NaN;
        }
        return StdStats.stddev(this.x_means);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return (this.mean() - (1.96*this.stddev())/Math.sqrt(this.trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return (this.mean() + (1.96*this.stddev())/Math.sqrt(this.trials));
    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats stats =new PercolationStats(10, 100);
        System.out.println("mean="+stats.mean()+" stddev="+stats.stddev());
        StdOut.println("95% confidence interval = "+ stats.confidenceLo() +", "+ stats.confidenceHi() );
    }

}