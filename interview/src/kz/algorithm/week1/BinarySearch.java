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
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (a[mid] == key) {
                return mid;
            }
            if (a[mid] > key) {
                return recursiveFunction(a, key, l, mid - 1);
            }
            return recursiveFunction(a, key, mid + 1, r);
        }
        return -1;
    }

    private static int descResursiveFunction(int a[], int key, int l, int r) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (a[mid] == key) {
                return mid;
            }
            if (a[mid] < key) {
                return descResursiveFunction(a, key, l, mid - 1);
            }
            return descResursiveFunction(a, key, mid + 1, r);
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {4, 13, 26, 33, 45, 47, 80, 84, 95, 99, 101};
        int descA[] = {101, 99, 95, 84, 80, 47, 45, 33, 26, 13, 4};
        System.out.println("loop function " + loopFunction(a, 84));
        System.out.println("recursive function " + recursiveFunction(a, 84, 0, 11));
        System.out.println("desc recursive function " + descResursiveFunction(descA, 84, 0, 11));
    }
}
