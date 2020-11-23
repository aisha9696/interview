package kz.algorithm;

public class Percolation {
    char[][] desk;
    int n ;
    int count =0;
    //
    public Percolation(int n) {
       this.desk= new char[n][n];
       this.n = n;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        this.desk[row][col] = '*';
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if(this.desk[row][col] == '*') return true;
        else return false;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {

        return true;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return 0;
    }


    // does the system percolate?
    public boolean percolates() {
        return true;
    }


    // test client (optional)
    public static void main(String[] args) {

    }
}
