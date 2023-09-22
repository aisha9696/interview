package kz.algorithm.princeton_algorithm.task2;

import kz.algorithm.algorithm.sort.QuickSort;

public class ThreeSUM {
    private static QuickSort quickSort = new QuickSort();


    public static int BruteForce(int a[]) {
        int N = a.length;
        int count = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) count++;
                }
            }
        }
        return count;
    }

    public static int improved3Sum(int a[]) {
        quickSort.sortedInt(a, 0, a.length - 1);
        int count = 0;

        for (int i = 0; i < a.length - 1; i++) {
            int L = i;
            int R = a.length - 1;
            while ( (L < R) && (L+1!=R)) {
                int sumtotal = a[i] + a[L + 1] + a[R];
                if (sumtotal == 0) {
                    System.out.println(""+ a[i] +" " +a[L + 1] +" "+ a[R]);
                    count++;
                    L++;
                } else if (sumtotal > 0) {
                    R--;
                } else if (sumtotal < 0) {
                    L++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] a = {30, -40, -20, -10, 40, 0, 10, 5};
        System.out.println("Brute force " + BruteForce(a));
        System.out.println("Improved 3Sum " + improved3Sum(a));
    }
}
