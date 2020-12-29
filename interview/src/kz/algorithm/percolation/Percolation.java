package kz.algorithm.percolation;


import kz.algorithm.week1.QuickUnionWeightedComp;

public class Percolation {
    int[][] desk;
    int n;
    public QuickUnionWeightedComp quwc;
    int[][] number_desk;
    boolean firstTop = true;
    boolean firstBottom= true;
    int vtop;
    int vbottom;
    //
    public Percolation(int n, int[][] desk, int[][] number_desk) {
        this.desk = desk;
        this.n = n;
        this.number_desk = number_desk;
        quwc = new QuickUnionWeightedComp(n * n);

    }

    public void connectVNumber(){
        if (this.desk.length > 0) {
            for (int i = 0; i < n; i++) {
                if (this.desk[0][i] == 1) {
                    if(firstTop) {vtop =number_desk[0][i]; firstTop=false;}
                    else{quwc.union(vtop, number_desk[0][i]);}
                }
                if (this.desk[n - 1][i] == 1) {
                    if(firstBottom) {vbottom = number_desk[n - 1][i]; firstBottom=false;}
                    else{quwc.union(vbottom, number_desk[n - 1][i]);}

                }
            }
        }
    }
    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (isTopNeighbourOpen(row,col)){
            quwc.union(number_desk[row][col], number_desk[(row - 1 < 0) ? 0 : row - 1][col]);
        }
        if (isLeftNeighbourOpen(row, col)){
            quwc.union(number_desk[row][col], number_desk[row][(col + 1 >= n) ? n - 1 : col + 1]);
        }
        if(isRigthNeighbourOpen(row, col)){
            quwc.union(number_desk[row][col], number_desk[row][(col - 1 < 0) ? 0 : col - 1]);
        }
        if(isBottomNeighbourOpen(row,col)){
            quwc.union(number_desk[row][col], number_desk[(row + 1 >= n) ? n - 1 : row + 1][col]);
        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (this.desk[row][col] == 1) return true;
        else return false;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        /*if (this.desk[(row + 1 > n) ? n - 1 : row + 1][col] == 1) isfull = true;
        if (this.desk[(row - 1 < 0) ? 0 : row - 1][col] == 1) isfull = true;
        if (this.desk[row][(col + 1 > n) ? n : col + 1] == 1) isfull = true;
        if (this.desk[row][(col - 1 < 0) ? 0 : col - 1] == 1) isfull = true;*/

        return (this.quwc.connected(number_desk[row][col], vtop)?true:false);

    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        int count = 0;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (isOpen(i, j)) count++;
            }
        }
        return count;
    }
    // does the system percolate?
    public boolean isTopNeighbourOpen(int row, int col) {
        return (this.desk[(row - 1 < 0) ? 0 : row - 1][col] == 1) ? true : false;
    }

    public boolean isLeftNeighbourOpen(int row, int col) {
        return (this.desk[row][(col + 1 >= n) ? n - 1 : col + 1] == 1) ? true : false;
    }

    public boolean isRigthNeighbourOpen(int row, int col) {
        return (this.desk[row][(col - 1 < 0) ? 0 : col - 1] == 1) ? true : false;
    }

    public boolean isBottomNeighbourOpen(int row, int col) {
        return (this.desk[(row + 1 >= n) ? n - 1 : row + 1][col] == 1) ? true : false;
    }

    public void percolate() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isOpen(i, j)) {
                    open(i, j);
                }
            }
        }
    }

    public boolean isPercolate(){
        return (this.quwc.connected(vbottom, vtop)?true:false);
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}
