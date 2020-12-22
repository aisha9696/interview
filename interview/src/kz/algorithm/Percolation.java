package kz.algorithm;

import javax.swing.*;

public class Percolation {
    int[][] desk;
    int n;
    QuickUnionWeightedComp quwc ;

    //
    public Percolation(int n, int [][] desk) {
        this.desk = desk;
        this.n = n;
        quwc = new QuickUnionWeightedComp(n*n);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        this.desk[row][col] = 1;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (this.desk[row][col] == 1) return true;
        else return false;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        boolean isfull = false;
        if (this.desk[(row + 1 > n) ? n : row + 1][col] == 1) isfull = true;
        if (this.desk[(row - 1 < 0) ? 0 : row - 1][col] == 1) isfull = true;
        if (this.desk[row][(col + 1 > n) ? n : col + 1] == 1) isfull = true;
        if (this.desk[row][(col - 1 < 0) ? 0 : col - 1] == 1) isfull = true;

        return isfull;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        int count = 0;
        for (int i=0; i < this.n; i++) {
            for (int j=0; j < this.n; j++) {
                if(isOpen(i,j)) count++;
            }
        }
        return count;
    }

    public boolean isVtop (int row){
        return (row == 0)?true:false;
    }

    public boolean isVbootom(int row){
        return (row == n)?true:false;
    }

    // does the system percolate?
    public boolean percolates() {


        return true;
    }


    // test client (optional)
    public static void main(String[] args) {

    }
}
