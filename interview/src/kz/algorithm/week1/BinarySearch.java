package kz.algorithm.week1;

public class BinarySearch {
    private static int loopFunction(int a[], int key) {
        int lowest = 0;
        int highest = a.length - 1;
        while (lowest <= highest) {
            int mid = lowest + (highest - lowest) / 2;
            if (a[mid] > key) highest = mid - 1;
            else if (a[mid] < key) lowest = mid + 1;
            else return mid;
        }
        return -1;
    }

    private static int recursiveFunction(int a[], int key, int l, int r) {
        if(r>=l){
            int mid = l +(r-l)/2;


        }


        return -1;
    }


    public static void main(String[] args) {
        int a[] = {4, 13, 26, 33, 45, 47, 80, 84, 95, 99, 101};
        System.out.println("loop function " + loopFunction(a, 84));
    }
}
